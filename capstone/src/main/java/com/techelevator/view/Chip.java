package com.techelevator.view;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Chip extends Product{


    public Chip(String slotLocation, String name, BigDecimal price, String category) {
        super(slotLocation, name, price, category);
    }

    @Override
    public String dispensedSound() {
        return "Crunch Crunch, Yum!";
    }







}
