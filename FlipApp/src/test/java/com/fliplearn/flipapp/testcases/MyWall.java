package com.fliplearn.flipapp.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.fliplearn.flipapp.helper.Base;
import com.fliplearn.flipapp.helper.GenericFunctions;
import com.fliplearn.flipapp.pagemodules.HomeModule;
import com.fliplearn.flipapp.pagemodules.LoginModule;
import com.fliplearn.flipapp.pagemodules.MobileNumberModule;
import com.fliplearn.flipapp.pagemodules.MyWallModule;
import com.fliplearn.flipapp.pagemodules.OnboardingModule;
import com.fliplearn.flipapp.pagemodules.QuizModule;

public class MyWall extends Base 
{
	HomeModule homMod;
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
		homMod = new HomeModule(driver);
		logMod = new LoginModule(driver);
		onbMod = new OnboardingModule(driver);
		mobNumMod = new MobileNumberModule(driver);
		quiMod = new QuizModule(driver);
		myWalMod = new MyWallModule(driver);
		
	}
		
	/**
	 * Verify User User Login
	 * @author Durga
	 * @since 2018-10-20
	 * @version 1.2
	 * @throws InterruptedException 
	 * @modifiedBy Tarun Goswami on 13 April 2019
	 */
	@Test//(dataProvider = "group0")
	public void verifyMywall() throws InterruptedException
	{
		String role = "Admin";
		logMod.Login(role, "CBSE", "6", "Single", "Prime", "Yes");
		
		homMod.myWallSection.click();
		String x = MyWallModule.likeComment.getText();
		System.out.println(x);		
		MyWallModule.comment.click();
		MyWallModule.clickonLike();
		System.out.println("Post was liked");
		String y=MyWallModule.clickonLike.getAttribute("class");
		System.out.println(y);
		
		
		MyWallModule.clickForDisLike(driver, y);
		System.out.println("Post was Disliked");
		
		Assert.assertEquals(generic.isElementDisplayed(driver, MyWallModule.likeComment), true);
		Assert.assertEquals(generic.isElementDisplayed(driver, MyWallModule.comment), true);
		Assert.assertEquals(generic.isElementDisplayed(driver, MyWallModule.clickonLike), true);
			
	}
}