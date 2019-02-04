package com.fliplearn.flipapp.pagemodules;

import java.util.List;

import org.openqa.selenium.By;
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
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class LearnModule extends Base
{
	GenericFunctions generic = new GenericFunctions();

	@FindBy(xpath="(//*[text()='Learn'])[1]")
	@AndroidFindBy(xpath="//*[@text='Learn']") 
	@iOSXCUITFindBy(id="Learn")
	public RemoteWebElement learnImg;	

	@FindBy(xpath="//strong[text()='Fliplearn Prime']")
	@AndroidFindBy(xpath="//*[@text='Fliplearn Prime']")
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name='Fliplearn Prime']")
	public RemoteWebElement primeImg;

	@FindBy(xpath="//h4/strong[contains(text(),'VMC Live')]")
	@AndroidFindBy(xpath="//*[@text='VMC Live @ Fliplearn']")
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name='VMC Live @ Fliplearn']")
	public RemoteWebElement vmcImg;

	@FindBy(xpath="//a[text()='Pre Nursery']")
	@AndroidFindBy(xpath="//*[@text='Pre Nursery']")
	public RemoteWebElement selectClassLnk;

	@FindBy(xpath="//a[text()='Class 1']")
	@AndroidFindBy(xpath="//*[@resource-id='com.elss.educomp:id/tv_learn']")
	@iOSFindBy(id="(//XCUIElementTypeButton[@name='Learn >'])[1]")
	public List<RemoteWebElement> selectSubjectLnk;


	@FindBy(xpath="//a[@id='learn-icon']")
	@AndroidFindBy(id="com.elss.educomp:id/ll_mm") 
	public List<RemoteWebElement> selectTopic;

	@FindBy(xpath="//a[@id='learn-icon']")
	@AndroidFindBy(id="com.elss.educomp:id/rowThirdText") 
	public List<RemoteWebElement> Selectresource;

	@FindBy(xpath="//a[@id='learn-icon']")
	@AndroidFindBy(xpath="(//*[@resource-id='com.elss.educomp:id/subject_text'])[1]") 
	public RemoteWebElement resource;
	
	@FindBy(xpath="//a[@id='learn-icon']")
	@AndroidFindBy(xpath="//*[@text='Noticeboard']") 
	public RemoteWebElement noticeBoard;

	public LearnModule(WebDriver driver) 
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);	
	}

	public void clickOnLearnImage() throws InterruptedException
	{
		Thread.sleep(2000);
		if(platform.equals("iOS"))
		{
			generic.touchCordinates(driver, 80, 15);
		}
		else
			learnImg.click();
		System.out.println("Clicked on learn");
	}

	public void clickOnPrimeImage() throws InterruptedException
	{
		extentTest.log(Status.INFO, "Before checking visibility");
		generic.waitForElementVisibility(driver, primeImg);
		extentTest.log(Status.INFO, "Waiting for element visibility");
		Thread.sleep(1000);
		primeImg.click();
	}

	public void clickOnSubjectLink()
	{
		selectSubjectLnk.get(0).click();
	}
	
	public void clicknoticeBoard()
	{
		noticeBoard.click();
	}
	
	

}