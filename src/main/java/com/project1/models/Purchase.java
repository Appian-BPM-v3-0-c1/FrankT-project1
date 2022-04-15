package com.project1.models;

public class Purchase {
    private int id;
    private String date;
    private int shopping_cart_id;
    private int items_id;

    public Purchase() {
    }

    public Purchase(int id, String date, int shopping_cart_id, int items_id) {
        this.id = id;
        this.date = date;
        this.shopping_cart_id = shopping_cart_id;
        this.items_id = items_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getShopping_cart_id() {
        return shopping_cart_id;
    }

    public void setShopping_cart_id(int shopping_cart_id) {
        this.shopping_cart_id = shopping_cart_id;
    }

    public int getItems_id() {
        return items_id;
    }

    public void setItems_id(int items_id) {
        this.items_id = items_id;
    }
}

