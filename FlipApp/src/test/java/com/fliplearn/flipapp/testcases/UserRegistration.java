package com.fliplearn.flipapp.testcases;

import org.testng.annotations.BeforeMethod;
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
	
	@BeforeMethod
	public void befMethod()
	{
		logMod = new LoginModule(driver);
		onbMod = new OnboardingModule(driver);
		mobNumMod = new MobileNumberModule(driver);
		quiMod = new QuizModule(driver);
	}
	
	/**
	 * Verify User Admin Login on Desktop Web Browser
	 * @author Tarun Goswami
	 * @since 2018-09-20
	 * @version 1.0
	 */
	@Test
	public void verifyWebAdminLogin()
	{
		logMod.Login("admin");
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
		logMod.Login("admin");			
	}
	
	/**
	 * Verify User Principal Login on Desktop Web Browser
	 * @author Durga
	 * @since 2018-09-21
	 * @version 1.0
	 */
	@Test
	public void verifyWebPrincipalLogin()
	{
		logMod.Login("principal");
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
		logMod.Login("principal");		
	}
	
	
	/**
	 * Verify User Teacher Login on Desktop Web Browser
	 * @author Durga
	 * @since 2018-09-21
	 * @version 1.0
	 */
	@Test
	public void verifyWebTeacherLogin()
	{
		logMod.Login("teacher");
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
		logMod.Login("teacher");
	}	
	
	
	/**
	 * Verify User Parent Login on Desktop Web Browser
	 * @author Durga
	 * @since 2018-09-21
	 * @version 1.0
	 */
	@Test
	public void verifyWebParentLogin()
	{
		logMod.Login("parent");
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
		logMod.Login("parent");		
	}

	/**
	 * Verify User Student Login on Desktop Web Browser
	 * @author Durga
	 * @since 2018-09-21
	 * @version 1.0
	 */
	@Test
	public void verifyWebStudentLogin()
	{
		logMod.Login("student");
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
		
		logMod.Login("student");		
//		mobNumMod.skipBtn.click();
//		quiMod.skipBtn.click();
//		GenericFunctions.touchCordinates(driver, 10, 95);
//		GenericFunctions.touchCordinates(driver, 10, 95);
	}
}