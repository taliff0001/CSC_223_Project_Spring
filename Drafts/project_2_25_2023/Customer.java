package project_2_25_2023;

public class Customer {

	private int custNum;
	private static int customerNumber = 0;
	private int arrivalTime;
	private int serviceTime;
	private int finishTime;
	private int waitTime;
	private int serviceStartTime;
	private String lane;
	
	public Customer() {}
	
	public Customer(int a, int s) {
		this.arrivalTime = a;
		this.serviceTime = s;
		customerNumber++;
		this.custNum = customerNumber;
		this.lane = "A"; //THIS IS TEMPORARY TO CHECK DATABASE FUNCTIONALITY
	}
	
	public String toString() {
		String s = "Arrival time: " + arrivalTime + "   Service time: " + serviceTime;
		return s;
	}

	public int getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(int arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public int getServiceTime() {
		return serviceTime;
	}

	public void setServiceTime(int serviceTime) {
		this.serviceTime = serviceTime;
	}

	public int getFinishTime() {
		return finishTime;
	}

	public void setFinishTime(int finishTime) {
		this.finishTime = finishTime;
	}

	public int getWaitTime() {
		return waitTime;
	}

	public void setWaitTime(int waitTime) {
		this.waitTime = waitTime;
	}

	public String getLane() {
		return lane;
	}

	public void setLane(String lane) {
		this.lane = lane;
	}

	public int getServiceStartTime() {
		return serviceStartTime;
	}

	public void setServiceStartTime(int serviceStartTime) {
		this.serviceStartTime = serviceStartTime;
	}

	public int getCustNum() {
		return custNum;
	}

	public void setCustNum(int custNum) {
		this.custNum = custNum;
	}
	
	
}
