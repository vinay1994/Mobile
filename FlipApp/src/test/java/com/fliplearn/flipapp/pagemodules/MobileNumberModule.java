package com.fliplearn.flipapp.pagemodules;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;

public class MobileNumberModule 
{
	@FindBy(xpath="//button[contains(text(),'Skip')]")
	@AndroidFindBy(id="com.elss.educomp:id/skip_button") 
	@iOSFindBy(xpath="//XCUIElementTypeSecureTextField")
	public RemoteWebElement skipBtn;
	
	public MobileNumberModule(WebDriver driver)
	{
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
	

}
