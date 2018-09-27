package com.fliplearn.flipapp.testcases;

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
		onbMod.skipScreen();
	}
	
	/**
	 * Verify User Admin Login on Desktop Browser
	 * @author vinay kumar 
	 * @since 2018-09-25
	 * @version 1.0
	 */
	@Test
	public void createAnn_Desktop_admin()
	{
		  logMod = new LoginModule(driver);
		  logMod.Login("admin");
		  annMod=new AnnouncementModule(driver);
		  annMod.mouseOverOnpostBtn();		
	}
	
	/**
	 * Verify User Admin Login on Android App
	 * @author vinay kumar 
	 * @since 2018-09-20
	 * @version 1.0
	 */
	@Test
	public void createAnn_Android_admin() 
	{
		 logMod.Login("admin");
	}
	

}
