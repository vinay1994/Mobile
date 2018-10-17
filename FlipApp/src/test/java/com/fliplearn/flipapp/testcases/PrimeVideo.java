
	
     package com.fliplearn.flipapp.testcases;
	 import java.io.IOException;
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
	 public class PrimeVideo extends Base{
		
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
			public void preSubjectContent()
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
	           @Test
	           public void verifySubjectContent(String role) throws IOException, InterruptedException
	           {
	        		logMod.Login(role);
	        		leaMod.clickOnLearnImage();
	        		leaMod.clickOnPrimeImage();
	        		
	       		String expectedList = readData(platform, role, "Prime Subjects");
	 
	        	   
	           }}

	


	


