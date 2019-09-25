package com.fliplearn.flipapp.pagemodules;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.fliplearn.flipapp.helper.Base;
import com.fliplearn.flipapp.helper.GenericFunctions;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class HomeModule extends Base
{
	GenericFunctions generic=new GenericFunctions();
	
	public HomeModule(WebDriver driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	/********** OLD UI ***********/
	
	@FindBy(xpath="(//*[text()='My Wall '])[2]")
	@AndroidFindBy(xpath="//*[@text='My Wall']")
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name='My Wall']")
	public static RemoteWebElement myWallSection;
	
	/********** New UI **********/
	
	/*** Start Learning Section ***/
	@FindBy(xpath="//h3[text()='Start Learning']")
	@AndroidFindBy(xpath="//*[@text='Start Learning']")
	public  RemoteWebElement startLearning; 
	
	/*** Start Learning Section ***/
	@FindBy(xpath="//h3[text()='Start Practicing']")
	@AndroidFindBy(xpath="//*[@text='Start Practicing']")
	public  RemoteWebElement startPracticing;
	
	@FindBy(css="span[id='learnPracticeModeSwitch'][class='checkbtnnewcheckleft']")
	public RemoteWebElement learningModeBtn;
	
	@FindBy(css="span[id='learnPracticeModeSwitch'][class='checkbtnnewcheck']")
	public RemoteWebElement practiceModeBtn;
	
	@FindBy(css="span[id='learnPracticeModeSwitch']")
	public RemoteWebElement learnPracticeModeBtn;
	
	@FindBy(css="p[class='font18 fontregular switchFontStyle']")
	public RemoteWebElement learnPracticeModeTxt;
	
	@FindBy(xpath="//select[@id='selectTerm2']")
    public RemoteWebElement classDrp;
	
	@FindBy(xpath="//a[text()='Buy Subscription ']")
	public RemoteWebElement vmcBuySubscription;
	
	//VMC Select Class Popup
	@FindBy(xpath="//img[contains(@src,'fliplearn_guru_logo.jpg')]")
	public RemoteWebElement selectClassLogoImg;
	
	
	// Click on Practice Mode Button
	public void clickOnlearnPracticeModeBtn()
	{
		learnPracticeModeBtn.click();
	}
	
	// Select any subject
	public void selectSubject(String subjectName)
	{
		driver.findElement(By.xpath("//div[@id='subjectTiles']/a/h4[text()='"+subjectName+"']")).click();
	}
	
	// Verify any Subject
	public boolean verifySubjectDisplayed(String subjectName)
	{
		boolean displayed = true;
		try
		{
			Thread.sleep(5000);
			WebElement element = driver.findElement(By.xpath("//div[@id='subjectTiles']/a/h4[text()='"+subjectName+"']"));
		}
		catch(Exception e) 
		{
			displayed = false;
		};
		
		return displayed;
	}
	
	// Select any Class
	public void selectClass(String className) throws InterruptedException
	{
		generic.waitForElementVisibility(driver, classDrp);
		classDrp.click();
		Select selectClass = new Select(classDrp);
		selectClass.selectByVisibleText(className);
	}
	
	/*** Popular Video Section ***/
	
	@FindBy(xpath="//h3[text()='Popular Videos']")
	public RemoteWebElement popularVideosHeading;
	
	@FindBy(xpath="(//div[@class='popularVideoSection pos-relative equalHeightimg'])[1]")
	public RemoteWebElement popularVideo;
	
	@FindBy(css="h3[class='modal-title ng-binding']")
	public RemoteWebElement popularVideoModalHeading;	
	
	@FindBy(xpath="(//div[@class='popularVideoName']//h2)[1]")
	public RemoteWebElement popularVideoName;
	
	@FindBy(xpath="(//img[contains(@src,'playButtonVideo.png')])[1]")
	public RemoteWebElement popularVideoBtn;
	
    // Click on First Popular Video
	public void clickOnPopularVideo() throws InterruptedException
	{
		popularVideo.click();
		generic.waitForElementVisibility(driver, popularVideoModalHeading);
	}
	
	/*** Fliplearn Wall Section ***/
	
	@FindBy(xpath="//h3[text()='Fliplearn Wall']")
	public RemoteWebElement fliplearnWallHeading;
	
	@FindBy(xpath="(//div[@class='owl-carousel owl-theme fliplearnWall-carousel owl-loaded owl-drag']//img[starts-with(@src,'https://')])[1]")
	public RemoteWebElement fliplearnWallImg;
	
	@FindBy(xpath="(//div[@class='owl-carousel owl-theme fliplearnWall-carousel owl-loaded owl-drag']//img)[1]")
	public RemoteWebElement fliplearnWallThumb;
	
	@FindBy(xpath="(//div[@class='owl-carousel owl-theme fliplearnWall-carousel owl-loaded owl-drag']//img)[2]")
	public RemoteWebElement fliplearnWallVideoThumb;
	
	//div[@class='ytp-cued-thumbnail-overlay-image']
	
	@FindBy(xpath="//div[@class='owl-carousel owl-theme fliplearnWall-carousel owl-loaded owl-drag']//a[@class='equalHeightimg']")
	public List<RemoteWebElement> fliplearnWallThumbs;
	
	@FindBy(xpath="(//div[@class='col-sm-6 col-xs-4 text-right popularMore ng-scope'])[1]")
	public RemoteWebElement fliplearnWallMoreBtn;
	
	// Click on First My Wall Content
	public void clickOnMyWallContent() throws InterruptedException
	{
		fliplearnWallThumb.click();
	}
	
	// Click on First My Wall Content
	public void clickOnFliplearnWallMoreBtn() throws InterruptedException
	{
		fliplearnWallMoreBtn.click();
	}
	
	
	/*** Noticeboard Section ***/
	
	
	@FindBy(xpath="//h3[text()='School Noticeboard']")
	public RemoteWebElement noticeboardHeading;
	
	@FindBy(xpath="(//div[@class='pos-relative m-t-10 border-blue-1 cursor equalHeightimg'])[1]")
	public RemoteWebElement noticeboardThumb;
	
	@FindBy(xpath="//div[@class='pos-relative m-t-10 border-blue-1 cursor equalHeightimg']")
	public List<RemoteWebElement> noticeboardThumbs;
	
	@FindBy(xpath="(//div[@class='col-sm-6 col-xs-4 text-right popularMore ng-scope'])[2]")
	public RemoteWebElement noticeboardMoreBtn;
	
	@FindBy(xpath="//h4[@class='fontregular mobilefont16 ng-binding' and text()='Announcement'] | //h4[@class='fontregular mobilefont16 ng-binding' and text()='Album'] //h4[@class='fontregular mobilefont16 ng-binding' and text()='Homework']")
	public RemoteWebElement noticeboardEventType;
	
	@FindBy(xpath="//p[@class='font18 mobilefont14 ng-binding'] | //ul/li[@class='assetNameOthers announceNew_2 font16 ng-binding']")
	public RemoteWebElement noticeTitle;
	
	// Click on First Noticeboard Content
	public void clickOnNoticeboardContent() throws InterruptedException
	{
		noticeboardThumb.click();
	}
	
	// Click on First My Wall Content
	public void clickOnNoticeboardMoreBtn() throws InterruptedException
	{
		noticeboardMoreBtn.click();
	}
			
}