package com.techelevator.view;

public class Candy extends Product{
    public Candy(String slotLocation, String name, double price, String category) {
        super(slotLocation, name, price, category);
    }

    @Override
    public String dispensedSound() {
        return "Munch Munch, Yum!";
    }


}
