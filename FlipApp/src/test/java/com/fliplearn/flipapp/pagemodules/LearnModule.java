package com.fliplearn.flipapp.pagemodules;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;

public class LearnModule {
	
	@FindBy(id="learn-icon")
	@AndroidFindBy(id="learn-icon") 
	@iOSFindBy(id="")
	public RemoteWebElement learn;	
	
	@FindBy(xpath="//strong[text()='Fliplearn Prime']")
	@AndroidFindBy(id="")
	@iOSFindBy(id="")
	public RemoteWebElement primeImg;
	
	
	public LearnModule(WebDriver driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		
	}

}
