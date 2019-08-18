package com.piao.springTransaction;

import java.math.BigDecimal;

public interface BookShopDao {

    BigDecimal getBookPrice(String isbn);

    BigDecimal getBalance(int id);

    int getBookStock(String isbn);

    void updateAccountBalance(int userId ,BigDecimal price);

    void updateBookStock(String isbn);
}
