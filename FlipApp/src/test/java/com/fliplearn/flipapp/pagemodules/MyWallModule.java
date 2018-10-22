package com.fliplearn.flipapp.pagemodules;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class MyWallModule 
{
	@FindBy(xpath="//li[@id='wall-feed']")
	@AndroidFindBy(xpath="//li[@id='wall-feed']")
	public RemoteWebElement myWallTab;
	
	public MyWallModule(WebDriver driver)
	{
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
	
	

}
