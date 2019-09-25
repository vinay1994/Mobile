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

	@FindBy(xpath = "//*[contains(text(),'Live Class Recording - Linear Equations - 18 May')]")
	public RemoteWebElement videoLink;

	public Guru(WebDriver driver) {

		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	public void clickOnCoursePageBtn() throws InterruptedException {

		generic.waitForElementVisibility(driver, courseBtn);
		courseBtn.click();
		String MainWindow = driver.getWindowHandle();

		// To handle all new opened window.
		Set<String> s1 = driver.getWindowHandles();
		Iterator<String> i1 = s1.iterator();

		while (i1.hasNext()) {
			String ChildWindow = i1.next();

			if (!MainWindow.equalsIgnoreCase(ChildWindow)) {

				// Switching to Child window
				driver.switchTo().window(ChildWindow);
				System.out.println(driver.switchTo().window(ChildWindow).getTitle());
			}
		}
	}

	public void clickOnVideos() throws InterruptedException {

		generic.mouseHoverAndClick(driver, mycoursesBtn, mathsubject);
		
	}
}
