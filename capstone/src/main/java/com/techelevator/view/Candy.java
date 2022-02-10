package com.techelevator.view;

public class Candy extends Product{
    public Candy(String slotLocation, String name, double price, String category, int inventory) {
        super(slotLocation, name, price, category, inventory);
    }

    @Override
    public String dispensedSound() {
        return "Munch Munch, Yum!";
    }

    Candy moonpie = new Candy("B1", "Moonpie", 1.80, "Candy", 5);
    Candy cowtales = new Candy("B2", "Cowtales", 1.50, "Candy", 5);
    Candy wonkaBar = new Candy("B3", "Wonka Bar", 1.50, "Candy", 5);
    Candy crunchie = new Candy("B4", "Crunchie", 1.75, "Candy", 5);
}
