package com.piao.hibernate.service;


import com.piao.hibernate.AccountException;
import com.piao.hibernate.StockException;
import com.piao.hibernate.repository.BookShopDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
@Service
public class BookShopServiceImpl implements BookShopService {

    @Autowired
    private BookShopDao bookShopDaoImpl;
    // 写在类上和写在方法上时不同的，写在哪去掉哪的
    @SuppressWarnings("all")
    public void purchaseBook(String isbn, int id){

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
