/*
 * Barber.java
 * Author: Jeremiah Hanson
 * ----------------------------------------------------------------
 * This class gives a customer access to the barbers services
 */

package main;

public class Barber {
	
	private int cutTime, numChairsAvail, numChairsUsed, customers;
	private int numCut, numLeft;

	/*
	 * Constructor
	 * Author: Jeremiah Hanson
	 * -------------------------------------------
	 * Parameters:
	 * 	time: time to cut one customers hair
	 * 	charis: number of chairs for waiting customers
	 * 	customers: the number of customers to arrive to the shop
	 */
	public Barber(int time, int chairs, int customers) {
		this.cutTime = time;
		this.numChairsAvail = chairs;
		this.numChairsUsed = 0;
	}
	
	/*
	 * CutHair
	 * Author: Jeremiah Hanson
	 * -------------------------------
	 * Purpose: the barber takes an amount
	 * 	of time to cut hair
	 * Parameters:
	 * 	name: the customer being served
	 */
	public void cutHair(String name) {
		numChairsUsed--;
		try {
			Thread.sleep(cutTime);
		} catch (InterruptedException e) {
			System.out.println("ERROR: " + name + " has been interupted");
			e.printStackTrace();
		}
		numCut++;
	}
	
	/*
	 * jobDone
	 * Author: Jeremiah Hanson
	 * -----------------------------------
	 * Purpose: checks if the barbers job is 
	 * 	done
	 */
	public boolean jobDone() {
		return (numCut + numLeft) == customers;
	}
	
	/*
	 * isChair
	 * Author: Jeremiah Hanson
	 * -----------------------------------
	 * Purpose: checks if there is a chair
	 * 	available to wait in, and returns the 
	 * 	result
	 * Parameters: 
	 *  name: the name of the customer
	 */
	public boolean isChair(String name) {
		if (numChairsAvail > numChairsUsed) {
			System.out.println(name + " has taken a seat.");
			numChairsUsed++;
			return true;
		} else {
			System.out.println(name + " found no chair and left.");
			numLeft++;
			return false;
		}
	}
}
