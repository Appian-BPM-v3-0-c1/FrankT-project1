package com.revature.project1.ui;

import java.util.Scanner;

public class MainMenu implements IMenu {


    @Override
    public void start() {
        char input = ' ';
        boolean exit = false;
        Scanner scan = new Scanner(System.in);

        while (!exit) {
            System.out.println("\nWelcome to Super Store!");
            System.out.println("Select Department Store using numbers from 1 to 3");
            System.out.println("[1] Electronic Department");
            System.out.println("[2] Food department");
            System.out.println("[3] Sport Department");
            System.out.println("[x] Exit");

            System.out.print("\nEnter: ");
            input = scan.next().toLowerCase().charAt(0);

            switch (input) {
                case '1':
                    new ElectronicDepartment().start();
                    break;
                case '2':
                    new FoodDepartment().start();
                    break;
                case '3':
                    new SportDepartment().start();
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
