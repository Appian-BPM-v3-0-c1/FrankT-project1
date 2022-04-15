package com.project1.services;

import com.project1.daos.ItemsDAO;

import com.project1.models.Items;

import java.util.List;

public class ItemsService {

    private final ItemsDAO itemsDAO;


    public ItemsService(ItemsDAO itemsDAO) {
        this.itemsDAO = itemsDAO;
    }

    public ItemsDAO getItemsDAO() {
        return itemsDAO;
    }

    public boolean isValidItem(Items items) {
        List<Items> itemsList = itemsDAO.findAll();

        for (Items u : itemsList) {
            if (u.getName().equals(items.getName())) {
                return true;
            }
        }

        return false;
    }


}
