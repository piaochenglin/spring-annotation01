package com.piao.springTransaction;

import java.util.List;

public interface Cashier {
    void checkout(List<String> isbns, Integer id);
}
