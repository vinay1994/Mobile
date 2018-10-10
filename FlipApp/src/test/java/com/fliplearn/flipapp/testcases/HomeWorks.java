package com.fliplearn.flipapp.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.fliplearn.flipapp.helper.Base;
import com.fliplearn.flipapp.pagemodules.AnnouncementModule;
import com.fliplearn.flipapp.pagemodules.HeaderModule;
import com.fliplearn.flipapp.pagemodules.HomeWorkModule;
import com.fliplearn.flipapp.pagemodules.LoginModule;
import com.fliplearn.flipapp.pagemodules.MenuModule;
import com.fliplearn.flipapp.pagemodules.MobileNumberModule;
import com.fliplearn.flipapp.pagemodules.OnboardingModule;
import com.fliplearn.flipapp.pagemodules.QuizModule;
import com.fliplearn.flipapp.pagemodules.SignInAsModule;
import com.fliplearn.flipapp.pagemodules.YourProfileModule;

public class HomeWorks extends Base {
	
		LoginModule logMod;
		OnboardingModule onbMod;
		MobileNumberModule mobNumMod;
		HomeWorkModule homeWoMod;
		MenuModule menMod;
		SignInAsModule signInMod;
		QuizModule quiMod;
		YourProfileModule youProMod;
		HeaderModule heaMod;
		
		@BeforeMethod
		public void befMethod()
		{
			logMod = new LoginModule(driver);
			onbMod = new OnboardingModule(driver);
			mobNumMod = new MobileNumberModule(driver);
			homeWoMod = new HomeWorkModule(driver);
			signInMod=new SignInAsModule(driver);
		    quiMod=new QuizModule(driver);
		    youProMod = new YourProfileModule(driver);
		    heaMod = new HeaderModule(driver);
		}

		/**
		 * Verify Admin, Principal and Teacher can create home works on Web, Android and iOS
		 * @author vinay kumar 
		 * @since 2018-09-30
		 * @version 1.1
		 * @throws Throwable 
		 */
		
		@Test(dataProvider = "group2")
		public void createHomework(String role) throws Throwable
		{
			logMod.Login(role);
			homeWoMod.mouseOverOnpostBtn();	
			extentTest.log(Status.PASS, "Mouse Hover on Post button");
			Assert.assertEquals(homeWoMod.fillTxt(), homeWoMod.getTitle());
		}

		/**
		 * Verify User Student and parent can not create home work on Browser
		 * @author vinay kumar 
		 * @since 2018-09-25
		 * @version 1.0
		 * @throws InterruptedException 
		 **/

		@Test(dataProvider = "group3")
		public void canNotcreateHomework(String role) throws InterruptedException
		{
			logMod.Login(role);
			Assert.assertTrue(homeWoMod.isPostBtndisplayed(), "Post button is displaying for User:-"+role);
		}

	

		/**
		 * Verify User Student and parent can view  home work on Browser, android and ios
		 * @author vinay kumar 
		 * @since 2018-09-25
		 * @version 1.0
		 * @throws Throwable 
		 */
		@Test(dataProvider = "group2")
		public void canViewHomework(String role) throws Throwable
		{
			logMod.Login(role);
			homeWoMod.mouseOverOnpostBtn();
			String exepected = homeWoMod.fillTxt();
			homeWoMod.mouseOverOnProfileLogout();
			logMod.Login("Student");
			youProMod.updateClassAndSection(driver, "Pre-Nursery", "A");
			heaMod.clickonHomeBtn();	
			String actual = homeWoMod.getTitle();
			youProMod.updateClassAndSection(driver, "Class 12", "A");
			Assert.assertEquals(exepected, actual);
		}

		
}
