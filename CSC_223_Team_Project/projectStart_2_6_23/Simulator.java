package projectStart_2_6_23;

import java.util.LinkedList;
import java.util.Scanner;

public class Simulator {

	public static void main(String[] args) {
		//First get parameters
		Scanner scan = new Scanner(System.in);
		System.out.println("Min arrival time between customers: ");
		int minA = scan.nextInt();
		System.out.println("Max arrival time between customers: ");
		int maxA = scan.nextInt();
		System.out.println("Minimum service time: ");
		int minS = scan.nextInt();
		System.out.println("Minimum service time: ");
		int maxS = scan.nextInt();
		System.out.println("Number of customers: ");
		int numCust = scan.nextInt();
		
		//Construct the customer generator based on the given parameters
		CustomerCreator customerCreator = new CustomerCreator(minA, maxA, minS, maxS);
		
		//Load these customers into a list (will likely change later but I think this
		//is the easiest way to get the simulator running). If you have questions look
		//at the API's
		LinkedList<Customer> mainList = new LinkedList<>();
		for(int i = 0;i<numCust;++i)
			mainList.add(customerCreator.next());
		
		//Create the three service lanes
		LinkedList<Customer> A = new LinkedList<>();
		LinkedList<Customer> B = new LinkedList<>();
		LinkedList<Customer> C = new LinkedList<>();
		
		//Initialize the clock and enter the main loop		
		int clock=0;
		for(;;++clock) {
			//Remove the customer at the front of the main queue and store in a temporary variable			
			Customer cust = null;
			if(!mainList.isEmpty())
				cust = mainList.pop();
			//Put customer in the queue with the shortest line when it is their arrival time;
			//If lines are of equal length put in the first available line alphabetically.
			//Record the numbers.

			
			//If a lane is empty when a customer arrives, the customer's finish
			//time is set now by adding the customer's arrival and service times.
			//Otherwise it is set by looking at the finish time of the customer
			//in front of them and adding the current customer's service time to
			//that number.
			
			//The customer's at the front of the queues need to have their finish times
			//checked each iteration. When done they are "popped" from the front of their
			//respective queues into a temporary variable and passed to the DataCollector's
			//logCustomer method.
			
			//DataCollector will log the status of the lines and data
			//from customers as they leave finish and leave queues
			DataCollector.logQueueStatus(null);
			DataCollector.logCustomer(null); 
											
		} //End main loop
			
		
		
		
		
		
		
		
		
		
		
		
	} //End main
} //End class
