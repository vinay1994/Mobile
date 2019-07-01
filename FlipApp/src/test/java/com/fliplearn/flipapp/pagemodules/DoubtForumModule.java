package com.fliplearn.flipapp.pagemodules;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.fliplearn.flipapp.helper.Base;
import com.fliplearn.flipapp.helper.GenericFunctions;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class DoubtForumModule extends Base{
	
	GenericFunctions generic = new GenericFunctions();
	public DoubtForumModule() 
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	@FindBy(xpath="//*[text()='Doubt Forum']")
	public RemoteWebElement clickOnDouFor;
	
	@FindBy(xpath="//*[@class='hidden-xs ng-binding']")    
	public List<RemoteWebElement >verNoOfTab;
	
	@FindBy(xpath="//*[contains(@src,'doubt.png')]")
	public RemoteWebElement verDouFormImg;
	
	@FindBy(xpath="//*[text()='Fliplearn Guru']")
	public RemoteWebElement verFlipGuruTxt;
	
	@FindBy(xpath="//*[contains(@src,'doubtforumastronaut.png')]")
	public RemoteWebElement verAskImg;
	
	

	public void clickOnDoubtForumTab() {
		clickOnDouFor.click();
		
	}
	
	public  void verifyNumOfDoubtForuTab(String role) throws InterruptedException, IOException {
		 
    
	//String expectedList = "Doubts, My Doubts, Post For Me";	
	List<RemoteWebElement> actualList = verNoOfTab;
    //generic.compareList(actualList, expectedList);
    
    String expectedList = readData(platform, role, "Doubt Forum Tabs");
	 System.out.println("Expected List:"+expectedList);
	 
	 Assert.assertEquals(generic.compareList(actualList, expectedList), true);
    
    
			 
		    }}

	

	

			
			
		

	
	


