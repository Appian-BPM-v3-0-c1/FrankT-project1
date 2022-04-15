package com.project1.daos;

import com.project1.connection.DatabaseConnection;
import com.project1.models.Items;
import com.project1.models.Purchase;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class PurchaseDAO implements CrudDAO <Purchase> {
    LocalDateTime myDateObj = LocalDateTime.now();
    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm");
    String dateTime = myDateObj.format(myFormatObj);

    Connection con = DatabaseConnection.getCon();

    @Override
    public void save(Purchase obj) {

        try {
            PreparedStatement ps = con.prepareStatement("INSERT INTO purchase (date, shopping_cart_id, items_id)" +
                    " VALUES (?, ?, ?)");
            ps.setString(1,dateTime);
            ps.setInt(2,obj.getShopping_cart_id());
            ps.setInt(3,obj.getItems_id());


            ps.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<Purchase> findAll() {
        List<Purchase> purchaseList = new ArrayList<>();

        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM purchase");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Purchase purchase = new Purchase();

                purchase.setId(rs.getInt("id"));
                purchase.setDate(rs.getString("date"));
                purchase.setShopping_cart_id(rs.getInt("shopping_cart_id"));
                purchase.setItems_id(rs.getInt("items_id"));


               purchaseList.add(purchase);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return purchaseList;


    }

    @Override
    public Purchase findById(String id) {
        return null;
    }

    @Override
    public boolean update(Purchase updateObj) {
        return false;
    }

    @Override
    public boolean removeById(String id) {
        return false;
    }



    public boolean removeById(int shopping_cart_id){

        int n = 0;

        try {
            PreparedStatement ps = con.prepareStatement("DELETE FROM purchase WHERE shopping_cart_id = ? ");
            ps.setInt(1, shopping_cart_id);



            n = ps.executeUpdate();

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;

    }



}