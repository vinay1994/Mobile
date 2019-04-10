package com.fliplearn.flipapp.pagemodules;

import java.util.Iterator;
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

public class BookstoreCartModule extends Base
{
	GenericFunctions generic=new GenericFunctions();
	
	public  BookstoreCartModule(WebDriver driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@FindBy(css="select[id='schoolinput']")
	public RemoteWebElement schoolList;
	
	@FindBy(xpath="(//a[@title='Remove item' and @class='action action-delete'])")
	public List<RemoteWebElement> removeIconList;
	
	@FindBy(xpath="//li[@id='showminicart']")
	public RemoteWebElement cartIcon;
	
	@FindBy(xpath="//i[@class='uk-icon-cart-arrow-down']/span")
	public RemoteWebElement cartItemCount;
	
	@FindBy(xpath="//div[@class='cart-empty']/p[1]")
	public RemoteWebElement noItemText;
	
	@FindBy(xpath="//div[@class='page messages']/div[2]/div[2]/div")
	public RemoteWebElement cartItemMessage;
	
	//Remove cart item
	public void removeCartItem(String noOfItem) throws InterruptedException
	{
		int count;
		
		if(noOfItem == "One")
			count = 1;
		else
		{	
			count = removeIconList.size();
		}	
			
		for(int i = 0; i < count; i++)
		{
			removeIconList.get(0).click();
			Thread.sleep(2000);
		}
		
	}

}