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

public class LearnModule extends Base
{

	GenericFunctions generic = new GenericFunctions();
	
	@FindBy(xpath="//div[@id='navbar']//li[2]/div")
	@AndroidFindBy(xpath="//*[@text='Learn']") 
	@iOSFindBy(id="")
	public RemoteWebElement learnImg;	
	
	@FindBy(xpath="//strong[text()='Fliplearn Prime']")
	@AndroidFindBy(xpath="//strong[text()='Fliplearn Prime']")
	@iOSFindBy(id="")
	public RemoteWebElement primeImg;
	
	
	@FindBy(xpath="//h4/strong[contains(text(),'VMC Live')]")
	@AndroidFindBy(xpath="//strong[text()='Fliplearn Prime']")
	@iOSFindBy(id="")
	public RemoteWebElement vmcImg;
	
	
	
	
	
	@FindBy(xpath="//a[text()='Pre Nursery']")
	@AndroidFindBy(xpath="//a[text()='Pre Nursery']")
	@iOSFindBy(id="")
	public RemoteWebElement selectClassLnk;
	
	@FindBy(xpath="//a[text()='Class 1']")
	@AndroidFindBy(xpath="//a[text()='Class 7']")
	@iOSFindBy(id="")
	public RemoteWebElement selectSubjLnk;
		
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
		generic.waitForElementVisibility(driver, primeImg);
		Thread.sleep(1000);
		primeImg.click();
	}
	
	public void clickOnSubjectLink()
	{
		selectSubjLnk.click();
	}
	
}