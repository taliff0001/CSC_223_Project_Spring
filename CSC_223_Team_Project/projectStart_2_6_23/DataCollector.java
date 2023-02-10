package projectStart_2_6_23;

import java.io.FileWriter;
import java.io.IOException;

public class DataCollector { // I'll work on this one, don't worry about it

	public DataCollector() {

	}

	public static void logCustomer(Customer c, FileWriter fw) {
		String info = "";
		info += c.getCustNum() + ",";
		info += c.getArrivalTime() + ",";
		info += c.getServiceTime() + ",";
		info += c.getLane() + ",";
		info += c.getFinishTime() + ",";
		info += "Notes go here.";
		info += "\r";
		try {
			fw.write(info);
		} catch (IOException ioe) {
			System.out.println("Error writing to file");
		}
	}

	public static void logQueueStatus(Object object) {

	}

}
