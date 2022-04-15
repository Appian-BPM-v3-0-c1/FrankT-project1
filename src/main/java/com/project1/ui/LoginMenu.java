package com.project1.ui;

import com.project1.daos.ItemsDAO;
import com.project1.daos.ShoppingCartDAO;
import com.project1.models.Customer;
import com.project1.services.CustomerService;
import com.project1.services.ItemsService;
import com.project1.services.ShoppingCartService;

import java.util.Scanner;


public class LoginMenu implements IMenu {

    private final CustomerService customerService;
    private final ItemsService itemsService;


    public LoginMenu(CustomerService customerService, ItemsService itemsService) {
        this.customerService = customerService;
        this.itemsService = itemsService;
    }

    @Override
    public void start() {
        char input;
        Scanner scan = new Scanner(System.in);

        exit:
        {
            while (true) {
                System.out.println("\nWelcome to Super Store!");
                System.out.println("Are you already a member please select 1 to sign in,\n " +
                        "select two to create an account, or select x to exit the program");
                System.out.print("\n[1] Sign in");
                System.out.print("\n[2] Register");
                System.out.print("\n[x] Exit");

                System.out.print("\nEnter: ");
                input = scan.next().toLowerCase().charAt(0);

                switch (input) {
                    case '1':
                        login();
                        break;
                    case '2':
                        createAccount();
                        break;
                    case 'x':

                        break exit;
                    default:
                        System.out.println("\nInvalid input!");
                        break;
                }
            }
        }
    }

    private void createAccount() {
        String username;
        String password;
        String firstname;
        String lastname;
        String email;
        String street;
        String city;
        String state;
        String zip;

        Customer customer = new Customer();

        Scanner scan = new Scanner(System.in);

        while (true) {
            while (true) {
                System.out.println("\nPlease enter your username");
                username = scan.nextLine();

                if (!customerService.isDupUsername(username)) {
                    if (customerService.isValidUserName(username)) {
                        customer.setUsername(username);
                        break;
                    } else {
                        System.out.println("\nInvalid username");
                    }
                } else {
                    System.out.println("\nInvalid Duplicate username");
                }
            }

            while (true) {
                System.out.println("\nPlease enter your password, it needs to be" +
                        " 6 characters and at least one number");

                password = scan.nextLine();


                if (customerService.isValidPassword(password)) {
                    customer.setPassword(password);
                    break;
                } else {
                    System.out.println("\nWrong password, please try again");
                }
            }

            while (true) {
                System.out.println("\nPlease enter your first name");

                firstname = scan.nextLine();

                if (customerService.isValidUserName(firstname)) {
                    customer.setFirstname(firstname);
                    break;
                } else {
                    System.out.println("Invalid first name, please try again. ");
                }

            }
            while (true) {
                System.out.println("\nPlease enter your last name");

                lastname = scan.nextLine();

                if (customerService.isValidUserName(lastname)) {
                    customer.setLastname(lastname);
                    break;
                } else {
                    System.out.println("Invalid last name, please try again. ");
                }
            }
            while (true) {
                System.out.println("\nPlease enter your email");

                email = scan.nextLine();

                if (customerService.isValidEmail(email)) {
                    customer.setEmail(email);
                    break;
                } else {
                    System.out.println("Invalid Email Address, please make sure you are using" +
                            " the correct pattern like: 'username@domain.com'");
                }
            }

            System.out.println("\nPlease enter your Street");

            street = scan.nextLine();
            customer.setStreet(street);

            System.out.println("\nPlease enter your City");

            city = scan.nextLine();
            customer.setCity(city);

            System.out.println("\nPlease enter your State");

            state = scan.nextLine();
            customer.setState(state);


            while (true) {

                System.out.println("\nPlease enter your Zipcode");

                zip = scan.next();
                customer.setZip(zip);

                if (customerService.isValidZip(zip)) {
                    customer.setZip(zip);
                    break;
                } else {
                    System.out.println("Invalid Zip Code, please make sure you " +
                            "are entering 5 numbers only");
                }
            }

            System.out.println("\nPlease confirm your credentials (y/n)");
            System.out.println(customer);

            System.out.print("\nEnter: ");

            if (scan.next().toLowerCase().charAt(0) == 'y') {
                System.out.println("\nAccount created successfully");
                customerService.getCustomersDAO().save(customer);
                break;
            }
        }
    }

    private void login() {
        Scanner scan = new Scanner(System.in);

        while (true) {
            Customer customer = new Customer();


            System.out.print("\nUsername: ");
            customer.setUsername(scan.next());


            System.out.print("\nPassword: ");
            customer.setPassword(scan.next());



             if (customerService.isValidLogin(customer)) {

                customer = customerService.getCustomersDAO().findByUserName(customer.getUsername());

                System.out.println("You are log in, Happy shopping");

                if (customerService.isAdmin(customer)) {
                     new AdminMenu(new ItemsService(new ItemsDAO())).start();
                }

                new StoreMenu(customer, new ShoppingCartService(new ShoppingCartDAO()), itemsService).start();

                break;
            } else{
                System.out.println("Invalid username or password");
            }

        }

    }

}
