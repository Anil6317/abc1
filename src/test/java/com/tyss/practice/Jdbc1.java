package com.tyss.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class Jdbc1 {

	public static void main(String[] args) throws SQLException 
	{
		String brandname="MI";
		String mobilename="note 11";
		int price=19999;
        Driver jddriver=new Driver();
        
        DriverManager.registerDriver(jddriver);
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sdet44","root","root");
        try {
        	Statement st=con.createStatement();
        	int result=st.executeUpdate("insert into ");
        }
        finally
        {
        	
        }
        

	}

}
