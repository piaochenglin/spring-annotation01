package com.piao.springTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Transactional(propagation = Propagation.REQUIRES_NEW)
@Service
public class BookShopService {

    @Autowired
    BookShopDaoImpl bookShopDaoImpl;

    public void purchaseBook(String isbn,int id){

        int stock = bookShopDaoImpl.getBookStock(isbn);
        if (stock <= 0){
            throw new StockException("库存不足");
        }
        bookShopDaoImpl.updateBookStock(isbn);

        BigDecimal price = bookShopDaoImpl.getBookPrice(isbn);
        BigDecimal balance = bookShopDaoImpl.getBalance(id);
        if (balance.compareTo(price) < 0){
            throw new AccountException("余额不足");
        }

        bookShopDaoImpl.updateAccountBalance(id,price);

        System.out.println("购买成功");
    }


}
