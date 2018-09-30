package com.fliplearn.flipapp.pagemodules;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;
import com.fliplearn.flipapp.helper.Base;

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

	public  void Login(String userType)
	{   
		if(userType!=null) 
		{
			String username = aConfig.getProperty(userType.toUpperCase() + "_USERNAME");
			String password =  aConfig.getProperty(userType.toUpperCase() +"_PASSWORD");


			if(eConfig.getProperty("PLATFORM").equals("ANDROID")) 
			{
				OnboardingModule onbMod= new OnboardingModule(driver);
				onbMod.skipScreen();
				extentTest.log(Status.PASS, "Click on Skip button.");
			}

			usernameTxt.sendKeys(username);
			extentTest.log(Status.PASS, "Enter Username: "+username);
			passwordTxt.sendKeys((password));
			extentTest.log(Status.PASS, "Enter Password");

			if(eConfig.getProperty("PLATFORM").equals("ANDROID")) 
			{
				((AndroidDriver) driver).hideKeyboard();
				extentTest.log(Status.PASS, "Hide Keyboard");
			}
			loginBtn.click();
			extentTest.log(Status.PASS, "Click on Login button");
			if(eConfig.getProperty("PLATFORM").equals("WEB")& userType.equalsIgnoreCase("student"))
				System.out.println("skip popUp is missing for userType "+userType);
			else {
				MobileNumberModule mobMod= new MobileNumberModule(driver);
				mobMod.skipBtn.click();
			}
		}
	}


}
