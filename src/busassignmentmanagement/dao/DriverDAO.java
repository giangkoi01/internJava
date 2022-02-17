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
import busassignmentmanagement.model.Driver;
import oracle.net.aso.d;

public class DriverDAO {
	public static List<Driver> getDriver(){
		List<Driver> drivers = new ArrayList<Driver>();
		try (Connection connection = DriverManager.getConnection(DatabaseConstant.URL, DatabaseConstant.USERNAME, DatabaseConstant.PASSWORD)){
			Class.forName(DatabaseConstant.DRIVER_STRING);
			
			Statement statement = connection.createStatement();
			
			ResultSet resultSet = statement.executeQuery("select * from driver");
			while (resultSet.next()) {
				int id = resultSet.getInt(1);
				String name = resultSet.getString(2);
				String adress = resultSet.getString(3);
				int phoneNumber = resultSet.getInt(4);
				String level = resultSet.getString(5);
				
				Driver driver = new Driver(id, name, adress, phoneNumber, level);
				drivers.add(driver);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return drivers;
	}
	
	public void insertDriver(Driver driver) {
		if(driver == null) {
			return;
		}
		try (Connection connection = DriverManager.getConnection(DatabaseConstant.URL, DatabaseConstant.USERNAME, DatabaseConstant.PASSWORD)){
			Class.forName(DatabaseConstant.DRIVER_STRING);
			
			String sql = "INSERT INTO driver(id, name, address, phoneNumber, driver_level) VALUES (?, ?, ?, ?, ?)";
			
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, driver.getId());
			preparedStatement.setString(2, driver.getName());
			preparedStatement.setString(3, driver.getAdress());
			preparedStatement.setInt(4, driver.getPhoneNumber());
			preparedStatement.setString(5, driver.getLevel());
			preparedStatement.execute();
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
}
