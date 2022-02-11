package com.techelevator.view;

import java.math.BigDecimal;

public abstract class Product {

    private String slotLocation;
    private String name;
    private BigDecimal price;
    private String category;
    private int inventory;

    public Product(String slotLocation, String name, BigDecimal price, String category) {
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

    public BigDecimal getPrice() {
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
        this.price = BigDecimal.valueOf(price);
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }

    public void sellProduct() {
        this.inventory -=1 ;
    }

    public int getInventory() {
        return this.inventory;
    }
}
