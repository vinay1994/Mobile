package com.fliplearn.flipapp.testcases;

import org.testng.annotations.Test;

import com.fliplearn.flipapp.helper.Base;
import com.fliplearn.flipapp.helper.GenericFunctions;
import com.fliplearn.flipapp.pagemodules.LoginModule;
import com.fliplearn.flipapp.pagemodules.MenuModule;
import com.fliplearn.flipapp.pagemodules.MobileNumberModule;
import com.fliplearn.flipapp.pagemodules.OnboardingModule;
import com.fliplearn.flipapp.pagemodules.QuizModule;
import com.fliplearn.flipapp.pagemodules.SignInAsModule;

import io.appium.java_client.android.AndroidDriver;

public class Quiz extends Base 
{

	LoginModule logMod;
	OnboardingModule onbMod;
	MenuModule menuMod;
	MobileNumberModule mobNumMod;
	QuizModule quiMod;
	SignInAsModule signinmod;

	/**
	 * Verify Quiz on Android App
	 * @author Durga
	 * @since 2018-09-24
	 * @version 1.0
	 * @throws InterruptedException 
	 */
	@Test
	public void verifyAndroidQuiz() throws InterruptedException
	{
		logMod = new LoginModule(driver);
		onbMod = new OnboardingModule(driver);
		menuMod = new MenuModule(driver);
		
		onbMod.skipScreen();
		logMod.Login("admin");		
		((AndroidDriver) driver).hideKeyboard();
		logMod.loginBtn.click();
		Thread.sleep(6000);

		signinmod.adminLnk.click();
		
		mobNumMod.skipBtn.click();
		quiMod.skipBtn.click();
		GenericFunctions.touchCordinates(driver, 10, 95);
		GenericFunctions.touchCordinates(driver, 10, 95);
		menuMod.menuBtn.click();
		quiMod.quizgames.click();
		
		
	}
	
}