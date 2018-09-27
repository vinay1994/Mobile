package com.fliplearn.flipapp.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
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
	 * verify Prime classes on web when admin click on fliplearn prime tile on learn page
	 * @author Jagrati
	 * @since 2018-09-25
	 * @throws InterruptedException 
	 * @version 1.1
	 */
     @Test
     public void verifyPrimeAdminClasses() 
     {
    	 logMod.Login("admin");
    	 mobNumMod.skipBtn.click();
    	 signInMod.adminLnk.click();
    	 LearnMod.learnImg.click();
    	 LearnMod.primeImg.click();
        
    	 String expectedList = aConfig.getProperty("ADMIN_PRIME_CLASSES");
    	 Assert.assertEquals(GenericFunctions.compareList(selClaMod.classList, expectedList), true);
     }
}