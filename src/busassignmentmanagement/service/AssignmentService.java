package busassignmentmanagement.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import busassignmentmanagement.Main;
import busassignmentmanagement.dao.AssignmentDAO;
import busassignmentmanagement.model.Driver;
import busassignmentmanagement.model.Router;
import busassignmentmanagement.model.drivingManager.Assignment;
import busassignmentmanagement.model.drivingManager.BusLineList;

public class AssignmentService {
	public static AssignmentDAO assignmentDAO = new AssignmentDAO();

	public void totalDistance() {
		for (Assignment assignment : Main.assignments) {
			System.out.println("tổng khoảng chạy xe trong ngày trong ngày của " + assignment.getDriver().getName()
					+ " là :" + assignment.getBusLineLists().stream().mapToDouble(BusLineList::getDistance).sum());
		}

	}

	public void sortByNumberLine() {
		Main.assignments.sort((o1, o2) -> o2.getBusLineLists().size() - o1.getBusLineLists().size());

		for (Assignment assignment : Main.assignments) {
			System.out.println(assignment);
		}
	}

	public void sortByName() {
		Collections.sort(Main.assignments, (o1, o2) -> o1.getDriver().getName().compareTo(o2.getDriver().getName()));

		for (Assignment assignment : Main.assignments) {
			System.out.println(assignment);
		}
	}

	public void showAssignment() {
		Main.assignments.forEach(e -> System.out.println(e));

	}

	public void addNewAssignment() {
		if (Main.drivers.size() == 0 || Main.routers.size() == 0) {
			System.out.println("nhập lái xe và tuyến trước khi phân công");
			return;
		}

		System.out.println("nhập số lái xe cần phân công");
		int driverNumber = -1;
		do {
			try {
				driverNumber = new Scanner(System.in).nextInt();
				if (driverNumber > 0) {
					if (driverNumber <= Main.drivers.size()) {
						break;
					}
					System.out.println("số lượng phân công phải nhỏ hơn số lượng lái xe");
				}
				System.out.println("số lượng lái xe cần phân công phải lớn hơn 0");
			} catch (InputMismatchException e) {
				System.out.println("số lượng lái xe phải là 1 số");
			}
		} while (true);

		boolean checkDriver = false;
		for (int i = 0; i < driverNumber; i++) {
			System.out.println("mời bạn nhập id lái xe");
			int DriverId = -1;
			Driver driver = null;
			do {
				try {
					DriverId = new Scanner(System.in).nextInt();
					driver = DriverService.findDriverById(DriverId);
					if (driver != null) {
						break;
					}
					System.out.println("lái xe không tồn tại, mời nhập lại");
				} catch (InputMismatchException e) {
					System.out.println("id phải là 1 số");
				}
			} while (true);

			System.out.println("nhập số tuyến");
			int routerNumber = -1;
			do {
				try {
					routerNumber = new Scanner(System.in).nextInt();
					if (routerNumber > 0) {
						if (routerNumber <= Main.routers.size()) {
							break;
						}
						System.out.println("nhập lại số lượng tuyến");
					}
					System.out.println("số lượng tuyến phải lớn hơn 0");
				} catch (InputMismatchException e) {
					System.out.println("số lượng tuyến phải là 1 số");
				}
			} while (true);

			List<BusLineList> busLineLists = new ArrayList<BusLineList>();

			Router router = null;
			int turnNumber = -1;
			for (int j = 0; j < routerNumber; j++) {

				System.out.println("nhập id tuyến");
				do {
					int RouterId = new Scanner(System.in).nextInt();
					router = RouterService.findRouterById(RouterId);
					if (router != null) {
						break;
					}
					System.out.println("tuyến không tồn tại, nhập lại");
				} while (true);

				System.out.println("nhập số lượt đi");
				do {
					turnNumber = new Scanner(System.in).nextInt();
					if (turnNumber  <= 15) {
						break;
					}
					System.out.println("tổng số lượt không quá 15");
				} while (true);
				BusLineList busLineList = new BusLineList(router, turnNumber);

				for (Assignment assignment : Main.assignments) {
					if (assignment.getDriver().getId() == DriverId) {
						assignment.getBusLineLists().add(busLineList);
						checkDriver = true;
						break;
					}
				}
				if (!checkDriver) {
					busLineLists.add(busLineList);
					Assignment assignment = new Assignment(driver, busLineLists);
					Main.assignments.add(assignment);
					assignmentDAO.insertAssignment(assignment);
				}
			}
		}
	}
}
