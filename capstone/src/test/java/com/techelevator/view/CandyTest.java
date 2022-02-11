package com.techelevator.view;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class CandyTest {


    @Test
    public void testConstructor() {
        // arrange
    Candy candyTest = new Candy("A1", "Gummy Bear", BigDecimal.valueOf(2), "Candy");
        // act
        String expectedSlotResult = "A1";
        String expectedCategoryResult = "Candy";

        String result = candyTest.getSlotLocation();
        String result1 = candyTest.getCategory();
        // assert
        Assert.assertEquals(expectedSlotResult,result);
        Assert.assertEquals(expectedCategoryResult,result1);


    }
}
