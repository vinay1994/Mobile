package com.fliplearn.flipapp.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.fliplearn.flipapp.helper.Base;
import com.fliplearn.flipapp.pagemodules.EventModule;
import com.fliplearn.flipapp.pagemodules.HeaderModule;
import com.fliplearn.flipapp.pagemodules.LearnModule;
import com.fliplearn.flipapp.pagemodules.LoginModule;
import com.fliplearn.flipapp.pagemodules.MenuModule;
import com.fliplearn.flipapp.pagemodules.MobileNumberModule;
import com.fliplearn.flipapp.pagemodules.OnboardingModule;
import com.fliplearn.flipapp.pagemodules.QuizModule;
import com.fliplearn.flipapp.pagemodules.SignInAsModule;
import com.fliplearn.flipapp.pagemodules.YourProfileModule;

public class Event extends Base 
{
	LoginModule logMod;
	OnboardingModule onbMod;
	MobileNumberModule mobNumMod;
	EventModule eveMod;
	MenuModule menMod;
	SignInAsModule signInMod;
	QuizModule quiMod;
	YourProfileModule youProMod;
	HeaderModule heaMod;
	LearnModule learnMod;
	
	@BeforeMethod
	public void beforeEvent()
	{
		logMod = new LoginModule(driver);
		onbMod = new OnboardingModule(driver);
		mobNumMod = new MobileNumberModule(driver);
		eveMod = new EventModule(driver);
		menMod = new MenuModule(driver);
		signInMod=new SignInAsModule(driver);
	    quiMod=new QuizModule(driver);
	    youProMod=new YourProfileModule(driver);
	    heaMod=new HeaderModule(driver);
	    learnMod = new LearnModule(driver);
	}
	
	/**
	 * Verify Admin, Principal and Teacher can create Announcement on Web, Android and iOS
	 * @author vinay kumar 
	 * @since 2018-09-30
	 * @version 1.2
	 * @throws Throwable 
	 */
	@Test(dataProvider = "staff")
	public void createAnnouncement(String role) throws Throwable
	{
		logMod.Login(role, "CBSE", "6", "Single", "Prime", "Yes");
		eveMod.fillTxt("Announcement");
	}

	/**
	 * Verify Admin, Principal and Teacher can create Album on Web, Android and iOS
	 * @author vinay kumar 
	 * @since 2018-09-30
	 * @version 1.2
	 * @throws Throwable 
	 */
	@Test(dataProvider = "staff")
	public void createAlbum(String role) throws Throwable
	{
		logMod.Login(role, "CBSE", "6", "Single", "Prime", "Yes");
		eveMod.fillTxt("Album");
	}
	
	/**
	 * Verify Admin, Principal and Teacher can create Home work on Web, Android and iOS
	 * @author vinay kumar 
	 * @since 2018-09-30
	 * @version 1.2
	 * @modifiedBy Tarun Goswami on 2019-04-09
	 * @throws Throwable 
	 */
	@Test(dataProvider = "staff")
	public void createHomework(String role) throws Throwable
	{
		logMod.Login(role, "CBSE", "6", "Single", "Prime", "Yes");
		eveMod.fillTxt("Homework");
	}
	
	/**
	 * Verify Admin, Principal and Teacher can not create Announcement on Web, Android and iOS
	 * @author vinay kumar 
	 * @since 2018-09-30
	 * @version 1.2
	 * @throws IOException 
	 * @throws Throwable 
	 */
	@Test(dataProvider = "nostaff")
	public void canNotCreateAnnouncement(String role) throws InterruptedException, IOException
	{
		logMod.Login(role, "CBSE", "6", "Single", "Prime", "Yes");
		if(role.equals("Parent"))
			eveMod.noticeboardTab.click();
		Assert.assertEquals(eveMod.isPostBtndisplayed(), false);
	}
	
	/**
	 * Verify Admin, Principal and Teacher can not create Album on Web, Android and iOS
	 * @author vinay kumar 
	 * @since 2018-09-30
	 * @version 1.2
	 * @throws IOException 
	 * @throws Throwable 
	 */
	@Test(dataProvider = "nostaff")
	public void canNotCreateAlbum(String role) throws InterruptedException, IOException
	{
		logMod.Login(role, "CBSE", "6", "Single", "Prime", "Yes");
		if(role.equals("Parent"))
			eveMod.noticeboardTab.click();
		Assert.assertEquals(eveMod.isPostBtndisplayed(), false);
	}
	
	/**
	 * Verify Admin, Principal and Teacher can not create Homework on Web, Android and iOS
	 * @author vinay kumar 
	 * @since 2018-09-30
	 * @version 1.2
	 * @throws IOException 
	 * @throws Throwable 
	 */
	@Test(dataProvider = "nostaff")
	public void canNotCreateHomework(String role) throws InterruptedException, IOException
	{
		logMod.Login(role, "CBSE", "6", "Single", "Prime", "Yes");
		if(role.equals("Parent"))
			eveMod.noticeboardTab.click();
		Assert.assertEquals(eveMod.isPostBtndisplayed(), false);
	}
	
