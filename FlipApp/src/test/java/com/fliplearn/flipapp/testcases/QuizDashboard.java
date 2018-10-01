package com.fliplearn.flipapp.testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
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
	}

	/**
	 * Verify Quiz Dashboard Classes for Admin, Principal and Teacher on Web, Android and iOS
	 * @author Durga
	 * @since 2018-09-21
	 * @version 1.2
	 * @throws InterruptedException 
	 * @throws IOException 
	 */
	@Parameters({ "role" })
	@Test
	public void verifyQuizDashBoardClasses(String role) throws InterruptedException, IOException
	{
		logMod.Login(role);
		if(platform.equals("Web"))
			leaMod.learnImg.click();

		leaMod.learnImg.click();
		quiDasMod.quizDashBoardBtn.click();	
		GenericFunctions.waitForElementVisibility(driver, quiDasMod.classListBtn);
		quiDasMod.classListBtn.click();
		
		

		String expectedList = readData(platform, role, "Quiz Dashboard Classes");
    	Assert.assertEquals(GenericFunctions.compareList(quiDasMod.dashboardClassList, expectedList), true);		
	}
}