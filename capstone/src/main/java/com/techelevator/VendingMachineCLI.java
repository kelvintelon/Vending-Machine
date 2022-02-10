package com.techelevator;

import com.techelevator.view.InventoryReader;
import com.techelevator.view.Menu;
import com.techelevator.view.Product;

public class VendingMachineCLI {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String EXIT_MAIN_MENU = "Exit";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE };
	private double balance;
	private static final String FEED_MONEY = "Add money";
	private static final String FEED_MONEY_ONE = "Add One Dollar";
	private static final String FEED_MONEY_TWO = "Add Two Dollars";
	private static final String FEED_MONEY_FIVE = "Add Five Dollars";
	private static final String FEED_MONEY_TEN = "Add Ten Dollars";
	private static final String[] FEED_MENU_OPTIONS = { FEED_MONEY_ONE, FEED_MONEY_TWO, FEED_MONEY_FIVE, FEED_MONEY_TEN};




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
				if  {

				}
					menu.getChoiceFromOptions(FEED_MENU_OPTIONS);

			} else if (choice.equals(EXIT_MAIN_MENU)) {
				// exit
			}
		}
	}

	public static void main(String[] args) {
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		cli.run();
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


	public void addBalance(int money) {
		this.balance = this.balance + money;
		System.out.println("Balance is " + balance);
	}
}
