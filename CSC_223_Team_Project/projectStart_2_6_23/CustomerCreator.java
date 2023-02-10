package projectStart_2_6_23;

public class CustomerCreator {
	static int minArrival;
	static int maxArrival;
	static int minService;
	static int maxService;
	
	CustomerCreator(int minA, int maxA, int minS, int maxS) {
		minArrival = minA;
		maxArrival = maxA;
		minService = minS;
		maxService = maxS;
		
	}
	public static Customer next() {
		
		//Code goes here to randomize arrival and service time within the
		//given range and generate customer objects based on those times
		
		Customer customer = new Customer();
		
		return customer;
	}
	
}
