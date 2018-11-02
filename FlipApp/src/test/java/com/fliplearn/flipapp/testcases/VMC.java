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
import com.fliplearn.flipapp.pagemodules.SelectClassModule;
import com.fliplearn.flipapp.pagemodules.SelectSubjectModule;
import com.fliplearn.flipapp.pagemodules.SignInAsModule;
import com.fliplearn.flipapp.pagemodules.YourProfileModule;

public class VMC extends Base
	{
		LoginModule logMod;
		MobileNumberModule mobNumMod;
		MenuModule menMod;
		LearnModule leaMod;
		SignInAsModule signInMod;
		SelectClassModule selClaMod;
		SelectSubjectModule selSubMod;
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
		    selClaMod=	new SelectClassModule(driver);
		    selSubMod= new SelectSubjectModule(driver);   
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
		@Test(dataProvider = "group2")
		public void displayVMCSchool(String role) throws InterruptedException
		{			
			logMod.Login(role, "CBSE", "6", "Single", "Prime", "Yes");
			
			if(platform.equals("Web"))
				leaMod.clickOnLearnImage();
			
			assertEquals(generic.isElementDisplayed(driver, leaMod.vmcImg), true);
		}	
		
		@Test(dataProvider = "group3")
		public void displayVMCStudent(String role) throws InterruptedException
		{
			
			logMod.Login(role, "CBSE", "12", "Single", "None", "Yes");

			assertEquals(generic.isElementDisplayed(driver, leaMod.vmcImg), true);

//			if(role.equals("Student"))
//			{	
//				youProMod.updateClassAndSection(driver, "Class 12", "A");	
//				leaMod.clickOnLearnImage();
//				assertEquals(generic.isElementDisplayed(driver, leaMod.vmcImg), true);
//				youProMod.updateClassAndSection(driver, "Class 6", "A");	
//			}
			
		}

		@Test(dataProvider = "group3")
		public void doNotDisplayVMCStudent(String role) throws InterruptedException
		{
			logMod.Login(role, "CBSE", "6", "Single", "Prime", "Yes");
		    if(!role.equals("Guest"))
		    	leaMod.clickOnLearnImage();
			assertEquals(generic.isElementDisplayed(driver, leaMod.vmcImg), false);			
		}		
}
