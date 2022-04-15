package com.project1.ui;

import com.project1.daos.ItemsDAO;
import com.project1.daos.ShoppingCartDAO;
import com.project1.models.*;
import com.project1.services.*;

import java.util.List;
import java.util.Scanner;

public class ShoppingCarMenu implements IMenu {

    private final Customer customer;

    private final ItemsService itemsService;

    private final ShoppingCartService shoppingCartService;
    private final DepartmentService departmentService;
    private final PurchaseService purchaseService;

    public ShoppingCarMenu(Customer customer, ItemsService itemsService, ShoppingCartService shoppingCartService,
                           DepartmentService departmentService, PurchaseService purchaseService) {
        this.customer = customer;

        this.itemsService = itemsService;
        //   this.shoppingCart = shoppingCart;
        this.shoppingCartService = shoppingCartService;
        this.departmentService = departmentService;
        this.purchaseService = purchaseService;
    }

    @Override
    public void start() {


        char input = ' ';
        boolean exit = false;
        Scanner scan = new Scanner(System.in);

        while (!exit) {

            System.out.println("\n\t\t **** Shopping Cart Menu ****");
            System.out.println("[1] Show Items");
            System.out.println("[2] View Cart");
            System.out.println("[3] View History");
            System.out.println("[4] Purchase from Cart");
            System.out.println("[5] Go back to previous menu");
            System.out.println("[x] Exit");

            System.out.print("\nEnter: ");
            input = scan.next().toLowerCase().charAt(0);

            switch (input) {
                case '1':
                    showItems();
                    break;
                case '2':
                    viewCart();
                    break;
                case '3':
                    viewHistory();
                    break;
                case '4':
                    purchase();
                    break;
                case '5':
                    new StoreMenu(customer, new ShoppingCartService(new ShoppingCartDAO()), new ItemsService(itemsService.getItemsDAO())).start();

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


    private void showItems() {
        List<Items> itemsList = itemsService.getItemsDAO().findAll();

        System.out.println("\t*** Items ***");

        for (int i = 0; i < itemsList.size(); i++) {
            System.out.println("[" + (i + 1) + "] " + itemsList.get(i).getName());
        }

    }


    private void viewCart() {


        List<ShoppingCart> shoppingCartList = shoppingCartService.getShoppingCartDAO().findAll();

        for (int i = 0; i < shoppingCartList.size(); i++) {
            System.out.println("[" + (i + 1) + "] " + shoppingCartList.get(i).getName() + "\t\t" +
                    shoppingCartList.get(i).getPrice());


        }

    }

    private void viewHistory() {
        Items item = new Items();
        List<Purchase> purchaseList = purchaseService.getPurchaseDAO().findAll();

        System.out.println("\n *** Date ***\t\t\t*** Items ***\t\t\t *** Price ***");

        for (int i = 0; i < purchaseList.size(); i++) {

            String date = purchaseList.get(i).getDate();
            int cartId = purchaseList.get(i).getShopping_cart_id();
            int itemId = purchaseList.get(i).getItems_id();
            item = itemsService.getItemsDAO().findItemById(itemId);

            System.out.println(date + "\t" + item.getName() + "\t" + item.getPrice());


        }


    }


    private void purchase() {

        List<ShoppingCart> shoppingCartList = shoppingCartService.getShoppingCartDAO().findAll();


        Scanner scan = new Scanner(System.in);
        int input;


        for (int i = 0; i < shoppingCartList.size(); i++) {
            System.out.println("[" + (i + 1) + "] " + shoppingCartList.get(i).getName() + "\t\t" +
                    shoppingCartList.get(i).getPrice());

        }


        System.out.print("\nEnter: ");
        input = scan.nextInt() - 1;
        scan.nextLine();


        if (input < shoppingCartList.size()) {
            ShoppingCart thisShoppinCart = shoppingCartList.get(input);


            System.out.println("You've selected the " + thisShoppinCart.getName() + ". Would you like to add this to your cart?");

            if (scan.next().charAt(0) == 'y') {

                Purchase purchase = new Purchase();


                Items item = new Items();


                purchase.setShopping_cart_id(thisShoppinCart.getId());
                purchase.setDate(purchase.getDate());
                purchase.setItems_id(thisShoppinCart.getItemsId());


                System.out.println(purchase.getShopping_cart_id());

                purchaseService.getPurchaseDAO().save(purchase);

                System.out.println("Purchase was successful");

                List<Purchase> purchaseList = purchaseService.getPurchaseDAO().findAll();

                int id = shoppingCartList.get(input).getId();
                int shopping_cart_id = purchaseList.get(input).getShopping_cart_id();


//                purchaseService.getPurchaseDAO().removeById(shopping_cart_id);
//                shoppingCartService.getShoppingCartDAO().deletedFromCart2(id);


                System.out.println("Press X to go back to previous menu");

                while (true) {

                    char x;
                    x = scan.next().toLowerCase().charAt(0);

                    if (x == 'x') {

                        new ElectronicDeptMenu(customer, new ItemsService(new ItemsDAO())).start();
                        break;
                    } else {
                        System.out.println("Invalid key");
                    }


                }

            }
        }

    }
}