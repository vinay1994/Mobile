package com.fliplearn.flipapp.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.*;

import com.fliplearn.flipapp.helper.Base;
import com.fliplearn.flipapp.helper.GenericFunctions;
import com.fliplearn.flipapp.pagemodules.HeaderModule;
import com.fliplearn.flipapp.pagemodules.HomeModule;
import com.fliplearn.flipapp.pagemodules.LoginModule;
import com.fliplearn.flipapp.pagemodules.MobileNumberModule;
import com.fliplearn.flipapp.pagemodules.MyWallModule;
import com.fliplearn.flipapp.pagemodules.OnboardingModule;
import com.fliplearn.flipapp.pagemodules.PrimeDemoModule;
import com.fliplearn.flipapp.pagemodules.QuizModule;
import com.fliplearn.flipapp.pagemodules.YourProfileModule;

public class DemoPrimeVideos extends Base {
	LoginModule logMod;
	OnboardingModule onbMod;
	MobileNumberModule mobNumMod;
	QuizModule quiMod;
	GenericFunctions generic;
	MyWallModule myWalMod;
	HeaderModule heaMod;
	YourProfileModule youProMod;
	HomeModule homMod;
	PrimeDemoModule primedemomodule;

	@BeforeMethod
	public void befMethod() {
		generic = new GenericFunctions();
		logMod = new LoginModule(driver);
		onbMod = new OnboardingModule(driver);
		mobNumMod = new MobileNumberModule(driver);
		quiMod = new QuizModule(driver);
		myWalMod = new MyWallModule(driver);
		heaMod = new HeaderModule(driver);
		youProMod = new YourProfileModule(driver);
		homMod = new HomeModule(driver);
		primedemomodule = new PrimeDemoModule(driver);
	}

	@Test
	public void verifyParentAbleToPlayDemoVideo() throws InterruptedException, IOException {
		String role = "Parent";
		logMod.Login(role, "CBSE", "6", "Single", "Prime", "Yes");
		Assert.assertTrue(primedemomodule.flipLearnPrimeTile.isDisplayed());
		primedemomodule.clickOnPrimeTile();
		Assert.assertEquals(primedemomodule.textToIdentifyParent.getText(),
				"Please access the content from your child's account.");
      
		primedemomodule.playingDemoVideos();
	
	}
	
	
	

}
