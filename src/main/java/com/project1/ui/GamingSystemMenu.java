package com.project1.ui;

import com.project1.daos.ItemsDAO;
import com.project1.models.Customer;
import com.project1.models.Items;
import com.project1.models.ShoppingCart;
import com.project1.services.ItemsService;
import com.project1.services.ShoppingCartService;

import java.util.List;
import java.util.Scanner;

public class GamingSystemMenu implements IMenu {


    private final ShoppingCartService shoppingCartService;
    private final Customer customer;
    private final ItemsService itemsService;


    public GamingSystemMenu(ShoppingCartService shoppingCartService, Customer customer, ItemsService itemsService) {
        this.shoppingCartService = shoppingCartService;
        this.customer = customer;
        this.itemsService = itemsService;
    }


    @Override
    public void start() {


        List<Items> items = itemsService.getItemsDAO().findAll();


        Scanner scan = new Scanner(System.in);
        int input;

        System.out.println(" #  *** Items *** \t\t\t\t\t*** Prices ***\t *** Stock ***");

        for (int i = 0; i < items.size(); i++) {

            System.out.println("[" + (i + 1) + "] " + items.get(i).getName() + "\t\t" +
                    items.get(i).getPrice() + "\t\t\t\t" + items.get(i).getStock());
        }


        System.out.print("\nItem Number Enter: ");


        input = scan.nextInt() - 1;

        scan.nextLine();


        if (input < items.size()) {
            Items thisItem = items.get(input);

            System.out.println("You've selected the " + thisItem.getName() + ". Would you like to add this to your cart?");

            if (scan.next().charAt(0) == 'y') {
                ShoppingCart shoppingCart = new ShoppingCart();

                shoppingCart.setItemsId(thisItem.getId());
                shoppingCart.setCustomersId(customer.getId());
                shoppingCart.setName(thisItem.getName());
                shoppingCart.setPrice(thisItem.getPrice());

                shoppingCartService.getShoppingCartDAO().save(shoppingCart);



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
