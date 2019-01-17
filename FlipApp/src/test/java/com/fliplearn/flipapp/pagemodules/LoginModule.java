package com.fliplearn.flipapp.pagemodules;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;
import com.fliplearn.flipapp.helper.Base;
import com.fliplearn.flipapp.helper.GenericFunctions;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class LoginModule extends Base
{	
	GenericFunctions generic = new GenericFunctions();
	OnboardingModule onbMod = new OnboardingModule(driver);
	MobileNumberModule mobNumMod = new MobileNumberModule(driver);
	SignInAsModule sigInMod = new SignInAsModule(driver);
	QuizModule quiMod = new QuizModule(driver);

	
	@FindBy(id="Fname")
	@AndroidFindBy(id="com.elss.educomp:id/userId") 
	@iOSXCUITFindBy(xpath="//XCUIElementTypeTextField")
	public RemoteWebElement usernameTxt;

	@FindBy(id="password-lg1")
	@AndroidFindBy(id="com.elss.educomp:id/password_edit")
	@iOSXCUITFindBy(xpath="//XCUIElementTypeSecureTextField")
	public RemoteWebElement passwordTxt;

	@FindBy(xpath="//button[text()='Login']")
	@AndroidFindBy(id="com.elss.educomp:id/login")
	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name='Login']")
	public RemoteWebElement loginBtn;

	public LoginModule(WebDriver driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	/**
	 * verify User Login
	 * @author Vinay
	 * @since 2018-09-25
	 * @throws InterruptedException 
	 * @version 1.5
	 * @throws IOException 
	 */
	public  void Login(String role, String board, String className, String profile, String subscription, String mobile) throws InterruptedException
	{   
		if(role!=null) 
		{
			String username = aConfig.getProperty(role + "_Username"+"_"+board+"_"+className+"_"+profile+"_"+subscription+"_"+mobile);
			String password =  aConfig.getProperty(role +"_Password"+"_"+board+"_"+className+"_"+profile+"_"+subscription+"_"+mobile);
		
			System.out.println("Username is"+username);
			if(eConfig.getProperty("Platform").equals("Android")) 
			{
				onbMod.skipScreen();
				extentTest.log(Status.PASS, "Click on Skip button.");
			}

			usernameTxt.clear();
			usernameTxt.sendKeys(username);
			extentTest.log(Status.PASS, "Enter Username: "+username);
			passwordTxt.clear();
			passwordTxt.sendKeys((password));
			extentTest.log(Status.PASS, "Enter Password");
      
			if(eConfig.getProperty("Platform").equals("Android")) 
			{
				((AndroidDriver) driver).hideKeyboard();
				extentTest.log(Status.PASS, "Hide Keyboard");
			}
			loginBtn.click();
			extentTest.log(Status.PASS, "Click on Login button");
				 
			 if(platform.equals("Android"))
			 {
				 System.out.println("Inside Android");

				 if(!username.contains("automationp"))
				 {	 
					 quiMod.skipBtn.click();
					 extentTest.log(Status.PASS, "Click on Quiz Skip Button");
				 }	 
				 Thread.sleep(3000);
				 driver.findElement(By.xpath("//*[@text='GOT IT']")).click();
				 extentTest.log(Status.PASS, "Tap on Got it.");
				 if(!role.equals("Guest"))
				 { 	 
					 Thread.sleep(3000);
					 driver.findElement(By.xpath("//*[@text='GOT IT']")).click();

				 	extentTest.log(Status.PASS, "Tap on Got it.");
				 }	
			 }		
		}
	}
	

		 
	 //Check for bug here why skip not showing for student
//	 if(!(role.equals("Student") && platform.equals("Web")))
//	 {	
//		mobNumMod.skipBtn.click();
//		extentTest.log(Status.PASS, "Click on Skip Button");
//	 }	
	 
//	 if(role.equals("Parent"))
//	 { 
//		 generic.waitForElementVisibility(driver, sigInMod.parentLnk);
//		 sigInMod.parentLnk.click();
//		 extentTest.log(Status.PASS, "Click on First Parent Link.");
//		 sigInMod.proceedBtn.click();
//	 }
//

 }
