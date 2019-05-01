package com.fliplearn.flipapp.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.fliplearn.flipapp.helper.Base;
import com.fliplearn.flipapp.helper.GenericFunctions;
import com.fliplearn.flipapp.pagemodules.HeaderModule;
import com.fliplearn.flipapp.pagemodules.LoginModule;
import com.fliplearn.flipapp.pagemodules.MenuModule;
import com.fliplearn.flipapp.pagemodules.MobileNumberModule;
import com.fliplearn.flipapp.pagemodules.OnboardingModule;
import com.fliplearn.flipapp.pagemodules.QuizModule;
import com.fliplearn.flipapp.pagemodules.PrimeClassModule;
import com.fliplearn.flipapp.pagemodules.QuizDashBoardModule;
import com.fliplearn.flipapp.pagemodules.SignInAsModule;


public class QuizGames extends Base 
{
	LoginModule logMod;
	HeaderModule heaMod;
	OnboardingModule onbMod;
	MenuModule menuMod;
	MobileNumberModule mobNumMod;
	QuizModule quiMod;
	QuizDashBoardModule quiDasMod;
	SignInAsModule signInMod;
	PrimeClassModule selClaMod;
	GenericFunctions generic;
	
	@BeforeMethod
	public void befQuiz()
	{   generic= new GenericFunctions();
		heaMod = new HeaderModule(driver);
		logMod = new LoginModule(driver);
		onbMod = new OnboardingModule(driver);
		menuMod = new MenuModule(driver);
		signInMod = new SignInAsModule(driver);
		mobNumMod = new MobileNumberModule(driver);
		quiMod = new QuizModule(driver);
		selClaMod = new PrimeClassModule(driver);
		quiDasMod = new QuizDashBoardModule(driver);
	}

	/**
	 * Verify Quiz on Android App
	 * @author Durga
	 * @since 2018-09-24
	 * @version 1.0
	 * @throws InterruptedException 
	 * @throws IOException 
	 */
	@Test(dataProvider = "allusers")
	public void verifyQuizGamesMenu(String role) throws InterruptedException, IOException
	{
		logMod.Login(role, "CBSE", "6", "Single", "Prime", "Yes");
		
		heaMod.clickOnQuizGamesMnu();
			
		if(role.equals("Parent") || role.equals("Student") || role.equals("Guest"))
			Assert.assertEquals(generic.isElementDisplayed(driver, quiMod.firstSplashNinjaImg), true);
		else
		Assert.assertEquals(generic.isElementDisplayed(driver, quiDasMod.playQuizBtn), true);
	}
	
}