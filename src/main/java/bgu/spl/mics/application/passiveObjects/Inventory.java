package main.java.bgu.spl.mics.application.passiveObjects;


import java.util.Arrays;
import java.util.HashMap;

/**
 * Passive data-object representing the store inventory.
 * It holds a collection of {@link BookInventoryInfo} for all the
 * books in the store.
 * <p>
 * This class must be implemented safely as a thread-safe singleton.
 * You must not alter any of the given public methods of this class.
 * <p>
 * You can add ONLY private fields and methods to this class as you see fit.
 */
public class Inventory {
	private BookInventoryInfo[] bookInventory;
	private static Inventory instance = null;
	private HashMap<String,Integer> hashMap;
	/**
     * Retrieves the single instance of this class.
     */
	public static Inventory getInstance() {
		if(instance == null) {
			instance = new Inventory();
		}
		return instance;
	}

	/**
     * Initializes the store inventory. This method adds all the items given to the store
     * inventory.
     * <p>
     * @param inventory 	Data structure containing all data necessary for initialization
     * 						of the inventory.
     */
	public void load (BookInventoryInfo[ ] inventory ) {
		this.bookInventory = inventory;
		for(int i = 0 ; i < bookInventory.length ; i++){
			hashMap.put(bookInventory[i].getBookTitle() , bookInventory[i].getAmountInInventory());
		}
	}
	
	/**
     * Attempts to take one book from the store.
     * <p>
     * @param book 		Name of the book to take from the store
     * @return 	an {@link Enum} with options NOT_IN_STOCK and SUCCESSFULLY_TAKEN.
     * 			The first should not change the state of the inventory while the 
     * 			second should reduce by one the number of books of the desired type.
     */

	public OrderResult take (String book) {
			int i = getSpecificBook(book);
			if(i!=-1){
				if(bookInventory[i].getAmountInInventory() > 0){
					bookInventory[i].reduceAmountInInventory();
					hashMap.replace(bookInventory[i].getBookTitle(),bookInventory[i].getAmountInInventory());
					return SUCCESSFULLY_TAKEN;
			}
		}
		return NOT_IN_STOCK;
		//todo:: complete the function;
	}

private int getSpecificBook(String book){
		for(int i = 0 ; i < bookInventory.length ; i++) {
		if (bookInventory[i].getBookTitle().equals(book)) {
		return i;
		}
		}
		return -1;
		}
	
	
	/**
     * Checks if a certain book is available in the inventory.
     * <p>
     * @param book 		Name of the book.
     * @return the price of the book if it is available, -1 otherwise.
     */
	public int checkAvailabiltyAndGetPrice(String book) {
		int i = getSpecificBook(book);
		if (i != -1)
			return bookInventory[i].getPrice();
		else return i;
	}
	
	/**
     * 
     * <p>
     * Prints to a file name @filename a serialized object HashMap<String,Integer> which is a Map of all the books in the inventory. The keys of the Map (type {@link String})
     * should be the titles of the books while the values (type {@link Integer}) should be
     * their respective available amount in the inventory. 
     * This method is called by the main method in order to generate the output.
     */
	public void printInventoryToFile(String filename){
		System.out.println(Arrays.asList(this.hashMap));
	}
}
