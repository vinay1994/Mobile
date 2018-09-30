package com.fliplearn.flipapp.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.fliplearn.flipapp.helper.Base;
import com.fliplearn.flipapp.pagemodules.AnnouncementModule;
import com.fliplearn.flipapp.pagemodules.LoginModule;
import com.fliplearn.flipapp.pagemodules.MenuModule;
import com.fliplearn.flipapp.pagemodules.MobileNumberModule;
import com.fliplearn.flipapp.pagemodules.OnboardingModule;
import com.fliplearn.flipapp.pagemodules.QuizModule;

public class Announcements extends Base 
{

	LoginModule logMod;
	OnboardingModule onbMod;
	MobileNumberModule mobNumMod;
	AnnouncementModule annMod;
	MenuModule menMod;

	@BeforeMethod
	public void befMethod()
	{
		logMod = new LoginModule(driver);
		onbMod = new OnboardingModule(driver);
		mobNumMod = new MobileNumberModule(driver);
		annMod = new AnnouncementModule(driver);
		//onbMod.skipScreen();
	}

	/**
	 * Verify User Admin to create announcement on Browser
	 * @author vinay kumar 
	 * @since 2018-09-25
	 * @version 1.0
	 * @throws InterruptedException 
	 */
	@Test
	public void createAnnoncement() throws InterruptedException
	{
		logMod.Login("admin");
		annMod.mouseOverOnpostBtn();	
		Assert.assertEquals(annMod.fillTxt(), annMod.getTitle());
	}

	/**
	 * Verify User Admin Login on Android Android App
	 * @author vinay kumar 
	 * @since 2018-09-20
	 * @version 1.0
	 * @throws InterruptedException 
	 */
	@Test
	public void createAnnoncementAdminAndroid() throws InterruptedException 
	{
		logMod.Login("admin");
		annMod.mouseOverOnpostBtn();	
		Assert.assertEquals(annMod.fillTxt(), annMod.getTitle());
	}

	/**
	 * Verify User principal to create announcement on Browser
	 * @author vinay kumar 
	 * @since 2018-09-25
	 * @version 1.0
	 * @throws InterruptedException 
	 */

	@Test
	public void createAnnoncementPrincipalWeb() throws InterruptedException
	{
		logMod.Login("principal");
		annMod.mouseOverOnpostBtn();	
		Assert.assertEquals(annMod.fillTxt(), annMod.getTitle());
	}

	/**
	 * Verify User principal to create announcement on Android App
	 * @author vinay kumar 
	 * @since 2018-09-25
	 * @version 1.0
	 * @throws InterruptedException 
	 */

	@Test
	public void createAnnoncementPrincipalAndroid() throws InterruptedException
	{
		logMod.Login("principal");
		annMod.mouseOverOnpostBtn();	
		Assert.assertEquals(annMod.fillTxt(), annMod.getTitle());
	}

	/**
	 * Verify User Teacher to create announcement on Browser
	 * @author vinay kumar 
	 * @since 2018-09-25
	 * @version 1.0
	 * @throws InterruptedException 
	 */
	@Test
	public void createAnnoncementTeacherWeb() throws InterruptedException
	{
		logMod.Login("teacher");
		annMod.mouseOverOnpostBtn();	
		Assert.assertEquals(annMod.fillTxt(), annMod.getTitle());
	}

	/**
	 * Verify User Teacher to create announcement on Android App
	 * @author vinay kumar 
	 * @since 2018-09-25
	 * @version 1.0
	 * @throws InterruptedException 
	 */
	@Test
	public void createAnnoncementTeacherAndroid() throws InterruptedException
	{
		logMod.Login("teacher");
		annMod.mouseOverOnpostBtn();	
		Assert.assertEquals(annMod.fillTxt(), annMod.getTitle());
	}


	/**
	 * Verify User parent can not create announcement on Browser
	 * @author vinay kumar 
	 * @since 2018-09-25
	 * @version 1.0
	 * @throws InterruptedException 
	 */
	@Test
	public void canNotcreateAnnoncementParentWeb() throws InterruptedException
	{
		logMod.Login("parent");
		Assert.assertTrue(annMod.isPostBtndisplayed(), "Post button is displaying for Parent");
	}

	/**
	 * Verify User parent can not create announcement on Android App
	 * @author vinay kumar 
	 * @since 2018-09-25
	 * @version 1.0
	 * @throws InterruptedException 
	 */
	@Test
	public void canNotcreateAnnoncementParentAndroid() throws InterruptedException
	{
		logMod.Login("parent");
		Assert.assertTrue(annMod.isPostBtndisplayed(), "Post button is displaying for Parent");
	}

	/**
	 * Verify User Student can not create announcement on Browser
	 * @author vinay kumar 
	 * @since 2018-09-25
	 * @version 1.0
	 * @throws InterruptedException 
	 */
	@Test
	public void canNotcreateAnnoncementStudentWeb() throws InterruptedException
	{
		logMod.Login("student");
		Assert.assertTrue(annMod.isPostBtndisplayed(), "Post button is displaying for Student");
	}

	/**
	 * Verify User Student can not create announcement on Android App
	 * @author vinay kumar 
	 * @since 2018-09-25
	 * @version 1.0
	 * @throws InterruptedException 
	 */
	@Test
	public void canNotcreateAnnoncementStudentAndroid() throws InterruptedException
	{
		logMod.Login("student");
		Assert.assertTrue(annMod.isPostBtndisplayed(), "Post button is displaying for Student");
	}

	/**
	 * Verify User Student can view  announcement on Browser
	 * @author vinay kumar 
	 * @since 2018-09-25
	 * @version 1.0
	 * @throws InterruptedException 
	 */
	@Test
	public void canViewAnnoncementStudentWeb() throws InterruptedException
	{
		logMod.Login("admin");
		String exepected = annMod.fillTxt();
		annMod.mouseOverOnProfile();
		logMod.Login("student");
		Assert.assertEquals(exepected, annMod.getTitle());
	}

	/**
	 * Verify User Student can view  announcement on Android App
	 * @author vinay kumar 
	 * @since 2018-09-25
	 * @version 1.0
	 * @throws InterruptedException 
	 */
	@Test
	public void canViewAnnoncementStudentAndroid() throws InterruptedException
	{
		logMod.Login("admin");
		String exepected = annMod.fillTxt();
		annMod.mouseOverOnProfile();
		logMod.Login("student");
		Assert.assertEquals(exepected, annMod.getTitle());
	}

	/**
	 * Verify User parent can view  announcement on Browser
	 * @author vinay kumar 
	 * @since 2018-09-25
	 * @version 1.0
	 * @throws InterruptedException 
	 */
	@Test
	public void canViewAnnoncementParentWeb() throws InterruptedException
	{
		logMod.Login("admin");
		String exepected = annMod.fillTxt();
		annMod.mouseOverOnProfile();
		logMod.Login("parent");
		Assert.assertEquals(exepected, annMod.getTitle());
	}

	/**
	 * Verify User parent can view  announcement on Android App
	 * @author vinay kumar 
	 * @since 2018-09-25
	 * @version 1.0
	 * @throws InterruptedException 
	 */
	@Test
	public void canViewAnnoncementParentAndroid() throws InterruptedException
	{
		logMod.Login("admin");
		String exepected = annMod.fillTxt();
		annMod.mouseOverOnProfile();
		logMod.Login("parent");
		Assert.assertEquals(exepected, annMod.getTitle());
	}
}
