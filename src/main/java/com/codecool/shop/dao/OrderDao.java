package com.codecool.shop.dao;

import com.codecool.shop.model.OrderedItems;
import com.codecool.shop.model.Product;
import com.codecool.shop.model.ProductCategory;
import com.codecool.shop.model.Supplier;

import java.util.List;

public interface OrderDao {
    void emptyCart();
    int getNumberOfItems();
    void add(OrderedItems product);
    OrderedItems find(int id);
    void remove(int id);


    List<OrderedItems> getAll();
    List<Product> getBy(Supplier supplier);
    List<Product> getBy(ProductCategory productCategory);
}
