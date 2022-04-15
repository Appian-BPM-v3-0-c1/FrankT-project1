package com.project1.daos;

import com.project1.models.OrderHistory;

import java.util.List;

public class OrderHistoryDAO implements CrudDAO<OrderHistory> {
    @Override
    public void save(OrderHistory obj) {

    }

    @Override
    public List<OrderHistory> findAll() {
        return null;
    }

    @Override
    public OrderHistory findById(String id) {
        return null;
    }

    @Override
    public boolean update(OrderHistory updateObj) {
        return false;
    }

    @Override
    public boolean removeById(String id) {
        return false;
    }
}
