package com.fliplearn.flipapp.helper;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.remote.RemoteWebElement;


import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;

public class GenericFunctions extends Base
{
	/**
	 * This will convert Date to String
	 * @author Tarun Goswami
	 * @since 2018-09-20
	 * @version 1.0
	 */
	public String formatDateToString()
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
	public File getLatestFilefromDir(String dirPath)
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
	public void touchCordinates(WebDriver driver, int x, int y) throws InterruptedException
	{
		Dimension size = driver.manage().window().getSize();

		System.out.println("Accepted Value in percentage:"+x+"..........."+y);

		int endX = (size.width * x)/100;
		int endY = (size.height * y)/100;

		System.out.println("Coordinate value to tap:"+endX+"..........."+endY);

		TouchAction touchAction = new TouchAction((PerformsTouchActions) driver);
		touchAction.tap(PointOption.point(endX, endY)).perform() ;
		Thread.sleep(3000);
	}

	public void scrollBy(WebDriver driver, int x, int y) throws InterruptedException
	{
		Thread.sleep(3000);
		TouchAction action = new TouchAction((AndroidDriver)driver);
		
		Dimension size = driver.manage().window().getSize();
		System.out.println("Accepted value to move:"+x+"..........."+y);
		
		int endX = (size.width * x)/100;
		int endY = (size.height * y)/100;

		System.out.println("Coordinate value to move:"+endX+"..........."+endY);
		action.press(PointOption.point(endX, size.height-10));
		action.moveTo(PointOption.point(endX, endY));
		action.release();
		action.perform();
		Thread.sleep(3000);
		

		
		
		
	}
	/**
	 * This will mouse hove and click on given element
	 * @author Vinay Yadav, Tarun Goswami
	 * @since 2018-10-06
	 * @version 1.1
	 * @throws InterruptedException 
	 */
	
	public void mouseHoverAndClick(WebDriver driver, RemoteWebElement element, RemoteWebElement target) throws InterruptedException 
	{

		element.sendKeys(Keys.ENTER);;
		generic.waitForElementVisibility(driver, element);
		extentTest.log(Status.PASS, "Wait for element visibility.");
		Thread.sleep(3000);
		Actions act=new Actions(driver);
		act.moveToElement(element).click(target).build().perform();
	}

	/**
	 * This will get latest file from directory
	 * @author vinay yadav
	 * @since 2018-09-24
	 * @version 1.0
	 */
	public void selectClassByValue(WebElement elm, String value) {
		Select sc =new Select(elm);
		sc.selectByValue(value);	
	}
	
	/**
	 * This will get latest file from directory
	 * @author vinay yadav
	 * @since 2018-09-24
	 * @version 1.0
	 */
	public void selectByVisibleText(WebElement elm, String value) {
		Select sc =new Select(elm);
		sc.selectByVisibleText(value);	
	}
	/**
	 * This will get latest file from directory
	 * @author vinay yadav
	 * @since 2018-09-24
	 * @version 1.0
	 */
	public void UploadFile(String FilePath) throws Throwable{
		StringSelection ss = new StringSelection(FilePath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		robot.setAutoDelay(3000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}

	/**
	 * use select class 
	 * @author vinay yadav
	 * @since 2018-09-24
	 * @version 1.0
	 */

	public void selectElementByIndex(RemoteWebElement elm, int index) {
		Select sc =new Select(elm);
		sc.selectByIndex(index);	
	}
	/**
	 * This will wait for element
	 * @author vinay yadav
	 * @since 2018-09-24
	 * @version 1.0
	 * @param driver 
	 * @throws InterruptedException 
	 */

	public  void waitForElementVisibility(WebDriver driver, RemoteWebElement element) throws InterruptedException {
		(new WebDriverWait(driver, 60)).until(ExpectedConditions.visibilityOf(element));
		Thread.sleep(3000);
	}


	/** To compare two lists
	 * @author Tarun Goswami
	 * @since 2018-09-25
	 * @version 1.0
	 * @throws InterruptedException 
	 */
	public boolean compareList(List<RemoteWebElement> webList, String expectedString) throws InterruptedException
	{
		Thread.sleep(2000);
		List<String> expectedList =  Arrays.asList(expectedString.split("\\s*,\\s*"));
		List<String> actualList = new ArrayList<String>();

		boolean result = false;

		//To get text of web elements and store in array list
		for(RemoteWebElement ele : webList ) 
		{
			actualList.add(ele.getText().toString().replaceAll("\n", " "));
		}

		extentTest.log(Status.INFO, "Actual List:"+actualList);
		extentTest.log(Status.INFO, "Expected List:"+expectedList);
		System.out.println("Actual List:"+actualList);
		System.out.println("Expected List:"+expectedList);
		

		//Return true if lists are equal
		if(actualList.equals(expectedList))
		{	
			result = true;
			extentTest.log(Status.PASS, "List are equal.");
		}	
		else
		{	
			extentTest.log(Status.FAIL, "List are not equal.");
		}	

		return result;
	}

	/**
	 * Wait for Page load
	 * @author Tarun Goswami
	 * @since 2018-09-30
	 * @version 1.0
	 */
	public void waitForPageLoad(WebDriver driver) 
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


	public boolean isElementDisplayed(WebDriver driver, RemoteWebElement element) throws InterruptedException 
	{
		Thread.sleep(4000);
		Boolean found = true;
		try 
		{
			element.isDisplayed();
		}
		catch(Exception e)
		{
			found = false;
		}
		return found;
	}

	/**
	 * Get Currently selected option from dropdown
	 * @author Tarun Goswami
	 * @since 2018-10-06
	 * @version 1.0
	 * @throws InterruptedException 
	 */
	public String getCurrentlySelectedOption(WebDriver driver, RemoteWebElement element) throws InterruptedException
	{
		Thread.sleep(2000);
		Select sel = new Select(element);
		String strCurrentValue = sel.getFirstSelectedOption().getText();
		return strCurrentValue;
	}
	
	/**
	 * Select desired value from dropdown
	 * @author Tarun Goswami
	 * @since 2018-10-06
	 * @version 1.0
	 * @return 
	 * @throws InterruptedException 
	 */
	public void selectValueFromList(WebDriver driver, RemoteWebElement element, String value) throws InterruptedException
	{
		Thread.sleep(2000);
		Select sel = new Select(element);
		sel.selectByVisibleText(value);
	}
	
	/**
	 * Click using Action Class
	 * @author Tarun Goswami
	 * @since 2018-10-06
	 * @version 1.0
	 * @throws InterruptedException 
	 */
	public void actionClick(WebDriver driver, RemoteWebElement element) throws InterruptedException
	{
		Thread.sleep(2000);
		Actions actions = new Actions(driver);
		actions.moveToElement(element).click().perform();
	}
	/**
	 * Click using Action Class
	 * @author vinay 
	 * @since 2018-10-06
	 * @version 1.0
	 * @throws InterruptedException 
	 */
	public void scrollPageToBottom(){
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}
	public void scrollPage(RemoteWebElement element){
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	}
}

