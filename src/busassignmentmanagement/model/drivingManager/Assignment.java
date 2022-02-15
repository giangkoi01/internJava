package busassignmentmanagement.model.drivingManager;

import java.io.Serializable;
import java.util.List;

import busassignmentmanagement.model.Driver;
import busassignmentmanagement.model.Router;

public class Assignment implements Serializable{

	private static final long serialVersionUID = 1L;
	private Driver driver;
	private List<BusLineList> busLineLists;
	
	public Assignment(Driver driver, List<BusLineList> busLineLists) {
		super();
		this.driver = driver;
		this.busLineLists = busLineLists;
	}
	public Assignment() {
		super();
	}
	public Driver getDriver() {
		return driver;
	}
	public void setDriver(Driver driver) {
		this.driver = driver;
	}
	public List<BusLineList> getBusLineLists() {
		return busLineLists;
	}
	public void setBusLineLists(List<BusLineList> busLineLists) {
		this.busLineLists = busLineLists;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "Assignment [driver=" + driver + ", busLineLists=" + busLineLists + "]";
	}
	
	
}
