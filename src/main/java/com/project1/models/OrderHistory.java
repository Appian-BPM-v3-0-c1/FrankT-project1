package com.project1.models;

public class OrderHistory {

    private int id;
    private int customerId;
    private int itemsId;

    public OrderHistory() {
    }

    public OrderHistory(int id, int customerId, int itemsId) {
        this.id = id;
        this.customerId = customerId;
        this.itemsId = itemsId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getItemsId() {
        return itemsId;
    }

    public void setItemsId(int itemsId) {
        this.itemsId = itemsId;
    }

    @Override
    public String toString() {
        return "OrderHistory{" +
                "id=" + id +
                ", customerId=" + customerId +
                ", itemId=" + itemsId +
                '}';
    }
}