package com.codecool.shop.model;


import java.lang.reflect.Field;

public class OrderedItems {

    private int id;
    protected Product product;
    private int amount;

    public OrderedItems(Product product) {
        this.amount = 1;
        this.product = product;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void increaseAmount(){
            amount++;
    }

    public void decreaseAmount(){
        if(amount > 1){
            amount--;
        }
    }

    public Supplier getSupplier(){
        return product.getSupplier();
    }

    public ProductCategory getProductCategory(){
        return product.getProductCategory();
    }

    public String toString(){
        return product.toString() + ", amount:" + amount;
    }

}
