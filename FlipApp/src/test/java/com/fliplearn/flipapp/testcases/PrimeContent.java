package com.fliplearn.flipapp.testcases;

import java.io.IOException;
import org.testng.Assert;
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

public class PrimeContent extends Base
{
	LoginModule logMod;
	MobileNumberModule mobNumMod;
	MenuModule menMod;
	LearnModule leaMod;
	SignInAsModule signInMod;
	PrimeClassModule selClaMod;
	PrimeSubjectModule selSubMod;
	GenericFunctions generic;
	HeaderModule heaMod;
	
	@BeforeMethod
	public void prePrime()
	{
	    generic = new GenericFunctions();
		logMod = new LoginModule(driver);
		mobNumMod = new MobileNumberModule(driver);
		menMod = new MenuModule(driver);
		signInMod = new SignInAsModule(driver);
		leaMod = new LearnModule(driver);
	    selClaMod=	new PrimeClassModule(driver);
	    selSubMod= new PrimeSubjectModule(driver);   
	    heaMod = new HeaderModule(driver);
	}

	/**
	 * verify Prime Tile displayed on Web, Android
	 * @author Jagrati Mishra
	 * @since 2018-10-20
	 * @throws InterruptedException 
	 * @version 1.1
	 * @throws IOException 
	 */
     @Test(dataProvider = "group0")
     public void verifyPrimeTileDisplayed(String role) throws IOException, InterruptedException 
     {
		 logMod.Login(role, "CBSE", "6", "Single", "Prime", "Yes");
    	 
    	 if(platform.equals("Web"))
    	 {	 
    		 if(!role.equals("Guest"))
    			 leaMod.clickOnLearnImage();
    	 }
    	 Assert.assertEquals(generic.isElementDisplayed(driver, leaMod.primeImg), true);
     }
    
	/**
	 * verify Prime classes on Web, Android, iOS when User click on fliplearn prime tile on learn page
	 * @author Jagrati Mishra
	 * @since 2018-09-25
	 * @throws InterruptedException 
	 * @version 1.3
	 * @throws IOException 
	 */
	 @Test( priority=1,dataProvider = "group2")
     public void verifyPrimeClasses(String role) throws IOException, InterruptedException 
     {
		 logMod.Login(role, "CBSE", "6", "Single", "Prime", "Yes");
    	   	 
    	 if(platform.equals("Web"))
    		 leaMod.clickOnLearnImage();
    	 
    	 leaMod.clickOnPrimeImage();
 
    	 String expectedList = readData(platform, role, "Prime Classes");

    	 Assert.assertEquals(generic.compareList(selClaMod.classLst, expectedList), true);
     }
    
     
     /**
 	 * verify Prime classes on Web, Android, iOS when User click on fliplearn prime tile on learn page
 	 * @author Jagrati
 	 * @since 2018-10-05
 	 * @throws InterruptedException 
 	 * @version 1.1
 	 * @throws IOException 
 	 */
 	 
	@Test(priority=2,dataProvider ="group0")
	public void verifyPrimeSubjects(String role) throws IOException, InterruptedException  
	{ 
		logMod.Login(role, "CBSE", "6", "Single", "Prime", "Yes");
    	 
    	 if(platform.equals("Web"))
    	 {	 
    		 if(!role.equals("Guest"))
    			 leaMod.clickOnLearnImage();
    	 }
		
    	 String expectedList = readData(platform, role, "Prime Subjects");
	 
		 leaMod.clickOnPrimeImage();			

		if(role.equals("Parent") || role.equals("Student") || role.equals("Guest"))
		{	
	    	Assert.assertEquals(generic.compareList(selSubMod.studentSubjectList, expectedList), true);
		}
		else
		{
		   leaMod.clickOnSubjectLink();
	    	Assert.assertEquals(generic.compareList(selSubMod.subjectList, expectedList), true);
		}
     }
 }