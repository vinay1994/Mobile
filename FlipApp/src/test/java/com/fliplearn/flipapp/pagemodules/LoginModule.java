package com.fliplearn.flipapp.pagemodules;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
				((AndroidDriver) driver).hideKeyboard();
				MenuModule menu= new MenuModule(driver);
				menu.skipScreen();
			}
			usernameTxt.sendKeys(username);
			passwordTxt.sendKeys((password));
			loginBtn.click();
			
			if(eConfig.getProperty("PLATFORM").equals("DESKTOP")) 
			{
				MenuModule menu= new MenuModule(driver);
				menu.skipScreen();
			}	
		}
		else 
		{
			System.out.println("userType is :"+userType);
		}
	}
}
