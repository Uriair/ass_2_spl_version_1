package main.java.bgu.spl.mics.application.passiveObjects;

import java.util.ArrayList;
import java.util.List;

/**
 * Passive data-object representing a customer of the store.
 * You must not alter any of the given public methods of this class.
 * <p>
 * You may add fields and methods to this class as you see fit (including public methods).
 */
public class Customer {
	private int id;
	private String name;
	private String address;
	private int distance;
	private List<OrderReceipt> customerReceiptList;
	private int currentAmount;
	private int creditNumber;


	public Customer(int id , String name , String address , int distance , int Amount , int creditNumber){
		this.id = id;
		this.name = name;
		this.address = address;
		this.distance = distance;
		this.customerReceiptList = new ArrayList<OrderReceipt>();
		this.currentAmount = Amount;
		this.creditNumber = creditNumber;

	}
	/**
     * Retrieves the name of the customer.
     */
	public String getName() {
		return name;
	}

	/**
     * Retrieves the ID of the customer  . 
     */
	public int getId() {
		return id;
	}
	
	/**
     * Retrieves the address of the customer.  
     */
	public String getAddress() {
		return address;
	}
	
	/**
     * Retrieves the distance of the customer from the store.  
     */
	public int getDistance() {
		return distance;
	}

	
	/**
     * Retrieves a list of receipts for the purchases this customer has made.
     * <p>
     * @return A list of receipts.
     */
	public List<OrderReceipt> getCustomerReceiptList() {
		return customerReceiptList;
	}
	
	/**
     * Retrieves the amount of money left on this customers credit card.
     * <p>
     * @return Amount of money left.   
     */
	public int getAvailableCreditAmount() {
		return currentAmount;
	}

	public void chargeByAmount(int moneySpend) {
		this.currentAmount -= moneySpend;
	}

	public boolean isLegalOrder(int amount){
		return amount < currentAmount;
	}
	/**
     * Retrieves this customers credit card serial number.    
     */
	public int getCreditNumber() {
		return creditNumber;
	}
}
