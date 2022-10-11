package com.techelevator.controllers;

import com.techelevator.view.InventoryReader;
import com.techelevator.view.Log;
import com.techelevator.view.Product;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@RestController
@CrossOrigin
public class VendingMachineController {

    public InventoryReader list = new InventoryReader();
    public List<Product> newItemList = list.fileInventory();
    public Log moneyPrint = new Log();

    private BigDecimal balance = new BigDecimal(0).setScale(2, RoundingMode.HALF_UP);

    @RequestMapping(path= "/getList", method = RequestMethod.GET)
    public List<Product> getList() {
        return newItemList;
    }


}
