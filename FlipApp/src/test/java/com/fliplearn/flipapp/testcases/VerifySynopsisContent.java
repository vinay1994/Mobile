
package com.fliplearn.flipapp.testcases;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
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
import com.fliplearn.flipapp.pagemodules.VerifySynopsisModule;
import com.fliplearn.flipapp.pagemodules.VideoContentModule;
import com.fliplearn.flipapp.pagemodules.YourProfileModule;

public class VerifySynopsisContent extends Base{
	
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
	VideoContentModule vidConMod;
	VerifySynopsisModule verSynMod;
	
	  @BeforeMethod
		public void preVerifySynopsis()
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
		    verSynMod=new VerifySynopsisModule();
		
		
		}
	  
	  @Test(dataProvider="group2")
	  public void verifyRealLifeApp(String role) throws InterruptedException {
		 
			logMod.Login(role, "Single", "None", "Yes");
	        leaMod.clickOnLearnImage();
	        leaMod.clickOnPrimeImage();
	        Thread.sleep(2000);
	        
	    	Actions actions = new Actions(driver);
	    	actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
	    	Thread.sleep(3000);
    		verSynMod.clickOnClass();
    		Thread.sleep(2000);
    		verSynMod.clickOnSubject();
	        verSynMod.clickOnConTopic();
	        Thread.sleep(2000);
	        Assert.assertEquals(generic.isElementDisplayed(driver, verSynMod.verifyRealLife), true);
	        Thread.sleep(2000);
	        verSynMod.closeRealLifeSyn();
	        Thread.sleep(2000);
	        
	        
      } 
	  
		
		  
		  
		  
	  }
	
	
	
	
	


	

}

