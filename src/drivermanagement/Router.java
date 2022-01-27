package drivermanagement;

import java.util.Scanner;

public class Router {
	private static int idAuto = 100;
	private int id;
	private int distance;
	private int stopPoint;
	public static int getIdAuto() {
		return idAuto;
	}
	public static void setIdAuto(int idAuto) {
		Router.idAuto = idAuto;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = idAuto++;
	}
	public int getDistance() {
		return distance;
	}
	public void setDistance(int distance) {
		this.distance = distance;
	}
	public int getStopPoint() {
		return stopPoint;
	}
	public void setStopPoint(int stopPoint) {
		this.stopPoint = stopPoint;
	}
	
	public Router() {
		super();
	}
	
	public Router(int id, int distance, int stopPoint) {
		super();
		this.id = id;
		this.distance = distance;
		this.stopPoint = stopPoint;
	}
	
	public void input() {
		boolean check = true;
		do {
			try {
				Scanner sc = new Scanner(System.in);
				System.out.println("nhập khoảng cách: ");
				this.setDistance(sc.nextInt());
				System.out.println("nhập số điểm dừng: ");
				this.setStopPoint(sc.nextInt());
			} catch (Exception e) {
				System.out.println("chỉ được nhập số");
				check = false;
			}
		} while (!check);
	}
	
	@Override
	public String toString() {
		return "Route{" +
                "iD=" + id +
                ", distance='" + distance + '\'' +
                ", stops=" + stopPoint +
                '}';
	}
}
