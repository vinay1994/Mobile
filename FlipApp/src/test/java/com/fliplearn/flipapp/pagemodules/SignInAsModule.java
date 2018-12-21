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
	@FindBy(xpath="//*[text()='admin']")
	@AndroidFindBy(xpath="//*[@text='ADMIN']") 
	//@iOSFindBy(id="")
	public RemoteWebElement adminLnk;
	
	@FindBy(xpath="(//div[@class='display-flex'])[1]")
	@AndroidFindBy(xpath="//*[@text='PARENT']") 
	//@iOSFindBy(id="")
	RemoteWebElement parentLnk;
	
	@FindBy(xpath="//*[text()='Proceed']")
	@AndroidFindBy(xpath="//*[@text='PARENT']") 
	//@iOSFindBy(id="")
	public RemoteWebElement proceedBtn;
	
	public SignInAsModule(WebDriver driver)
	{
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
}
