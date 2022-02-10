package com.techelevator.view;

import java.math.BigDecimal;

public class Gum extends Product{
    public Gum(String slotLocation, String name, BigDecimal price, String category) {
        super(slotLocation, name, price, category);
    }

    @Override
    public String dispensedSound() {
        return "Chew Chew, Yum!";
    }


}
