package com.java.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {
	public static Connection Conn()
	{
		Connection conn=null;
	try{
		Class.forName("com.mysql.jdbc.Driver");
	    conn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/banking","root","root");
		
	}
	catch(Exception e)
	{
	System.err.println(e);
	}
	return conn;
	}

	public static void main(String[] args)
	{
	System.out.println(Conn());		
	}
}
