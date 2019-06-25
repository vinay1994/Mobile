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
import com.fliplearn.flipapp.util.User;
import com.fliplearn.flipapp.util.UserDetail;

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


    @FindBy(xpath="//button[text()='Use your login ID/Password']")
    public RemoteWebElement useLoginIDPassBtn;
    
	@FindBy(id="Fname")
	@AndroidFindBy(id="com.elss.educomp:id/userId") 
	@iOSXCUITFindBy(xpath="//XCUIElementTypeTextField")
	public RemoteWebElement usernameTxt;

	@FindBy(id="password-lg1")
	@AndroidFindBy(id="com.elss.educomp:id/password_edit")
	@iOSXCUITFindBy(xpath="//XCUIElementTypeSecureTextField")
	public RemoteWebElement passwordTxt;

	@FindBy(xpath="(//*[text()='Login'])[2]")
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
	public  void Login(String role, String board, String className, String profile, String subscription, String mobile) throws InterruptedException, IOException
	{   
		UserDetail detail = new UserDetail();
    	detail.readData();

		User user = detail.matchDetails(role, board, className, profile, subscription, mobile);
		
		String username = user.getuserName();
		String password = user.getPassword();
	

		if(eConfig.getProperty("Platform").equals("Android")) 
		{
			onbMod.skipScreen();
			extentTest.log(Status.PASS, "Click on Skip button.");
		}
		 useLoginIDPassBtn.click();		
		 generic.waitForElementVisibility(driver, usernameTxt);	

		 usernameTxt.clear();
		 usernameTxt.sendKeys(username);
		 extentTest.log(Status.PASS, "Enter Username: "+username);
		 passwordTxt.clear();
		 passwordTxt.sendKeys((password));
		 extentTest.log(Status.PASS, "Enter Password");
		

		 //		if(eConfig.getProperty("Platform").equals("Android")) 
		 //		{
		 //			((AndroidDriver) driver).hideKeyboard();
		 //			extentTest.log(Status.PASS, "Hide Keyboard");
		 //		}

		 loginBtn.click();
		 extentTest.log(Status.PASS, "Click on Login button");

		 if(eConfig.getProperty("Platform").equals("Android")) 
		 {
			 quiMod.skipBtn.click();
			 extentTest.log(Status.PASS, "Click on Quiz Skip Button");

			 if(!role.equals("Student") && !role.equals("Guest"))
			 {
				 Thread.sleep(3000);
				 driver.findElement(By.xpath("//*[@text='GOT IT']")).click();
				 extentTest.log(Status.PASS, "Tap on Got it.");	
				 driver.findElement(By.xpath("//*[@text='GOT IT']")).click();
				 extentTest.log(Status.PASS, "Tap on Got it.");	
			 } 
		 }

		 if(eConfig.getProperty("Platform").equals("iOS")) 
		 {
			// quiMod.skipBtn.click();
			// extentTest.log(Status.PASS, "Click on Quiz Skip Button");

		/*	 if(!role.equals("Student") && !role.equals("Guest"))
			 {
				 Thread.sleep(3000);
				 driver.findElement(By.xpath("//*[@text='GOT IT']")).click();
				 extentTest.log(Status.PASS, "Tap on Got it.");	
				 driver.findElement(By.xpath("//*[@text='GOT IT']")).click();
				 extentTest.log(Status.PASS, "Tap on Got it.");	
			 }*/ 
		 }

	}		
}			 



