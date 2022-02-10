package com.techelevator.view;

import java.math.BigDecimal;

public class Candy extends Product{
    public Candy(String slotLocation, String name, BigDecimal price, String category) {
        super(slotLocation, name, price, category);
    }

    @Override
    public String dispensedSound() {
        return "Munch Munch, Yum!";
    }


}
