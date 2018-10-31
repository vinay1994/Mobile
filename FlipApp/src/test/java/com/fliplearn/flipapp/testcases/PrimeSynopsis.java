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
import com.fliplearn.flipapp.pagemodules.SelectClassModule;
import com.fliplearn.flipapp.pagemodules.SelectSubjectModule;
import com.fliplearn.flipapp.pagemodules.SignInAsModule;
import com.fliplearn.flipapp.pagemodules.SubjectContentModule;
import com.fliplearn.flipapp.pagemodules.SynopsisModule;
import com.fliplearn.flipapp.pagemodules.VideoContentModule;
import com.fliplearn.flipapp.pagemodules.YourProfileModule;

public class PrimeSynopsis extends Base
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
	VideoContentModule vidConMod;
	SynopsisModule synMod;
	SubjectContentModule subConMod;
	
	@BeforeMethod
	public void preVerifySynopsis()
	{
		generic = new GenericFunctions();
		logMod = new LoginModule(driver);
		mobNumMod = new MobileNumberModule(driver);
		menMod = new MenuModule(driver);
		vidConMod = new VideoContentModule(driver);
		signInMod = new SignInAsModule(driver);
		leaMod = new LearnModule(driver);
		selClaMod =	new SelectClassModule(driver);
		selSubMod = new SelectSubjectModule(driver);  
		subConMod = new SubjectContentModule(driver);
		youProMod=new YourProfileModule(driver);
		heaMod=new HeaderModule(driver);
		synMod=new SynopsisModule(driver);
	}
	
	/**
	* verify Real Life Cotent on Web, Android, iOS for Admin, Principal, Teacher
	* @author Jagrati
	* @since 2018-10-14
	* @throws InterruptedException 
	* @version 1.1
	* @throws IOException 
	*/
	@Test(dataProvider="group2")
	public void verifyRealLifeSchool(String role) throws InterruptedException
	{
		logMod.Login(role, "Single", "None", "Yes");
		leaMod.clickOnLearnImage();
		leaMod.clickOnPrimeImage();
		        		
		Thread.sleep(3000);
		selClaMod.clickOnClassContent(driver, "Class 10");
		selSubMod.clickOnSubject(driver, role, "Biology");
		subConMod.clickOnBookContent();
		subConMod.clickOnBookTopicContent();
		Thread.sleep(2000);
		subConMod.clickOnRealLife();
		Thread.sleep(3000);
		
	    Assert.assertEquals(synMod.synopsisHeading.getText(), "Nutrition in Human Being");
	}
	
	/**
	* verify Real Life Cotent on Web, Android, iOS for Parent, Student
	* @author Jagrati
	* @since 2018-10-14
	* @throws InterruptedException 
	* @version 1.1
	* @throws IOException 
	*/
	@Test(dataProvider="group3")
	public void verifyRealLifeStudent(String role) throws InterruptedException
	{
		logMod.Login(role, "Single", "None", "Yes");
		leaMod.clickOnLearnImage();
		leaMod.clickOnPrimeImage();
		        		
		Thread.sleep(3000);

		selSubMod.clickOnSubject(driver, role, "English");

		Thread.sleep(2000);
		subConMod.clickOnViewAllSample(driver);
		  
		subConMod.clickOnRealLife();
		Thread.sleep(3000);
	    Assert.assertEquals(synMod.synopsisHeadingStudent.getText(), "Past: Simple Usage");
	} 
	
	/**
	* verify Topic Synopsis on Web, Android, iOS for Admin, Principal, Teacher
	* @author Jagrati
	* @since 2018-10-14
	* @throws InterruptedException 
	* @version 1.1
	* @throws IOException 
	*/
	@Test(dataProvider="group2")
	public void verifyTopicSynopsisSchool(String role) throws InterruptedException
	{
		logMod.Login(role, "Single", "None", "Yes");
		leaMod.clickOnLearnImage();
		leaMod.clickOnPrimeImage();
		        		
		Thread.sleep(3000);
		selClaMod.clickOnClassContent(driver, "Class 10");
		selSubMod.clickOnSubject(driver, role, "Biology");
		subConMod.clickOnBookContent();
		subConMod.clickOnBookTopicContent();
		Thread.sleep(2000);
		subConMod.clickOnTopicSynopsis();
		Thread.sleep(3000);
		
	    Assert.assertEquals(synMod.synopsisHeading.getText(), "Nutrition In Human Being");
	}
	
	/**
	* verify Topic Synopsis on Web, Android, iOS for Parent, Student
	* @author Jagrati
	* @since 2018-10-14
	* @throws InterruptedException 
	* @version 1.1
	* @throws IOException 
	*/
	@Test(dataProvider="group3")
	public void verifyTopicSynopsisStudent(String role) throws InterruptedException
	{
		  logMod.Login(role, "Single", "None", "Yes");
		  leaMod.clickOnLearnImage();
		  leaMod.clickOnPrimeImage();
		        		
		 Thread.sleep(3000);

		  selSubMod.clickOnSubject(driver, role, "English");

		  Thread.sleep(2000);
		  subConMod.clickOnViewAllSample(driver);
		  
		  subConMod.clickOnTopicSynopsis();
		  Thread.sleep(3000);

	      Assert.assertEquals(synMod.synopsisHeadingStudent.getText(), "Past: Simple Usage");
	} 
	
	/**
	* verify Mind Maps on Web, Android, iOS for Admin, Principal, Teacher
	* @author Jagrati
	* @since 2018-10-14
	* @throws InterruptedException 
	* @version 1.1
	* @throws IOException 
	*/
	@Test(dataProvider="group2")
	public void verifyMindMapsSchool(String role) throws InterruptedException
	{
		logMod.Login(role, "Single", "None", "Yes");
		leaMod.clickOnLearnImage();
		leaMod.clickOnPrimeImage();
		        		
		Thread.sleep(3000);
		selClaMod.clickOnClassContent(driver, "Class 10");
		selSubMod.clickOnSubject(driver, role, "Biology");
		subConMod.clickOnBookContent();
		subConMod.clickOnBookTopicContent();
		Thread.sleep(2000);
		subConMod.clickOnTopicSynopsis();
		Thread.sleep(3000);
		
	    Assert.assertEquals(synMod.synopsisHeading.getText(), "Nutrition In Human Being");
	}
	
	/**
	* verify Mind Maps on Web, Android, iOS for Parent, Student
	* @author Jagrati
	* @since 2018-10-14
	* @throws InterruptedException 
	* @version 1.1
	* @throws IOException 
	*/
	@Test(dataProvider="group3")
	public void verifyMindMapsStudent(String role) throws InterruptedException
	{
		  logMod.Login(role, "Single", "None", "Yes");
		  leaMod.clickOnLearnImage();
		  leaMod.clickOnPrimeImage();
		        		
		 Thread.sleep(3000);

		  selSubMod.clickOnSubject(driver, role, "English");

		  Thread.sleep(2000);
		  subConMod.clickOnViewAllSample(driver);
		  
		  subConMod.clickOnMindMaps();
		  Thread.sleep(3000);

	      Assert.assertEquals(synMod.synopsisHeadingStudent.getText(), "Past- simple usage");
	} 
}
