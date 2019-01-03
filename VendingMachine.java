import java.io.*;
import java.util.Scanner;
import java.text.DecimalFormat;

/*************************************************************************
 * Simulates a real life vending machine with stock read from a file.
 * 
 * CSCE 155A Spring 2018
 * Assignment 4
 * @file VendingMachine.java
 * @author Jeremy Suing and Justin Brinkman
 * @version 1.0
 * @date March 5, 2018
 *************************************************************************/
public class VendingMachine {
	
	//data members
	public Item[] stock;  //Array of Item objects in machine
	public double money;  //Amount of revenue earned by machine
	public boolean usedA = false;
	public boolean usedB = false;
	DecimalFormat df = new DecimalFormat("0.00");
	/*********************************************************************
	 * This is the constructor of the VendingMachine class that take a
	 * file name for the items to be loaded into the vending machine.
	 *
	 * It creates objects of the Item class from the information in the 
	 * file to populate into the stock of the vending machine.  It does
	 * this by looping the file to determine the number of items and then
	 * reading the items and populating the array of stock. 
	 * 
	 * @param filename Name of the file containing the items to stock into
	 * this instance of the vending machine. 
	 * @throws FileNotFoundException If issues reading the file.
	 *********************************************************************/
	public VendingMachine(String filename) throws FileNotFoundException {
		//Open the file to read with the scanner
		File file = new File(filename);
		Scanner scan = new Scanner(file);

		//Determine the total number of items listed in the file
		int totalItem = 0;
		while (scan.hasNextLine()) {
			scan.nextLine();
			totalItem++;
		} //End while another item in file
		//Create the array of stock with the appropriate number of items
		stock = new Item[totalItem];
		scan.close();

		//Open the file again with a new scanner to read the items
		scan = new Scanner(file);
		int itemQuantity = -1;
		double itemPrice = -1;
		String itemDesc = "";
		int count = 0;
		String line = "";

		//Read through the items in the file to get their information
		//Create the item objects and put them into the array of stock
		while(scan.hasNextLine()) {
			line = scan.nextLine();
			String[] tokens = line.split(",");
			try {
				itemDesc = tokens[0];
				itemPrice = Double.parseDouble(tokens[1]);
				itemQuantity = Integer.parseInt(tokens[2]);

				stock[count] = new Item(itemDesc, itemPrice, itemQuantity);
				count++;
			} catch (NumberFormatException nfe) {
				System.out.println("Bad item in file " + filename + 
						" on row " + (count+1) + ".");
			}
		} //End while another item in file
		scan.close();
		
		//Initialize the money data variable.
		money = 0.0;
	} //End VendingMachine constructor
	
	/*********************************************************************
	 * This method completes the vending transaction given valid inputs.
	 * 
	 * @param money: amount of money the user put into the machine
	 * itemSelection: the user's selected item 
	 * 
	 *********************************************************************/
	public void vend(double userMoney, Item itemSelection){
		if(userMoney >= itemSelection.price && itemSelection.quantity > 0){
			outputMessage(userMoney, itemSelection);
			userMoney -= itemSelection.price;
			money += itemSelection.price;
			itemSelection.quantity -= 1;
		}else{
			outputMessage(userMoney, itemSelection);
		}
	}
	Scanner scanner = new Scanner(System.in);
	public boolean vending = true;
	
	
	/*********************************************************************
	 * This method displays the events of the transaction to the user.
	 * 
	 * @param money: amount of money the user put into the machine
	 * itemSelection: the user's selected item 
	 * 
	 *********************************************************************/
	public void outputMessage(double money, Item itemSelection){
		if(money >= itemSelection.price && itemSelection.quantity > 0){
			System.out.println("You selected: " + itemSelection.description);
			System.out.println("Vending item...");
			System.out.println("Returning change: "+"$"+
					df.format((money-itemSelection.price)));
		}else if(money < itemSelection.price){
			System.out.println("Not enough money for this item.");
			
			//loop to prompt user to enter a valid money value
			while(money < itemSelection.price){
				System.out.println("Enter more money (enter -1 to exit) ");
				if (scanner.hasNextInt()){
					int intMoney = scanner.nextInt();
					if (intMoney == -1){
						System.out.println("Thanks! Come Again.");
						System.exit(0);
					}else if(intMoney>0){
						money = money + intMoney;
					}else{
						System.out.println("Please enter a valid dollar value #.##");
					}
				}else if(scanner.hasNextDouble()){
					double moneyInput = scanner.nextDouble();
					if (moneyInput > 0){
						money = money + moneyInput;
					}else{
						System.out.println("Please enter a valid dollar value #.##");
						scanner.nextLine();
					}
				}else{
					System.out.println("Please enter a valid dollar value #.##");
					scanner.nextLine();
				}
			} System.out.println("You now have $" + df.format(money) + " to spend.");
			
			//make a selection after putting in more money
			boolean bool=true;
			Item userItem = null;
			while(bool==true){
				System.out.println("Please make a selection (enter 0 to exit)");
				if (scanner.hasNextInt()){
					int userInput = scanner.nextInt();
					if (userInput > 0){
						userItem = stock[userInput-1];
						bool=false;
					}else if(userInput ==0){
						bool=false;
						System.out.println("Thanks! Come Again.");
						System.exit(0);
					}else{
						System.out.println("Please make a valid selection.");
						scanner.nextLine();
					}
				}else{
					System.out.println("Please make a valid selection.");
					scanner.nextLine();
				}
			}
			
			vend(money, userItem);
			
		//if vending machine is out of item
		}else if(itemSelection.quantity <= 0){
			System.out.println("We are out of this item.");
			System.out.println("Choose another item (enter -1 to exit) ");
			int userInput = scanner.nextInt();
			if (userInput == -1){
				System.out.println("Thanks! Come Again.");
				System.exit(0);
			}scanner.nextLine();
			vend(money, stock[userInput-1]);
		}
	}
	
	
	/*********************************************************************
	 * This method displays the vending machine's menu to the user.
	 * 
	 *********************************************************************/
	public void printMenu(){
		System.out.printf("%-20s%-20s%-20s%-20s", "Item#", "Item", "Price",
				"Quantity");
		System.out.println();
		for(int i=0; i<stock.length; i++){
			System.out.printf("%-20s%-20s%-20s%-20s", (i+1),stock[i].description, 
					"$"+df.format(stock[i].price), stock[i].quantity);
			System.out.println();
		}
	}
	
} //End VendingMachine class definition
