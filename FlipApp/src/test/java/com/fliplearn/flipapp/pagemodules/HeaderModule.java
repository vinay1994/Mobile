package com.fliplearn.flipapp.pagemodules;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;

public class HeaderModule 
{
	public HeaderModule(WebDriver driver) 
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);	
	}
	
	@FindBy(css="button[class='dropbtn_nav btn-dd dropbtn']")
	@AndroidFindBy(xpath="") 
	@iOSFindBy(id="")
	public RemoteWebElement profileImg;	

	@FindBy(xpath="(//ul[@class='b-t-1 header-dd']//a)[1]")
	@AndroidFindBy(xpath="") 
	@iOSFindBy(id="")
	public RemoteWebElement myProfileLnk;
	

	
}
