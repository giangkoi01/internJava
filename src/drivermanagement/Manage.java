package drivermanagement;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Manage {
	public static List<Driver> drivers = new ArrayList<Driver>();
	public static List<Router> routers = new ArrayList<Router>();
	public static List<Assignment> assignments = new ArrayList<Assignment>();
	public static Scanner scanner = new Scanner(System.in);
	
	public void run() {
		boolean check = true;
		int choose = 0;
		do {
			System.out.println("chọn chức năng: ");
			System.out.println("Danh sach chuc nang:");
            System.out.println("1.Nhập danh sách lái xe");
            System.out.println("2.In ra danh sach lái xe:");
            System.out.println("3.Nhập danh sách tuyến");
            System.out.println("4.In ra danh sách tuyến");
            System.out.println("5.Nhap lich phân công");
            System.out.println("6.In danh sách lịch phân công");
            System.out.println("7.Sx theo ten ");
            System.out.println("8.Sx theo so lượt chạy");
            System.out.println("9.Tổng số quãng đường mà tài xế đi trong một ngày.");
            try {
            	choose = scanner.nextInt();
			} catch (Exception e) {
				System.out.println("chỉ được nhập số");
				check = false;
			}
            switch (choose) {
			case 1:
				inputDriver();
				break;
			case 2:
				outputDriver();
				break;

			default:
				break;
			}
		} while (check);
	}
	
	public void inputDriver() {
		Driver driver = new Driver();
		driver.input();
		drivers.add(driver);
		}
	
	public void outputDriver() {
		routers.forEach(e -> System.out.println(e));
	}
}
