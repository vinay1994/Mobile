package com.fliplearn.flipapp.pagemodules;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ManagerUsersModule
{

	public ManagerUsersModule(WebDriver driver) 
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);	
	}
	
	@FindBy(xpath="(//div[@class='radiobutton']/input)[2]")
	public RemoteWebElement teacherRadioBtn;
	
	@FindBy(xpath="(//a[text()='View/ Edit'])[1]")
	public RemoteWebElement viewEditLnk;

}
