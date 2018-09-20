package com.fliplearn.flipapp.testcases;

import org.testng.annotations.Test;

import com.fliplearn.flipapp.helper.Base;
import com.fliplearn.flipapp.pagemodules.LoginModule;
import com.fliplearn.flipapp.pagemodules.OnboardingModule;

import io.appium.java_client.android.AndroidDriver;

public class UserRegistration extends Base 
{

	LoginModule logMod;
	OnboardingModule onbMod;

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
	 */
	@Test
	public void verifyAndroidAdminLogin()
	{
		logMod = new LoginModule(driver);
		onbMod = new OnboardingModule(driver);
		
		onbMod.skipScreen();
		logMod.Login("student");		
		((AndroidDriver) driver).hideKeyboard();
		logMod.loginBtn.click();
		
	}
}
