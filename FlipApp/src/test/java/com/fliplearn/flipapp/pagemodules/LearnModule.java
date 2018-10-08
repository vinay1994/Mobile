package com.fliplearn.flipapp.pagemodules;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;

public class LearnModule 
{
	@FindBy(xpath="//div[@id='navbar']//li[2]/div")
	@AndroidFindBy(xpath="//*[@text='Learn']") 
	@iOSFindBy(id="")
	public RemoteWebElement learnImg;	
	
	@FindBy(xpath="//strong[text()='Fliplearn Prime']")
	@AndroidFindBy(xpath="//strong[text()='Fliplearn Prime']")
	@iOSFindBy(id="")
	public RemoteWebElement primeImg;
	
	@FindBy(xpath="//a[text()='Pre Nursery']")
	@AndroidFindBy(xpath="//a[text()='Pre Nursery']")
	@iOSFindBy(id="")
	public RemoteWebElement selectClassLnk;
		
	public LearnModule(WebDriver driver) 
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);	
	}
}