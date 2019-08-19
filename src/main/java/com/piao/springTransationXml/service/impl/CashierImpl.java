package com.piao.springTransationXml.service.impl;


import com.piao.springTransationXml.service.BookShopService;
import com.piao.springTransationXml.service.Cashier;

import java.util.List;


public class CashierImpl implements Cashier {

    private BookShopService bookShopService;

    public void setBookShopService(BookShopService bookShopService) {
        this.bookShopService = bookShopService;
    }

    @Override
    public void checkout(List<String> isbns, Integer id) {
        for (String isbn : isbns){
            bookShopService.purchaseBook(isbn,id);
        }
    }
}
