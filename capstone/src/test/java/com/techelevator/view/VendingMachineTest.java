package com.techelevator.view;

import com.techelevator.VendingMachineCLI;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VendingMachineTest {

    @Test
    public void addBalanceTest() throws FileNotFoundException {
        // arrange
        VendingMachineCLI vendingmachineBalance = new VendingMachineCLI();
        vendingmachineBalance.addBalance(2);

        // act
        BigDecimal result = new BigDecimal(2).setScale(2, RoundingMode.HALF_UP);
        BigDecimal expectedResult = vendingmachineBalance.getBalance();
        // assert
        Assert.assertEquals(expectedResult, result);
    }

    @Test
    public void productSelectionTest() throws FileNotFoundException {
        // arrange
        VendingMachineCLI vendingMachTest = new VendingMachineCLI();
        Drink drinkTest = new Drink("C1", "Gatorade", BigDecimal.valueOf(1), "Drink");
        List<Product> productTest = new ArrayList<>();
        vendingMachTest.addBalance(10);
        productTest.add(drinkTest);
        productTest.add(drinkTest);
        productTest.add(drinkTest);
        productTest.add(drinkTest);
        vendingMachTest.productSelection(productTest,"C1");
        vendingMachTest.productSelection(productTest,"C1");
        // act
        BigDecimal result = vendingMachTest.getBalance();
        BigDecimal expectedResult = BigDecimal.valueOf(8).setScale(2, RoundingMode.HALF_UP);
        // assert
        Assert.assertEquals(expectedResult,result);
    }

    @Test
    public void finishTransactionTest() throws FileNotFoundException {
        // arrange
        VendingMachineCLI vendingMach = new VendingMachineCLI();
        vendingMach.addBalance(10);

        // act
        vendingMach.finishTransaction();
        BigDecimal expectedResult = new BigDecimal(0).setScale(2, RoundingMode.HALF_UP);
        BigDecimal result = vendingMach.getBalance();

        // assert
        Assert.assertEquals(expectedResult,result);

    }

    @Test
    public void displayInventoryTest() {
        VendingMachineCLI vendingMachTest = new VendingMachineCLI();
        Drink drinkTest = new Drink("C1", "Gatorade", BigDecimal.valueOf(1), "Drink");
        List<Product> productTest = new ArrayList<>();
        productTest.add(drinkTest);
        productTest.add(drinkTest);
        productTest.add(drinkTest);
        // should print the list
        vendingMachTest.displayVendingMachineInventory(productTest);

    }
}
