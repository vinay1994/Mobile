package com.fliplearn.flipapp.util;

import java.io.File;
import java.io.IOException;
import java.net.Inet4Address;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.fliplearn.flipapp.helper.Base;
import com.fliplearn.flipapp.helper.GenericFunctions;



public class Screenshots extends Base
{	
	static GenericFunctions generic = new GenericFunctions();
	static String folderExtension = generic.formatDateToString();
	static String  reportFileFolderName = "Screenshots_" + folderExtension;
	
	public static String captureScreenshot(WebDriver driver,String imageName) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		
		String filePath;
		
		if(Inet4Address.getLocalHost().getHostAddress().equals("10.0.14.202"))
		{
		filePath = "C:\\tomcat\\webapps\\fliplearn\\screenshots\\" + reportFileFolderName + "\\";
		}
		else
		{
			filePath = System.getProperty("user.dir")+ "\\screenshots\\" + reportFileFolderName + "\\";
		}	
			
        File file = new File(filePath);
		
		if (!file.exists()) 
		{
			file.mkdirs();
		}
		
		String property = filePath+imageName+".png";
		
		File dest=new File(property);
		FileUtils.copyFile(source, dest);
		if(Inet4Address.getLocalHost().getHostAddress().equals("10.0.14.202"))
		{
		          property = "http://10.0.14.202:8080/fliplearn/screenshots/"+reportFileFolderName+"/"+imageName+".png";
		}
		return property;
	}
}

