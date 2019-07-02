package com.fliplearn.flipapp.pagemodules;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.fliplearn.flipapp.helper.Base;
import com.fliplearn.flipapp.helper.GenericFunctions;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class DoubtForumModule extends Base{
	
	GenericFunctions generic = new GenericFunctions();
	public DoubtForumModule() 
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	@FindBy(xpath="//*[text()='Doubt Forum']")
	public RemoteWebElement clickOnDouFor;
	
	@FindBy(xpath="//*[@class='hidden-xs ng-binding']")    
	public List<RemoteWebElement >verNoOfTab;
	
	@FindBy(xpath="//*[contains(@src,'doubt.png')]")
	public RemoteWebElement verDouFormImg;
	
	@FindBy(xpath="//*[text()='Fliplearn Guru']")
	public RemoteWebElement verFlipGuruTxt;
	
	@FindBy(xpath="//*[contains(@src,'doubtforumastronaut.png')]")
	public RemoteWebElement verAskImg;
	
	@FindBy(xpath="//*[@class='btn-animation']")
	public RemoteWebElement clickOnAskUrDoubt;
	
	@FindBy(xpath="(//*[@placeholder='Ask your doubt'])[2]")
	public RemoteWebElement entText;
	
	@FindBy(xpath="//*[text()='Search']")
	public RemoteWebElement cliOnSearch;
	
	@FindBy(name="subject")
	public RemoteWebElement selectSubject;
	
	@FindBy(name="chapter")
	public RemoteWebElement slectChap;
	
	@FindBy(xpath="//*[text()='Create']")
	public RemoteWebElement cliOnCreate;
	
	
	public void clickOnDoubtForumTab() {
		clickOnDouFor.click();
		}
	public void clickOnAskYourDoubt() {
		clickOnAskUrDoubt.click();
	}
	public void enterAskYourDoubtText() {
		entText.sendKeys("Create Post For Testing");
		}
	public void clickOnSearchButtn() {
		cliOnSearch.click();
	}
	
	public  void verifyNumOfDoubtForuTab(String role) throws InterruptedException, IOException {
		 List<RemoteWebElement> actualList = verNoOfTab;}
	
    public void selectSubjectFromDropDwn() {
    	selectSubject.click();
    	generic.selectByVisibleText(selectSubject,"Maths");
    	
    }
    public void selectChapFromDropdwn() {
    	slectChap.click();
    	generic.selectByVisibleText(slectChap, "Polynomials");
    }
    public void clickOnCreateButton() {
    	cliOnCreate.click();
    }
    
    
    
			 
		    }

	

	

			
			
		

	
	


