package com.techelevator.view;

public class Gum extends Product{
    public Gum(String slotLocation, String name, double price, String category, int inventory) {
        super(slotLocation, name, price, category, inventory);
    }

    @Override
    public String dispensedSound() {
        return "Chew Chew, Yum!";
    }

    Gum uChews = new Gum("D1", "U-Chews", 0.85, "Gum", 5);
    Gum littleLeague = new Gum("D2", "Little League", 0.95, "Gum", 5);
    Gum chiclets = new Gum("D3", "Chiclets", 0.75, "Gum", 5);
    Gum triplemint = new Gum("D4", "Triplemint", 0.75, "Gum", 5);
}
