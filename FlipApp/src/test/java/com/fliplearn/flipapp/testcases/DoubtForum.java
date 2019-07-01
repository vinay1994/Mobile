package com.fliplearn.flipapp.testcases;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.fliplearn.flipapp.helper.Base;
import com.fliplearn.flipapp.helper.GenericFunctions;
import com.fliplearn.flipapp.pagemodules.DoubtForumModule;
import com.fliplearn.flipapp.pagemodules.HomeModule;
import com.fliplearn.flipapp.pagemodules.LearnModule;
import com.fliplearn.flipapp.pagemodules.LoginModule;
import com.fliplearn.flipapp.pagemodules.MenuModule;
import com.fliplearn.flipapp.pagemodules.MobileNumberModule;
import com.fliplearn.flipapp.pagemodules.OnboardingModule;
import com.fliplearn.flipapp.pagemodules.PracticeChapterTopicModule;
import com.fliplearn.flipapp.pagemodules.PrimeChapterTopicModule;
import com.fliplearn.flipapp.pagemodules.PrimeClassModule;
import com.fliplearn.flipapp.pagemodules.PrimePurchaseFlowModule;
import com.fliplearn.flipapp.pagemodules.PrimeSubjectModule;

public class DoubtForum extends Base{
	LoginModule logMod;
	MobileNumberModule mobNumMod;
	MenuModule menMod;
	LearnModule leaMod;
	PrimeClassModule priClaMod;
	PrimeSubjectModule priSubMod;
	PrimePurchaseFlowModule priPurFloMod;
	GenericFunctions generic;
	PrimeChapterTopicModule priChaTopMod;
	OnboardingModule onbMod;
	PracticeChapterTopicModule praChaTopMod;
	HomeModule homMod;
	DoubtForumModule douForMod;
	
	@BeforeMethod
	public void preVerifyDoubtForum() 
	{	
		logMod = new LoginModule(driver);
		mobNumMod = new MobileNumberModule(driver);
		menMod = new MenuModule(driver);
		leaMod = new LearnModule(driver);
		priClaMod =	new PrimeClassModule(driver);
		priSubMod = new PrimeSubjectModule(driver); 
		priPurFloMod= new PrimePurchaseFlowModule(driver);
		 generic=new GenericFunctions();
		 onbMod = new OnboardingModule(driver);
		 praChaTopMod=new PracticeChapterTopicModule(driver);
		 homMod=new HomeModule(driver);
		 douForMod=new DoubtForumModule();
	}
	@Test(dataProvider="doubt_staff")
	public void verifyDoubtForumTab(String role) throws InterruptedException, IOException  {
		
		    logMod.Login(role, "CBSE", "10", "Single", "Prime", "Yes");
		    Thread.sleep(6000);
		   
		    JavascriptExecutor jse = (JavascriptExecutor)driver;
		    jse.executeScript("window.scrollBy(0,250)", "");
		    System.out.println(douForMod.clickOnDouFor);
			Assert.assertTrue(douForMod.clickOnDouFor.isDisplayed());
			Assert.assertTrue(douForMod.verDouFormImg.isDisplayed());
			douForMod.clickOnDoubtForumTab();
			Assert.assertTrue(douForMod.verFlipGuruTxt.isDisplayed());
			Assert.assertTrue(douForMod.verAskImg.isDisplayed());

			}
	@Test(dataProvider="doubt_staff")
	public void verifyCountOfDoubtTabs(String role) throws InterruptedException, IOException {
	        logMod.Login(role, "CBSE", "10", "Single", "Prime", "Yes");
	        Thread.sleep(6000);
	        JavascriptExecutor jse = (JavascriptExecutor)driver;
		    jse.executeScript("window.scrollBy(0,250)", "");
            Thread.sleep(2000);
            douForMod.clickOnDoubtForumTab();
            douForMod.verifyNumOfDoubtForuTab(role);

            }
		
		
		
		
		
		
		
		
	}
	


