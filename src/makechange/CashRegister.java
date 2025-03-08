package makechange;

import java.util.Scanner;

public class CashRegister {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		double itemCost = 0.0;
		double amountTendered = 0.0;
		double change = 0.0;
		
		// TODO: Welcome message (add quit feature?)
		
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
			// TODO: Call printChange method here
		}
		
	}
	
	// TODO: Calculate and display the number of bills and coins to be returned 

}
