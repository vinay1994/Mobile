package com.fliplearn.flipapp.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.fliplearn.flipapp.helper.Base;
import com.fliplearn.flipapp.helper.GenericFunctions;
import com.fliplearn.flipapp.pagemodules.LearnModule;
import com.fliplearn.flipapp.pagemodules.LoginModule;
import com.fliplearn.flipapp.pagemodules.MenuModule;
import com.fliplearn.flipapp.pagemodules.MobileNumberModule;
import com.fliplearn.flipapp.pagemodules.OnboardingModule;
import com.fliplearn.flipapp.pagemodules.QuizDashBoardModule;
import com.fliplearn.flipapp.pagemodules.QuizModule;
import com.fliplearn.flipapp.pagemodules.SelectClassModule;
import com.fliplearn.flipapp.pagemodules.SignInAsModule;

public class QuizDashboard extends Base 
{

	LoginModule logMod;
	OnboardingModule onbMod;
	LearnModule learnMod;
	MenuModule menuMod;
	MobileNumberModule mobNumMod;
	QuizModule quiMod;
	SignInAsModule signInMod;
	SelectClassModule selClaMod;
	QuizDashBoardModule quizdashMod;
	
	@BeforeMethod
	public void befQuiz()
	{
		logMod = new LoginModule(driver);
		onbMod = new OnboardingModule(driver);
		menuMod = new MenuModule(driver);
		signInMod = new SignInAsModule(driver);
		mobNumMod = new MobileNumberModule(driver);
		quiMod = new QuizModule(driver);
		selClaMod = new SelectClassModule(driver);
		learnMod = new LearnModule(driver);
		quizdashMod = new QuizDashBoardModule(driver); 
	}

	/**
	 * Verify Quiz on Android App
	 * @author Durga
	 * @since 2018-09-21
	 * @version 1.0
	 * @throws InterruptedException 
	 */
	@Test
	public void verifyWebQuizDashBoard() throws InterruptedException
	{
		logMod.Login("admin");		
		mobNumMod.skipBtn.click();
		signInMod.adminLnk.click();
		signInMod.proceedBtn.click();
		learnMod.learn.click();
		quizdashMod.quizdashboardBtn.click();
		
		String expectedList = aConfig.getProperty("QUIZ_HEAD") ;
		
		Assert.assertEquals(GenericFunctions.compareList(selClaMod.quizHead, expectedList), true);
				
	}
	
	
	// For Android Mobile
	@Test
	public void verifyAndroidQuizdashBoard() throws InterruptedException
	{	
		logMod.Login("admin");		
		
		signInMod.adminLnk.click();
		mobNumMod.skipBtn.click();
		quiMod.skipBtn.click();
		
		GenericFunctions.touchCordinates(driver, 10, 95);
		GenericFunctions.touchCordinates(driver, 10, 95);
		
		learnMod.learn.click();
		quizdashMod.quizdashboardBtn.click();
		quizdashMod.playQuizBtn.click();
		
		String expectedList = aConfig.getProperty("ADMIN_QUIZ_CLASSES") ;
		
		Assert.assertEquals(GenericFunctions.compareList(selClaMod.classList, expectedList), true);
		
		
	}
}