package com.fliplearn.flipapp.testcases;

import org.testng.annotations.Test;

import com.fliplearn.flipapp.helper.Base;
import com.fliplearn.flipapp.pagemodules.LoginModule;
import com.fliplearn.flipapp.pagemodules.MenuModule;
import com.fliplearn.flipapp.pagemodules.OnboardingModule;

import io.appium.java_client.android.AndroidDriver;

public class Quiz extends Base 
{

	LoginModule logMod;
	OnboardingModule onbMod;
	MenuModule menuMod;

	/**
	 * Verify Quiz on Android App
	 * @author Durga
	 * @since 2018-09-21
	 * @version 1.0
	 */
	@Test
	public void verifyAndroidQuiz()
	{
		logMod = new LoginModule(driver);
		onbMod = new OnboardingModule(driver);
		menuMod = new MenuModule(driver);
		
		onbMod.skipScreen();
		logMod.Login("admin");		
		((AndroidDriver) driver).hideKeyboard();
		menuMod.menuBtn.click();
		
	}
	
}