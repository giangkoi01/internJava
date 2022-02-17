package busassignmentmanagement;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import busassignmentmanagement.dao.AssignmentDAO;
import busassignmentmanagement.dao.DriverDAO;
import busassignmentmanagement.dao.RouterDAO;
import busassignmentmanagement.model.Driver;
import busassignmentmanagement.model.Router;
import busassignmentmanagement.model.drivingManager.Assignment;
import busassignmentmanagement.service.AssignmentService;
import busassignmentmanagement.service.DriverService;
import busassignmentmanagement.service.RouterService;
import busassignmentmanagement.util.DataUtil;

public class Main {
	public static List<Driver> drivers = new ArrayList<Driver>();
	public static List<Router> routers = new ArrayList<Router>();
	public static List<Assignment> assignments = new ArrayList<Assignment>();
	
	private static RouterService routerService = new RouterService();
	private static DriverService driverService = new DriverService();
	private static AssignmentService assignmentService = new AssignmentService();
	
	private static void initializeData() {
		List<Driver> driverList = DriverDAO.getDriver();
		drivers = DataUtil.isNullOrEmpty(driverList) ? new ArrayList<Driver>() : (ArrayList<Driver>) driverList;
		
		List<Router> routerList = RouterDAO.getRouter();
		routers = DataUtil.isNullOrEmpty(routerList) ? new ArrayList<Router>() : (ArrayList<Router>) routerList;
		
		List<Assignment> assignmentList = AssignmentDAO.getAssignment();
		assignments = DataUtil.isNullOrEmpty(assignmentList) ? new ArrayList<Assignment>() : (ArrayList<Assignment>) assignmentList;
	}

	public static void main(String[] args) {
		initializeData();
		menu();
	}

	public static void menu() {
		do {
			int functionChoice = functionChoice();
			switch (functionChoice) {
			case 1:
				driverService.addNewDriver();
				break;
			case 2:
				driverService.showDriver();
				break;
			case 3:
				routerService.addNewRouter();
				break;
			case 4:
				routerService.showRouter();
				break;
			case 5:
				assignmentService.addNewAssignment();
				break;
			case 6:
				assignmentService.showAssignment();
				break;
			case 7:
				assignmentService.sortByName();
				break;
			case 8:
				assignmentService.sortByNumberLine();
				break;
			case 9:
				assignmentService.totalDistance();
				break;
			}
		} while (true);
	}

	public static int functionChoice() {
		System.out.println("Quản lý phân công xe bus");
		System.out.println("1, nhập danh sách lai xe mới:");
		System.out.println("2, in danh sách lai xe");
		System.out.println("3,nhập danh sách tuyến mới:");
		System.out.println("4,in danh sách tuyến mới:");
		System.out.println("5,nhập lái xe cần phân công");
		System.out.println("6, in danh sách lái xe đã phân công");
		System.out.println("7,sắp xếp danh sách lái xe theo tên:");
		System.out.println("8,sắp xếp theo số lượng tuyến:");
		System.out.println("9,tính tổng khoảng cách lái xe trong ngày");
		System.out.println("mời bạn chọn chức năng:");

		do {
			try {
				int choose = new Scanner(System.in).nextInt();
				if (choose > 0 && choose < 10) {
					return choose;
				}
				System.out.println("chức năng chỉ từ 1 đến 7");
			} catch (InputMismatchException e) {
				System.out.println("chức năng phải là 1 số");
			}
		} while (true);
	}
}
