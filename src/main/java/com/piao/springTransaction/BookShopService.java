package com.piao.springTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
// timeout属性缩短每个连接的处理时间，提高性能
// readonly true 的话不上锁，提高性能
@Transactional(propagation = Propagation.REQUIRES_NEW,noRollbackFor = AccountException.class,timeout = 3,readOnly = false)
@Service
public class BookShopService {

    @Autowired
    BookShopDaoImpl bookShopDaoImpl;

    public void purchaseBook(String isbn,int id){
//        try {
//            Thread.sleep(4000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

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
