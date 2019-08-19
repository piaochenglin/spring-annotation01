package com.piao.springTransationXml.service.impl;


import com.piao.springTransationXml.AccountException;
import com.piao.springTransationXml.StockException;
import com.piao.springTransationXml.service.BookShopDao;
import com.piao.springTransationXml.service.BookShopService;

import java.math.BigDecimal;

// timeout属性缩短每个连接的处理时间，提高性能
// readonly true 的话不上锁，提高性能
public class BookShopServiceImpl implements BookShopService {

    private BookShopDao bookShopDaoImpl;


    // 注入的时候，要接口，不能写具体实现类
    public void setBookShopDaoImpl(BookShopDao bookShopDaoImpl) {
        this.bookShopDaoImpl = bookShopDaoImpl;
    }

    public void purchaseBook(String isbn, int id){
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
