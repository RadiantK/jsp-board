package com.radiantk.board.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseUtil {

	// db¿¬µ¿
	public static Connection getConnection() {
		try {
			String url = "jdbc:mysql://localhost/board";
			String dbId = "board";
			String dbPassword = "board";
			Class.forName("com.mysql.jdbc.Driver");
			
			return DriverManager.getConnection(url, dbId, dbPassword);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
