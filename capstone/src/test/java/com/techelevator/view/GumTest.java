package com.techelevator.view;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class GumTest {
    @Test
    public void testConstructor() {
        // arrange
        Gum gumTest = new Gum("D1", "Juicy Fruit", BigDecimal.valueOf(2), "Gum");
        // act
        String expectedSlotResult = "D1";
        String expectedCategoryResult = "Gum";

        String result = gumTest.getSlotLocation();
        String result1 = gumTest.getCategory();
        // assert
        Assert.assertEquals(expectedSlotResult,result);
        Assert.assertEquals(expectedCategoryResult,result1);


    }



}
