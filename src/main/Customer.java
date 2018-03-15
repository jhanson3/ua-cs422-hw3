/*
 * Customer.java
 * Author: Jeremiah Hanson
 * ----------------------------------------------------------------
 * This class controls a Customer
 */

package main;

public class Customer implements Runnable{

	private String name;
	Barber barber;
	
	/*
	 * Constructor
	 * Author: Jeremiah Hanson
	 * ----------------------------------------------
	 * Parameters:
	 * 	name: the name of the customer
	 * 	barber: the barber
	 */
	public Customer(String name, Barber barb) {
		this.name = name;
		this.barber = barb;
	}
	
	@Override
	public void run() {
		
		if (!barber.isChair(name))
			return;
		
		synchronized(barber) {
			barber.cutHair(name);
		}
		
	}

}
