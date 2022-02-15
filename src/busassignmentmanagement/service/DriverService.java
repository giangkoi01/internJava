package busassignmentmanagement.service;

import busassignmentmanagement.Main;
import busassignmentmanagement.model.Driver;
import busassignmentmanagement.util.file.FileUtil;

public class DriverService {
	public static FileUtil fileUtil = new FileUtil();
	
	public void showDriver() {
		Main.drivers.forEach(e -> System.out.println(e));
	}

	public void addNewDriver() {
		Driver driver = new Driver();
		driver.input();
		Main.drivers.add(driver);
		fileUtil.writeDataToFile(Main.drivers, "driver.dat");
	}
	
	public static Driver findDriverById(int driverId) {
		for (Driver driver : Main.drivers) {
			if (driver.getId() == driverId) {
				return driver;
			}
		}
		return null;
	}
}
