package busassignmentmanagement.model.drivingManager;

import java.io.Serializable;

import busassignmentmanagement.model.Router;

public class BusLineList implements Serializable{
	private static final long serialVersionUID = 1L;
	private Router router;
	private int turnNumber;
	
	
	public float getDistance(){
        return router.getDistance()*turnNumber*2;
    }
	
	public Router getRouter() {
		return router;
	}
	public void setRouter(Router router) {
		this.router = router;
	}
	public int getTurnNumber() {
		return turnNumber;
	}
	public void setTurnNumber(int turnNumber) {
		this.turnNumber = turnNumber;
	}
	public BusLineList(Router router, int turnNumber) {
		super();
		this.router = router;
		this.turnNumber = turnNumber;
	}
	public BusLineList() {
		super();
	}
	@Override
	public String toString() {
		return "BusLineList [router=" + router + ", turnNumber=" + turnNumber + "]";
	}
	
}
