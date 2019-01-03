/*************************************************************************
 * Represents an item in a vending machine.
 * 
 * CSCE 155A Spring 2018
 * Assignment 4
 * @file Item.java
 * @author Justin Brinkman
 * @date March 25, 2018
 *************************************************************************/


public class Item {
	public String description;
	public double price;
	public int quantity;
	
	
	/*********************************************************************
	 * This is the constructor of the Item class. It accepts a description, 
	 * price and quantity for a vending machine item.
	 * 
	 * @param itemDescription: name of item
	 * 	itemPrice: price of item
	 * itemQuantity: quantity of item
	 * 
	 *********************************************************************/
	public Item(String itemDescription, double itemPrice, int itemQuantity){
		description = itemDescription;
		price = itemPrice;
		quantity = itemQuantity;
	}
}
