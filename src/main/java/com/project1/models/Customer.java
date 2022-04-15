package com.project1.models;

public class Customer {
    private int id;
    private String username;
    private String password;
    private String firstname;
    private String lastname;
    private String email;
    private String street;
    private String city;
    private String state;
    private String zip;
    private String userType = "default";

    public Customer() {
    }

    public Customer(int id, String username, String password, String firstname, String lastname, String email,
                    String street, String city, String state, String zip, String userType) {

        this.id = id;
        this.username = username;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.userType = userType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    @Override
    public String toString() {
        return "username = " + username + "\n" +
                "Password = " + password + '\n' +
                "Firstname = " + firstname + '\n' +
                "Lastname = " + lastname + '\n' +
                "Email = " + email + '\n' +
                "Street = " + street + '\n' +
                "City = " + city + '\n' +
                "State = " + state + '\n' +
                "Zip = " + zip + '\n' +
                "UserType = " + userType + '\n';
    }



}



