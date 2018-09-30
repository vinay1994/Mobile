package com.fliplearn.flipapp.helper;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.Status;

import org.openqa.selenium.remote.RemoteWebElement;


import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;

public class GenericFunctions extends Base
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
	
	/**
	 * To perform touch by percentage
	 * @author Tarun Goswami
	 * @since 2018-09-22
	 * @version 1.0
	 */
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
	
	/**
	 * This will get latest file from directory
	 * @author vinay yadav
	 * @since 2018-09-24
	 * @version 1.0
	 */
	
	public static void mouseOver(WebDriver driver, WebElement elm, WebElement target) {
		Actions act=new Actions(driver);
		act.moveToElement(elm).perform();
		act.moveToElement(target).click().perform();
	}
	
	/**
	 * This will get latest file from directory
	 * @author vinay yadav
	 * @since 2018-09-24
	 * @version 1.0
	 */
	public static void selectClassByValue(WebElement elm, String value) {
		Select sc =new Select(elm);
		sc.selectByValue(value);	
	}

	/**
	 * This will get latest file from directory
	 * @author vinay yadav
	 * @since 2018-09-24
	 * @version 1.0
	 */
	
	public static void selectClassByIndex(WebElement elm, int index) {
		Select sc =new Select(elm);
		sc.selectByIndex(index);	
	}

	/**
	 *  To compare two lists
	 * @author Tarun Goswami
	 * @since 2018-09-25
	 * @version 1.0
	 */
	public static boolean compareList(List<RemoteWebElement> webList, String expectedString)
	{
		List<String> expectedList =  Arrays.asList(expectedString.split("\\s*,\\s*"));
		List<String> actualList = new ArrayList<String>();
				
		boolean result = false;
		
		//To get text of web elements and store in array list
		for(RemoteWebElement ele : webList ) 
		{
		    actualList.add(ele.getText());
		}
		
		extentTest.log(Status.INFO, "Actual List:"+actualList);
		extentTest.log(Status.INFO, "Expected List:"+expectedList);
	
		//Return true if lists are equal
		if(actualList.equals(expectedList))
			result = true;
		else
			System.out.println("Lists are not equal");
			
		return result;
	}
	
	/**
	 * Wait for Page load
	 * @author Tarun Goswami
	 * @since 2018-09-30
	 * @version 1.0
	 */
	public static void waitForPageLoad(WebDriver driver) 
	{
		ExpectedCondition<Boolean> pageLoadCondition = new
				ExpectedCondition<Boolean>() 
				{
	            	public Boolean apply(WebDriver driver) 
	            	{
	            		return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
	                }
	            };
	    WebDriverWait wait = new WebDriverWait(driver, 30);
	    wait.until(pageLoadCondition);
	}
	
	/**
	 *  Wait for Element Visibility
	 * @author Tarun Goswami
	 * @since 2018-09-30
	 * @version 1.0
	 */
	public static void waitForElementVisibility(WebDriver driver, RemoteWebElement classListBtn)
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement ele = wait.until(ExpectedConditions.visibilityOf(classListBtn));	
	}
}

