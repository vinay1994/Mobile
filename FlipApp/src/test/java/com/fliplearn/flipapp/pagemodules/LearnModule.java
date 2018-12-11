package com.fliplearn.flipapp.pagemodules;

import java.util.List;

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

public class LearnModule extends Base
{
	GenericFunctions generic = new GenericFunctions();

	@FindBy(xpath="//a[@id='learn-icon']")
	//	@AndroidFindBy(xpath="") 
	//	@iOSFindBy(id="")
	public RemoteWebElement learnImg;	

	@FindBy(xpath="//strong[text()='Fliplearn Prime']")
	@AndroidFindBy(xpath="//*[@text='Fliplearn Prime']")
	//	@iOSFindBy(id="")
	public RemoteWebElement primeImg;

	@FindBy(xpath="//h4/strong[contains(text(),'VMC Live')]")
	@AndroidFindBy(xpath="//*[@text='VMC Live @ Fliplearn']")
	//	@iOSFindBy(id="")
	public RemoteWebElement vmcImg;

	@FindBy(xpath="//a[text()='Pre Nursery']")
	@AndroidFindBy(xpath="//a[text()='Pre Nursery']")
	//	@iOSFindBy(id="")
	public RemoteWebElement selectClassLnk;

	@FindBy(xpath="//a[text()='Class 1']")
	@AndroidFindBy(xpath="//*[@text='Biology']")
	//	@iOSFindBy(id="")
	public RemoteWebElement selectSubjectLnk;


	@FindBy(xpath="//a[@id='learn-icon']")
	@AndroidFindBy(id="com.elss.educomp:id/ll_mm") 
	//	@iOSFindBy(id="")
	public List<RemoteWebElement> selectTOpic;

	@FindBy(xpath="//a[@id='learn-icon']")
	@AndroidFindBy(id="com.elss.educomp:id/rowThirdText") 
	//	@iOSFindBy(id="")
	public List<RemoteWebElement> Selectresource;



	@FindBy(xpath="//a[@id='learn-icon']")
	@AndroidFindBy(xpath="(//*[@resource-id='com.elss.educomp:id/subject_text'])[1]") 
	//			@iOSFindBy(id="")
	public RemoteWebElement resource;		

	public LearnModule(WebDriver driver) 
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);	
	}

	public void clickOnLearnImage() throws InterruptedException
	{
		Thread.sleep(2000);
		learnImg.click();
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
		selectSubjectLnk.click();
	}

}