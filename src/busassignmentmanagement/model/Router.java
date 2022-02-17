package busassignmentmanagement.model;

import java.io.Serializable;
import java.util.InputMismatchException;
import java.util.Scanner;

import busassignmentmanagement.Main;

public class Router implements Serializable{

	private static final long serialVersionUID = 1L;
	public static int autoId = 100;
	private int id;
	private float distance;
	private int stopPoint;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public float getDistance() {
		return distance;
	}
	public void setDistance(float distance) {
		this.distance = distance;
	}
	public int getStopPoint() {
		return stopPoint;
	}
	public void setStopPoint(int stopPoint) {
		this.stopPoint = stopPoint;
	}
	public Router(int id, int distance, int stopPoint) {
		super();
		this.id = id;
		this.distance = distance;
		this.stopPoint = stopPoint;
	}
	public Router() {
		super();
	}
	@Override
	public String toString() {
		return "Router [id=" + id + ", distance=" + distance + ", stopPoint=" + stopPoint + "]";
	}
	
	public void input() {
		if(Main.routers.size() == 0) {
			this.id = autoId++;
		}else {
			this.id = Main.routers.get(Main.routers.size() - 1).getId() + 1;
		}
		System.out.println("nhập khoảng cách");
		float distance = -1;
		do {
			try {
				distance = new Scanner(System.in).nextFloat();
				if(distance > 0) {
					break;
				}
				System.out.println("khoảng cách phải lớn hơn 0");
			} catch (InputMismatchException e) {
				System.out.println("khoảng cách phải là 1 số");
			}
		} while (true);
		this.distance = distance;
		
		System.out.println("nhập số điểm dừng");
		int stopPoinNumber = -1;
		do {
			try {
				stopPoinNumber = new Scanner(System.in).nextInt();
				if(stopPoinNumber > 0) {
					break;
				}
				System.out.println("số điểm dừng phải lớn hơn 0");
			} catch (InputMismatchException e) {
				System.out.println("sô điểm dừng phải là 1 số");
			}
		} while (true);
		this.stopPoint = stopPoinNumber;
	}
	
	
}
