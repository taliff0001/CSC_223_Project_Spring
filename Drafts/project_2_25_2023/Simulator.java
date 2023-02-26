package project_2_25_2023;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

public class Simulator {

	public static void main(String[] args) {
//		String customerDataPath = InOut.getWriteLocation();
//		File file = new File(customerDataPath);
//		FileWriter filewriter = null;
//		try {
//			filewriter = new FileWriter(file);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		DataCollector.checkConnect();
		//First get parameters
		Scanner scan = new Scanner(System.in);
		System.out.println("Min arrival time between customers: ");
		int minA = scan.nextInt();
		System.out.println("Max arrival time between customers: ");
		int maxA = scan.nextInt();
		System.out.println("Minimum service time: ");
		int minS = scan.nextInt();
		System.out.println("Maximum service time: ");
		int maxS = scan.nextInt();
		System.out.println("Number of customers: ");
		int numCust = scan.nextInt();
		
		//Construct the customer generator based on the given parameters
		CustomerCreator customerCreator = new CustomerCreator(minA, maxA, minS, maxS);
		
		//Load these customers into a list (will likely change later but I think this
		//is the easiest way to get the simulator running). If you have questions look
		//at the API's
		LinkedList<Customer> mainList = new LinkedList<>();
		for(int i = 0;i<numCust;++i) {
			Customer cust = CustomerCreator.next();
			System.out.println(cust);
			mainList.add(cust);
			
		}
		//Create the three service lanes
		LinkedList<Customer> A = new LinkedList<>();
		LinkedList<Customer> B = new LinkedList<>();
		LinkedList<Customer> C = new LinkedList<>();
		
		//Initialize the clock and enter the main loop
		int time=0;
		boolean arrive = false; //keeps track of when it is time for a customer to arrive and enter a line
		Customer cust = null; 
		Customer cust1 = null;
		for(;time<200;++time) {
			
			//Remove the customer at the front of the main queue and store in a temporary variable			
			
			if(cust == null) //If cust is null it means it's time to check the queue of entering customers
							//for the next customer in line
				if(!mainList.isEmpty()) //Only get the next customer if there is one so as not to throw an exception
					cust = mainList.pop();
				else if (A.isEmpty() && B.isEmpty() && C.isEmpty()){ //The loop is done when there are no customers in the main queue
																	//or in any of the lanes
					System.out.println("Finished at " + time + " (or the minute before)");
					System.exit(0);				
			}				
					
			//Put customer in the queue with the shortest line when it is their arrival time;
			//If lines are of equal length put in the first available line alphabetically.
			//Record the numbers.
			

			//Check if it's time for a customer to depart
			if(!A.isEmpty() && A.getLast().getFinishTime()==time) {
				//remove the customer and do w/e
				cust1 = A.pop();
				DataCollector.logCustomer(cust1);
				System.out.println("Customer" + cust1.getCustNum() + "finished in lane A at " + time);
			}
			if(!B.isEmpty() && B.getLast().getFinishTime()==time) {
				cust1 = B.pop();
				DataCollector.logCustomer(cust1);
				System.out.println("Customer" + cust1.getCustNum() + "finished in lane B at " + time);
				
			}
			if(!C.isEmpty() && C.getLast().getFinishTime()==time) {
				cust1 = C.pop();
				DataCollector.logCustomer(cust1);
				System.out.println("Customer" + cust1.getCustNum() + "finished in lane C at " + time);
			}
			
			//Check if it's time for a customer to arrive and if so put in line
			//and store in a boolean variable
			arrive = checkArrival(cust, time, arrive);
			if(arrive) { //Put in shortest line when time
				
				if(A.isEmpty()) {
					cust.setWaitTime(0);
					cust.setFinishTime(time+cust.getServiceTime());
					A.push(cust);
					System.out.println("Customer entered lane A (empty) at " + time);
				}
				else if(B.isEmpty()) {
					cust.setWaitTime(0);
					cust.setFinishTime(time+cust.getServiceTime());
					B.push(cust);
					System.out.println("Customer entered lane B (empty) at " + time);
				}
				else if(C.isEmpty()) {
					cust.setWaitTime(0);
					cust.setFinishTime(time+cust.getServiceTime());
					C.push(cust);
					System.out.println("Customer entered lane C (empty) at " + time);
				}
				
				else if (A.size()<B.size() && A.size() < C.size()) {
					A.push(cust); 
					//And set times
					//finish time is equal to finish time of customer in front of plus
					//service time, wait time is equal to finish time of next customer
					//minus this customer's arrival time
					System.out.println("Customer entered lane A at " + time);
				}
				else if(B.size() < C.size()) {
					B.push(cust); //Set times
					System.out.println("Customer entered lane B at " + time);
				}
				else {
					C.push(cust); //Set times
					System.out.println("Customer entered lane C at " + time);
				}
				cust = null;
			}
				
			
			
			//If a lane is empty when a customer arrives, the customer's finish
			//time is set now by adding the customer's arrival and service times.
			//Otherwise it is set by looking at the finish time of the customer
			//in front of them and adding the current customer's service time to
			//that number.
			
			//The customer's at the front of the queues need to have their finish times
			//checked each iteration. When done they are "popped" from the front of their
			//respective queues into a temporary variable and passed to the DataCollector's
			//logCustomer method.
			System.out.println(time);
			//DataCollector will log the status of the lines and data
			//from customers as they leave finish and leave queues
//			DataCollector.logQueueStatus(null);
			//Pass the data collection class the filewriter instance that was created in
			//main along with the next customer to log
//			DataCollector.logCustomer(cust, filewriter);								
		} //End main loop
		
//			try {
//				filewriter.close();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}	
		
		
	} //End main
	public static boolean checkArrival(Customer c, int t, boolean a) {
		if (c != null && c.getArrivalTime()==t) //When time to arrive set boolean to true
			return true;
//		if (a==true) { //Increment wait time if customer has waited through previous loop
//			int w = c.getWaitTime();
//			++w;
//			c.setWaitTime(w);
//			return true;		
//		}
		else
			return false;
	}

	
	
} //End class









