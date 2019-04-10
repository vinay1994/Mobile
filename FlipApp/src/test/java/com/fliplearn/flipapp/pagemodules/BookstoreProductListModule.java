package com.fliplearn.flipapp.pagemodules;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.fliplearn.flipapp.helper.Base;
import com.fliplearn.flipapp.helper.GenericFunctions;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class BookstoreProductListModule extends Base
{
	GenericFunctions generic=new GenericFunctions();
	
	public  BookstoreProductListModule(WebDriver driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@FindBy(css="select[id='schoolinput']")
	public RemoteWebElement schoolList;
	
	@FindBy(css="span[class='base']")
	public RemoteWebElement productListLbl;
	
	@FindBy(css="input[type='submit'], [value='Proceed']")
	public RemoteWebElement productList;
	
	@FindBy(xpath="//div[@class='databg']/h4/a")
	public List<RemoteWebElement> ItemTitle;
	
	@FindBy(xpath="(//input[contains(@id,'student_')])[1]")
	public RemoteWebElement studentName;
	
	@FindBy(xpath="(//input[contains(@id,'usn_')])[1]")
	public RemoteWebElement admissionNo;
	
	@FindBy(xpath="(//button[@class='add_to_cart'])[1]")
	public RemoteWebElement addToCart;
	
}

