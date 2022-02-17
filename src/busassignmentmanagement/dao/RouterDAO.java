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
import busassignmentmanagement.model.Router;

public class RouterDAO {
	public static List<Router> getRouter(){
		List<Router> routers = new ArrayList<Router>();
		try (Connection connection = DriverManager.getConnection(DatabaseConstant.URL, DatabaseConstant.USERNAME, DatabaseConstant.PASSWORD)){
			Class.forName(DatabaseConstant.DRIVER_STRING);
			
			Statement statement = connection.createStatement();
			
			ResultSet resultSet = statement.executeQuery("select * from router");
			while (resultSet.next()) {
				int id = resultSet.getInt(1);
				int distance = resultSet.getInt(2);
				int stopPoint = resultSet.getInt(3);
				
				Router router = new Router(id, distance, stopPoint);
				routers.add(router);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return routers;
	}
	
	public void insertRouter(Router router) {
		if(router == null) {
			return;
		}
		try (Connection connection = DriverManager.getConnection(DatabaseConstant.URL, DatabaseConstant.USERNAME, DatabaseConstant.PASSWORD)){
			Class.forName(DatabaseConstant.DRIVER_STRING);
			
			String sql = "INSERT INTO router(id, distance, stop_point) VALUES (?, ?, ?)";
			
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, router.getId());
			preparedStatement.setFloat(2, router.getDistance());
			preparedStatement.setInt(3, router.getStopPoint());
			preparedStatement.execute();
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
