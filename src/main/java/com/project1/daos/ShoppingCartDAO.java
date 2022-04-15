package com.project1.daos;

import com.project1.connection.DatabaseConnection;

import com.project1.models.ShoppingCart;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCartDAO implements CrudDAO<ShoppingCart> {

    Connection con = DatabaseConnection.getCon();

    @Override
    public void save(ShoppingCart obj) {

        try {
            PreparedStatement ps = con.prepareStatement("INSERT INTO shopping_cart (items_id, customers_id, name, price)" +
                    " VALUES ( ?, ?, ?, ?)");

            ps.setInt(1, obj.getItemsId());
            ps.setInt(2, obj.getCustomersId());
            ps.setString(3, obj.getName());
            ps.setString(4, obj.getPrice());


            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<ShoppingCart> findAll() {
        List<ShoppingCart> shoppingCartList = new ArrayList<>();

        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM shopping_cart");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                ShoppingCart shoppingCart = new ShoppingCart();

                shoppingCart.setId(rs.getInt("id"));
                shoppingCart.setItemsId(rs.getInt("items_id"));
                shoppingCart.setCustomersId(rs.getInt("customers_id"));
                shoppingCart.setName(rs.getString("name"));
                shoppingCart.setPrice(rs.getString("price"));


                shoppingCartList.add(shoppingCart);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return shoppingCartList;

    }

    @Override
    public ShoppingCart findById(String id) {


        return null;
    }

    @Override
    public boolean update(ShoppingCart updateObj) {

        try {
            PreparedStatement ps = con.prepareStatement("UPDATE shopping_cart SET items_id = ? WHERE id = ? " +
                    "WHERE customers_id = ?" + "WHERE name = ?" + "WHERE price = ?");


            ps.setInt(1, updateObj.getId());
            ps.setInt(2, updateObj.getItemsId());
            ps.setInt(3, updateObj.getCustomersId());
            ps.setString(4, updateObj.getName());

            ps.executeUpdate();

            return true;

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return false;
    }


    @Override
    public boolean removeById(String id) {

        ShoppingCart shoppingCart = new ShoppingCart();

        try {
            PreparedStatement ps = con.prepareStatement("UPDATE  items SET" +
                    " stock = stock - ? WHERE name = ?");

            ps.setString(1, "id");

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return false;
    }

    public boolean deleteFromCart(String name, String price) {
        int n = 0;

        try {
            PreparedStatement ps = con.prepareStatement("DELETE FROM shopping_cart WHERE name = ? AND price = ?");
            ps.setString(1, name);
            ps.setString(2, price);


            n = ps.executeUpdate();

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    public boolean deletedFromCart2(int id){


        int n = 0;

        try {
            PreparedStatement ps = con.prepareStatement("DELETE FROM shopping_cart WHERE id = ? ");
            ps.setInt(1, id);



            n = ps.executeUpdate();

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;


    }


}
