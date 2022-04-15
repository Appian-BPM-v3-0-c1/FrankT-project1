package com.project1.ui;

import com.project1.daos.ItemsDAO;
import com.project1.daos.ShoppingCartDAO;
import com.project1.models.Customer;
import com.project1.services.ItemsService;
import com.project1.services.ShoppingCartService;

import java.util.Scanner;

public class ElectronicDeptMenu implements IMenu {

    private final Customer customer;
    private final ItemsService itemsService;

    public ElectronicDeptMenu(Customer customer, ItemsService itemsService) {
        this.customer = customer;
        this.itemsService = itemsService;
    }

    @Override
    public void start() {

        char input = ' ';
        boolean exit = false;
        Scanner scan = new Scanner(System.in);

        while (!exit) {
            System.out.println("\nWelcome to the Electronic Department!");
            System.out.println("Select Department Store using numbers from 1 to 4");
            System.out.println("[1] Game Systems");
            System.out.println("[2] Tvs");
            System.out.println("[3] Computers");
            System.out.println("[4] Go back to previous menu");
            System.out.println("[x] Exit");

            System.out.print("\nEnter: ");
            input = scan.next().toLowerCase().charAt(0);

            switch (input) {
                case '1':
                    new GamingSystemMenu(new ShoppingCartService(new ShoppingCartDAO()),customer, new ItemsService(new ItemsDAO())).start();
                    break;
                case '2':
                    new TelevisionMenu(new ShoppingCartService(new ShoppingCartDAO()),customer, new ItemsService(new ItemsDAO())).start();
                    break;
                case '3':
                    new ComputerMenu(new ShoppingCartService(new ShoppingCartDAO()),customer, new ItemsService(new ItemsDAO())).start();
                case '4':
                    new StoreMenu(customer, new ShoppingCartService(new ShoppingCartDAO()),itemsService).start();
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
