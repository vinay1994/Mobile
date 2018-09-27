package com.fliplearn.flipapp.pagemodules;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.FindBy;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;

public class LearnModule {
	
	public LearnModule(WebDriver driver) {
		// TODO Auto-generated constructor stub
	}

	@FindBy(id="learn-icon")
	@AndroidFindBy(xpath="//*[@text='Learn']") 
	@iOSFindBy(id="")
	public RemoteWebElement learn;	
	
	@FindBy(xpath="//strong[text()='Fliplearn Prime']")
	@AndroidFindBy(id="")
	@iOSFindBy(id="")
	public RemoteWebElement primeimg;
	
	@FindBy(xpath="//a[text()='Pre Nursery']")
	@AndroidFindBy(xpath="//a[text()='Pre Nursery']")
	@iOSFindBy(id="")
	public RemoteWebElement selectclass;

}
