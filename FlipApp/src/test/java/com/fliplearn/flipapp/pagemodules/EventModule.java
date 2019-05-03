package com.fliplearn.flipapp.pagemodules;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;
import com.fliplearn.flipapp.helper.Base;
import com.fliplearn.flipapp.helper.GenericFunctions;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;

public class EventModule extends Base 
{
    GenericFunctions generic=new GenericFunctions();
	
	String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());

	@FindBy(xpath="//button[@class='btn btn-primary dropdown-toggle']")
	@AndroidFindBy(id="com.elss.educomp:id/post_layout") 
	public  RemoteWebElement postBtn;
	
	@FindBy(xpath="(//li[@class='ng-scope']/a[text()='Noticeboard '])[2]")
	public RemoteWebElement noticeboardTab;

	@FindBy(xpath="(//button[@id='announcement'])[2]")
	public RemoteWebElement annBtn;
	
	@FindBy(xpath="(//button[@id='homework'])[2]")
	public RemoteWebElement homeWorkBtn;
	
	@FindBy(xpath="(//button[@id='album'])[2]")
	public RemoteWebElement albBtn;

	@FindBy(xpath="(//input[@id='title'])[2]")
	RemoteWebElement titleTxt;

	@FindBy(xpath="//span[contains(@class,'btn-co')]")
	RemoteWebElement shareWithBtn;

	@FindBy(xpath="//label[(text()='No')]")
	RemoteWebElement noRdBtn;

	@FindBy(xpath="(//textarea[@id='textboxIssuereport'])[2]")
	RemoteWebElement addDescriptionTxt;


	@FindBy(xpath="//input[contains(@ng-click,'createFile()')]")
	RemoteWebElement uploadImageBtn;

	@FindBy(xpath="//button[(text()='Create')]")
	RemoteWebElement createBtn;

	@FindBy(xpath="(//label[contains(@ng-class,'checkleft')])[2]")
	RemoteWebElement select_class;   


	@FindBy(xpath="//button[contains(@id,'close')]")
	RemoteWebElement save;

	@FindBy(xpath="//h4[@class='m-t-20 margin-bottom-0 ng-binding']")
	RemoteWebElement getTitle;
	
	@FindBy(xpath="(//div[@class='Exm_1text ng-scope']/p)[1]")
	RemoteWebElement getRecentTitle;


	@FindBy(xpath="//img[contains(@class,'profilePic ng-scope')]")
	RemoteWebElement profile;


	@FindBy(xpath="//a[contains(@ng-click,'logout()')]")
	RemoteWebElement logout;
	
	@FindBy(xpath="//select[@name='subject']")
	RemoteWebElement selectsubj;

	public EventModule(WebDriver driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	public void mouseOverOnpostBtn(String eventType) throws InterruptedException 
	{
		Thread.sleep(2000);
		
		switch(eventType)
		{
			case "Announcement":
				generic.mouseHoverAndClick(driver,postBtn, annBtn);
				break;
			case "Album":
				generic.mouseHoverAndClick(driver,postBtn, albBtn);
				break;	
			case "Homework":
				generic.mouseHoverAndClick(driver,postBtn, homeWorkBtn);
				break;	
			default:
				break;
		}	
	}
	
	public void mouseOverOnProfileLogout() throws InterruptedException 
	{
		generic.mouseHoverAndClick(driver,profile, logout);
	}
	
	public void selectsubject() {
		selectsubj.click();
		generic.selectElementByIndex(selectsubj, 5);
	}
	
	
	public String fillTxt(String eventType) throws Throwable 
	{
		noticeboardTab.click();
		Thread.sleep(3000);

		mouseOverOnpostBtn(eventType);
		Thread.sleep(2000);

		driver.switchTo().activeElement();
		Thread.sleep(1000);
		titleTxt.clear();
		titleTxt.click();
		titleTxt.sendKeys("Testing automation Title_"+timeStamp);
		shareWithBtn.click();
		Thread.sleep(2000);
		select_class.click();
		extentTest.log(Status.PASS, "Select Class");
		save.click();
		
		if(eventType.equals("Homework"))
		{	
			
			selectsubject();
		}	
		generic.waitForElementVisibility(driver, addDescriptionTxt);
		addDescriptionTxt.clear();
		
		addDescriptionTxt.sendKeys("Qa add description for testing purpose on this time :"+timeStamp);
		generic.scrollPage(createBtn);
		uploadImageBtn.click();
		
		String Filepath = System.getProperty("user.dir")+"\\resources\\images\\vinay.png";
		generic.UploadFile(Filepath);
		
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("document.getElementById('btn-next').focus();");
		jse.executeScript("arguments[0].click();", createBtn);
		Thread.sleep(2000);
		noticeboardTab.click();

		
		isTitleDisplayed("Testing automation Title_"+timeStamp);
		return "Testing automation Title_"+timeStamp;
	}


	public boolean isTitleDisplayed(String Title) throws InterruptedException
	{
		int i=0;
		String ActualTitle=getTitle();
		while(!(ActualTitle.equalsIgnoreCase(Title)) && i<10)
		{
			driver.navigate().refresh();
			ActualTitle=getTitle();
			i++;
		}

		if(!(ActualTitle.equalsIgnoreCase(Title)))
		{
			return false;
		}
		else
		{
			return true;
		}
	}
	public String getTitle() throws InterruptedException
	{
		generic.waitForElementVisibility(driver, getTitle);
		return getTitle.getText();
	}
	
	public void clickOnNoticeboard()
	{
		noticeboardTab.click();
	}
	
	public String getRecentTitle() throws InterruptedException
	{
		generic.waitForElementVisibility(driver, getRecentTitle);
		return getRecentTitle.getText();
	}
	
	public boolean isPostBtndisplayed() throws InterruptedException 
	{
		return generic.isElementDisplayed(driver, postBtn);
	}


}
