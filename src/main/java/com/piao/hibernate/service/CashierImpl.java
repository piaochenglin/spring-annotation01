package com.piao.hibernate.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CashierImpl implements Cashier {

    @Autowired
    private BookShopService bookShopService;

    @Override
    public void checkout(List<String> isbns, Integer id) {
        for (String isbn : isbns){
            bookShopService.purchaseBook(isbn,id);
        }
    }
}
