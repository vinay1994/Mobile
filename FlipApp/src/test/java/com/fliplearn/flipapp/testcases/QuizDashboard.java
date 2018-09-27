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
import com.fliplearn.flipapp.pagemodules.QuizModule;
import com.fliplearn.flipapp.pagemodules.SelectClassModule;
import com.fliplearn.flipapp.pagemodules.SignInAsModule;

public class QuizDashboard extends Base 
{
	LoginModule logMod;
	OnboardingModule onbMod;
	LearnModule leaMod;
	MobileNumberModule mobNumMod;
	QuizModule quiMod;
	SignInAsModule sigInMod;
	SelectClassModule selClaMod;
	QuizDashBoardModule quiDasMod;
	
	@BeforeMethod
	public void befQuiz()
	{
		logMod = new LoginModule(driver);
		onbMod = new OnboardingModule(driver);
		sigInMod = new SignInAsModule(driver);
		mobNumMod = new MobileNumberModule(driver);
		quiMod = new QuizModule(driver);
		selClaMod = new SelectClassModule(driver);
		leaMod = new LearnModule(driver);
		quiDasMod = new QuizDashBoardModule(driver); 
		onbMod.skipScreen();
	}

	/**
	 * Verify Quiz on Android App
	 * @author Durga
	 * @since 2018-09-21
	 * @version 1.1
	 * @throws InterruptedException 
	 */
	@Test
	public void verifyWebQuizDashBoardAdmin() throws InterruptedException
	{
		logMod.Login("admin");		
		mobNumMod.skipBtn.click();
		sigInMod.adminLnk.click();
		sigInMod.proceedBtn.click();
		leaMod.learnImg.click();
		quiDasMod.quizDashboardBtn.click();
		
		String expectedList = aConfig.getProperty("QUIZ_HEAD") ;
		
		Assert.assertEquals(GenericFunctions.compareList(selClaMod.quizHead, expectedList), true);
	}
	
	/**
	 * Verify Quiz on Android App
	 * @author Durga
	 * @since 2018-09-21
	 * @version 1.1
	 * @throws InterruptedException 
	 */
	@Test
	public void verifyAndroidQuizdashBoard() throws InterruptedException
	{	
		logMod.Login("admin");		
		
		sigInMod.adminLnk.click();
		mobNumMod.skipBtn.click();
		quiMod.skipBtn.click();
		
		GenericFunctions.touchCordinates(driver, 10, 95);
		GenericFunctions.touchCordinates(driver, 10, 95);
		
		leaMod.learnImg.click();
		quiDasMod.quizdashboardBtn.click();
		quiDasMod.playQuizBtn.click();
		
		String expectedList = aConfig.getProperty("ADMIN_QUIZ_CLASSES") ;
		Assert.assertEquals(GenericFunctions.compareList(selClaMod.classList, expectedList), true);
	}
}