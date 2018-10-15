package com.fliplearn.flipapp.pagemodules;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fliplearn.flipapp.helper.GenericFunctions;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;

public class ProfileHomeModule 
{
GenericFunctions generic = new GenericFunctions();
	
	public ProfileHomeModule(WebDriver driver) 
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);	
	}
	
	@FindBy(xpath="//ul[@class='nav nav-tabs invite_video dashboardInnerView ng-scope']/li/a[text()='Noticeboard']")
	@AndroidFindBy(xpath="") 
	@iOSFindBy(id="")
	public RemoteWebElement noticeboardTab;
}
