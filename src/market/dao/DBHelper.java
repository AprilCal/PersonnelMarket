package market.dao;

import java.sql.*;

/***
 * 
 * create by AprilCal on 2018.1.11
 *
 */
public class DBHelper {
	static String driver = "com.mysql.jdbc.Driver";
	static String url = "jdbc:mysql://127.0.0.1:3306/personnel_market?useSSL=false";
	static String dbUsername = "root";
	static String dbPassword = "510676";
	
	static {
		//get db connector class
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, dbUsername, dbPassword);
	}
}