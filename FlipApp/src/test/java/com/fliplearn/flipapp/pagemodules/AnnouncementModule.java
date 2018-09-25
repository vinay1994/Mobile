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

public class AnnouncementModule extends Base {
	
	@FindBy(xpath="//button[contains(text(),'Post')]")
	@AndroidFindBy(className="") 
	@iOSFindBy(id="")
	RemoteWebElement postBtn;
	
	@FindBy(id="announcement")
	@AndroidFindBy(id="") 
	@iOSFindBy(id="")
	RemoteWebElement annBtn;
	public AnnouncementModule(WebDriver driver)
	{
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
	
	public void mouseOverOnpostBtn() {
		GenericFunctions.mouseOver(driver,postBtn, annBtn);
		
	}
}


