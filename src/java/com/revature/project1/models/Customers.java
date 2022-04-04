package com.revature.project1.models;

import java.util.ArrayList;
import java.util.List;

public class Customers {
    private int customerID;
    private String customerFirstName;
    private String customerLastName;
    private String customerStreetAddress;
    private String customerCity;
    private String customerState;
    private int customerZipcode;


    public int getCustomerID() {
        return customerID;
    }

    public Customers(int customerID, String customerFirstName, String customerLastName,
                     String customerStreetAddress, String customerCity, String customerState,
                     int customerZipcode) {

        this.customerID = customerID;
        this.customerFirstName = customerFirstName;
        this.customerLastName = customerLastName;
        this.customerStreetAddress = customerStreetAddress;
        this.customerCity = customerCity;
        this.customerState = customerState;
        this.customerZipcode = customerZipcode;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getCustomerFirstName() {
        return customerFirstName;
    }

    public void setCustomerFirstName(String customerFirstName) {
        this.customerFirstName = customerFirstName;
    }

    public String getCustomerLastName() {
        return customerLastName;
    }

    public void setCustomerLastName(String customerLastName) {
        this.customerLastName = customerLastName;
    }

    public String getCustomerStreetAddress() {
        return customerStreetAddress;
    }

    public void setCustomerStreetAddress(String customerStreetAddress) {
        this.customerStreetAddress = customerStreetAddress;
    }

    public String getCustomerCity() {
        return customerCity;
    }

    public void setCustomerCity(String customerCity) {
        this.customerCity = customerCity;
    }

    public String getCustomerState() {
        return customerState;
    }

    public void setCustomerState(String customerState) {
        this.customerState = customerState;
    }

    public int getCustomerZipcode() {
        return customerZipcode;
    }

    public void setCustomerZipcode(int customerZipcode) {
        this.customerZipcode = customerZipcode;
    }


    public Customers() {

    }

    @Override
    public String toString() {
        return
                "customerID=" + customerID +
                        ", customerFirstName='" + customerFirstName + '\'' +
                        ", customerLastName='" + customerLastName + '\n' +
                        ", customerStreetAddress='" + customerStreetAddress + '\'' +
                        ", customerCity='" + customerCity + '\'' +
                        ", customerState='" + customerState + '\'' +
                        ", customerZipcode=" + customerZipcode +
                        '}';
    }

}
