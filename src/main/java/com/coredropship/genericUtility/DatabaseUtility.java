package com.coredropship.genericUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.jdbc.Driver;

/**
 * this class contains all reusable actions of database
 * @author Shiva
 *
 */
public class DatabaseUtility 
{
	private Connection connection;
	private ResultSet result;
	private Statement statement;
	private Driver dbdriver;
	
	/**
	 * thsi method is used to open the database connection
	 * @param dbURL
	 * @param dbUserName
	 * @param dbPassword
	 */
	public void openDBConnection(String dbURL,String dbUserName,String dbPassword)
	{
		try {
			dbdriver=new Driver();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			DriverManager.registerDriver(dbdriver);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			connection=DriverManager.getConnection(dbURL, dbUserName, dbPassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * this method is used to fetch the data from database
	 * @param query
	 * @param columnName
	 * @return
	 */
	public List<String>getDataFromDatabase(String query,String columnName)
	{

		try {
			statement = connection.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			result = statement.executeQuery(query);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		List <String>list=new ArrayList<String>();
		try {
			while(result.next())
			{
				list.add(result.getString(columnName));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;

	
	}
	
	/**
	 * this method is used to modify data 
	 * @param query
	 */
	public void modifyDataIntoDB(String query)
	{

		try {
			statement = connection.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			statement.executeUpdate(query);
		} catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	/**
	 * this method is used to verify data 
	 * @param query
	 * @param columnName
	 * @param expectedData
	 * @return
	 */
	public boolean verifyDataInDatabase(String query,String columnName,String expectedData)
	{
		List<String> list = getDataFromDatabase(query,columnName);
		boolean flag=false;
		if(list.contains(expectedData))flag=true;
		return flag;

	}
	/**
	 * this method is used to close the database
	 */
	public void closeDB()
	{
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

}
