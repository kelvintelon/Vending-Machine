package com.techelevator.view;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class ChipTest {

    @Test
    public void testConstructor() {
        // arrange
        Chip chipTest = new Chip("B1", "Potato Crisps", BigDecimal.valueOf(3), "Chip");
        // act
        String expectedSlotResult = "B1";
        String expectedCategoryResult = "Chip";

        String result = chipTest.getSlotLocation();
        String result1 = chipTest.getCategory();
        // assert
        Assert.assertEquals(expectedSlotResult,result);
        Assert.assertEquals(expectedCategoryResult,result1);


    }




}
