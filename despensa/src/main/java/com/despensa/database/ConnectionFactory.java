package com.despensa.database;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	public static Connection conn = null;
	private final static String URLSQLSERVER = "jdbc:sqlserver://localhost:1433;"
			+ "user=sa;password=@ITB123456;databaseName=DESPENSA";
	
	public static Connection connectionSqlServer()  {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver")
			               .getDeclaredConstructor()
			               .newInstance();
			
			conn = DriverManager.getConnection(URLSQLSERVER);
		} catch (Exception e) {
			
			throw new RuntimeException(e);
		}
		
		return conn;
	}

}
