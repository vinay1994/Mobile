
	
     package com.fliplearn.flipapp.testcases;
	 import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
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
import com.fliplearn.flipapp.pagemodules.SubjectContentModule;
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
			SubjectContentModule subConMod;
			
			 /**
		 	 * verify PrimeVideo on Web, Android, iOS when User click on prime content
		 	 * @author Jagrati
		 	 * @since 2018-10-14
		 	 * @throws InterruptedException 
		 	 * @version 1.0
		 	 * @throws IOException 
		 	 */
			
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
			   subConMod=new SubjectContentModule(driver);
			
			}
		  
		 
	           @Test(dataProvider ="group2")
	           public void verifySubjectContent(String role) throws IOException, InterruptedException
	           {
	       			logMod.Login(role, "Single", "None", "Yes");
	        		leaMod.clickOnLearnImage();
	        		leaMod.clickOnPrimeImage();
	        		
	        		Actions actions = new Actions(driver);
	        		actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
	        		
	        		subConMod.clickOnClassContent();
	        		subConMod.clickOnSubjectContent();
	        		subConMod.clickOnBookContent();
	        		subConMod.clickOnBookTopicContent();
	        		subConMod.clickOnVideoContentandverifyJWPlayer(driver);
	       		}
	           
	           /**
			 	 * verify PrimeVideo on Web, Android, iOS when User click on prime content
			 	 * @author Jagrati
			 	 * @since 2018-10-14
			 	 * @throws InterruptedException 
			 	 * @version 1.0
			 	 * @throws IOException 
			 	 */
	          
	           
	 }

	


	


