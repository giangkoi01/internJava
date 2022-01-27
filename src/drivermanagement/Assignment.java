package drivermanagement;

import java.util.List;

public class Assignment {
	private Driver driver;
	private List<Router> routers;
	private List<Integer> quantity;
	public Driver getDriver() {
		return driver;
	}
	public void setDriver(Driver driver) {
		this.driver = driver;
	}
	public List<Router> getRouters() {
		return routers;
	}
	public void setRouters(List<Router> routers) {
		this.routers = routers;
	}
	public List<Integer> getQuantity() {
		return quantity;
	}
	public void setQuantity(List<Integer> quantity) {
		this.quantity = quantity;
	}
	public Assignment() {
		super();
	}
	public Assignment(Driver driver, List<Router> routers, List<Integer> quantity) {
		super();
		this.driver = driver;
		this.routers = routers;
		this.quantity = quantity;
	}
	
	@Override
	public String toString() {
		return "Assignment{" +
                "driver=" + driver +
                ", driverlist=" + routers +
                ", quantity=" + quantity +
                '}';
	}
}
