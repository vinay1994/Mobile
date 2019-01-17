package com.fliplearn.flipapp.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.fliplearn.flipapp.helper.Base;
import com.fliplearn.flipapp.helper.GenericFunctions;
import com.fliplearn.flipapp.pagemodules.HeaderModule;
import com.fliplearn.flipapp.pagemodules.LoginModule;
import com.fliplearn.flipapp.pagemodules.MobileNumberModule;
import com.fliplearn.flipapp.pagemodules.MyWallModule;
import com.fliplearn.flipapp.pagemodules.OnboardingModule;
import com.fliplearn.flipapp.pagemodules.QuizModule;
import com.fliplearn.flipapp.pagemodules.YourProfileModule;

public class Login extends Base 
{
	LoginModule logMod;
	OnboardingModule onbMod;
	MobileNumberModule mobNumMod;
	QuizModule quiMod;
	GenericFunctions generic;
	MyWallModule myWalMod;
	HeaderModule heaMod;
	YourProfileModule youProMod;
	
	@BeforeMethod
	public void befMethod()
	{
		generic = new GenericFunctions();
		logMod = new LoginModule(driver);
		onbMod = new OnboardingModule(driver);
		mobNumMod = new MobileNumberModule(driver);
		quiMod = new QuizModule(driver);
		myWalMod = new MyWallModule(driver);
		heaMod = new HeaderModule(driver);
		youProMod = new YourProfileModule(driver);
	}
	
	
	/**
	 * Verify User User Login
	 * @author Vinay Yadav, Durga
	 * @since 2018-10-20
	 * @version 1.2
	 * @throws InterruptedException 
	 */
	@Test(dataProvider = "allusers")
	public void verifyLogin(String role) throws InterruptedException
	{
		logMod.Login(role, "CBSE", "6", "Single", "Prime", "Yes");
		
		if(platform.equals("Web"))
		{
			if(!role.equals("Guest"))
				Assert.assertEquals(generic.isElementDisplayed(driver, myWalMod.myWall), true);
		}	
		else if(platform.equals("iOS"))
		{
			heaMod.clickOnLogoutBtn();
		}
	}
	
	/**
	 * Verify User User Login
	 * @author Durga
	 * @since 2018-10-20
	 * @version 1.2
	 * @throws InterruptedException 
	 */
	@Test(dataProvider = "allusers")
	public void verifyLogout(String role) throws InterruptedException
	{
		logMod.Login(role, "CBSE", "6", "Single", "Prime", "Yes");
		
		if(platform.equals("Web"))
		{
			if(!role.equals("Guest"))
				generic.mouseHoverAndClick(driver, heaMod.profileImg, heaMod.logoutLnk);
			else
				generic.mouseHoverAndClick(driver, heaMod.guestProfileImg, heaMod.logoutLnk);				
		}
		else
		{
			heaMod.clickOnLogoutBtn();
		}	
		Assert.assertTrue(logMod.usernameTxt.isDisplayed());
	}
}