package com.fliplearn.flipapp.testcases;

import org.testng.annotations.Test;

import com.fliplearn.flipapp.helper.Base;
import com.fliplearn.flipapp.helper.GenericFunctions;
import com.fliplearn.flipapp.pagemodules.LoginModule;
import com.fliplearn.flipapp.pagemodules.MobileNumberModule;
import com.fliplearn.flipapp.pagemodules.OnboardingModule;
import com.fliplearn.flipapp.pagemodules.QuizModule;

import io.appium.java_client.android.AndroidDriver;

public class UserRegistration extends Base 
{

	LoginModule logMod;
	OnboardingModule onbMod;
	MobileNumberModule mobNumMod;
	QuizModule quiMod;
	
	/**
	 * Verify User Admin Login on Desktop Browser
	 * @author Tarun Goswami
	 * @since 2018-09-20
	 * @version 1.0
	 */
	@Test
	public void verifyDesktopAdminLogin()
	{
		logMod = new LoginModule(driver);
		logMod.Login("admin");
		logMod.loginBtn.click();
	}
	
	/**
	 * Verify Admin User Login on Android App
	 * @author Tarun Goswami
	 * @since 2018-09-20
	 * @version 1.0
	 * @throws InterruptedException 
	 */
	@Test
	public void verifyAndroidAdminLogin() throws InterruptedException
	{
		logMod = new LoginModule(driver);
		onbMod = new OnboardingModule(driver);
		mobNumMod = new MobileNumberModule(driver);
		quiMod = new QuizModule(driver);
		
		onbMod.skipScreen();
		logMod.Login("student");		
		((AndroidDriver) driver).hideKeyboard();
		logMod.loginBtn.click();
		mobNumMod.skipBtn.click();
		quiMod.skipBtn.click();
		GenericFunctions.touchCordinates(driver, 10, 95);
		GenericFunctions.touchCordinates(driver, 10, 95);

	}
}
