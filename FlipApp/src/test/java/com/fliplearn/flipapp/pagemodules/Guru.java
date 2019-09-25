package com.fliplearn.flipapp.pagemodules;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.fliplearn.flipapp.helper.Base;
import com.fliplearn.flipapp.helper.GenericFunctions;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Guru extends Base {

	GenericFunctions generic = new GenericFunctions();
	@FindBy(xpath = "//a[contains(text(),'Go to Course Page')]  |  //a[contains(text(),'Go To Trial Course')]")
	public RemoteWebElement courseBtn;

	@FindBy(xpath = "//a[contains(text(),'My Courses')]")
	public RemoteWebElement mycoursesBtn;

	@FindBy(xpath = "//a[contains(text(),'Foundation-X-Mathematics')]")
	public RemoteWebElement mathsubject;

	@FindBy(xpath = "(//div[@class='activityinstance'])[1]")
	public RemoteWebElement videoLnk;

	public Guru(WebDriver driver) {

		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	public void clickOnCoursePageBtn() throws InterruptedException 
	{
		generic.waitForElementVisibility(driver, courseBtn);
		courseBtn.click();
	}

	public void clickOnVideos() throws InterruptedException {

		generic.mouseHoverAndClick(driver, mycoursesBtn, mathsubject);
		videoLnk.click();
		generic.verifyVideoContent(driver);
		
	}
}
