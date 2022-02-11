package com.techelevator.view;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class LogTest {


    @Test
    public void writerTest() {
        // arrange
        Log test = new Log();

        // act
        test.logWriter("FEED MONEY",  BigDecimal.valueOf(2.00).setScale(2, RoundingMode.HALF_UP),
                BigDecimal.valueOf(2.00).setScale(2, RoundingMode.HALF_UP));
        test.moneyWriter("A1", "Potato Crisps",  BigDecimal.valueOf(2.00).setScale(2, RoundingMode.HALF_UP),
                BigDecimal.valueOf(2.00).setScale(2, RoundingMode.HALF_UP));

        // assert

    }


}
