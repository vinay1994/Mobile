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
import com.fliplearn.flipapp.pagemodules.OnboardingModule;
import com.fliplearn.flipapp.pagemodules.SelectClassModule;
import com.fliplearn.flipapp.pagemodules.SignInAsModule;

public class FliplearnPrime extends Base{
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
	 * verify Primeclasses on web
	 * @author jagrati
	 * @since 2018-09-25
	 * @throws InterruptedException 
	 */
     @Test
     public void verifyPrimeAdminClasses() 
     {
    	 logMod.Login("admin");
    	 mobNumMod.skipBtn.click();
    	 signInMod.adminLnk.click();
    	 LearnMod.learn.click();
    	 LearnMod.primeImg.click();
        
    	 String expectedList = aConfig.getProperty("ADMIN_PRIME_CLASSES");
    	 Assert.assertEquals(GenericFunctions.compareList(selClaMod.classList, expectedList), true);

     }
}
