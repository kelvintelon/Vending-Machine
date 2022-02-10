package com.techelevator;

import com.techelevator.view.InventoryReader;
import com.techelevator.view.Menu;
import com.techelevator.view.Product;

public class VendingMachineCLI {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String EXIT_MAIN_MENU = "Exit";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE };
	private double balance = 0.00;
	private static final String FEED_MONEY = "Feed money";
	private static final String FEED_MONEY_ONE = "Add One Dollar";
	private static final String FEED_MONEY_TWO = "Add Two Dollars";
	private static final String FEED_MONEY_FIVE = "Add Five Dollars";
	private static final String FEED_MONEY_TEN = "Add Ten Dollars";
	private static final String[] FEED_MENU_OPTIONS = { FEED_MONEY_ONE, FEED_MONEY_TWO, FEED_MONEY_FIVE, FEED_MONEY_TEN};
	private static final String SELECT_PRODUCT = "Select Product";
	private static final String FINISH_TRANSACTION = "Final Transaction";
	private static final String[] PURCHASE_MENU_OPTIONS = {FEED_MONEY, SELECT_PRODUCT, FINISH_TRANSACTION};




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
					addBalance(1.00);
				} if (moneyChoice.equals(FEED_MONEY_TWO)) {
					addBalance(2.00);
				} if (moneyChoice.equals(FEED_MONEY_FIVE)) {
					addBalance(5.00);
				} if (moneyChoice.equals(FEED_MONEY_TEN)) {
					addBalance(10.00);
				}
			} else if (choice.equals(SELECT_PRODUCT)) {
				//select product method
			} else if (choice.equals(FINISH_TRANSACTION)) {
				// finish transaction method
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
		
	}





	public void displayVendingMachineInventory() {
		InventoryReader list = new InventoryReader();
		for (Product name: list.fileInventory()) {
			if (name.getInventory() == 0) {
				System.out.println("Out of stock");
			}
			System.out.println(name.getSlotLocation() + " " + name.getName() + " " + name.getPrice() + " " + name.getCategory());
		}
	}


	public void addBalance(double money) {
		if (money == 1.00) {
			balance += 1.00;
		} if (money == 2.00) {
			balance += 2.00;
		} if (money == 5.00) {
			balance += 5.00;
		}if (money == 10.00) {
			balance += 10.00;
		}

	}
}
