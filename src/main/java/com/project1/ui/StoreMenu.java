package com.project1.ui;

import com.project1.daos.*;
import com.project1.models.Customer;
import com.project1.models.ShoppingCart;
import com.project1.services.*;

import java.util.Scanner;

public class StoreMenu implements IMenu {

    private final Customer customer;

    private final ShoppingCartService shoppingCartService;

    private final ItemsService itemsService;

    public StoreMenu(Customer customer, ShoppingCartService shoppingCartService, ItemsService itemsService) {
        this.customer = customer;
        this.shoppingCartService = shoppingCartService;
        this.itemsService = itemsService;
    }

    @Override
    public void start() {

        char input = ' ';
        boolean exit = false;
        Scanner scan = new Scanner(System.in);

        while (!exit) {
            System.out.println("\nWelcome to Super Store!");
            System.out.println("Select Department Store using numbers from 1 to 4");
            System.out.println("[1] Electronic Department");
            System.out.println("[2] Food department");
            System.out.println("[3] Sport Department");
            System.out.println("[4] View cart");
            System.out.println("[x] Exit");

            System.out.print("\nEnter: ");
            input = scan.next().toLowerCase().charAt(0);

            switch (input) {
                case '1':
                    new ElectronicDeptMenu(customer, new ItemsService(new ItemsDAO())).start();
                    break;
                case '2':
                    new FoodDepartmentMenu(customer, itemsService, shoppingCartService).start();
                    break;
                case '3':
                    new SportDepartmentMenu(customer, itemsService, shoppingCartService).start();
                    break;
                case '4':
                    new ShoppingCarMenu(customer, new ItemsService(new ItemsDAO()), new ShoppingCartService
                            (new ShoppingCartDAO()), new DepartmentService(new DepartmentDAO()),
                            new PurchaseService(new PurchaseDAO())).start();
                    break;
                case 'x':
                    exit = true;
                    break;
                default:
                    System.out.println("\nInvalid input!");
                    break;
            }
        }

    }

}
