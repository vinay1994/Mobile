package com.fliplearn.flipapp.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.fliplearn.flipapp.helper.Base;
import com.fliplearn.flipapp.helper.GenericFunctions;
import com.fliplearn.flipapp.pagemodules.HeaderModule;
import com.fliplearn.flipapp.pagemodules.LoginModule;
import com.fliplearn.flipapp.pagemodules.MobileNumberModule;
import com.fliplearn.flipapp.pagemodules.OnboardingModule;
import com.fliplearn.flipapp.pagemodules.ProfileHomeModule;
import com.fliplearn.flipapp.pagemodules.QuizModule;
import com.fliplearn.flipapp.pagemodules.YourProfileModule;

public class UserProfile extends Base
{
	GenericFunctions generic;
	LoginModule logMod;
	OnboardingModule onbMod;
	MobileNumberModule mobNumMod;
	QuizModule quiMod;
	YourProfileModule youProMod;
	HeaderModule heaMod;
	ProfileHomeModule proHomMod;
	
	@BeforeMethod
	public void befMethod()
	{
		logMod = new LoginModule(driver);
		onbMod = new OnboardingModule(driver);
		mobNumMod = new MobileNumberModule(driver);
		quiMod = new QuizModule(driver);
		youProMod = new YourProfileModule(driver);
		heaMod = new HeaderModule(driver);
		generic = new GenericFunctions();
		proHomMod = new ProfileHomeModule(driver);
	}

	/**
	 * Verify User is not guest
	 * @author Tarun Goswami
	 * @since 2018-10-10
	 * @modifiedBy Tarun Goswami on 2019-03-11
	 * @version 1.1
	 * @throws InterruptedException 
	 */
	@Test(dataProvider = "allusers")
	public void verifyUserNotGuest(String role) throws InterruptedException
	{		
		logMod.Login(role, "CBSE", "6", "Single", "Prime", "Yes");
		
		if(platform.equals("Web"))
		{
			generic.mouseHoverAndClick(driver, heaMod.profileImg, heaMod.myProfileLnk);
			Thread.sleep(3000);
			Assert.assertEquals(youProMod.getUsernameLabel(), role+" Name");
		}
		else
		{
			Assert.assertEquals(youProMod.getUsernameLabel(), role);
		}
	}
}
