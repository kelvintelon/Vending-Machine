package com.techelevator.view;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class InventoryReaderTest {

    @Test
    public void Test_Reader_Method() {
        InventoryReader test = new InventoryReader();

        List<Product> testList = test.fileInventory();
        boolean expectedResult1 = testList.get(0).getName().equals("Potato Crisps");
        boolean expectedResult2 = testList.get(4).getName().equals("Moonpie");
        boolean expectedResult3 = testList.get(8).getName().equals("Cola");
        boolean expectedResult4 = testList.get(12).getName().equals("U-Chews");


        Assert.assertEquals(true,expectedResult1);
        Assert.assertEquals(true, expectedResult2);
        Assert.assertEquals(true, expectedResult3);
        Assert.assertEquals(true, expectedResult4);

    }


}
