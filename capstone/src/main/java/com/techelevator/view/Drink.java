package com.techelevator.view;

public class Drink extends Product{
    public Drink(String slotLocation, String name, double price, String category) {
        super(slotLocation, name, price, category);
    }

    @Override
    public String dispensedSound() {
        return "Glug Glug, Yum!";
    }



}
