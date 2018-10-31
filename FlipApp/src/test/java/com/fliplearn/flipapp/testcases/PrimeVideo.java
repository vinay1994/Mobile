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
import com.fliplearn.flipapp.pagemodules.VideoContentModule;
import com.fliplearn.flipapp.pagemodules.YourProfileModule;

public class PrimeVideo extends Base
{
	LoginModule logMod;
	MobileNumberModule mobNumMod;
	MenuModule menMod;
	LearnModule leaMod;
	SignInAsModule signInMod;
	SelectClassModule selClaMod;
	SelectSubjectModule selSubMod;
	SubjectContentModule subConMod;
	GenericFunctions generic;
	YourProfileModule youProMod;
	HeaderModule heaMod;
	VideoContentModule vidConMod;

			
	/**
	* verify PrimeVideo on Web, Android, iOS when User click on prime content
	* @author Jagrati
	* @since 2018-10-14
	* @throws InterruptedException 
	* @version 1.0
	* @throws IOException 
	*/
			
	@BeforeMethod
	public void prePrimeVideo()
	{
		generic = new GenericFunctions();
		logMod = new LoginModule(driver);
		mobNumMod = new MobileNumberModule(driver);
		menMod = new MenuModule(driver);
		signInMod = new SignInAsModule(driver);
		leaMod = new LearnModule(driver);
		selClaMod =	new SelectClassModule(driver);
		selSubMod = new SelectSubjectModule(driver);
		subConMod = new SubjectContentModule(driver);
		youProMod = new YourProfileModule(driver);
		heaMod = new HeaderModule(driver);
		vidConMod = new VideoContentModule(driver);
	}
		  
	/**
	* verify PrimeVideo on Web, Android, iOS when Admin, Principal, Teacher click on Video Content
	* @author Jagrati
	* @since 2018-10-14
	* @throws InterruptedException 
	* @version 1.1
	* @throws IOException 
	*/

	@Test(dataProvider ="group2")
	public void playPrimeVideoSchool(String role) throws IOException, InterruptedException
	{
		logMod.Login(role, "Single", "None", "Yes");
	    leaMod.clickOnLearnImage();
	    leaMod.clickOnPrimeImage();
	        		
	    Thread.sleep(3000);

	    selClaMod.clickOnClassContent(driver, "Class 10");
	    selSubMod.clickOnSubject(driver, role, "Biology");
	    subConMod.clickOnBookContent();
	    subConMod.clickOnBookTopicContent();
	    vidConMod.clickOnVideoContent(driver, "Digestion");
	    vidConMod.clickOnVideoContentandverJWPlayer(driver);
	}
	
	/**
	* verify PrimeVideo on Web, Android, iOS when Parent, Student click on Video Content
	* @author Jagrati
	* @since 2018-10-14
	* @throws InterruptedException 
	* @version 1.1
	* @throws IOException 
	*/
	@Test(dataProvider ="group3")
	public void playPrimeVideoStudent(String role) throws IOException, InterruptedException
	{
		logMod.Login(role, "Single", "None", "Yes");
	    leaMod.clickOnLearnImage();
	    leaMod.clickOnPrimeImage();
	        		
	    selSubMod.clickOnSubject(driver, role, "English");
	    vidConMod.clickOnVideoContent(driver, "Countable and Uncountable Nouns");
	    vidConMod.clickOnVideoContentandverJWPlayer(driver);
	}
}