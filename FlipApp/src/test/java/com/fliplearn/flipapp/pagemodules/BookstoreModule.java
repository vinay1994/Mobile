package com.fliplearn.flipapp.pagemodules;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.fliplearn.flipapp.helper.Base;
import com.fliplearn.flipapp.helper.GenericFunctions;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class BookstoreModule extends Base
{
	
GenericFunctions generic=new GenericFunctions();
	
	public  BookstoreModule(WebDriver driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@FindBy(xpath="//div[@class='fullwidhtInner']/h2[text()='Fliplearn Book Store']")
	public  RemoteWebElement bookstoreHeading; 

}
