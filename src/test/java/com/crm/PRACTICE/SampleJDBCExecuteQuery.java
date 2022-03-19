package com.crm.PRACTICE;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class SampleJDBCExecuteQuery {
	
	@Test
	public void sampleJDBCExecuteQuery() throws Throwable
	{
		String expData = "Chaitra";
		//Step 1: register the database
		Driver driverRef = new Driver();
		DriverManager.registerDriver(driverRef);
		
		//Step 2: get connector from database - provide db name
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentsdb", "root", "root");
		
		//Step 3: issue create statement
		Statement state = con.createStatement();
		
		//Step 4: execute Query -- provide table name
		ResultSet result = state.executeQuery("select * from studentinfo;");
		while(result.next())
		{
			System.out.println(result.getString(1)+" "+result.getString(2)+" "+result.getString(3));
			String actData = result.getString(1);
			if(expData.equalsIgnoreCase(actData))
			{
				System.out.println(actData + "data is verfied");
				break;
			}
		}
		
		//Step 5: close the databse
		con.close();
	}

}
