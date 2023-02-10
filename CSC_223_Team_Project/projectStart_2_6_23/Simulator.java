package projectStart_2_6_23;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

public class Simulator {

	public static void main(String[] args) {
		String customerDataPath = InOut.getWriteLocation();
		File file = new File(customerDataPath);
		FileWriter filewriter = null;
		try {
			filewriter = new FileWriter(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//First get parameters
//		Scanner scan = new Scanner(System.in);
//		System.out.println("Min arrival time between customers: ");
//		int minA = scan.nextInt();
//		System.out.println("Max arrival time between customers: ");
//		int maxA = scan.nextInt();
//		System.out.println("Minimum service time: ");
//		int minS = scan.nextInt();
//		System.out.println("Minimum service time: ");
//		int maxS = scan.nextInt();
//		System.out.println("Number of customers: ");
//		int numCust = scan.nextInt();
		
		//Construct the customer generator based on the given parameters
//		CustomerCreator customerCreator = new CustomerCreator(minA, maxA, minS, maxS);
		
		//Load these customers into a list (will likely change later but I think this
		//is the easiest way to get the simulator running). If you have questions look
		//at the API's
//		LinkedList<Customer> mainList = new LinkedList<>();
//		for(int i = 0;i<numCust;++i)
//			mainList.add(customerCreator.next());
		
		//Create the three service lanes
		LinkedList<Customer> A = new LinkedList<>();
		LinkedList<Customer> B = new LinkedList<>();
		LinkedList<Customer> C = new LinkedList<>();
		
		//---Test Code here----------------------------------------//
		
		Customer cust1 = new Customer();		
		cust1.setCustNum(1);
		cust1.setArrivalTime(1);
		cust1.setServiceTime(5);
		cust1.setLane('A');
		cust1.setFinishTime(6);
		A.add(cust1);
		
		Customer cust2 = new Customer();
		cust2.setCustNum(2);
		cust2.setArrivalTime(2);
		cust2.setServiceTime(9);
		cust2.setLane('B');
		cust2.setFinishTime(11);
		A.add(cust2);
		
		//Initialize the clock and enter the main loop
		int clock=0;
		for(;clock<2;++clock) {
			//Remove the customer at the front of the main queue and store in a temporary variable			
			Customer cust = null;
//			if(!mainList.isEmpty())
//				cust = mainList.pop();
			//Put customer in the queue with the shortest line when it is their arrival time;
			//If lines are of equal length put in the first available line alphabetically.
			//Record the numbers.

			
			cust = A.get(clock);
			
			
			
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
			//Pass the data collection class the filewriter instance that was created in
			//main along with the next customer to log
			DataCollector.logCustomer(cust, filewriter);
											
		} //End main loop
			try {
				filewriter.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
		
		
		
		
		
		
		
		
		
	} //End main
} //End class
