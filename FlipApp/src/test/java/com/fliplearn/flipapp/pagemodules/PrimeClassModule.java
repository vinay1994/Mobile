package com.fliplearn.flipapp.pagemodules;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fliplearn.flipapp.helper.Base;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class PrimeClassModule extends Base
{
    //Class List
	@FindBy(xpath="//div[@class='panel-heading']/h4/a")
	@AndroidFindBy(id="com.elss.educomp:id/tv_content_class_model")
	public List<RemoteWebElement> classLst;
	
	public PrimeClassModule(WebDriver driver)
	{
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
	
	public void selectUserClass(String className)
	{
		if(platform.equals("Web"))
			driver.findElement(By.xpath("//a[text()='"+className+"']")).click();
		else if(platform.equals("Android"))
			driver.findElement(By.xpath("//*[@text='"+className+"']")).click();
		else if(platform.equals("iOS"))
			driver.findElement(By.xpath("//*[@text='"+className+"']")).click();		
	}
	
}

