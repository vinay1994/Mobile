package com.fliplearn.flipapp.pagemodules;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class NoticeboardModule 
{
	@FindBy(xpath="//div[@class='col-md-2 col-sm-2 col-xs-4 gallery-heading']/h3[text()='Noticeboard']")
	public static RemoteWebElement noticeboardHeading;
	
	@FindBy(xpath="(//h4[@class='m-t-20 margin-bottom-0 ng-binding'])[1]")
	public static RemoteWebElement noticeTitle;
	
	
	public NoticeboardModule(WebDriver driver)
	{
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

}




