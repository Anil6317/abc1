package com.tyss.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.mysql.cj.jdbc.Driver;
import com.mysql.cj.x.protobuf.MysqlxCrud.Collection;


public class FetchDataFromDatabase 
{

	public static void main(String[] args) throws SQLException {
		//>>>step1 create the object for driver implementation class and register driver to jdbc
		Driver dbdriver=new Driver();
		DriverManager.registerDriver(dbdriver);
		//step2>>>get/establish database connection
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/sdet44","root","root");
		//step3>>>>create statement
		Statement statement=connection.createStatement();
		//step4>>>execute query
		ResultSet result=statement.executeQuery("select mobileName as name from mobile");
		//step 5>>> utilization/fetch particular column data
		
		while(result.next())
		{
			System.out.println(result.getString("name"));
			
		}
		
	}

}
