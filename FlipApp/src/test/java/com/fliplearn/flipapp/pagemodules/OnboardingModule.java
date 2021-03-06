package com.fliplearn.flipapp.pagemodules;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;
import io.appium.java_client.touch.offset.PointOption;

public class OnboardingModule 
{
	@FindBy(xpath="//button[text()='Skip']")
	@AndroidFindBy(id="com.elss.educomp:id/btn_finish")
	@iOSFindBy(xpath="//XCUIElementTypeButton[@name='SKIP']")
	public RemoteWebElement skipBtn;
	
	@AndroidFindBy(xpath="//*[@text='GOT IT']")
	public RemoteWebElement gotItBtn;
	
	public OnboardingModule(WebDriver driver)
	{
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
	//test
	public void skipScreen()
	{
		skipBtn.click();
	}

}
