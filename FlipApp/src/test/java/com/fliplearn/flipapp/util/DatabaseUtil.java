package com.fliplearn.flipapp.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.fliplearn.flipapp.helper.Base;

public class DatabaseUtil extends Base
{
	String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	String DB_URL = "jdbc:mysql://stgumsdb.fliplearn.com";

	String USER = "root";
	String PASS = "flip@159$$";
	
	public long readOTP(String dataBaseName, String mobileNumber)
	{
		Connection conn = null;
		Statement stmt = null;
		
		long  verification_code = 0;
		   
		try
		{
			Class.forName(JDBC_DRIVER);		   
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
		    stmt = conn.createStatement();
		    
		    String sql = "SELECT * FROM ums_api.user_verification_code where mobile_no = " +mobileNumber + " order by updated_date desc Limit 1;";
		    ResultSet rs = stmt.executeQuery(sql);

		    while(rs.next())
		    {
		         verification_code  = rs.getLong("verification_code");		
		    }
		    rs.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if(stmt!=null)
					conn.close();
			}
			catch(SQLException se)
			{
			}
			try
			{
				if(conn!=null)
					conn.close();
		    }
			catch(SQLException se)
			{
		         se.printStackTrace();
		    }
		}
		return verification_code;
	}
}	

