package projectStart_2_6_23;

public class CustomerCreator {
	static double minArrival;
	static double maxArrival;
	static double minService;
	static double maxService;
	
	CustomerCreator(double minA, double maxA, double minS, double maxS) {
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
