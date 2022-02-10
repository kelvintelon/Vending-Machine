package com.techelevator.view;

public class Drink extends Product{
    public Drink(String slotLocation, String name, double price, String category, int inventory) {
        super(slotLocation, name, price, category, inventory);
    }

    @Override
    public String dispensedSound() {
        return "Glug Glug, Yum!";
    }

    Drink cola = new Drink("C1", "Cola", 1.25, "Drink", 5);
    Drink drSalt = new Drink("C2", "Dr. Salt", 1.50, "Drink", 5);
    Drink mountainMelter = new Drink("C3", "Mountain Melter", 1.50, "Drink", 5);
    Drink heavy = new Drink("C1", "Heavy", 1.50, "Drink", 5);
}
