/*
 * SleepingBarber.java
 * Author: Jeremiah Hanson
 * ----------------------------------------------------------------
 * This is the main class for my sleeping barber solution
 */

package main;

public class SleepingBarber {

	private static int numCustomers, timePerCust, timeBetweenCust, numChairs;
	private static Thread[] customer;
	
	public static void main(String[] args) {
		
		if (args.length < 4) {
			System.out.println("ERROR: Not enough arguments!");
			return;
		} else {
			numCustomers = Integer.parseInt(args[0]);
			timePerCust = Integer.parseInt(args[1]);
			timeBetweenCust = Integer.parseInt(args[2]);
			numChairs = Integer.parseInt(args[3]);
		}
		
		Barber barber = new Barber(timePerCust, numChairs, numCustomers);
		
		customer = new Thread[numCustomers];
		for (int i = 0; i < numCustomers; i++) {
			customer[i] = new Thread(new Customer(("Customer " + i), barber));
		}
		
		while (!barber.jobDone()) {
			
		}
		
	}
	
}
