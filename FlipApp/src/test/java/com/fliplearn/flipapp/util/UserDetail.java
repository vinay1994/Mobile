package com.fliplearn.flipapp.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.fliplearn.flipapp.helper.Constants;

public class UserDetail 
{
    ArrayList<User> userList = new ArrayList<User>();
    
    public void readData() throws IOException
    {  	 
    	InputStream XlsxFileToRead = new FileInputStream(Constants.USER_FILE);

		XSSFWorkbook workbook = new XSSFWorkbook(XlsxFileToRead);
		XSSFSheet sheet = workbook.getSheet("Sheet1");
	 
		 for (Row row : sheet) 
		 {
			String className = row.getCell(2).toString(); 
			if(className.contains("."))
				className = className.substring( 0, className.indexOf("."));
			userList.add(new User(row.getCell(0).toString(), row.getCell(1).toString(), className, row.getCell(3).toString(), row.getCell(4).toString(), row.getCell(5).toString(),   row.getCell(6).toString(), "123456")); 
		 }
		 
    }
    
    public User matchDetails(String role, String board, String className, String roleType, String subType, String mobile)
    {

    	for(User user:userList)
    	{
    		if(user.getRole().equals(role) && user.getBoard().equals(board)  && user.getClassName().equals(className) && user.getRoleType().equals(roleType) && user.getSubType().equals(subType) && user.getMobile().equals(mobile))
    		{    			
    			System.out.println(user);
    			return user;			
    		}
    	}
    	return null; 	
    }   
}
