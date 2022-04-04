package com.revature.project1.ui;

import java.util.Scanner;

public class ElectronicDepartment implements IMenu {
    @Override
    public void start() {
        char input = ' ';
        boolean exit = false;
        Scanner scan = new Scanner(System.in);

        while (!exit) {
            System.out.println("\nWelcome to the Electronic Department!");
            System.out.println("Select Department Store using numbers from 1 to 3");
            System.out.println("[1] Game Systems");
            System.out.println("[2] Tvs");
            System.out.println("[3] Computers");
            System.out.println("[x] Exit");

            System.out.print("\nEnter: ");
            input = scan.next().toLowerCase().charAt(0);

            switch (input) {
                case '1':
                    new StoreMenu().start();
                    break;
                case '2':
                    break;
                case '3':
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
