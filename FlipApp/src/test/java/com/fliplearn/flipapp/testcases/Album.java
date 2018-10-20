package com.fliplearn.flipapp.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.fliplearn.flipapp.helper.Base;
import com.fliplearn.flipapp.pagemodules.AlbumModule;
import com.fliplearn.flipapp.pagemodules.AnnouncementModule;
import com.fliplearn.flipapp.pagemodules.HeaderModule;
import com.fliplearn.flipapp.pagemodules.LoginModule;
import com.fliplearn.flipapp.pagemodules.MenuModule;
import com.fliplearn.flipapp.pagemodules.MobileNumberModule;
import com.fliplearn.flipapp.pagemodules.OnboardingModule;
import com.fliplearn.flipapp.pagemodules.QuizModule;
import com.fliplearn.flipapp.pagemodules.SignInAsModule;
import com.fliplearn.flipapp.pagemodules.YourProfileModule;

public class Album extends Base {
		LoginModule logMod;
		OnboardingModule onbMod;
		MobileNumberModule mobNumMod;
		AlbumModule albMod;
		MenuModule menMod;
		SignInAsModule signInMod;
		QuizModule quiMod;
	   YourProfileModule youProMod;
	   HeaderModule heaMod;
		
		@BeforeMethod
		public void befAlbum()
		{
			logMod = new LoginModule(driver);
			onbMod = new OnboardingModule(driver);
			mobNumMod = new MobileNumberModule(driver);
			albMod = new AlbumModule(driver);
			signInMod=new SignInAsModule(driver);
		    quiMod=new QuizModule(driver);
		    youProMod=new YourProfileModule(driver);
		    heaMod=new HeaderModule(driver);
		}

		/**
		 * Verify Admin, Principal and Teacher can create album on Web, Android and iOS
		 * @author vinay kumar 
		 * @since 2018-09-30
		 * @version 1.1
		 * @throws Throwable 
		 */
		
		@Test(dataProvider = "group2")
		public void createAlbum(String role) throws Throwable
		{
			logMod.Login(role, "Single", "None", "Yes");
			//albMod.mouseOverOnpostBtn();	
			extentTest.log(Status.PASS, "Mouse Hover on Post button");
			Thread.sleep(3000);

			Assert.assertEquals(albMod.fillTxt(), albMod.getTitle());
		}

		/**
		 * Verify User Student and parent can not create album on Browser
		 * @author vinay kumar 
		 * @since 2018-09-25
		 * @version 1.0
		 * @throws InterruptedException 
		 **/

		@Test(dataProvider = "group3")
		public void canNotcreateAlbum(String role) throws InterruptedException
		{
			logMod.Login(role, "Single", "None", "Yes");
			Assert.assertEquals(albMod.isPostBtndisplayed(), false);
		}

		/**
		 * Verify User Student and parent can view  album on Browser, android and ios
		 * @author vinay kumar 
		 * @since 2018-09-25
		 * @version 1.0
		 * @throws Throwable 
		 */
		@Test(dataProvider="group2")
		public void canViewAlbum(String role) throws Throwable
		{
			logMod.Login(role, "Single", "None", "Yes");
			Thread.sleep(3000);

			String exepected = albMod.fillTxt();
			albMod.mouseOverOnProfileLogout();
			logMod.Login("Student", "Single", "None", "Yes");
			youProMod.updateClassAndSection(driver, "Pre-Nursery", "A");
			heaMod.clickonHomeBtn();	
			String actual = albMod.getTitle();
			youProMod.updateClassAndSection(driver, "Class 12", "A");
			Assert.assertEquals(exepected, actual);
		}

		

}
