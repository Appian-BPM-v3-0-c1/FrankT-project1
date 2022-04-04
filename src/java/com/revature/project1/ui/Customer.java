package com.revature.project1.ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Customer {

    //I created the lists
    List<Integer> customerID = new ArrayList<Integer>();
    List<String> customerFirstName = new ArrayList<String>();
    List<String> customerLastName = new ArrayList<>();
    List<String> customerStreetAddress = new ArrayList<String>();
    List<String> customerCity = new ArrayList<>();
    List<String> customerState = new ArrayList<>();
    List<Integer> customerZipcode = new ArrayList<>();

    Scanner scan = new Scanner(System.in);

    public Customer() {

    }

    public void AddCustomer() {


        System.out.print("\nPlease enter name of the ID ");

        int n = Integer.parseInt((scan.nextLine()));

        for (int i = 0; i < n; i++) {
            customerID.add(n);
            break;
        }

        System.out.print("\nPlease enter first name: ");
        String name = scan.nextLine();

        for (int i = 0; i < n; i++) {
            customerFirstName.add(name);
            break;
        }

        System.out.print("\nPlease enter Last name: ");
        name = scan.nextLine();
        for (int i = 0; i < n; i++) {
            customerLastName.add(name);
            break;
        }

        System.out.print("\nPlease enter Street Address: ");
         name = scan.nextLine();

        for (int i = 0; i < n; i++) {
            customerStreetAddress.add(name);
            break;
        }

        System.out.print("\nPlease enter City: ");
        name = scan.nextLine();
        for (int i = 0; i < n; i++) {
            customerCity.add(name);
            break;
        }

        System.out.print("\nPlease enter State: ");
        name = scan.nextLine();
        for (int i = 0; i < n; i++) {
            customerState.add(name);
            break;
        }

        System.out.print("\nPlease enter ZipCode: ");

        n = Integer.parseInt((scan.nextLine()));

        for (int i = 0; i < n; i++) {
            customerZipcode.add(n);
            break;
        }


//        System.out.println("The Customer Id is " + customerID + " First Name: " + customerFirstName +
//                " Last Name: ");


        char p;

        System.out.print("\nPlease enter the name of the customer and the customer ID");

        System.out.print("\nDo you want to shop at our Amazing Super Store Please enter 'Y' for yes" +
                " and 'N' for no");

        p = scan.next().toLowerCase().charAt(0);

        if (p == 'y') {

            new MainMenu().start();
        } else {
            System.out.println("Thank you for your time, we will see you next time!");
        }
    }

   

}
