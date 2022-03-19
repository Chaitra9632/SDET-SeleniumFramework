package com.crm.PRACTICE;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class SampleJDBCExecuteUpdate {
	
	@Test
	public void sampleJDBCExecuteUpdate() throws Throwable
	{
		Connection con= null;
		try
		{
		//Step 1: register the database
		Driver driverRef = new Driver();
		DriverManager.registerDriver(driverRef);
		
		//Step 2: get connection from database
	    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentsdb", "root", "root");
		System.out.println("connection establised");
		
		//Step 3: issue create statement
		Statement stat = con.createStatement();
		
		//Step 4: execute a query
		//insert into studentinfo values('Adarsh',11,'Japan');
		int result = stat.executeUpdate("insert into studinfo values('Adarsh',11,'Japan');");//
		if(result==1)
		{
			System.out.println("data added successfully");
		}
		else
		{
			System.out.println("data not added");
		}
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		
		finally
		{
			//Step 5: close the databse
			con.close();
			System.out.println("connection closed");
		}
		
		
		
	}

}
