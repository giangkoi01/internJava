package busassignmentmanagement.service;

import busassignmentmanagement.Main;
import busassignmentmanagement.dao.DriverDAO;
import busassignmentmanagement.model.Driver;

public class DriverService {
	public static DriverDAO driverDAO = new DriverDAO();
	
	public void showDriver() {
		Main.drivers.forEach(e -> System.out.println(e));
	}

	public void addNewDriver() {
		Driver driver = new Driver();
		driver.input();
		Main.drivers.add(driver);
		driverDAO.insertDriver(driver);
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
