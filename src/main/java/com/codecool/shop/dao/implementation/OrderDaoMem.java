package com.codecool.shop.dao.implementation;


import com.codecool.shop.dao.OrderDao;
import com.codecool.shop.model.OrderedItems;
import com.codecool.shop.model.Product;
import com.codecool.shop.model.ProductCategory;
import com.codecool.shop.model.Supplier;

import java.util.ArrayList;
import java.util.List;

import java.sql.* ;  // for standard JDBC programs
import java.math.* ; // for BigDecimal and BigInteger support

public class OrderDaoMem implements OrderDao {

    private List<OrderedItems> data = new ArrayList<>();
    private static OrderDaoMem instance = null;

    /* A private Constructor prevents any other class from instantiating.
     */
    private OrderDaoMem() {
    }

    public static OrderDaoMem getInstance() {
        if (instance == null) {
            instance = new OrderDaoMem();
        }
        return instance;
    }

    public float getPriceForAll() {
        int summ = 0;
        for (OrderedItems orderedItem: data) {
            summ += orderedItem.getProduct().getFloatPrice();
        }
        return summ;
    }

    @Override
    public void emptyCart() {
        this.data.clear();
    }

    @Override
    public int getNumberOfItems() {
        return data.size();
    }

    @Override
    public void add(OrderedItems orderedItems) {
        int id = orderedItems.getProduct().getId();
        for (OrderedItems oi : data) {
            if (oi.getProduct().getId() == id) return;
        }
        orderedItems.setId(data.size() + 1);
        data.add(orderedItems);
    }



    @Override
    public OrderedItems find(int id) {
        return data.stream().filter(t -> t.getId() == id).findFirst().orElse(null);
    }

    @Override
    public void remove(int id) {
        data.remove(find(id));
    }

    @Override
    public List<OrderedItems> getAll() {
        return data;
    }

    @Override
    public List<Product> getBy(Supplier supplier) {
        return null;
    }

    @Override
    public List<Product> getBy(ProductCategory productCategory) {
        return null;
    }


}