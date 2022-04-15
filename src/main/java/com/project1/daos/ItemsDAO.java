package com.project1.daos;

import com.project1.connection.DatabaseConnection;

import com.project1.models.Items;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemsDAO implements CrudDAO<Items> {

    Connection con = DatabaseConnection.getCon();

    @Override
    public void save(Items obj) {


    }

    @Override
    public List<Items> findAll() {
        List<Items> items = new ArrayList<>();

        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM items");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Items item = new Items();

                item.setId(rs.getInt("id"));
                item.setName(rs.getString("name"));
                item.setPrice(rs.getString("price"));
                item.setStock(rs.getInt("stock"));
                item.setDepartments_id(rs.getInt("departments_id"));

                items.add(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return items;
    }

    @Override
    public Items findById(String id) {
        return null;
    }

    @Override
    public boolean update(Items updateObj) {

        //update the stocks
        try {
            PreparedStatement ps = con.prepareStatement("UPDATE items SET stock = ? where id = ?");

            ps.setInt(1, updateObj.getStock());
            ps.setInt(2, updateObj.getId());

            ps.executeUpdate();

            return true;

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return false;
    }


    @Override
    public boolean removeById(String id) {
        return false;
    }


    public int getItemId(String price) {
        int id = 0;

        try {
            PreparedStatement ps = con.prepareStatement("SELECT (id) FROM items where price = ?");
            ps.setString(1, price);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                id = rs.getInt("id");

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return id;
    }

    public Items findItemById(int id) {
        Items item = new Items();

        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM items where id = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                item.setId(rs.getInt("id"));
                item.setName(rs.getString("name"));
                item.setPrice(rs.getString("price"));
                item.setStock(rs.getInt("stock"));
                item.setDepartments_id(rs.getInt("departments_id"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return item;
    }

}
