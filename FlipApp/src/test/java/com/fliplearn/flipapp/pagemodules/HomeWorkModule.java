package com.fliplearn.flipapp.pagemodules;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

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

public class HomeWorkModule extends Base {
	GenericFunctions generic=new GenericFunctions();

	String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());

	@FindBy(xpath="//button[contains(text(),'Post')]")
	@AndroidFindBy(id="com.elss.educomp:id/post_layout") 
	@iOSFindBy(id="")
	public  RemoteWebElement postBtn;

	@FindBy(xpath="//button[contains(@id,'homework')]")
	@AndroidFindBy(id="") 
	@iOSFindBy(id="")
	public RemoteWebElement homeWorkBtn;

	@FindBy(xpath="(//input[@id='title'])[2]")
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


	//	@FindBy(xpath="//textarea[contains(@class,'-touched')]")
	@FindBy(xpath="(//textarea[@id='textboxIssuereport'])[2]")
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


	@FindBy(xpath="//select[@name='subject']")
	@AndroidFindBy(id="") 
	@iOSFindBy(id="")
	RemoteWebElement selectsubj;


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






	public HomeWorkModule(WebDriver driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	public void mouseOverOnpostBtn() throws InterruptedException {
		generic.mouseHoverAndClick(driver, postBtn, homeWorkBtn);

	}
	public void mouseOverOnProfileLogout() throws InterruptedException {
		generic.mouseHoverAndClick(driver,profile, logout);

	}

	public String fillTxt() throws Throwable {
		Thread.sleep(3000);
		mouseOverOnpostBtn();	

		Thread.sleep(2000);
		driver.switchTo().activeElement();
		titleTxt.clear();
		titleTxt.click();
		titleTxt.sendKeys("Testing automation Title_"+timeStamp);
		shareWithBtn.click();
		select_class.click();
		extentTest.log(Status.PASS, "Select Class");
		save.click();
		selectsubject();
		generic.waitForElementVisibility(driver,addDescriptionTxt );
		addDescriptionTxt.clear();
		addDescriptionTxt.sendKeys("Qa add description for testing purpose on this time :"+timeStamp);
		generic.scrollPage(createBtn);;
		uploadImageBtn.click();
		String Filepath = System.getProperty("user.dir")+"\\resources\\images\\vinay.png";
		System.out.println(Filepath);
		generic.UploadFile(Filepath);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("document.getElementById('btn-next').focus();");
		jse.executeScript("arguments[0].click();", createBtn);
		Thread.sleep(2000);
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

		if(!(ActualTitle.equalsIgnoreCase(Title))){
			return false;
		}else{
			return true;
		}
	}
	public String getTitle() throws InterruptedException{

		generic.waitForElementVisibility(driver, getTitle);
		return getTitle.getText();
	}
	public boolean isPostBtndisplayed() throws InterruptedException {
		return generic.isElementDisplayed(driver, postBtn);
	}
	public void selectsubject() {
		generic.selectElementByIndex(selectsubj,5);
	}
}
