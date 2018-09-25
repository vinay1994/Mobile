package com.fliplearn.flipapp.pagemodules;

import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.FindBy;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;

public class LearnModule {
	
	@FindBy(id="learn-icon")
	@AndroidFindBy(id="learn-icon") 
	@iOSFindBy(id="")
	RemoteWebElement learn;	
	
	@FindBy(xpath="//strong[text()='Fliplearn Prime']")
	@AndroidFindBy(id="")
	@iOSFindBy(id="")
	RemoteWebElement primeimg;
	
	@FindBy(xpath="//a[text()='Pre Nursery']")
	@AndroidFindBy(xpath="//a[text()='Pre Nursery']")
	@iOSFindBy(id="")
	RemoteWebElement selectclass;

}
