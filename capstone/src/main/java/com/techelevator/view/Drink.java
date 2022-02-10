package com.techelevator.view;

import java.math.BigDecimal;

public class Drink extends Product{
    public Drink(String slotLocation, String name, BigDecimal price, String category) {
        super(slotLocation, name, price, category);
    }

    @Override
    public String dispensedSound() {
        return "Glug Glug, Yum!";
    }



}
