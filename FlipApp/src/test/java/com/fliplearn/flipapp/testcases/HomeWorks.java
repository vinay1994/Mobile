package com.fliplearn.flipapp.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.fliplearn.flipapp.helper.Base;
import com.fliplearn.flipapp.pagemodules.AnnouncementModule;
import com.fliplearn.flipapp.pagemodules.LoginModule;
import com.fliplearn.flipapp.pagemodules.MenuModule;
import com.fliplearn.flipapp.pagemodules.MobileNumberModule;
import com.fliplearn.flipapp.pagemodules.OnboardingModule;
import com.fliplearn.flipapp.pagemodules.QuizModule;
import com.fliplearn.flipapp.pagemodules.SignInAsModule;

public class HomeWorks extends Base {
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
		 * Verify Admin, Principal and Teacher can create home works on Web, Android and iOS
		 * @author vinay kumar 
		 * @since 2018-09-30
		 * @version 1.1
		 * @throws Throwable 
		 */
		
		@Test(dataProvider = "group2")
		public void createAnnoncement(String role) throws Throwable
		{
			logMod.Login(role);
			annMod.mouseOverOnpostBtn();	
			extentTest.log(Status.PASS, "Mouse Hover on Post button");
			
			Assert.assertEquals(annMod.fillTxt(), annMod.getTitle());
		}

		/**
		 * Verify User Student and parent can not create home work on Browser
		 * @author vinay kumar 
		 * @since 2018-09-25
		 * @version 1.0
		 * @throws InterruptedException 
		 **/

		@Test(dataProvider = "group2")
		public void canNotcreateAnnoncement(String role) throws InterruptedException
		{
			logMod.Login(role);
			Assert.assertTrue(annMod.isPostBtndisplayed(), "Post button is displaying for Parent");
		}

		/**
		 * Verify User Student and parent can view  home work on Browser, android and ios
		 * @author vinay kumar 
		 * @since 2018-09-25
		 * @version 1.0
		 * @throws Throwable 
		 */
		@Test
		public void canViewAnnoncement() throws Throwable
		{
			logMod.Login("admin");
			String exepected = annMod.fillTxt();
			annMod.mouseOverOnProfile();
			logMod.Login("student");
			Assert.assertEquals(exepected, annMod.getTitle());
		}

		
}
