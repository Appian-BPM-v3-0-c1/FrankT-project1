package com.project1.daos;

import com.project1.connection.DatabaseConnection;
import com.project1.models.Customer;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomersDAO implements CrudDAO<Customer> {

    Connection con = DatabaseConnection.getCon();

    @Override
    public void save(Customer obj) {
        try {
            PreparedStatement ps = con.prepareStatement("INSERT INTO customers (username, password, firstname," +
                    " lastname, email, street, city, state, zip, user_type) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

            ps.setString(1, obj.getUsername());
            ps.setString(2, obj.getPassword());
            ps.setString(3, obj.getFirstname());
            ps.setString(4, obj.getLastname());
            ps.setString(5, obj.getEmail());
            ps.setString(6, obj.getStreet());
            ps.setString(7, obj.getCity());
            ps.setString(8, obj.getState());
            ps.setString(9, obj.getZip());
            ps.setString(10, obj.getUserType());

            ps.executeUpdate();

        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public List<Customer> findAll() {
        List<Customer> userList = new ArrayList<>();

        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM customers");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Customer customer = new Customer();

                customer.setId(rs.getInt("id"));
                customer.setUsername(rs.getString("username"));
                customer.setPassword(rs.getString("password"));
                //checking to see if it works
                customer.setUserType(rs.getString("user_type"));


                userList.add(customer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return userList;
    }


    public List<Customer> findUserType() {
        List<Customer> userList = new ArrayList<>();

        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM customers");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Customer customer = new Customer();

                customer.setId(rs.getInt("id"));
                customer.setUsername(rs.getString("username"));
                customer.setPassword(rs.getString("password"));


                userList.add(customer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return userList;
    }





    @Override
    public Customer findById(String id) {
        return null;
    }

    @Override
    public boolean update(Customer updateObj) {
        return false;
    }

    @Override
    public boolean removeById(String id) {
        return false;
    }

    public List<String> findAllUsernames() {

        //List was created to check if the username was created already
        List<String> username_list = new ArrayList<>();

        try{
            PreparedStatement ps = con.prepareStatement("SELECT (username) FROM customers");
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                username_list.add(rs.getString("username"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return username_list;
    }


    public int getCustomerId(String username) {
        int id = 0;

        try {
            PreparedStatement ps = con.prepareStatement("SELECT (id) FROM customers where username = ?");
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                id = rs.getInt("id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return id;
    }

    //get user based on username
    public Customer findByUserName(String username){

        Customer customer= new Customer();

        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM customers where username = ?");
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
               customer.setId(rs.getInt("id"));
               customer.setUsername(rs.getString("username"));
               customer.setPassword(rs.getString("password"));
               customer.setFirstname(rs.getString("firstname"));
               customer.setLastname(rs.getString("lastname"));
               customer.setEmail(rs.getString("email"));
               customer.setStreet(rs.getString("street"));
               customer.setCity(rs.getString("city"));
               customer.setState(rs.getString("state"));
               customer.setZip(rs.getString("zip"));
               customer.setUserType(rs.getString("user_type"));


            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return customer;
    }

}

