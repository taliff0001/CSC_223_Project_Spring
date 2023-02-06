package projectStart_2_6_23;

public class Customer {

	private int arrivalTime;
	private int serviceTime;
	private int finishTime;
	private int waitTime;
	private int serviceStartTime;
	private char lane;
	
	public Customer() {}
	
	public Customer(int a, int s) {
		this.arrivalTime = a;
		this.serviceTime = s;
	}
	
	public String toString() {
		String s = null;
		return s;
	}

	public double getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(int arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public double getServiceTime() {
		return serviceTime;
	}

	public void setServiceTime(int serviceTime) {
		this.serviceTime = serviceTime;
	}

	public double getFinishTime() {
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

	public char getLane() {
		return lane;
	}

	public void setLane(char lane) {
		this.lane = lane;
	}

	public int getServiceStartTime() {
		return serviceStartTime;
	}

	public void setServiceStartTime(int serviceStartTime) {
		this.serviceStartTime = serviceStartTime;
	}
	
	
}
