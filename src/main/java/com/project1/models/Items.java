package com.project1.models;

public class Items {

    private int id;
    private String name;
    private String price;
    private int stock;
    private int departments_id;

    public Items() {
    }

    public Items(int id, String name, String price, int stock, int departments_id) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.departments_id = departments_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getDepartments_id() {
        return departments_id;
    }

    public void setDepartments_id(int departments_id) {
        this.departments_id = departments_id;
    }

    @Override
    public String toString() {return  "\n" + name + "\t\t\t\t\t\t" + price + "\t\t\t\t\t" + stock;

    }
}
