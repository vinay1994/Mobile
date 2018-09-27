package com.fliplearn.flipapp.pagemodules;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fliplearn.flipapp.helper.Base;
import com.fliplearn.flipapp.helper.GenericFunctions;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;

public class AnnouncementModule extends Base 
{
	
	@FindBy(xpath="//button[contains(text(),'Post')]")
	@AndroidFindBy(className="") 
	@iOSFindBy(id="")
	RemoteWebElement postBtn;
	
	@FindBy(id="announcement")
	@AndroidFindBy(id="") 
	@iOSFindBy(id="")
	RemoteWebElement annBtn;
	

	@FindBy(id="title")
	@AndroidFindBy(id="") 
	@iOSFindBy(id="")
	RemoteWebElement titleTXT;
	
	@FindBy(xpath="//span[contains(@class,'btn-co')]")
	@AndroidFindBy(id="") 
	@iOSFindBy(id="")
	RemoteWebElement shareWithBtn;
	
	@FindBy(xpath="//label[(text()='No')]")
	@AndroidFindBy(id="") 
	@iOSFindBy(id="")
	RemoteWebElement NoRd;
	
	
	@FindBy(xpath="//textarea[contains(@class,'-touched')]")
	@AndroidFindBy(id="") 
	@iOSFindBy(id="")
	RemoteWebElement adddescri;
	
	
	@FindBy(xpath="//input[contains(@ng-click,'createFile()')]")
	@AndroidFindBy(id="") 
	@iOSFindBy(id="")
	RemoteWebElement uploadImageBtn;
	
	@FindBy(xpath="//button[(text()='Create')]")
	@AndroidFindBy(id="") 
	@iOSFindBy(id="")
	RemoteWebElement createBtn;
	
	public AnnouncementModule(WebDriver driver)
	{
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
	
	public void mouseOverOnpostBtn() {
		GenericFunctions.mouseOver(driver,postBtn, annBtn);
		
	}
}


