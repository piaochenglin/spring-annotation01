package com.piao.springTransationXml.service;

import java.util.List;

public interface Cashier {
    void checkout(List<String> isbns, Integer id);
}
