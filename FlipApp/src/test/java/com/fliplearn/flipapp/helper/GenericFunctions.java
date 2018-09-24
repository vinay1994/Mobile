package com.fliplearn.flipapp.helper;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;

import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;

public class GenericFunctions
{
	/**
	 * This will convert Date to String
	 * @author Tarun Goswami
	 * @since 2018-09-20
	 * @version 1.0
	 */
	public static String formatDateToString()
	{
		DateFormat df = new SimpleDateFormat("dd/MM/yy kk:mm:ss aa");
		Date dateObj = new Date();
		String dateToString = df.format(dateObj);

		String formatDate = dateToString.replace('/', '_');
		formatDate = formatDate.replace(' ', '_');
		formatDate = formatDate.replace(':', '_');

		return formatDate;
	}
	
	/**
	 * This will get latest file from directory
	 * @author Tarun Goswami
	 * @since 2018-09-20
	 * @version 1.0
	 */
	public static File getLatestFilefromDir(String dirPath)
	{
	    File dir = new File(dirPath);
	    File[] files = dir.listFiles();
	    
	    if (files == null || files.length == 0) 
	    {
	        return null;
	    }

	    File lastModifiedFile = files[0];
	    
	    for (int i = 1; i < files.length; i++) 
	    {	    	
	    	if (lastModifiedFile.lastModified() < files[i].lastModified()) 
	    	{
	           lastModifiedFile = files[i];
	    	}
	    }
	    return lastModifiedFile;
	}
	
	public static void touchCordinates(WebDriver driver, int x, int y) throws InterruptedException
	{
		Dimension size = driver.manage().window().getSize();

		int endX = (size.width * x)/100;
        int endY = (size.height * y)/100;
        
        System.out.println("Values are"+endX+"..........."+endY);
        
        TouchAction touchAction = new TouchAction((PerformsTouchActions) driver);
        touchAction.tap(PointOption.point(endX, endY)).perform() ;
        Thread.sleep(3000);
	}
	
}
