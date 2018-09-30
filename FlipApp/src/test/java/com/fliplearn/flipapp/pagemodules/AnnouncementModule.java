package com.fliplearn.flipapp.pagemodules;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fliplearn.flipapp.helper.Base;
import com.fliplearn.flipapp.helper.GenericFunctions;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;

public class AnnouncementModule extends Base 
{

	@FindBy(xpath="//button[contains(text(),'Post')]")
	@AndroidFindBy(className="") 
	@iOSFindBy(id="")
	RemoteWebElement postBtn;

	@FindBy(xpath="//button[contains(@id,'announcement')]")
	@AndroidFindBy(id="") 
	@iOSFindBy(id="")
	RemoteWebElement annBtn;

	@FindBy(id="title")
	@AndroidFindBy(id="") 
	@iOSFindBy(id="")
	RemoteWebElement titleTxt;

	@FindBy(xpath="//span[contains(@class,'btn-co')]")
	@AndroidFindBy(id="") 
	@iOSFindBy(id="")
	RemoteWebElement shareWithBtn;

	@FindBy(xpath="//label[(text()='No')]")
	@AndroidFindBy(id="") 
	@iOSFindBy(id="")
	RemoteWebElement noRdBtn;


	@FindBy(xpath="//textarea[contains(@class,'-touched')]")
	@AndroidFindBy(id="") 
	@iOSFindBy(id="")
	RemoteWebElement addDescriptionTxt;


	@FindBy(xpath="//input[contains(@ng-click,'createFile()')]")
	@AndroidFindBy(id="") 
	@iOSFindBy(id="")
	RemoteWebElement uploadImageBtn;

	@FindBy(xpath="//button[(text()='Create')]")
	@AndroidFindBy(id="") 
	@iOSFindBy(id="")
	RemoteWebElement createBtn;

	@FindBy(xpath="(//label[contains(@ng-class,'checkleft')])[2]")
	@AndroidFindBy(id="") 
	@iOSFindBy(id="")
	RemoteWebElement select_class;   


	@FindBy(xpath="//button[contains(@id,'close')]")
	@AndroidFindBy(id="") 
	@iOSFindBy(id="")
	RemoteWebElement save;

	@FindBy(xpath="//h4[@class='m-t-20 margin-bottom-0 ng-binding']")
	@AndroidFindBy(id="") 
	@iOSFindBy(id="")
	RemoteWebElement getTitle;
	

	@FindBy(xpath="//img[contains(@class,'profilePic ng-scope')]")
	@AndroidFindBy(id="") 
	@iOSFindBy(id="")
	RemoteWebElement profile;


	@FindBy(xpath="//a[contains(@ng-click,'logout()')]")
	@AndroidFindBy(id="") 
	@iOSFindBy(id="")
	RemoteWebElement logout;


	public AnnouncementModule(WebDriver driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	public void mouseOverOnpostBtn() throws InterruptedException {
		GenericFunctions.mouseOver(driver,postBtn, annBtn);

	}
	public void mouseOverOnProfile() throws InterruptedException {
		GenericFunctions.mouseOver(driver,profile, logout);

	}

	public String fillTxt() throws InterruptedException {
		String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		driver.switchTo().activeElement();
		titleTxt.clear();
		titleTxt.sendKeys("Testing automation Title_"+timeStamp);
		select_class.click();
		save.click();
		noRdBtn.click();
		addDescriptionTxt.clear();
		addDescriptionTxt.sendKeys("Qa add description for testing purpose on this time :"+timeStamp);
		uploadImageBtn.click();
		uploadImageBtn.sendKeys("user.dir"+"resources/images/Screenshot (13).png");
		createBtn.click();
		isTitleDisplayed("Testing automation Title_"+timeStamp);
		return "Testing automation Title_"+timeStamp;
	}
	
	
	public boolean isTitleDisplayed(String Title) throws InterruptedException{
		int i=0;
		String ActualTitle=getTitle();
		while(!(ActualTitle.equalsIgnoreCase(Title)) && i<10){
			driver.navigate().refresh();
			ActualTitle=getTitle();
			i++;
		}
		if(!(ActualTitle.equalsIgnoreCase(Title))){
			return false;
		}else{
			return true;
		}
	}
	public String getTitle() throws InterruptedException{
		
		GenericFunctions.WaitFor_visibility(driver, getTitle);
		return getTitle.getText();
	}
	public boolean isPostBtndisplayed() {
		try {
		if(postBtn.getText().equalsIgnoreCase("Post"))
			return false;
		}
		catch(Exception e){
			return true;
		}
		return false;
	}
}
