package com.techelevator.view;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InventoryReader {

    List<Product> inventoryList = new ArrayList<>();

    public List<Product> fileInventory() {
        File vendingMachine = new File("vendingmachine.csv");



        try (Scanner vendingMachineInventory = new Scanner(vendingMachine)) {
            while(vendingMachineInventory.hasNextLine()) {
               String inventoryLine = vendingMachineInventory.nextLine();
               String[] inventoryInformation = inventoryLine.split("\\|");

               if (inventoryInformation[0].contains("A")) {
                   Product name = new Chip(inventoryInformation[0],inventoryInformation[1], BigDecimal.valueOf(Double.parseDouble(inventoryInformation[2])),inventoryInformation[3]);
                   inventoryList.add(name);
               }
               if (inventoryInformation[0].contains("B")) {
                   Product name = new Candy(inventoryInformation[0],inventoryInformation[1], BigDecimal.valueOf(Double.parseDouble(inventoryInformation[2])),inventoryInformation[3]);
                   inventoryList.add(name);
               }
               if (inventoryInformation[0].contains("C")) {
                   Product name = new Drink(inventoryInformation[0],inventoryInformation[1], BigDecimal.valueOf(Double.parseDouble(inventoryInformation[2])),inventoryInformation[3]);
                   inventoryList.add(name);
               }
                if (inventoryInformation[0].contains("D")) {
                    Product name = new Gum(inventoryInformation[0],inventoryInformation[1], BigDecimal.valueOf(Double.parseDouble(inventoryInformation[2])),inventoryInformation[3]);
                    inventoryList.add(name);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();

        }
        return inventoryList;



    }

}
