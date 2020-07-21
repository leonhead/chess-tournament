package com.leonhead.chesstournament.database;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;

class DatabaseConnectionTest {

	private String jdbcUrl = "jdbc:mysql://localhost:3306/chess_tournament?useSSL=false&serverTimezone=UTC";
	private String user = "chess";
	private String pass = "chess";

	@Test
	void testDatabaseConnection_jdbc() {
		System.out.println("Connecting to database: " + jdbcUrl);

		Connection connection = null;
		try {
			connection = DriverManager.getConnection(jdbcUrl, user, pass);
			System.out.println("Connection successful!!!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		assertTrue(connection != null);
	}

}
