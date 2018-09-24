package com.fliplearn.flipapp.pagemodules;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;

public class SignInAsModule 
{
	@FindBy(id="")
	@AndroidFindBy(id="//*[@text='ADMIN']") 
	@iOSFindBy(id="")
	RemoteWebElement adminLnk;
	
	@FindBy(id="")
	@AndroidFindBy(id="//*[@text='PARENT']") 
	@iOSFindBy(id="")
	RemoteWebElement parentLnk;
	
	public SignInAsModule(WebDriver driver)
	{
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
}
