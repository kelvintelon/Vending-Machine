package com.techelevator.view;

public abstract class Product {

    private String slotLocation;
    private String name;
    private double price;
    private String category;
    private int inventory;

    public Product(String slotLocation, String name, double price, String category, int inventory) {
        this.slotLocation = slotLocation;
        this.name = name;
        this.price = price;
        this.category = category;
        this.inventory = 5;
    }

    public String getSlotLocation() {
        return slotLocation;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }

    public String dispensedSound() {
        return "";
    }

    public void setSlotLocation(String slotLocation) {
        this.slotLocation = slotLocation;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }
}
