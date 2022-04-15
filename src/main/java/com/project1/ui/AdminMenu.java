/*Notes to self
I need to add the option for the admin user to add new
products  04/14/22
 */


package com.project1.ui;

import com.project1.daos.ItemsDAO;
import com.project1.models.Items;
import com.project1.services.ItemsService;

import java.util.List;
import java.util.Scanner;

public class AdminMenu implements IMenu {

    private final ItemsService itemsService;

    public AdminMenu(ItemsService itemsService) {
        this.itemsService = itemsService;
    }

    @Override
    public void start() {
        System.out.println("\nAdmin menu");


        char input;
        Scanner scan = new Scanner(System.in);

        exit:
        {
            while (true) {
                System.out.println("\nWelcome to the admin menu!");
                System.out.println("Please select 1 to sign in,\n " +
                        "select two to create an account, or select x to exit the program");
                System.out.print("\n[1] Update stock in the Electronic Department ");
                System.out.print("\n[2] Add new Departments");
                System.out.print("\n[x] Exit");

                System.out.print("\nEnter: ");
                input = scan.next().toLowerCase().charAt(0);

                switch (input) {
                    case '1':
                        stockUpdate();
                        break;
                    case '2':

                         addNewDepartment();
                    case 'x':

                        break exit;
                    default:
                        System.out.println("\nInvalid input!");
                        break;
                }
            }
        }

    }

    private void stockUpdate() {
        int input = 0;
        List<Items> items = itemsService.getItemsDAO().findAll();
        Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.println("\nPlease select an item to restock");

            System.out.println("#\t\tItems\t\t\t\t\t\t\t\t\t Price\n");
            for (int i = 0; i < items.size(); i++) {
                System.out.println("[" + (i + 1) + "] " + items.get(i).getName() + "\t\t\t\t" +
                        items.get(i).getPrice() + items.get(i).getStock());
            }

            input = scan.nextInt() - 1;


            System.out.println("Please select an Item to restock");

            if (input < items.size()) {
                Items selectItem = items.get(input);


                    System.out.println("\nYou selected " + selectItem.getName());
                    System.out.println("\nPlease enter in restock quantity");

                    selectItem.setStock(scan.nextInt());

                    System.out.println("\nIs this correct? (y/n)");
                    System.out.println(selectItem);



                    if (scan.next().charAt(0) == 'y') {
                        itemsService.getItemsDAO().update(selectItem);
                    }


                System.out.println("\nInvalid input!");
            }
        }
    }

    private void addNewDepartment () {

        System.out.println("\n *** Function coming soon!!! ***");
        new AdminMenu(new ItemsService(new ItemsDAO())).start();
    }
}
