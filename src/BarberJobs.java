/*
 * Barber.java
 * Author: Jeremiah Hanson
 * ----------------------------------------------------------------
 * This class gives a customer access to the barbers services
 */



public class BarberJobs {
	
	private int cutTime, numChairsAvail, numChairsUsed, customers;
	private int numCut, numLeft;
	public boolean busy;

	/*
	 * Constructor
	 * Author: Jeremiah Hanson
	 * -------------------------------------------
	 * Parameters:
	 * 	time: time to cut one customers hair
	 * 	charis: number of chairs for waiting customers
	 * 	customers: the number of customers to arrive to the shop
	 */
	public BarberJobs(int time, int chairs, int customers) {
		this.cutTime = time;
		this.numChairsAvail = chairs;
		this.numChairsUsed = 0;
		this.busy = false;
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
		busy = true;
		if (numChairsUsed > 0)
			numChairsUsed--;
		System.out.println(name + " gets a turn for a haircut.");
		try {
			Thread.sleep(cutTime);
		} catch (InterruptedException e) {
			System.out.println("ERROR: " + name + " has been interupted");
			e.printStackTrace();
		}
		System.out.println(name + "'s hair has been cut!");
		numCut++;
		busy = false;
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
			System.out.println(name + " has taken a seat to wait.");
			numChairsUsed++;
			return true;
		} else {
			System.out.println(name + " found no chair and left.");
			numLeft++;
			return false;
		}
	}
	
	/*
	 * isBusy
	 * Author: Jeremiah Hanson
	 * -----------------------------------
	 * Purpose: checks if the barber is currently
	 * 	cutting someones hair
	 */
	public boolean isBusy() {
		return busy;
	}
	
	/*
	 * jobStats
	 * Author: Jeremiah Hanson
	 * -----------------------------------
	 * Purpose: prints the barbers end-of-day
	 * 	job stats
	 */
	public void jobStats() {
		System.out.println();
		System.out.println("The barber is done for the day");
		System.out.println("    Number of haircuts: " + numCut);
		System.out.println("    Number who left:    " + numLeft);
	}
}
