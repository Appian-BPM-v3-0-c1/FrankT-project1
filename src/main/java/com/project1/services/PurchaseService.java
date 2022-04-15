package com.project1.services;

import com.project1.daos.PurchaseDAO;
import com.project1.models.Purchase;

import java.util.List;

public class PurchaseService {

    private final PurchaseDAO purchaseDAO;

    public PurchaseService(PurchaseDAO purchaseDAO) {
        this.purchaseDAO = purchaseDAO;
    }


    public boolean isValidPurchase(Purchase purchase){

        List<Purchase> purchaseList = purchaseDAO.findAll();


        return false;
    }

    public PurchaseDAO getPurchaseDAO() {
        return purchaseDAO;
    }
}
