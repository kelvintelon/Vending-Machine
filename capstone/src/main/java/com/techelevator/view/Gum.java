package com.techelevator.view;

public class Gum extends Product{
    public Gum(String slotLocation, String name, double price, String category) {
        super(slotLocation, name, price, category);
    }

    @Override
    public String dispensedSound() {
        return "Chew Chew, Yum!";
    }


}
