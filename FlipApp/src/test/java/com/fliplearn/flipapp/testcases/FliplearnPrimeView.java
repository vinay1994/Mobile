package com.fliplearn.flipapp.testcases;

import java.io.IOException;
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
import com.fliplearn.flipapp.pagemodules.SelectClassModule;
import com.fliplearn.flipapp.pagemodules.SignInAsModule;

public class FliplearnPrimeView extends Base
{
	LoginModule logMod;
	MobileNumberModule mobNumMod;
	MenuModule menuMod;
	LearnModule LearnMod;
	SignInAsModule signInMod;
	SelectClassModule selClaMod;

	@BeforeMethod
	public void prePrime()
	{
		logMod = new LoginModule(driver);
		mobNumMod = new MobileNumberModule(driver);
		menuMod = new MenuModule(driver);
		signInMod = new SignInAsModule(driver);
		LearnMod = new LearnModule(driver);
	    selClaMod=	new SelectClassModule(driver);
	}
	
	/**
	 * verify Prime classes on Web, Android, iOS when User click on fliplearn prime tile on learn page
	 * @author Jagrati
	 * @since 2018-09-25
	 * @throws InterruptedException 
	 * @version 1.3
	 * @throws IOException 
	 */
	 @Parameters({ "platform", "role" })
     @Test
     public void verifyPrimeClasses(String platform, String role) throws IOException, InterruptedException 
     {
    	 logMod.Login(role);
    	 
    	 if(platform.equals("Web"))
    		 LearnMod.learnImg.click();
    	 LearnMod.primeImg.click();
 
    	 String expectedList = readData(platform, role, "Prime Classes");
    	 Assert.assertEquals(GenericFunctions.compareList(selClaMod.classList, expectedList), true);
     }
 }