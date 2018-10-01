package com.fliplearn.flipapp.testcases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.fliplearn.flipapp.helper.Base;
import com.fliplearn.flipapp.pagemodules.LoginModule;
import com.fliplearn.flipapp.pagemodules.MobileNumberModule;
import com.fliplearn.flipapp.pagemodules.OnboardingModule;
import com.fliplearn.flipapp.pagemodules.QuizModule;

public class Login extends Base 
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
	 * Verify User User Login
	 * @author Vinay Yadav, Durga
	 * @since 2018-09-20
	 * @version 1.2
	 * @throws InterruptedException 
	 */
	@Parameters({ "role" })
	@Test
	public void verifyLogin(String role) throws InterruptedException
	{
		logMod.Login(role);
	}
}