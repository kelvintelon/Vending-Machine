package com.techelevator;

import com.techelevator.view.InventoryReader;
import com.techelevator.view.Menu;
import com.techelevator.view.Product;

import java.math.BigDecimal;
import java.sql.SQLOutput;
import java.util.List;
import java.util.Scanner;

public class VendingMachineCLI {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String EXIT_MAIN_MENU = "Exit";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE, EXIT_MAIN_MENU };
	private BigDecimal balance = new BigDecimal(0);
	private static final String FEED_MONEY = "Feed money";
	private static final String FEED_MONEY_ONE = "Add One Dollar";
	private static final String FEED_MONEY_TWO = "Add Two Dollars";
	private static final String FEED_MONEY_FIVE = "Add Five Dollars";
	private static final String FEED_MONEY_TEN = "Add Ten Dollars";
	private static final String[] FEED_MENU_OPTIONS = { FEED_MONEY_ONE, FEED_MONEY_TWO, FEED_MONEY_FIVE, FEED_MONEY_TEN};
	private static final String SELECT_PRODUCT = "Select Product";
	private static final String FINISH_TRANSACTION = "Finish Transaction";
	private static final String[] PURCHASE_MENU_OPTIONS = {FEED_MONEY, SELECT_PRODUCT, FINISH_TRANSACTION};
	public InventoryReader list = new InventoryReader();
	public List<Product> newItemList = list.fileInventory();

	private Menu menu;

	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
	}

	public void run() {
		while (true) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				// display vending machine items
				displayVendingMachineInventory();
			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				// do purchase
				purchaseOptions();
			} else if (choice.equals(EXIT_MAIN_MENU)) {
				// exit
				System.out.println("Thank you come again");
				System.exit(1);
			}
		}
	}

	public void purchaseOptions(){
		while (true) {
			String choice = (String) menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);

			if (choice.equals(FEED_MONEY)) {
				// handle money method
				String moneyChoice = (String) menu.getChoiceFromOptions(FEED_MENU_OPTIONS);
				if (moneyChoice.equals(FEED_MONEY_ONE)) {
					addBalance(1);
				} if (moneyChoice.equals(FEED_MONEY_TWO)) {
					addBalance(2);
				} if (moneyChoice.equals(FEED_MONEY_FIVE)) {
					addBalance(5);
				} if (moneyChoice.equals(FEED_MONEY_TEN)) {
					addBalance(10);
				}
			} else if (choice.equals(SELECT_PRODUCT)) {
				//select product method
				productSelection();
			} else if (choice.equals(FINISH_TRANSACTION)) {
				// finish transaction method
				finishTransaction();
			}
			System.out.println("Current Money Provided: $" + balance);
		}
	}


	public static void main(String[] args) {
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		cli.run();
	}


	public void productSelection() {
		displayVendingMachineInventory();
		System.out.println("Select a code ");
		Scanner userInput = new Scanner(System.in);
		String userChoice = userInput.nextLine();
		for (int i = 0; i < newItemList.size(); i++) {
			if (!(newItemList.get(i).getSlotLocation().equals(userChoice))) {
				System.out.println("This item doesn't exist here.");
				return;
			}
			if (newItemList.get(i).getSlotLocation().equals(userChoice)) {
				BigDecimal cost = newItemList.get(i).getPrice();
				if (balance.compareTo(cost) >= 0) {
					// check inventory
					if (newItemList.get(i).getInventory() == 0) {
						System.out.println("Sold out");
						return;
					}
					// subtracts from balance
					balance = balance.subtract(cost);

					// removes from inventory
					newItemList.get(i).sellProduct();


					System.out.println("Quantity left of item: " + newItemList.get(i).getInventory());
					System.out.println(newItemList.get(i).dispensedSound());
				} else {
					System.out.println("Feed Money");
			}
			}
		}
	}

	public void finishTransaction() {
		getChange(balance);
		balance = new BigDecimal(0);
		run();
	}


	public void getChange(BigDecimal balance) {

		double balanceValue = balance.doubleValue();
		int change = (int) (Math.ceil(balanceValue*100));
		int quarters = Math.round((int)change/25);
		change = change % 25;
		int dimes = Math.round((int)change/10);
		change = change % 10;
		int nickels = Math.round((int)change/5);
		change = change % 5;

		System.out.println("Return Change: Quarters: " + quarters + " Dime: " + dimes + " Nickel: " + nickels);

	}




	public void displayVendingMachineInventory() {
		for (Product name : newItemList) {
			if (name.getInventory() == 0) {
				System.out.println(name.getSlotLocation() + " " + name.getName() + " is Out of stock");
			} else {
				System.out.println(name.getSlotLocation() + " " + name.getName() + " "
						+ name.getPrice() + " " + name.getCategory());
			}
		}
	}


	public void addBalance(int money) {

		if (money == 1) {
			balance = balance.add(new BigDecimal(1.0));
		} if (money == 2) {
			balance = balance.add(new BigDecimal(2.0));
		} if (money == 5) {
			balance = balance.add(new BigDecimal(5.0));
		}if (money == 10) {
			balance = balance.add(new BigDecimal(10.0));
		}

	}
}
