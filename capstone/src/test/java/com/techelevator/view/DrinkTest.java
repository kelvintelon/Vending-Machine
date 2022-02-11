package com.techelevator.view;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class DrinkTest {

    @Test
    public void testConstructor() {
        // arrange
        Drink drinkTest = new Drink("C1", "Gatorade", BigDecimal.valueOf(1), "Drink");
        // act
        String expectedSlotResult = "C1";
        String expectedCategoryResult = "Drink";

        String result = drinkTest.getSlotLocation();
        String result1 = drinkTest.getCategory();
        // assert
        Assert.assertEquals(expectedSlotResult,result);
        Assert.assertEquals(expectedCategoryResult,result1);


    }
}
