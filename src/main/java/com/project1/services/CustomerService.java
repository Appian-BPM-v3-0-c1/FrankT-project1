package com.project1.services;

import com.project1.daos.CustomersDAO;
import com.project1.models.Customer;

import java.util.List;

public class CustomerService {

    private final CustomersDAO customersDAO;

    public CustomerService(CustomersDAO customersDAO) {
        this.customersDAO = customersDAO;
    }

    public CustomersDAO getCustomersDAO() {
        return customersDAO;
    }

    public boolean isDupUsername(String username) {

        List<String> username_list = customersDAO.findAllUsernames();

        for (String u : username_list) {
            if (u.equals(username)) {
                return true;
            }
        }

        return false;
    }

    public boolean isValidUserName(String username) {

        return username.matches("^(?=[a-zA-Z0-9._]{5,20}$)(?!.*[_.]{2})[^_.].*[^_.]$");

    }

    public boolean isValidPassword(String password) {

        return password.matches("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{6,}$");
    }

    public boolean isValidZip(String zip) {

        return zip.matches("^\\d{5}$");
    }

    public boolean isValidEmail(String email) {
        return email.matches("(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)" +
                "*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09" +
                "\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]" +
                "*[a-z0-9])?|\\[(?:(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9]))\\.){3}(?:(2(5[0-5]|" +
                "[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9])|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\" +
                "x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])");
    }

    public boolean isValidName(String name) {
        return name.matches("/.*\\S.*/");
    }




    public boolean isValidLogin(Customer customer) {
        List<Customer> customerList = customersDAO.findAll();

        for (Customer u : customerList) {
            if (u.getUsername().equals(customer.getUsername()) && u.getPassword().equals(customer.getPassword()) ) {
                return true;
            }
        }

        return false;
    }

    public boolean isAdmin(Customer customer){
        return customer.getUserType().equals("admin");
    }
}
