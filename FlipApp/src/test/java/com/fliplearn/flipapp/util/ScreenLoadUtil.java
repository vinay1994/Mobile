package com.fliplearn.flipapp.util;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.fliplearn.flipapp.helper.Base;
import com.fliplearn.flipapp.helper.GenericFunctions;
import com.fliplearn.flipapp.pagemodules.LearnModule;
import com.fliplearn.flipapp.pagemodules.LoginModule;
import com.fliplearn.flipapp.pagemodules.MobileNumberModule;
import com.fliplearn.flipapp.pagemodules.MyWallModule;
import com.fliplearn.flipapp.pagemodules.OnboardingModule;
import com.fliplearn.flipapp.pagemodules.QuizModule;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ScreenLoadUtil extends Base 
{

	LoginModule logMod;
	OnboardingModule onbMod;
	MobileNumberModule mobNumMod;
	QuizModule quiMod;
	GenericFunctions generic;
	MyWallModule myWalMod;
	LearnModule leaMod;

	@BeforeMethod
	public void befMethod()
	{
		generic = new GenericFunctions();
		logMod = new LoginModule(driver);
		onbMod = new OnboardingModule(driver);
		mobNumMod = new MobileNumberModule(driver);
		quiMod = new QuizModule(driver);
		myWalMod = new MyWallModule(driver);
		leaMod = new LearnModule(driver);
	}


	/**
	 * Verify User User Login
	 * @author Vinay Yadav, Durga
	 * @since 2018-10-20
	 * @version 1.2
	 * @throws InterruptedException 
	 */
	@Test
	public void loadTestOnAndroid() throws InterruptedException
	{
		if(eConfig.getProperty("Platform").equals("Android")) 
		{
			onbMod.skipScreen();
		}

		logMod.usernameTxt.sendKeys("class9.demo");
		logMod.passwordTxt.sendKeys(("156523"));

		if(eConfig.getProperty("Platform").equals("Android")) 
		{
			((AndroidDriver) driver).hideKeyboard();
			extentTest.log(Status.PASS, "Hide Keyboard");
		}
		Timestamp beforetime = new Timestamp(System.currentTimeMillis());
		logMod.loginBtn.click();
		Assert.assertTrue(quiMod.skipBtn.isDisplayed()	);
		Timestamp aftertime = new Timestamp(System.currentTimeMillis());
		System.out.println("Login takes time to visible: "+(aftertime.getTime()-beforetime.getTime()));
		extentTest.log(Status.PASS, "Click on Login button");

		if(!platform.equals("Web"))
		{
			quiMod.skipBtn.click();

			extentTest.log(Status.PASS, "Click on Quiz Skip Button");

			generic.touchCordinates(driver, 10, 95);
			 beforetime = new Timestamp(System.currentTimeMillis());
			extentTest.log(Status.PASS, "Tap on Got it."); 
			Assert.assertTrue(leaMod.primeImg.isDisplayed()	);
			 aftertime = new Timestamp(System.currentTimeMillis());
			System.out.println(aftertime);
			System.out.println("Prime image takes time to visible: "+(aftertime.getTime()-beforetime.getTime()));

		}	

		 beforetime = new Timestamp(System.currentTimeMillis());
		leaMod.clickOnPrimeImage();
		Assert.assertTrue(leaMod.selectSubjectLnk.isDisplayed());
		 aftertime = new Timestamp(System.currentTimeMillis());
		System.out.println("subject takes time to visible: "+(aftertime.getTime()-beforetime.getTime()));
		beforetime = new Timestamp(System.currentTimeMillis());
		leaMod.selectSubjectLnk.click();
		Assert.assertTrue(leaMod.selectTOpic.get(0).isDisplayed());
		aftertime = new Timestamp(System.currentTimeMillis());
		System.out.println("Topics takes time to visible: "+(aftertime.getTime()-beforetime.getTime()));
		beforetime = new Timestamp(System.currentTimeMillis());
		leaMod.selectTOpic.get(0).click();
		Assert.assertTrue(leaMod.Selectresource.get(0).isDisplayed());
		aftertime = new Timestamp(System.currentTimeMillis());
		System.out.println("resource takes time to visible: "+(aftertime.getTime()-beforetime.getTime()));
		leaMod.Selectresource.get(0).click();
	}
	public void beforetime() {
		Timestamp beforetime = new Timestamp(System.currentTimeMillis());
	}
	public void aftertime() {
		Timestamp beforetime = new Timestamp(System.currentTimeMillis());
	}
//	public void timedifference() {
//		System.out.println(aftertime.getTime()-beforetime.getTime());
//	}
}
