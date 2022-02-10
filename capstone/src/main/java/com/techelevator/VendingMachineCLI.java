package com.techelevator;

import com.techelevator.view.InventoryReader;
import com.techelevator.view.Menu;
import com.techelevator.view.Product;

import java.math.BigDecimal;
import java.util.Scanner;

public class VendingMachineCLI {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String EXIT_MAIN_MENU = "Exit";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE };
	private BigDecimal balance;
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
		for (int i = 0; i < list.fileInventory().size(); i++) {
//			if (!(list.fileInventory().get(i).getSlotLocation().equals(userChoice))) {
//				System.out.println("This item doesn't exist here.");
//				break;
//			}
			if (list.fileInventory().get(i).getSlotLocation().equals(userChoice)) {
				BigDecimal cost = list.fileInventory().get(i).getPrice();
				if (balance.compareTo(cost) >= 0) {
					// subtracts from balance
					balance.subtract(cost);
					// removes from inventory
					list.fileInventory().get(i).setInventory(list.fileInventory().get(i).getInventory() - 1);
					System.out.println(list.fileInventory().get(i).dispensedSound());
				} else {
					System.out.println("Feed Money");
			}
			}
		}
	}

//	public void finishTransaction() {
//		balance;
//	}
//
//	public void getChange(BigDecimal balance) {
//		BigDecimal quarter = BigDecimal.valueOf(.25);
//		BigDecimal quarterCount = balance.divide(quarter);
//		BigDecimal quarterBalance = (balance.subtract(balance.divide(quarter)));
//
//
//	}




	public void displayVendingMachineInventory() {
		for (Product name: list.fileInventory()) {
			if (name.getInventory() == 0) {
				System.out.println("Out of stock");
			}
			System.out.println(name.getSlotLocation() + " " + name.getName() + " "
					+ name.getPrice() + " " + name.getCategory());
		}
	}


	public void addBalance(int money) {
		if (money == 1) {
			BigDecimal one = BigDecimal.valueOf(1.0);
			balance.add(one);
		} if (money == 2) {
			BigDecimal two = BigDecimal.valueOf(2.0);
			balance.add(two);
		} if (money == 5) {
			BigDecimal five = BigDecimal.valueOf(5.0);
			balance.add(five);
		}if (money == 10) {
			BigDecimal ten = BigDecimal.valueOf(10.0);
			balance.add(ten);
		}

	}
}
