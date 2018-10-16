package com.fliplearn.flipapp.testcases;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
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

public class FliplearnPrimeView extends Base
{
	LoginModule logMod;
	MobileNumberModule mobNumMod;
	MenuModule menuMod;
	LearnModule LearnMod;
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
		menuMod = new MenuModule(driver);
		signInMod = new SignInAsModule(driver);
		LearnMod = new LearnModule(driver);
	    selClaMod=	new SelectClassModule(driver);
	    selSubMod= new SelectSubjectModule(driver);   
	    generic=new GenericFunctions();
	    youProMod = new YourProfileModule(driver);
	    heaMod = new HeaderModule(driver);
	}
	
	
	/**
	 * verify Prime classes on Web, Android, iOS when User click on fliplearn prime tile on learn page
	 * @author Jagrati
	 * @since 2018-09-25
	 * @throws InterruptedException 
	 * @version 1.3
	 * @throws IOException 
	 */
	 @Test( priority=1,dataProvider = "group2")
     public void verifyPrimeClasses(String role) throws IOException, InterruptedException 
     {
    	 logMod.Login(role);
    	 
    	 if(platform.equals("Web"))
    		 LearnMod.clickOnLearnImage();
    	 
    	 LearnMod.clickOnPrimeImage();
 
    	 String expectedList = readData(platform, role, "Prime Classes");

    	 Assert.assertEquals(generic.compareList(selClaMod.classLst, expectedList), true);

     }
    
     
     /**
 	 * verify Prime classes on Web, Android, iOS when User click on fliplearn prime tile on learn page
 	 * @author Jagrati
 	 * @since 2018-10-05
 	 * @throws InterruptedException 
 	 * @version 1.0
 	 * @throws IOException 
 	 */
 	 
	@Test(priority=2,dataProvider ="group1")
	public void verifyPrimeSubjects(String role) throws IOException, InterruptedException  
	{ 
		logMod.Login(role);
		
		 if(platform.equals("Web"))
    		 LearnMod.clickOnLearnImage();
    	 
    	LearnMod.clickOnPrimeImage();
		String expectedList = readData(platform, role, "Prime Subjects");
		
		if(role.equals("Parent") || role.equals("Student"))
		{
			if(role.equals("Student"))
			{	
				youProMod.updateClassAndSection(driver, "Class 6", "A");
				heaMod.clickonHomeBtn();	
			}

	    	Assert.assertEquals(generic.compareList(selSubMod.studentSubjectList, expectedList), true);
		}
		
		else
		{
			LearnMod.clickOnSubjectLink();
			Assert.assertEquals(generic.compareList(selSubMod.subjectList, expectedList), true);
		}
     }
	 
	
	 
 }