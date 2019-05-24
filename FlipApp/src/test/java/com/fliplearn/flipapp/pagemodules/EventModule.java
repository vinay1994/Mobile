package com.fliplearn.flipapp.pagemodules;

import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.util.HashMap;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.fliplearn.flipapp.helper.Base;
import com.fliplearn.flipapp.helper.GenericFunctions;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;
import io.appium.java_client.touch.offset.PointOption;

public class EventModule extends Base 
{
    GenericFunctions generic=new GenericFunctions();
    HomeModule homMod = new HomeModule(driver);
	
	public static String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());

	@FindBy(xpath="//button[@class='btn btn-primary dropdown-toggle']")
	@AndroidFindBy(xpath="//*[@text='POST']") 
	public  RemoteWebElement postBtn;
	
	@FindBy(xpath="(//li[@class='ng-scope']/a[text()='Noticeboard '])[2]")
	@AndroidFindBy(xpath="//*[@text='Noticeboard']") 
	public RemoteWebElement noticeboardTab;

	@FindBy(xpath="(//button[@id='announcement'])[2]")
	@AndroidFindBy(xpath="//*[@text='Announcement']") 
	public RemoteWebElement annBtn;
	
	@FindBy(xpath="(//button[@id='homework'])[2]")
	@AndroidFindBy(xpath="//*[@text='Homework']")
	public RemoteWebElement homeWorkBtn;
	
	@FindBy(xpath="(//button[@id='album'])[2]")
 	@AndroidFindBy(xpath="//*[@text='Album']") 
	public RemoteWebElement albBtn;

	@FindBy(xpath="(//input[@id='title'])[2]")
	@AndroidFindBy(id="com.elss.educomp:id/title")
	RemoteWebElement titleTxt;

	@FindBy(xpath="//span[contains(@class,'btn-co')]")
	@AndroidFindBy(xpath="//*[@text='+Add']")
	RemoteWebElement shareWithBtn;

	@FindBy(xpath="//label[(text()='No')]")
	@AndroidFindBy(xpath="//*[@text='No']")
	RemoteWebElement noRdBtn;

	@FindBy(xpath="(//textarea[@id='textboxIssuereport'])[2]")
	@AndroidFindBy(id="com.elss.educomp:id/description")
	RemoteWebElement addDescriptionTxt;

	//C:\Users\Batta K\git\flip-app\FlipApp\resources\images\vinay.png
	@FindBy(xpath="//input[contains(@ng-click,'createFile()')]")
	@AndroidFindBy(id="com.elss.educomp:id/add_icon")
	RemoteWebElement uploadImageBtn;

	@FindBy(xpath="//button[(text()='Create')]")
	@AndroidFindBy(xpath="//*[@text='Create']")
	RemoteWebElement createBtn;

	@FindBy(xpath="(//label[contains(@ng-class,'checkleft')])[2]")
	@AndroidFindBy(xpath="(//*[@resource-id='com.elss.educomp:id/expandable_group_list_checkbox_view'])[2]")
	RemoteWebElement select_class;   

	@FindBy(xpath="//button[contains(@id,'close')]")
	RemoteWebElement save;
	
	@AndroidFindBy(xpath="//*[@text='Done']")
	RemoteWebElement done;
	
	@FindBy(xpath="//h4[@class='m-t-20 margin-bottom-0 ng-binding']")
	@AndroidFindBy(xpath="(//*[@resource-id='com.elss.educomp:id/title'])[1]")
	RemoteWebElement getTitle;
	
	@FindBy(xpath="(//div[@class='Exm_1text ng-scope']/p)[1]")
	RemoteWebElement getRecentTitle;

	@FindBy(xpath="//img[contains(@class,'profilePic ng-scope')]")
	RemoteWebElement profile;

	@FindBy(xpath="//a[contains(@ng-click,'logout()')]")
	RemoteWebElement logout;
	
	@FindBy(xpath="//select[@name='subject']")
	RemoteWebElement selectsubj;
	
	@AndroidFindBy(id="com.elss.educomp:id/subject_spinner")
	RemoteWebElement selectsub;
	
	@AndroidFindBy(xpath="//*[@text='Art']")
	RemoteWebElement subj;
	
	@AndroidFindBy(xpath="//*[@text='Date']")
	RemoteWebElement submissionDate;
	
	@AndroidFindBy(xpath="//android.view.View[@content-desc=\"30 May 2019\"]")
	RemoteWebElement date;
	
	@AndroidFindBy(xpath="//*[@text='OK']")
	RemoteWebElement dateOk;
	
	@AndroidFindBy(id="com.elss.educomp:id/add_from_gallery")
	RemoteWebElement gallery;
	
	@AndroidFindBy(id="com.android.packageinstaller:id/permission_allow_button")
	RemoteWebElement allowBtn;
	
	@AndroidFindBy(xpath="(//*[@class='android.widget.ImageView'])[1]")
	RemoteWebElement imageClick;
	
	@AndroidFindBy(id="com.elss.educomp:id/btn_done")
	RemoteWebElement imageDone;
	
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
	
	
	public void fillTxt(String eventType) throws Throwable 
	{
		
		noticeboardTab.click();
		Thread.sleep(3000);
	/*	if(platform.equals("Android"))
	  	 {	 
	  		postBtn.click();
	  		
	  		if(eventType.equals("Announcement"))
	  			annBtn.click();
	  		else if (eventType.equals("Album"))			
	  			albBtn.click();
	  		else  			
	  			homeWorkBtn.click();

	  		titleTxt.clear();
			titleTxt.click();
			titleTxt.sendKeys("Testing automation Title_"+timeStamp);
			shareWithBtn.click();
			select_class.click();
			extentTest.log(Status.PASS, "Select Class");
			done.click();
			addDescriptionTxt.sendKeys("Qa add description for testing purpose on this time :"+timeStamp);
			//save.click();
			createBtn.click();
	  		
	  	
	  			
				//uploadImageBtn.click();
				//gallery.click();
				//allowBtn.click();
				//gallery.click();
				//imageClick.click();
				//imageDone.click();
				//Thread.sleep(2000);
				//generic.scrollBy(driver, 95, 50);
				//done.click();
				//save.click();
				//createBtn.click();
				//Thread.sleep(2000);
	  			//selectsub.click();
				//subj.click();
				//Thread.sleep(1000);
				//submissionDate.click();
				//date.click();
				//dateOk.click();
				//addDescriptionTxt.sendKeys("Qa add description for testing purpose on this time :\"+timeStamp");
				//generic.scrollBy(driver, 95, 50);
				//createBtn.click();
					  			
	  		
	  		  		
	  	 }
		else
		{
		mouseOverOnpostBtn(eventType);
		driver.switchTo().activeElement();
		titleTxt.clear();
		titleTxt.click();
		titleTxt.sendKeys("Testing automation Title_"+timeStamp);
		shareWithBtn.click();
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
		}
		isTitleDisplayed("Testing automation Title_"+timeStamp); */
		
		TouchAction action = new TouchAction((AndroidDriver)driver);
		
		Dimension size = driver.manage().window().getSize();
		
		
		//System.out.println("Coordinate value to move:"+endX+"..........."+endY);
		action.press(PointOption.point(500, 500));
		action.moveTo(PointOption.point(300, 300));
		action.release().perform();
		

		Thread.sleep(3000);
		
	}


	public boolean isTitleDisplayed(String Title) throws InterruptedException
	{		

		homMod.myWallSection.click();	
		noticeboardTab.click();	
		Thread.sleep(3000);
		
		String ActualTitle = getTitle();
		
		if(platform.equals("Web"))
		{	
			int i = 0;
			ActualTitle=getTitle();
			
			while(!(ActualTitle.equalsIgnoreCase(Title)) && i < 10)
			{
				driver.navigate().refresh();
				ActualTitle=getTitle();
				i++;
			}
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
		Thread.sleep(5000);
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
