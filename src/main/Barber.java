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
		
		// check to make sure there are enough arguments
		if (args.length < 4) {
			System.out.println("ERROR: Not enough arguments!");
			return;
		} else {
			numCustomers = Integer.parseInt(args[0]);
			timePerCust = Integer.parseInt(args[1])*100;
			timeBetweenCust = Integer.parseInt(args[2])*100;
			numChairs = Integer.parseInt(args[3]);
		}
		
		// create barber
		Barber barber = new Barber(timePerCust, numChairs, numCustomers);
		
		// add all customers to the thread list
		customer = new Thread[numCustomers];
		for (int i = 0; i < numCustomers; i++) {
			customer[i] = new Thread(new Customer(("Customer " + i), barber));
		}
	
		// Send in the customers!!!!
		for (int i = 0; i < customer.length; i++) {
			try {
				Thread.sleep(timeBetweenCust);
				customer[i].start();
			} catch (InterruptedException e) {
				System.out.println("ERROR: main sleep broke");
				e.printStackTrace();
			}
			
		}
		
		// wait for the job to be done
		try {
			for (int i = 0; i < numCustomers; i++) {
				customer[i].join();
			}
		} catch (Exception e) {
			System.out.println("ERROR: broke on join");
		}
		barber.jobStats();
		
	}
	
}
