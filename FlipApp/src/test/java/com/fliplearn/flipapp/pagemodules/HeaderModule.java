package com.fliplearn.flipapp.pagemodules;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fliplearn.flipapp.helper.Base;
import com.fliplearn.flipapp.helper.GenericFunctions;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;

public class HeaderModule extends Base
{
	GenericFunctions generic = new GenericFunctions();
	
	public HeaderModule(WebDriver driver) 
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);	
	}
	
	@FindBy(css="button[class='dropbtn_nav btn-dd dropbtn']")
	@AndroidFindBy(xpath="") 
	@iOSFindBy(id="")
	public RemoteWebElement profileImg;	

	@FindBy(xpath="(//ul[@class='b-t-1 header-dd']//a)[1]")
	@AndroidFindBy(xpath="") 
	@iOSFindBy(id="")
	public RemoteWebElement myProfileLnk;
	
	
	@FindBy(id="home-icon")
	@AndroidFindBy(xpath="") 
	@iOSFindBy(id="")
	public RemoteWebElement homeBtn;
	
	
	public void clickOnProfileImg() {
		profileImg.click();
		
	}
	public void clickOnmyProfileLnk() {
		myProfileLnk.click();
		
	}	
	
	public void clickonHomeBtn() throws InterruptedException
	{
		Thread.sleep(2000);

		homeBtn.click();	
		Thread.sleep(2000);
	}

	
}
