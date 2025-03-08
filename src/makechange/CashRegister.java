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
			System.out.printf("Change Due: %.2f\n", change);
			// TODO: Call getChange method here
			getChange(change);
		}
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
		System.out.println("\n\t\t\tWhere your input makes change!");
		System.out.println("\t\t\t  Press ENTER to continue...");
		sc.nextLine();
	}
	
	// TODO: Calculate and pass the number of bills and coins to be returned 
	public static void getChange (double changeDenom) {
		int cents = 0;
		int denomination = 0;
		int count = 0;
		
		cents = (int) (changeDenom * 100 + 0.5);
		denomination = 2_000;
		
		while(cents > 0) {
			count = cents /denomination;
			if(count > 0 ) {
				System.out.println(count + " " + findDenom(denomination, count));
				cents %= denomination;
			} 
			denomination = nextDenom(denomination);
			
		}
	}

	public static String findDenom(int denom, int count) {
		switch(denom) {
			case 2000:
				return "$20 dollar bill";
			case 1000:
				return "$10 dollar bill";
			case 500:
				return "$5 dollar bill";
			case 100:
				return "$1 dollar bill";
			case 25:
				return "quarter";
			case 10:
				return "dime";
			case 5:
				return "nickel";
			case 1:
				return "penny";
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