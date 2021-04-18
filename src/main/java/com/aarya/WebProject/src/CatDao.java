package com.aarya.WebProject.src;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CatDao {
	
	private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private static final String DB_URL = "jdbc:mysql://localhost";
	private static final String USER = "root";
	private static final String PASS = "password";
	private static final String dbName = "MY_TEST_DB";
	
	private static Connection connection = null;
	private static Statement statement = null;
	
	public static List<Cat> getCats() {
		connect(dbName);
		ResultSet rs = query(String.format("select * from %s.cats", dbName));
		List<Cat> cats = new ArrayList<Cat>();
		
		if(rs == null) { 
			return cats; 
		}
		
		try {
			while(rs.next()) {
				int id = rs.getInt("ID");
				String name = rs.getString("NAME");
				String owner = rs.getString("OWNER");
				char gender = rs.getString("GENDER").charAt(0);
				String birth = rs.getDate("BIRTH").toString();
				Cat cat = new Cat(id, name, gender, owner, birth);
				cats.add(cat);
			}
			
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		close();
		
		return cats;
	}
	
	public static void insertCat(Cat cat) throws NullPointerException {
		String sql = String.format("insert into %s.cats (NAME,GENDER,OWNER,BIRTH) values ('%s', '%c', '%s', '%s');", dbName, cat.getNAME(), cat.getGENDER(), cat.getOWNER(), cat.getBIRTH());
		connect(dbName);
		update(sql);
		close();
	}
	
	private static ResultSet query(String sql) {
		if(connection != null) {
			try {
				System.out.println("Creating statement...");
				statement = connection.createStatement();
				ResultSet rs = statement.executeQuery(sql);
				return rs;
			} catch(SQLException ex) {
				System.out.println("Error while executing query..." + ex.getLocalizedMessage());
			}
		}
		return null;
	}
	
	private static void update(String sql) throws NullPointerException {
		if(connection != null) {
			try {
				System.out.println("Creating statement");
				statement = connection.createStatement();
				statement.executeUpdate(sql);
			} catch(SQLException ex) {
				System.out.println("Error while executing query..." + ex.getLocalizedMessage());
			}
		} else {
			throw new NullPointerException("you are not connected to the database!");
		}
	}
	
	private static void connect(String dbName) {
		try {
			Class.forName(JDBC_DRIVER);
			System.out.println("Connecting to Database...");
			connection = DriverManager.getConnection(DB_URL + "/" + dbName,USER,PASS);
			System.out.println("Connected to Database...");
		} catch(Exception ex) {
			System.out.println("Error while connecting to Database..." + ex.getLocalizedMessage());
		}
	}
	
	private static void close() {
		try {
			if(statement != null) {
				statement.close();
			}
			if(connection != null) {
				connection.close();
			}
			System.out.println("Successfully closed the connection... Goodbye!");
		} catch(SQLException ex) {
			System.out.println("Error while closing connection: " + ex.getLocalizedMessage());
		}
	}
}
