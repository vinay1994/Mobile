package com.fliplearn.flipapp.pagemodules;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fliplearn.flipapp.helper.Base;
import com.fliplearn.flipapp.helper.GenericFunctions;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class PrimeClassModule extends Base
{
	GenericFunctions generic = new GenericFunctions();
    //Class List
	@FindBy(xpath="//div[@class='panel-heading']/h4/a")
	@AndroidFindBy(id="com.elss.educomp:id/tv_content_class_model")
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText")
	public List<RemoteWebElement> classLst;
	
	public PrimeClassModule(WebDriver driver)
	{
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
	
	public void selectUserClass(String className)
	{
		WebElement element = null;
		
		if(platform.equals("Web"))
			element = driver.findElement(By.xpath("//h4[@class='panel-title learnPanelTitle']/a[@role='button'][text()='"+className+"']"));
		else if(platform.equals("Android"))
			element = driver.findElement(By.xpath("//*[@text='"+className+"']"));
		else if(platform.equals("iOS"))
			element = driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='"+className+"']"));
		
		generic.clickUsingJSE(element);
	}
	
}

