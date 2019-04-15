package com.fliplearn.flipapp.pagemodules;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.fliplearn.flipapp.helper.Base;
import com.fliplearn.flipapp.helper.GenericFunctions;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class BookstoreSchoolModule extends Base
{
	
GenericFunctions generic=new GenericFunctions();
	
	public  BookstoreSchoolModule(WebDriver driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@FindBy(xpath="//div[@class='fullwidhtInner']/h2[text()='Fliplearn Book Store']")
	public  RemoteWebElement bookstoreHeading; 

	@FindBy(css="input[type='submit'], [value='Proceed']")
	public RemoteWebElement proceedBtn;
	
	public void selectSchool(String method, String value)
	{
	     Select schoolList = new Select(driver.findElement(By.xpath("//select[@name='school']")));
	    
	     if(method == "Text")
	    	 schoolList.selectByVisibleText(value);
	}
}
