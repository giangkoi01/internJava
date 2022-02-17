package busassignmentmanagement.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import busassignmentmanagement.constant.DatabaseConstant;
import busassignmentmanagement.model.drivingManager.Assignment;
import busassignmentmanagement.model.drivingManager.BusLineList;
import busassignmentmanagement.service.DriverService;
import busassignmentmanagement.service.RouterService;

public class AssignmentDAO {
	public static List<Assignment> getAssignment(){
		List<Assignment> assignments = new ArrayList<Assignment>();
		try {
			Connection connection = DriverManager.getConnection(DatabaseConstant.URL, DatabaseConstant.USERNAME, DatabaseConstant.PASSWORD);
			
			Statement statement = connection.createStatement();
			
			ResultSet resultSet = statement.executeQuery("select * from assignment");
			while (resultSet.next()) {
				int driver_id = resultSet.getInt(1);
				int router_id = resultSet.getInt(2);
				int turnNumber = resultSet.getInt(3);
				
				boolean checkDriver = false;
				BusLineList busLineList = new BusLineList(RouterService.findRouterById(router_id), turnNumber);
				for(Assignment assignment: assignments) {
					if(assignment.getDriver().getId() == driver_id) {
						assignment.getBusLineLists().add(busLineList);
						checkDriver = true;
						break;
					}
				}
				if (!checkDriver) {
					List<BusLineList> busLineLists = new ArrayList<BusLineList>();
					busLineLists.add(busLineList);
					assignments.add(new Assignment(DriverService.findDriverById(driver_id), busLineLists));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return assignments;
	}
	
	public void insertAssignment(Assignment assignment) {
		if(assignment == null) {
			return;
		}
		try (Connection connection = DriverManager.getConnection(DatabaseConstant.URL, DatabaseConstant.USERNAME, DatabaseConstant.PASSWORD)){
			Class.forName(DatabaseConstant.DRIVER_STRING);
			
			assignment.getBusLineLists().forEach(e ->{
				String sql = "INSERT INTO assignment(driver_id, router_id, turn_number) VALUES (?, ?, ?)";
				
				PreparedStatement preparedStatement;
				try {
					preparedStatement = connection.prepareStatement(sql);
					preparedStatement.setInt(1, assignment.getDriver().getId());
					preparedStatement.setInt(2, e.getRouter().getId());
					preparedStatement.setInt(3, e.getTurnNumber());
					preparedStatement.execute();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			});
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	
}