	/**
	 * Verify User parent can view  Announcement on Browser, android and ios
	 * @author vinay kumar 
	 * @since 2018-09-25
	 * @version 1.0
	 * @throws Throwable 
	 */
	@Test(dataProvider = "staff")
	public void parentCanViewAnnouncement(String role) throws Throwable
	{
		logMod.Login(role, "CBSE", "6", "Single", "Prime", "Yes");
		Thread.sleep(3000);
		//String exepected = eveMod.fillTxt("Announcement");
		youProMod.mouseOverOnProfileLogout();
		logMod.Login("Parent", "CBSE", "Pre", "Single", "Prime", "Yes");
		eveMod.clickOnNoticeboard();	
		String actual = eveMod.getTitle();
		//Assert.assertEquals(exepected, actual);
	}
	
	/**
	 * Verify User Student cam view  Announcement on Browser, android and ios
	 * @author vinay kumar 
	 * @since 2018-09-25
	 * @version 1.0
	 * @throws Throwable 
	 */
	@Test(dataProvider = "staff")
	public void studentCanViewAnnouncement(String role) throws Throwable
	{
		logMod.Login(role, "CBSE", "6", "Single", "Prime", "Yes");
		Thread.sleep(3000);
		//String exepected = eveMod.fillTxt("Announcement");
		youProMod.mouseOverOnProfileLogout();
		logMod.Login("Student", "CBSE", "Pre", "Single", "Prime", "Yes");
		heaMod.clickonHomeBtn();	
		String actual = eveMod.getRecentTitle();
		//Assert.assertEquals(exepected, actual);
	}
	
	/**
	 * Verify User parent can view  Announcement on Browser, android and ios
	 * @author vinay kumar 
	 * @since 2018-09-25
	 * @version 1.0
	 * @throws Throwable 
	 */
	@Test(dataProvider = "staff")
	public void parentCanViewAlbum(String role) throws Throwable
	{
		logMod.Login(role, "CBSE", "6", "Single", "Prime", "Yes");
		Thread.sleep(3000);
		//String exepected = eveMod.fillTxt("Album");
		youProMod.mouseOverOnProfileLogout();
		logMod.Login("Parent", "CBSE", "Pre", "Single", "Prime", "Yes");
		eveMod.clickOnNoticeboard();	
		String actual = eveMod.getTitle();
		//Assert.assertEquals(exepected, actual);
	}
	
	/**
	 * Verify User Student can view  Album on Browser, android and ios
	 * @author vinay kumar 
	 * @since 2018-09-25
	 * @version 1.0
	 * @throws Throwable 
	 */
	@Test(dataProvider = "staff")
	public void studentCanViewAlbum(String role) throws Throwable
	{
		logMod.Login(role, "CBSE", "6", "Single", "Prime", "Yes");
		Thread.sleep(3000);
		//String exepected = eveMod.fillTxt("Album");
		youProMod.mouseOverOnProfileLogout();
		logMod.Login("Student", "CBSE", "Pre", "Single", "Prime", "Yes");
		heaMod.clickonHomeBtn();	
		String actual = eveMod.getRecentTitle();
		//Assert.assertEquals(exepected, actual);
	}
	
	/**
	 * Verify User parent can view  Homework on Browser, android and ios
	 * @author vinay kumar 
	 * @since 2018-09-25
	 * @version 1.0
	 * @throws Throwable 
	 */
	@Test(dataProvider = "staff")
	public void parentCanViewHomework(String role) throws Throwable
	{
		logMod.Login(role, "CBSE", "6", "Single", "Prime", "Yes");
		Thread.sleep(3000);
		//String exepected = eveMod.fillTxt("Homework");
		youProMod.mouseOverOnProfileLogout();
		logMod.Login("Parent", "CBSE", "Pre", "Single", "Prime", "Yes");
		eveMod.clickOnNoticeboard();	
		String actual = eveMod.getTitle();
		//Assert.assertEquals(exepected, actual);
	}
	
	/**
	 * Verify User Student can view  Homework on Browser, android and ios
	 * @author vinay kumar 
	 * @since 2018-09-25
	 * @version 1.0
	 * @throws Throwable 
	 */
	@Test(dataProvider = "staff")
	public void studentCanViewHomework(String role) throws Throwable
	{
		logMod.Login(role, "CBSE", "6", "Single", "Prime", "Yes");
		Thread.sleep(3000);
		//String exepected = eveMod.fillTxt("Homework");
		youProMod.mouseOverOnProfileLogout();
		logMod.Login("Student", "CBSE", "Pre", "Single", "Prime", "Yes");
		heaMod.clickonHomeBtn();	
		String actual = eveMod.getRecentTitle();
		//Assert.assertEquals(exepected, actual);
	}
	
}
