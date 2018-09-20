package com.fliplearn.flipapp.pagemodules;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class OnboardingModule 
{
	
	@AndroidFindBy(id="com.elss.educomp:id/btn_finish")
	RemoteWebElement skipBtn;
	
	public OnboardingModule(WebDriver driver)
	{
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
	
	public void skipScreen()
	{
		skipBtn.click();
	}
}
