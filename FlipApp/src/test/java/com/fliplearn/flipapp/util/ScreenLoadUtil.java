package com.fliplearn.flipapp.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.fliplearn.flipapp.helper.Base;
import com.fliplearn.flipapp.helper.GenericFunctions;
import com.fliplearn.flipapp.pagemodules.HeaderModule;
import com.fliplearn.flipapp.pagemodules.LearnModule;
import com.fliplearn.flipapp.pagemodules.LoginModule;
import com.fliplearn.flipapp.pagemodules.MobileNumberModule;
import com.fliplearn.flipapp.pagemodules.MyWallModule;
import com.fliplearn.flipapp.pagemodules.OnboardingModule;
import com.fliplearn.flipapp.pagemodules.QuizModule;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ScreenLoadUtil extends Base 
{

	LoginModule logMod;
	HeaderModule heaMod;
	OnboardingModule onbMod;
	MobileNumberModule mobNumMod;
	QuizModule quiMod;
	GenericFunctions generic;
	MyWallModule myWalMod;
	LearnModule leaMod;

	@BeforeMethod
	public void befMethod()
	{
		generic = new GenericFunctions();
		heaMod = new HeaderModule(driver);
		logMod = new LoginModule(driver);
		onbMod = new OnboardingModule(driver);
		mobNumMod = new MobileNumberModule(driver);
		quiMod = new QuizModule(driver);
		myWalMod = new MyWallModule(driver);
		leaMod = new LearnModule(driver);
	}


	/**
	 * Verify User User Login
	 * @author Vinay Yadav, Durga
	 * @since 2018-10-20
	 * @version 1.2
	 * @throws InterruptedException 
	 * @throws IOException 
	 */
	@Test(invocationCount = 10)
	public void loadTestOnScreens() throws InterruptedException, IOException
	{
		FileInputStream myxls = new FileInputStream("/Users/tarungoswami/git/flip-app/FlipApp/testdata/loaddata.xlsx");
	    XSSFWorkbook studentsSheet = new XSSFWorkbook(myxls);
	    XSSFSheet worksheet = studentsSheet.getSheetAt(0);
	    
	    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		Date cdate = new Date();
		
	    int lastRow = worksheet.getLastRowNum();
	    
	    System.out.println(lastRow);
	    
	    Row row = worksheet.createRow(++lastRow);
	    
	  
		if(eConfig.getProperty("Platform").equals("Android")) 
		{
			onbMod.skipScreen();
		}

		logMod.usernameTxt.clear();
		logMod.usernameTxt.sendKeys("class9.demo");
		logMod.passwordTxt.sendKeys(("164864"));

		if(eConfig.getProperty("Platform").equals("Android")) 
		{
			((AndroidDriver) driver).hideKeyboard();
			extentTest.log(Status.PASS, "Hide Keyboard");
		}
		
		logMod.loginBtn.click();
		Timestamp beforetime = new Timestamp(System.currentTimeMillis());
		if(platform.equals("Android"))
			Assert.assertTrue(quiMod.skipBtn.isDisplayed());
		else if(platform.equals("iOS"))
			Assert.assertTrue(heaMod.burgerMenu.isDisplayed());

		Timestamp aftertime = new Timestamp(System.currentTimeMillis());
		System.out.println("Login takes time to visible: "+(aftertime.getTime()-beforetime.getTime()-500));

		if(!platform.equals("Web") && !platform.equals("iOS"))
		{
			Thread.sleep(2000);
			quiMod.skipBtn.click();
			
			extentTest.log(Status.PASS, "Click on Quiz Skip Button");
			System.out.println("Click on Quiz Skip Button");
			
			generic.touchCordinates(driver, 10, 95);
			System.out.println("Click on Got it");


			beforetime = new Timestamp(System.currentTimeMillis());
			Assert.assertTrue(leaMod.primeImg.isDisplayed()	);
			 aftertime = new Timestamp(System.currentTimeMillis());
			System.out.println("Prime image takes time to visible: "+(aftertime.getTime()-beforetime.getTime()));

		}	
	
		if(platform.equals("iOS"))
			leaMod.clickOnLearnImage();

		leaMod.clickOnPrimeImage();
		beforetime = new Timestamp(System.currentTimeMillis());
		Assert.assertTrue(driver.findElement(By.xpath("(//*[@resource-id='com.elss.educomp:id/tv_learn'])[1]")).isDisplayed());
		aftertime = new Timestamp(System.currentTimeMillis());
		System.out.println("subject takes time to visible: "+(aftertime.getTime()-beforetime.getTime()-500));
		row.createCell(0).setCellValue(dateFormat.format(cdate));		
		row.createCell(1).setCellValue("Subject Screen");
		row.createCell(2).setCellValue(aftertime.getTime()-beforetime.getTime()-500);
	    row = worksheet.createRow(++lastRow);

		
		leaMod.selectSubjectLnk.get(0).click();
		beforetime = new Timestamp(System.currentTimeMillis());
		Assert.assertTrue(leaMod.selectTopic.get(0).isDisplayed());
		aftertime = new Timestamp(System.currentTimeMillis());
		System.out.println("Chapter takes time to visible: "+(aftertime.getTime()-beforetime.getTime()-500));
		row.createCell(0).setCellValue(dateFormat.format(cdate));		
		row.createCell(1).setCellValue("Chapter Screen");
		row.createCell(2).setCellValue(aftertime.getTime()-beforetime.getTime()-500);
	    row = worksheet.createRow(++lastRow);
		
		leaMod.selectTopic.get(0).click();
		beforetime = new Timestamp(System.currentTimeMillis());
		Assert.assertTrue(leaMod.Selectresource.get(0).isDisplayed());
		aftertime = new Timestamp(System.currentTimeMillis());
		System.out.println("topic list time to visible: "+(aftertime.getTime()-beforetime.getTime()-500));
		row.createCell(0).setCellValue(dateFormat.format(cdate));		
		row.createCell(1).setCellValue("Topic Screen");
		row.createCell(2).setCellValue(aftertime.getTime()-beforetime.getTime()-500);
	    row = worksheet.createRow(++lastRow);
		
		leaMod.Selectresource.get(0).click();
		beforetime = new Timestamp(System.currentTimeMillis());
		Assert.assertTrue(leaMod.resource.isDisplayed());
		aftertime = new Timestamp(System.currentTimeMillis());
		System.out.println("resource list time to visible: "+(aftertime.getTime()-beforetime.getTime()-500));
		row.createCell(0).setCellValue(dateFormat.format(cdate));		
		row.createCell(1).setCellValue("Resource Screen");
		row.createCell(2).setCellValue(aftertime.getTime()-beforetime.getTime()-500);
	    row = worksheet.createRow(++lastRow);
		
	    myxls.close();
	    
	    FileOutputStream output_file =new FileOutputStream(new File("/Users/tarungoswami/git/flip-app/FlipApp/testdata/loaddata.xlsx"));  
	    
	    //write changes
	    studentsSheet.write(output_file);
	    output_file.close();
	    System.out.println(" is successfully written");
	       
	}
}
