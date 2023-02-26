package project_2_25_2023;

import java.util.Random;

public class CustomerCreator {
	
	static int minArrivalTime;
	static int maxArrivalTime;
	static int minServiceTime;
	static int maxServiceTime;
	static int previousArrivalTime;
	
	public CustomerCreator() {
		
	}
	
	public CustomerCreator(int minAT, int maxAT, int minST, int maxST) {
		minArrivalTime = minAT;
		maxArrivalTime = maxAT;
		minServiceTime = minST;
		maxServiceTime = maxST;
		previousArrivalTime = 0;
	}
	
	public static Customer next() {
		Random rand = new Random();
		
		int arrivalTime = rand.nextInt(minArrivalTime, maxArrivalTime);
		int serviceTime = rand.nextInt(minServiceTime, maxServiceTime);
		arrivalTime += previousArrivalTime;
		previousArrivalTime = arrivalTime;
		Customer cust = new Customer(arrivalTime, serviceTime);
		
		return cust;
		
	}

}