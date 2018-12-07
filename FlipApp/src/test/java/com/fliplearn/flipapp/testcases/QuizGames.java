package com.fliplearn.flipapp.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.fliplearn.flipapp.helper.Base;
import com.fliplearn.flipapp.helper.GenericFunctions;
import com.fliplearn.flipapp.pagemodules.LoginModule;
import com.fliplearn.flipapp.pagemodules.MenuModule;
import com.fliplearn.flipapp.pagemodules.MobileNumberModule;
import com.fliplearn.flipapp.pagemodules.OnboardingModule;
import com.fliplearn.flipapp.pagemodules.QuizModule;
import com.fliplearn.flipapp.pagemodules.SelectClassModule;
import com.fliplearn.flipapp.pagemodules.SignInAsModule;

public class QuizGames extends Base 
{
	LoginModule logMod;
	OnboardingModule onbMod;
	MenuModule menuMod;
	MobileNumberModule mobNumMod;
	QuizModule quiMod;
	SignInAsModule signInMod;
	SelectClassModule selClaMod;
	GenericFunctions generic;
	
	@BeforeMethod
	public void befQuiz()
	{   generic=new GenericFunctions();
		logMod = new LoginModule(driver);
		onbMod = new OnboardingModule(driver);
		menuMod = new MenuModule(driver);
		signInMod = new SignInAsModule(driver);
		mobNumMod = new MobileNumberModule(driver);
		quiMod = new QuizModule(driver);
		selClaMod = new SelectClassModule(driver);
	}

	/**
	 * Verify Quiz on Android App
	 * @author Durga
	 * @since 2018-09-24
	 * @version 1.0
	 * @throws InterruptedException 
	 */
	@Test(dataProvider = "group0")
	public void verifyQuizTileDisplayed(String role) throws InterruptedException
	{
		logMod.Login(role, "CBSE", "6", "Single", "Prime", "Yes");
		
		generic.scrollBy(driver, 50, 95);
	
		if(role.equals("Parent") || role.equals("Student") || role.equals("Guest"))
			Assert.assertEquals(generic.isElementDisplayed(driver, quiMod.quizGamesTile), true);
		else
		Assert.assertEquals(generic.isElementDisplayed(driver, quiMod.quizGamesTile), false);
	}
	
}