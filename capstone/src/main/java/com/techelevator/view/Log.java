package com.techelevator.view;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class Log {

    private static final SimpleDateFormat sdf1 = new SimpleDateFormat("MM-dd-yyy HH:mm:ss aa");
    Timestamp timestamp = new Timestamp(System.currentTimeMillis());

    public void logWriter(String message, BigDecimal a, BigDecimal b) {
        File destinationFile = new File("src/main/resources/log.txt");

        try (PrintWriter moneyPrint = new PrintWriter(new FileOutputStream(destinationFile, true))) {
            moneyPrint.println(sdf1.format(timestamp) + " " + message + " $" + a + " $" + b);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public void moneyWriter(String name, String slot, BigDecimal a, BigDecimal b) {
        File destinationFile = new File("src/main/resources/log.txt");

        try (PrintWriter moneyPrint = new PrintWriter(new FileOutputStream(destinationFile, true))) {
            moneyPrint.println(sdf1.format(timestamp) + " " + name + " " + slot + " $" + a + " $" + b);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}



