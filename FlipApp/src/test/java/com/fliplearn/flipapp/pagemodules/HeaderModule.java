package com.fliplearn.flipapp.pagemodules;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fliplearn.flipapp.helper.Base;
import com.fliplearn.flipapp.helper.GenericFunctions;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
public class HeaderModule extends Base
{
	GenericFunctions generic = new GenericFunctions();
	
	public HeaderModule(WebDriver driver) 
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);	
	}
	
	@FindBy(id="home-icon")
	public RemoteWebElement homeBtn;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name='Fliplearn']")
	public RemoteWebElement fliplearnText;
	
	@AndroidFindBy(xpath="//android.widget.ImageButton[@content-desc='Open navigation drawer']")
	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name='MenuIcon']")
	public RemoteWebElement burgerMenu;
	
	@AndroidFindBy(xpath="//*[@text='Quiz Games']")
	public RemoteWebElement quizGamesMnu;
	
	
	@AndroidFindBy(xpath="//*[@text='Settings']")
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name='Settings']")
	public RemoteWebElement userMenuSettings;
	
	@FindBy(xpath="//button[@class='dropbtn_nav btn-dd dropbtn dropdown-toggle'] | //a[@class='wraptext ng-binding']")
	public RemoteWebElement profileImg;	
	
	@FindBy(css="a[class='wraptext ng-binding']")
	public RemoteWebElement guestProfileImg;

	@FindBy(xpath="(//ul/li/a[@class='b-t-1 header-dd']//a)[1] | //a[@ui-sref='profile-view']")
	public RemoteWebElement myProfileLnk;
	
	@FindBy(linkText="Logout")
	@AndroidFindBy(id="com.elss.educomp:id/logout")
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name='Logout']")
	public RemoteWebElement logoutLnk;	
	
	@AndroidFindBy(id="android:id/button1")
	@iOSFindBy(xpath="//XCUIElementTypeButton[@name='Yes']")
	public RemoteWebElement yesLogoutLnk;	
	
	@FindBy(xpath="//li/a[text()='Buy Books'] | //a[@id='bookstore-icon']")
	public RemoteWebElement buyBooksLnk;
	
	public void clickOnProfileImg() 
	{
		profileImg.click();
	}
	
	public void clickOnmyProfileLnk() 
	{
		myProfileLnk.click();	
	}	
	
	public void clickonHomeBtn() throws InterruptedException
	{
		Thread.sleep(5000);

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("document.getElementById('home-icon').focus();");
		jse.executeScript("arguments[0].click();", homeBtn);
		
		Thread.sleep(2000);
	}
	
	public void clickOnLogoutBtn() throws InterruptedException
	{
		burgerMenu.click();
		Thread.sleep(3000);
	
		userMenuSettings.click();
			
		logoutLnk.click();
		yesLogoutLnk.click();
		Thread.sleep(3000);
	}
	
	public void clickOnQuizGamesMnu() throws InterruptedException
	{
		burgerMenu.click();
		Thread.sleep(2000);
	
		quizGamesMnu.click();
			
		Thread.sleep(5000);
	}
}
