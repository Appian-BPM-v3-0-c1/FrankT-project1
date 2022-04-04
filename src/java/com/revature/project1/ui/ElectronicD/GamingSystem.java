package com.revature.project1.ui.ElectronicD;

public class GamingSystem {


    private final String gameConsole = "Xbox";
    private final float price = 150;


    public String getGameConsole() {
        return gameConsole;
    }

    public float getPrice() {
        return price;
    }

    public GamingSystem() {
    }

    @Override
    public String toString() {
        return "GamingSystem{" +
                "gameConsole='" + gameConsole + '\'' +
                ", price=" + price +
                '}';

    }





}
