package com.fliplearn.flipapp.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.fliplearn.flipapp.helper.Base;
import com.fliplearn.flipapp.helper.GenericFunctions;
import com.fliplearn.flipapp.pagemodules.LoginModule;
import com.fliplearn.flipapp.pagemodules.MobileNumberModule;
import com.fliplearn.flipapp.pagemodules.MyWallModule;
import com.fliplearn.flipapp.pagemodules.OnboardingModule;
import com.fliplearn.flipapp.pagemodules.QuizModule;

public class MyWall extends Base 
{
	LoginModule logMod;
	MyWallModule mywallMod;
	OnboardingModule onbMod;
	MobileNumberModule mobNumMod;
	QuizModule quiMod;
	GenericFunctions generic;
	MyWallModule myWalMod;
	
	@BeforeMethod
	public void befMethod()
	{
		generic = new GenericFunctions();
		logMod = new LoginModule(driver);
		onbMod = new OnboardingModule(driver);
		mobNumMod = new MobileNumberModule(driver);
		quiMod = new QuizModule(driver);
		myWalMod = new MyWallModule(driver);
		
	}
		
	/**
	 * Verify User User Login
	 * @author Vinay Yadav, Durga
	 * @since 2018-10-20
	 * @version 1.2
	 * @throws InterruptedException 
	 */
	@Test(dataProvider = "group0")
	public void verifyMywall(String role) throws InterruptedException
	{
		logMod.Login(role, "CBSE", "6", "Single", "Prime", "Yes");
		
		if(platform.equals("Web"))
		{
			if(!role.equals("Guest"))
				Assert.assertEquals(generic.isElementDisplayed(driver, myWalMod.myWall), true);
		}
		
		MyWallModule.myWall.click();
		MyWallModule.likeComment.click();
		MyWallModule.comment.click();
		
		Assert.assertEquals(generic.isElementDisplayed(driver, MyWallModule.likeComment), true);
		Assert.assertEquals(generic.isElementDisplayed(driver, MyWallModule.comment), true);
			
		
	}
}