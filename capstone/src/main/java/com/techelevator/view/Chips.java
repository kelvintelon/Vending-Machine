package com.techelevator.view;

public class Chips extends Product{
    public Chips(String slotLocation, String name, double price, String category, int inventory) {
        super(slotLocation, name, price, category, inventory);
    }

    @Override
    public String dispensedSound() {
        return "Crunch Crunch, Yum!";
    }


    Chips potatoCrisps = new Chips("A1", "Potato Crisps", 3.05, "Chips", 5);
    Chips stackers = new Chips("A2", "Stackers", 1.45, "Chips", 5);
    Chips grainWaves = new Chips("A3", "Grain Waves", 2.75, "Chips", 5);
    Chips cloudPopcorn = new Chips("A4", "Cloud Popcorn", 3.65, "Chips", 5);
}
