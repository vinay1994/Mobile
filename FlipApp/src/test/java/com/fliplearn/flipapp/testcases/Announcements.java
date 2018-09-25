package com.fliplearn.flipapp.testcases;

import org.testng.annotations.Test;

import com.fliplearn.flipapp.helper.Base;
import com.fliplearn.flipapp.pagemodules.AnnouncementModule;
import com.fliplearn.flipapp.pagemodules.LoginModule;
import com.fliplearn.flipapp.pagemodules.MenuModule;
import com.fliplearn.flipapp.pagemodules.MobileNumberModule;
import com.fliplearn.flipapp.pagemodules.OnboardingModule;

public class Announcements extends Base {
	
	LoginModule logMod;
	OnboardingModule onbMod;
	MobileNumberModule mobNumMod;
	AnnouncementModule annmdl;
	MenuModule menu;
	
	/**
	 * Verify User Admin Login on Desktop Browser
	 * @author vinay kumar 
	 * @since 2018-09-25
	 * @version 1.0
	 */
	
	
	@Test
	public void createAnn_Desktop_admin() {
		  logMod = new LoginModule(driver);
		  logMod.Login("admin");
		  annmdl=new AnnouncementModule(driver);
		  annmdl.mouseOverOnpostBtn();
		
	}
	
	/**
	 * Verify User Admin Login on Android App
	 * @author vinay kumar 
	 * @since 2018-09-20
	 * @version 1.0
	 */
	@Test
	public void createAnn_Android_admin() {
		logMod = new LoginModule(driver);
		 logMod.Login("admin");
	}
	

}
