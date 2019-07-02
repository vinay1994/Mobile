package com.fliplearn.flipapp.pagemodules;


import java.time.Duration;
import java.util.NoSuchElementException;

import javax.management.relation.Role;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.fliplearn.flipapp.helper.Base;
import com.fliplearn.flipapp.helper.GenericFunctions;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
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
	
	@AndroidFindBy(xpath="//android.widget.ImageButton[@content-desc='Open navigation drawer'] | //*[@class='android.widget.ImageButton']")
	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name='MenuIcon']")
	public static RemoteWebElement burgerMenu;
    	
	@AndroidFindBy(xpath="//*[@text='Quiz Games']")
	public RemoteWebElement quizGamesMnu;
	
	@AndroidFindBy(xpath="//*[@text='Settings']")
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name='Settings']")
	public RemoteWebElement userMenuSettings;
	
	@FindBy(xpath="//button[@class='dropbtn_nav btn-dd dropbtn dropdown-toggle'] | //a[@class='wraptext ng-binding']/img")
	public RemoteWebElement profileImg;	
	
	@FindBy(css="a[class='wraptext ng-binding'][type='button']")
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
		try {
		 //if(!role.equals("Student") && !role.equals("Guest"))
		    burgerMenu.click();
		//	generic.touchCordinates(driver, 0, 0);
			Thread.sleep(3000);
		//	if(platform.equals("iOS")) {
				
		//	TouchActions action = new TouchActions(driver);
		//	Thread.sleep(3000);
		//	new TouchAction(driver).press(PointOption.point(500, 596)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000))).
		//	moveTo(PointOption.point(518, 478)).release().perform();
			
	//		action.press(94,442).moveTo(85,141).release().perform();
		//	action.scroll(userMenuSettings, 90, 497);
		//	action.perform();
			//}
			userMenuSettings.click();
			logoutLnk.click();
			yesLogoutLnk.click();
			Thread.sleep(3000);
		
		}
		catch(NoSuchElementException e) {}
		
	}
	
	public void clickOnQuizGamesMnu() throws InterruptedException
	{
		burgerMenu.click();
		Thread.sleep(2000);
	
		quizGamesMnu.click();
			
		Thread.sleep(5000);
	}
}
