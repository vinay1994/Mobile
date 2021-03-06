package com.fliplearn.flipapp.pagemodules;

import java.lang.reflect.InvocationTargetException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.fliplearn.flipapp.helper.Base;
import com.fliplearn.flipapp.helper.GenericFunctions;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;

public class YourProfileModule extends Base
{
	GenericFunctions generic = new GenericFunctions();
	HeaderModule heaMod = new HeaderModule(driver);
	
	public YourProfileModule(WebDriver driver) 
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);	
	}
	
	@FindBy(xpath="//a[@class='pull-right editclasssection ng-scope']/img[contains(@src,'edit-profile.png')]\r\n")
	public RemoteWebElement classEditImg;	
	
	@FindBy(xpath="//img[contains(@class,'profilePic ng-scope')]")
	RemoteWebElement profile;

	@FindBy(xpath="//a[contains(@ng-click,'logout()')]")
	RemoteWebElement logout;
	
	@FindBy(xpath="//form[@name='ClassSectionForm']//div[@class='registration-form'][1]//select")
	public RemoteWebElement classLst;
	
	@FindBy(xpath="//form[@name='ClassSectionForm']//div[@class='registration-form'][2]//select")
	public RemoteWebElement sectionLst;	

	@FindBy(xpath="//button[text()='Change']")
	public RemoteWebElement changeBtn;		
	
	@FindBy(xpath="(//div[@class='col-sm-4 userInfo ng-scope'])[1]/p")
	@AndroidFindBy(id="com.elss.educomp:id/role")
	public RemoteWebElement usernameLbl;	
	
	public void updateClassAndSection(WebDriver driver, String className, String sectionName) throws InvocationTargetException, InterruptedException
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
		
		if(!platform.equals("Web"))
			heaMod.burgerMenu.click();
		
		String roleName = usernameLbl.getText();
		return roleName;
	}
	
	public void mouseOverOnProfileLogout() throws InterruptedException, InvocationTargetException 
	{
		generic.mouseHoverAndClick(driver, profile, logout);
	}
}
