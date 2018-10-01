package com.fliplearn.flipapp.pagemodules;

import java.io.IOException;

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

public class LoginModule extends Base
{	
	@FindBy(id="Fname")
	@AndroidFindBy(id="com.elss.educomp:id/user_id_til") 
	@iOSFindBy(id="")
	RemoteWebElement usernameTxt;

	@FindBy(id="password-lg1")
	@AndroidFindBy(id="com.elss.educomp:id/password_edit")
	@iOSFindBy(id="")
	RemoteWebElement passwordTxt;

	@FindBy(xpath="//button[text()='Login']")
	@AndroidFindBy(id="com.elss.educomp:id/login")
	@iOSFindBy(id="")
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
	public  void Login(String role) throws InterruptedException
	{   
		if(role!=null) 
		{
			String username = aConfig.getProperty(role + "_Username");
			String password =  aConfig.getProperty(role +"_Password");
		
			if(eConfig.getProperty("Platform").equals("Android")) 
			{
				OnboardingModule onbMod= new OnboardingModule(driver);
				onbMod.skipScreen();
				extentTest.log(Status.PASS, "Click on Skip button.");
			}

			usernameTxt.sendKeys(username);
			extentTest.log(Status.PASS, "Enter Username: "+username);
			passwordTxt.sendKeys((password));
			extentTest.log(Status.PASS, "Enter Password");
      
			if(eConfig.getProperty("Platform").equals("Android")) 
			{
				((AndroidDriver) driver).hideKeyboard();
				extentTest.log(Status.PASS, "Hide Keyboard");
			}
			loginBtn.click();
			extentTest.log(Status.PASS, "Click on Login button");
			
			MobileNumberModule mobNumMod= new MobileNumberModule(driver);
			SignInAsModule sigInMod = new SignInAsModule(driver);
			QuizModule quiMod = new QuizModule(driver);
			 
			 if(role.equals("Parent"))
			 { 
	    		 sigInMod.parentLnk.click();
	    		 extentTest.log(Status.PASS, "Click on First Parent Link.");
			 }	 
			 
			 //Check for bug here why skip not showing for student
			 if(!(role.equals("Student") && platform.equals("Web")))
			 {	
				mobNumMod.skipBtn.click();
				extentTest.log(Status.PASS, "Click on Skip Button");
			 }	
			 
			 if(!platform.equals("Web"))
			 {
				 System.out.println("Platform is****:"+platform);
				 quiMod.skipBtn.click();
				 extentTest.log(Status.PASS, "Click on Quiz Skip Button");
				
				 GenericFunctions.touchCordinates(driver, 10, 95);
				 extentTest.log(Status.PASS, "Tap on Got it.");
				 GenericFunctions.touchCordinates(driver, 10, 95);
				 extentTest.log(Status.PASS, "Tap on Got it.");
			 }		
		}
	}
	
	public void Login(String role, String roleType)
	{
		SignInAsModule sigInMod = new SignInAsModule(driver);
		
		//On web skip mobile screen comes before User selection? 
		if(role.equals("Admin"))
		{	 
			sigInMod.adminLnk.click();
			extentTest.log(Status.PASS, "Click on First Admin Link.");
		} 
	}
 }
