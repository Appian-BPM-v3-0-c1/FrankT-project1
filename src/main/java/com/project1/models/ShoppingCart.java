package com.project1.models;

public class ShoppingCart {

    private int id;
    private int itemsId;
    private int customersId;
    private String name;
    private String price;

    public ShoppingCart() {
    }

    public ShoppingCart(int id, int itemsId, int customersId, String name, String price) {
        this.id = id;
        this.itemsId = itemsId;
        this.customersId = customersId;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getItemsId() {
        return itemsId;
    }

    public void setItemsId(int itemsId) {
        this.itemsId = itemsId;
    }

    public int getCustomersId() {
        return customersId;
    }

    public void setCustomersId(int customersId) {
        this.customersId = customersId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ShoppingCart{" +
                "id=" + id +
                ", itemsId=" + itemsId +
                ", customersId=" + customersId +
                ", name='" + name + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}