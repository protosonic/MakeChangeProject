package makechange;

import java.util.Scanner;

public class CashRegister {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		double itemCost = 0.0;
		double amountTendered = 0.0;
		double change = 0.0;
		// call greeting method
		greetingPrompt();
		
		// Prompt user for price of item
		System.out.println("Enter the price of the item ($): ");
		itemCost  = sc.nextDouble();
		
		// Prompt user for amount tendered
		System.out.println("Enter the amount tendered ($): ");
		amountTendered = sc.nextDouble();
		
		change = amountTendered - itemCost;
		
		// Display message if provided too little or exact amount
		// - too little
		if(change < 0) {
			System.out.println("Error: Insufficient funds!\n"
					+ "Recommendation: Programming can be lucrative...");
		// - exact amount
		} else if(change == 0) {
			System.out.println("Exact change has been provided, therefore no change is needed"
					+ "\n\t\t\tHave a Great Day!"
					+ "\n\t\t\t\texiting...");
		// Display change
		} else {
			System.out.println("----------------------------");
			System.out.printf("🄲🄷🄰🄽🄶🄴 🄳🅄🄴: %.2f\n", change);
			System.out.println("----------------------------");
			
			// Calling change loop
			getChange(change);
		}
		closingPrompt();
		sc.close();	
	}
	// Greeting prompt
	public static void greetingPrompt() {
		Scanner sc = new Scanner(System.in);
		System.out.println(">>===============================================================================<<\n"
				+ "||   _____          __            _________ .__                                  ||\n"
				+ "||  /     \\ _____  |  | __ ____   \\_   ___ \\|  |__ _____    ____    ____   ____  ||\n"
				+ "|| /  \\ /  \\\\__  \\ |  |/ // __ \\  /    \\  \\/|  |  \\\\__  \\  /    \\  / ___\\_/ __ \\ ||\n"
				+ "||/    Y    \\/ __ \\|    <\\  ___/  \\     \\___|   Y  \\/ __ \\|   |  \\/ /_/  >  ___/ ||\n"
				+ "||\\____|__  (____  /__|_ \\\\___  >  \\______  /___|  (____  /___|  /\\___  / \\___  >||\n"
				+ "||        \\/     \\/     \\/    \\/          \\/     \\/     \\/     \\//_____/      \\/ ||\n"
				+ ">>===============================================================================<<");
		System.out.println("\n\t\t\tWhere your input affects change!");
		System.out.println("\t\t\t  Press ENTER to continue...");
		sc.nextLine();
	}
	
	public static void closingPrompt() {
		System.out.println("----------------------------");
		System.out.println("\n\n\t\t\tThank you for using MakeChange\u2122"
				+ "\n\t\t  \u00A9 2025 MakeChange Inc. All rights reserved.");
	}
	
	public static void getChange (double intoDollars) {
		int cents = 0;
		int denomination = 0;
		int count = 0;
		
		// Converting cents into dollars
		cents = (int) (intoDollars * 100 + 0.5);
		
		// Starting loop at $20
		denomination = 2_000;
		
		// Loop counts down cents
		while(cents > 0) {
			count = cents /denomination;
			if(count > 0 ) {
				System.out.println("↳ " + count + " " + findDenom(denomination, count));
				cents %= denomination;
			} 
			denomination = nextDenom(denomination);
		}
	}

	public static String findDenom(int denom, int count) {
		switch(denom) {
			case 2000:
				return "$20 dollar bill" + (count > 1 ? "s" : "");
			case 1000:
				return "$10 dollar bill" + (count > 1 ? "s" : ""); 
			case 500:
				return "$5 dollar bill" + (count > 1 ? "s" : "");
			case 100:
				return "$1 dollar bill" + (count > 1 ? "s" : "");
			case 25:
				return "quarter" + (count > 1 ? "s" : "");
			case 10:
				return "dime" + (count > 1 ? "s" : "");
			case 5:
				return "nickel" + (count > 1 ? "s" : "");
			case 1:
				return "penn" + (count > 1 ? "ies" : "y");
			default:
				return "0";
		}
	}
	
	public static int nextDenom(int current) {
		switch(current) {
		case 2000:
			return 1000;
		case 1000:
			return 500;
		case 500:
			return 100;
		case 100:
			return 25;
		case 25:
			return 10;
		case 10:
			return 5;
		case 5:
			return 1;
		default:
			return 0;
		}
	}
}