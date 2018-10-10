package com.fliplearn.flipapp.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.fliplearn.flipapp.helper.Base;
import com.fliplearn.flipapp.helper.GenericFunctions;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.fliplearn.flipapp.helper.Base;
import com.fliplearn.flipapp.helper.GenericFunctions;
import org.testng.annotations.Test;

import com.fliplearn.flipapp.helper.Base;
import com.fliplearn.flipapp.pagemodules.AnnouncementModule;
import com.fliplearn.flipapp.pagemodules.LoginModule;
import com.fliplearn.flipapp.pagemodules.MenuModule;
import com.fliplearn.flipapp.pagemodules.MobileNumberModule;
import com.fliplearn.flipapp.pagemodules.OnboardingModule;
import com.fliplearn.flipapp.pagemodules.QuizModule;
import com.fliplearn.flipapp.pagemodules.SignInAsModule;


public class Announcement extends Base 
{

	LoginModule logMod;
	OnboardingModule onbMod;
	MobileNumberModule mobNumMod;
	AnnouncementModule annMod;
	MenuModule menMod;
	SignInAsModule signInMod;
	QuizModule quiMod;
	@BeforeMethod
	public void befMethod()
	{
		logMod = new LoginModule(driver);
		onbMod = new OnboardingModule(driver);
		mobNumMod = new MobileNumberModule(driver);
		annMod = new AnnouncementModule(driver);
		signInMod=new SignInAsModule(driver);
	    quiMod=new QuizModule(driver);
	}

	/**
	 * Verify Admin, Principal and Teacher can create announcement on Web, Android and iOS
	 * @author vinay kumar 
	 * @since 2018-09-30
	 * @version 1.1
	 * @throws Throwable 
	 */
	
	@Test(dataProvider = "group2")
	public void createAnnouncement(String role) throws Throwable
	{
		logMod.Login(role);
		annMod.mouseOverOnpostBtn();	
		extentTest.log(Status.PASS, "Mouse Hover on Post button");
	Assert.assertEquals(annMod.fillTxt(), annMod.getTitle());;
	}

	/**
	 * Verify User Student and parent can not create announcement on Browser
	 * @author vinay kumar 
	 * @since 2018-09-25
	 * @version 1.0
	 * @throws InterruptedException 
	 **/

	@Test(dataProvider = "group3")
	public void canNotCreateAnnouncement(String role) throws InterruptedException
	{
		logMod.Login(role);
		Assert.assertEquals(annMod.isPostBtndisplayed(), false);
	}

	/**
	 * Verify User Student and parent can view  announcement on Browser, android and ios
		Assert.assertEquals(annMod.isElementDisplayed(driver, annMod.postBtn), false);
	}
	
	/**
	 * Verify User Student can view  announcement on Browser
	 * @author vinay kumar 
	 * @since 2018-09-25
	 * @version 1.0
	 * @throws Throwable 
	 */
	@Test
	public void canViewAnnouncement() throws Throwable
	{
		logMod.Login("Admin");
		String exepected = annMod.fillTxt();
		annMod.mouseOverOnProfileLogout();
		logMod.Login("Student");
		Assert.assertEquals(exepected, annMod.getTitle());
	}

	/**
	 * Verify User Student can view  announcement on Android App
	 * @author vinay kumar 
	 * @since 2018-09-25
	 * @version 1.0
	 * @throws Throwable 
	 */
/**	@Test
	public void canViewAnnoncementStudentAndroid() throws Throwable
	{
		logMod.Login("admin");
		String exepected = annMod.fillTxt();
		annMod.mouseOverOnProfile();
		logMod.Login("student");
		Assert.assertEquals(exepected, annMod.getTitle());
	}
**/
	/**
	 * Verify User parent can view  announcement on Browser
	 * @author vinay kumar 
	 * @since 2018-09-25
	 * @version 1.0
	 * @throws Throwable 
	 */
	@Test
	public void canViewAnnoncementParentWeb() throws Throwable
	{
		logMod.Login("admin");
		String exepected = annMod.fillTxt();
		annMod.mouseOverOnProfileLogout();
		logMod.Login("parent");
		Assert.assertEquals(exepected, annMod.getTitle());
	}

	/**
	 * Verify User parent can view  announcement on Android App
	 * @author vinay kumar 
	 * @since 2018-09-25
	 * @version 1.0
	 * @throws Throwable 
	 */
	@Test
	public void canViewAnnoncementParentAndroid() throws Throwable
	{
		logMod.Login("admin");
		String exepected = annMod.fillTxt();
		annMod.mouseOverOnProfileLogout();
		logMod.Login("parent");
		Assert.assertEquals(exepected, annMod.getTitle());
	}
}