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
		logMod.Login("admin");		
		((AndroidDriver) driver).hideKeyboard();
		logMod.loginBtn.click();
		
	}
	
	/**
	 * Verify User Principal Login on Desktop Browser
	 * @author Durga
	 * @since 2018-09-21
	 * @version 1.0
	 */
	@Test
	public void verifyDesktopPrincipalLogin()
	{
		logMod = new LoginModule(driver);
		logMod.Login("principal");
		logMod.loginBtn.click();
	}
	
	/**
	 * Verify Principal User Login on Android App
	 * @author Durga
	 * @since 2018-09-21
	 * @version 1.0
	 */
	@Test
	public void verifyAndroidPrincipalLogin()
	{
		logMod = new LoginModule(driver);
		onbMod = new OnboardingModule(driver);
		
		onbMod.skipScreen();
		logMod.Login("principal");		
		((AndroidDriver) driver).hideKeyboard();
		logMod.loginBtn.click();
		
	}
	
	
	/**
	 * Verify User Teacher Login on Desktop Browser
	 * @author Durga
	 * @since 2018-09-21
	 * @version 1.0
	 */
	@Test
	public void verifyDesktopTeacherLogin()
	{
		logMod = new LoginModule(driver);
		logMod.Login("teacher");
		logMod.loginBtn.click();
	}
	
	/**
	 * Verify Teacher User Login on Android App
	 * @author Durga
	 * @since 2018-09-21
	 * @version 1.0
	 */
	@Test
	public void verifyAndroidTeacherLogin()
	{
		logMod = new LoginModule(driver);
		onbMod = new OnboardingModule(driver);
		
		onbMod.skipScreen();
		logMod.Login("teacher");		
		((AndroidDriver) driver).hideKeyboard();
		logMod.loginBtn.click();
		
	}	
	
	
	/**
	 * Verify User Parent Login on Desktop Browser
	 * @author Durga
	 * @since 2018-09-21
	 * @version 1.0
	 */
	@Test
	public void verifyDesktopParentLogin()
	{
		logMod = new LoginModule(driver);
		logMod.Login("parent");
		logMod.loginBtn.click();
	}
	
	/**
	 * Verify Parent User Login on Android App
	 * @author Durga
	 * @since 2018-09-21
	 * @version 1.0
	 */
	@Test
	public void verifyAndroidParentLogin()
	{
		logMod = new LoginModule(driver);
		onbMod = new OnboardingModule(driver);
		
		onbMod.skipScreen();
		logMod.Login("parent");		
		((AndroidDriver) driver).hideKeyboard();
		logMod.loginBtn.click();
		
	}

	
	
	/**
	 * Verify User Student Login on Desktop Browser
	 * @author Durga
	 * @since 2018-09-21
	 * @version 1.0
	 */
	@Test
	public void verifyDesktopStudentLogin()
	{
		logMod = new LoginModule(driver);
		logMod.Login("student");
		logMod.loginBtn.click();
	}
	
	/**
	 * Verify Student User Login on Android App
	 * @author Durga
	 * @since 2018-09-21
	 * @version 1.0
	 * @throws InterruptedException 
	 */
	@Test
	public void verifyAndroidStudentLogin() throws InterruptedException
	{
		logMod = new LoginModule(driver);
		onbMod = new OnboardingModule(driver);
		
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
