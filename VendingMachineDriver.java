import java.io.FileNotFoundException;
import java.util.*;
import java.text.DecimalFormat;

/*************************************************************************
 * Runs the vending machine.
 * 
 * CSCE 155A Spring 2018
 * Assignment 4
 * @file VendingMachineDriver.java
 * @author Justin Brinkman
 * @date March 25, 2018
 *************************************************************************/

public class VendingMachineDriver {
	
	/*************************************************************************
	 * Main method to run the program.
	 * 
	 *************************************************************************/
	public static void main(String[] args) throws FileNotFoundException{
		Scanner scanner = new Scanner(System.in);
		String machine;
		VendingMachine vendingMachineA = null;
		VendingMachine vendingMachineB = null;
		VendingMachine vendingMachine = null;
		DecimalFormat df = new DecimalFormat("0.00");
		
		System.out.println("Welcome to the vending machines!");

		
		//loop to run program
		boolean run = true;
		while(run==true){
			boolean bool = true;
		
			//prompts user to enter a valid input for selecting vending machine
			while(bool==true){
				System.out.println();
				System.out.println("Please select a vending machine: ");
				System.out.println("A-Drinks, B-Snacks, X-Exit: ");
				machine = scanner.nextLine();
				//running the drink machine
				if (machine.equalsIgnoreCase("A")){
					if (vendingMachineA==null||vendingMachineA.usedA == false){
						vendingMachineA = new VendingMachine("data/drinks.txt");
						bool = false;
						vendingMachineA.usedA = true;
					}else{
						bool=false;
					}vendingMachine = vendingMachineA;
					//running the snack machine
				}else if (machine.equalsIgnoreCase("B")){
					if (vendingMachineB==null||vendingMachineB.usedB == false){
						vendingMachineB = new VendingMachine("data/snacks.txt");
						bool = false;
						vendingMachineB.usedB = true;
					}else{
						bool=false;
					}vendingMachine = vendingMachineB;
				}else if (machine.equalsIgnoreCase("X")){
					bool = false;
					run = false;
					System.out.println("Thanks! Come Again.");
					System.exit(0);
				}else{
					System.out.println("Please enter a valid input.");
					bool = true;
				}
			}
		
		vendingMachine.printMenu();
		
		//gets valid money input from user
		double userMoney = 0.00;
		Item userItem = null;
		bool = true;
		while(bool==true){
			System.out.println("Please enter some money into the machine " +
					"(enter -1 to exit): ");
			if (scanner.hasNextInt()){
				int userInt = scanner.nextInt();
				if (userInt == -1){
					bool=false;
					run=false;
					System.out.println("Thanks! Come Again.");
					System.exit(0);
				}else if (userInt > 0.0){
					userMoney = userMoney + userInt;
					bool=false;
				}else{
					System.out.println("Please enter a valid dollar value #.##");
					bool=true;
				}scanner.nextLine();
			}else if(scanner.hasNextDouble()){
				double moneyInput = scanner.nextDouble();
				if (moneyInput > 0.0){
					userMoney = userMoney + moneyInput;
					bool=false;
				}else{
					System.out.println("Please enter a valid dollar value #.##");
					bool=true;
				}scanner.nextLine();
			}else{
				System.out.println("Please enter a valid dollar value #.##");
				bool=true;
				scanner.nextLine();
			}
		}
		
		//Allows user to select a valid item from the vending machine
		System.out.println("You now have $" + df.format(userMoney) + " to spend.");
		bool=true;
		while(bool==true){
			System.out.println("Please make a selection (enter 0 to exit)");
			if (scanner.hasNextInt()){
				int userInput = scanner.nextInt();
				if (userInput > 0 && userInput<=vendingMachine.stock.length){
					userItem = vendingMachine.stock[userInput-1];
					bool=false;
				}else if(userInput ==0){
					bool=false;
					System.out.println("Thanks! Come Again.");
					System.exit(0);
				}else{
					System.out.println("Please make a valid selection.");
				}scanner.nextLine();
			}else{
				System.out.println("Please make a valid selection.");
				scanner.nextLine();
			}
		}
		
		vendingMachine.vend(userMoney, userItem);
		}
		
		scanner.close();	
	}

}
