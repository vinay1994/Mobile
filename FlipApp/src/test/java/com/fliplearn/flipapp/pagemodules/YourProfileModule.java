package com.fliplearn.flipapp.pagemodules;

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

public class YourProfileModule extends Base
{
	GenericFunctions generic = new GenericFunctions();
	
	public YourProfileModule(WebDriver driver) 
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);	
	}
	
	@FindBy(xpath="//a[@class='pull-right editclasssection ng-scope']/img[contains(@src,'edit-profile.png')]\r\n")
//	@AndroidFindBy(xpath="") 
//	@iOSFindBy(id="")
	public RemoteWebElement classEditImg;	
	
	@FindBy(xpath="//img[contains(@class,'profilePic ng-scope')]")
	@AndroidFindBy(id="") 
	@iOSFindBy(id="")
	RemoteWebElement profile;


	@FindBy(xpath="//a[contains(@ng-click,'logout()')]")
	@AndroidFindBy(id="") 
	@iOSFindBy(id="")
	RemoteWebElement logout;
	
	//Class/Section Popup
	@FindBy(xpath="//form[@name='ClassSectionForm']//div[@class='registration-form'][1]//select")
//	@AndroidFindBy(xpath="") 
//	@iOSFindBy(id="")
	public RemoteWebElement classLst;
	
	@FindBy(xpath="//form[@name='ClassSectionForm']//div[@class='registration-form'][2]//select")
//	@AndroidFindBy(xpath="") 
//	@iOSFindBy(id="")
	public RemoteWebElement sectionLst;	

	@FindBy(xpath="//button[text()='Change']")
//	@AndroidFindBy(xpath="") 
//	@iOSFindBy(id="")
	public RemoteWebElement changeBtn;		
	
	@FindBy(xpath="(//div[@class='col-sm-4 userInfo ng-scope'])[1]/p")
//	@AndroidFindBy(xpath="") 
//	@iOSFindBy(id="")
	public RemoteWebElement usernameLbl;	
	
	public void updateClassAndSection(WebDriver driver, String className, String sectionName) throws InterruptedException
	{
		Thread.sleep(3000);
		HeaderModule heaMod = new HeaderModule(driver);
		generic.mouseHoverAndClick(driver, heaMod.profileImg, heaMod.myProfileLnk);
		Thread.sleep(3000);
		generic.waitForElementVisibility(driver, classEditImg);
		classEditImg.click();
		extentTest.log(Status.PASS, "Click on Class Edit Image Icon.");
		
		generic.selectValueFromList(driver, classLst, className);
		extentTest.log(Status.PASS, "Update Class to: "+className);

		generic.selectValueFromList(driver, sectionLst, sectionName);
		extentTest.log(Status.PASS, "Update Section to: "+sectionName);

		changeBtn.click();

	}
	
	public String getUsernameLabel() throws InterruptedException
	{
		Thread.sleep(3000);
		String roleName = usernameLbl.getText();
		System.out.println("Role Name is: "+roleName);
		return roleName;
	}
	
	public void mouseOverOnProfileLogout() throws InterruptedException 
	{
		generic.mouseHoverAndClick(driver, profile, logout);
	}
}
