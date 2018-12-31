package com.fliplearn.flipapp.testcases;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.fliplearn.flipapp.helper.Base;
import com.fliplearn.flipapp.helper.GenericFunctions;
import com.fliplearn.flipapp.pagemodules.HeaderModule;
import com.fliplearn.flipapp.pagemodules.LearnModule;
import com.fliplearn.flipapp.pagemodules.LoginModule;
import com.fliplearn.flipapp.pagemodules.MenuModule;
import com.fliplearn.flipapp.pagemodules.MobileNumberModule;
import com.fliplearn.flipapp.pagemodules.PrimeClassModule;
import com.fliplearn.flipapp.pagemodules.PrimeSubjectModule;
import com.fliplearn.flipapp.pagemodules.SignInAsModule;
import com.fliplearn.flipapp.pagemodules.YourProfileModule;

public class VMC extends Base
	{
		LoginModule logMod;
		MobileNumberModule mobNumMod;
		MenuModule menMod;
		LearnModule leaMod;
		SignInAsModule signInMod;
		PrimeClassModule selClaMod;
		PrimeSubjectModule selSubMod;
		GenericFunctions generic;
		YourProfileModule youProMod;
		HeaderModule heaMod;
		

		@BeforeMethod
		public void prePrime()
		{
			logMod = new LoginModule(driver);
			mobNumMod = new MobileNumberModule(driver);
			menMod = new MenuModule(driver);
			signInMod = new SignInAsModule(driver);
			leaMod = new LearnModule(driver);
		    selClaMod=	new PrimeClassModule(driver);
		    selSubMod= new PrimeSubjectModule(driver);   
		    generic=new GenericFunctions();
		    youProMod=new YourProfileModule(driver);
		    heaMod=new HeaderModule(driver);
		}
		
		/**
		 * Verify VMC Tile displayed for School Staff on Web, 
		 * @author Jagrati Mishra
		 * @since 2018-10-20
		 * @version 1.2
		 * @throws InterruptedException 
		 */
		@Test(dataProvider = "staff")
		public void displayVMCSchool(String role) throws InterruptedException
		{			
			logMod.Login(role, "CBSE", "6", "Single", "Prime", "Yes");
			
			if(platform.equals("Web"))
				leaMod.clickOnLearnImage();
			
			assertEquals(generic.isElementDisplayed(driver, leaMod.vmcImg), true);
		}	
		
		@Test(dataProvider = "nostaff")
		public void displayVMCStudent(String role) throws InterruptedException
		{
			
			logMod.Login(role, "CBSE", "12", "Single", "None", "Yes");
			assertEquals(generic.isElementDisplayed(driver, leaMod.vmcImg), true);
			
		}

		@Test(dataProvider = "nostaff")
		public void doNotDisplayVMCStudent(String role) throws InterruptedException
		{
			logMod.Login(role, "CBSE", "6", "Single", "Prime", "Yes");
		    if(!role.equals("Guest"))
		    	leaMod.clickOnLearnImage();
			assertEquals(generic.isElementDisplayed(driver, leaMod.vmcImg), false);			
		}		
}
