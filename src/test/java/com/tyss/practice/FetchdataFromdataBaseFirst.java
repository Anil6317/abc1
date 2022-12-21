package com.tyss.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class FetchdataFromdataBaseFirst
{
    public static void main(String[] args) throws SQLException 
	{
		//step1>>>>create the obj for driver implementation class and register driver to jdbc
		Driver dbdriver=new Driver();
		DriverManager.registerDriver(dbdriver);
		//step2>>>>get/establish database connection
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/sdet44", "root", "root");
		//step3>>>create staement
		Statement statement=connection.createStatement();
		//step4>>>>execute query
		int result=statement.executeUpdate("insert into mobilePhone values('note 10 pro max',20000,'MI');");
		//step 5>>>>validating data wheather updated or not 
		if(result==1)
		{
			System.out.println("data updated successfully");
		}
		

	}

}
