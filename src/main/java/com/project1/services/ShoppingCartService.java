package com.project1.services;

import com.project1.daos.ShoppingCartDAO;
import com.project1.models.ShoppingCart;

import java.util.List;

public class ShoppingCartService {

    private final ShoppingCartDAO shoppingCartDAO;

    public ShoppingCartService(ShoppingCartDAO shoppingCartDAO) {
        this.shoppingCartDAO = shoppingCartDAO;
    }


    public boolean isValidShoppingCart(ShoppingCart shoppingCart) {
        List<ShoppingCart> shoppingCartsList = shoppingCartDAO.findAll();

//        for (ShoppingCart u : shoppingCartsList) {
//            if (u.getItemsId().
//            (shoppingCart.getItemsId());
//                return true;
        return false;
    }


    public ShoppingCartDAO getShoppingCartDAO() {
        return shoppingCartDAO;
    }


}
