package com.piao.hibernate.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public class BookShopDaoImpl implements BookShopDao {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public BigDecimal getBookPrice(String isbn) {
        String hql = "select b.price from Book b where b.isbn = ?";
        BigDecimal price = (BigDecimal) getSession().createQuery(hql).setString(0, isbn).uniqueResult();
        return price;
    }

    @Override
    public BigDecimal getBalance(int id) {
        String hql = "select a.balance from Account a where a.id = ?";
        BigDecimal balance = (BigDecimal) getSession().createQuery(hql).setInteger(0, id).uniqueResult();
        return balance;
    }

    @Override
    public int getBookStock(String isbn) {
        String hql = "select b.stock from Book b where b.isbn = ?";
        int stock = (int) getSession().createQuery(hql).setString(0, isbn).uniqueResult();
        return stock;
    }

    @Override
    public void updateAccountBalance(int userId, BigDecimal price) {
        String hql = "update Account a set a.balance = a.balance - ? where a.id = ?";
        getSession().createQuery(hql).setBigDecimal(0, price).setInteger(1,userId).executeUpdate();
    }

    @Override
    public void updateBookStock(String isbn) {
        String hql = "update Book b set b.stock = b.stock - 1 where b.isbn = ?";
        getSession().createQuery(hql).setString(0,isbn).executeUpdate();
    }
}
