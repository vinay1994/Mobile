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
import com.fliplearn.flipapp.pagemodules.PrimeChapterTopicModule;
import com.fliplearn.flipapp.pagemodules.PrimeClassModule;
import com.fliplearn.flipapp.pagemodules.PrimeSubjectModule;
import com.fliplearn.flipapp.pagemodules.SignInAsModule;
import com.fliplearn.flipapp.pagemodules.PrimeResourceListModule;
import com.fliplearn.flipapp.pagemodules.PrimeResourceViewModule;
import com.fliplearn.flipapp.pagemodules.YourProfileModule;

public class PrimeResources extends Base
{	
	GenericFunctions generic;
	LoginModule logMod;
	MobileNumberModule mobNumMod;
	MenuModule menMod;
	LearnModule leaMod;
	SignInAsModule signInMod;
	PrimeClassModule oriClaMod;
	PrimeSubjectModule priSubMod;
	PrimeChapterTopicModule priChaTopMod;
	YourProfileModule youProMod;
	HeaderModule heaMod;
	PrimeResourceViewModule priResVieMod;
	PrimeResourceListModule priResLisMod;
	
	@BeforeMethod
	public void preVerifySynopsis()
	{
		generic = new GenericFunctions();
		logMod = new LoginModule(driver);
		mobNumMod = new MobileNumberModule(driver);
		menMod = new MenuModule(driver);
		priResVieMod = new PrimeResourceViewModule(driver);
		signInMod = new SignInAsModule(driver);
		leaMod = new LearnModule(driver);
		oriClaMod =	new PrimeClassModule(driver);
		priSubMod = new PrimeSubjectModule(driver);  
		priResLisMod = new PrimeResourceListModule(driver);
		priChaTopMod = new PrimeChapterTopicModule(driver);
		youProMod=new YourProfileModule(driver);
		heaMod=new HeaderModule(driver);
	}
	
	/**
	* verify PrimeVideo on Web, Android, iOS when Admin, Principal, Teacher click on Video Content
	* @author Jagrati
	* @since 2018-10-14
	* @throws InterruptedException 
	* @version 1.2
	* @throws IOException 
	*/

	@Test(dataProvider ="group2")
	public void playPrimeVideoSchool(String role) throws IOException, InterruptedException
	{
		logMod.Login(role, "CBSE", "6", "Single", "Prime", "Yes");
	    leaMod.clickOnLearnImage();
	    leaMod.clickOnPrimeImage();
	        		
	    Thread.sleep(3000);

	    oriClaMod.clickOnClassContent(driver, "Class 10");
	    priSubMod.clickOnSubject(driver, role, "Biology");
	    priResLisMod.clickOnBookChapter(driver, role, "1. Life Processes");
	    priResLisMod.clickOnBookTopicContent(driver, role, "Nutrition in Human Beings");
	    priResVieMod.clickOnVideoContent(driver, "Digestion");
	    priResVieMod.clickOnVideoContentandverJWPlayer(driver);
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
		logMod.Login(role, "CBSE", "6", "Single", "Prime", "Yes");
	    
		if(!role.equals("Guest"))
	    	leaMod.clickOnLearnImage();
	    
		leaMod.clickOnPrimeImage();
	        		
	    priSubMod.clickOnSubject(driver, role, "Social Studies");
	    Thread.sleep(2000);
	    priResLisMod.clickOnBookChapter(driver, role, "1. What, Where, How and When");
	  
	    
	    priResLisMod.clickOnBookTopicContent(driver, role, "Where did people live and origin of the word India?");
	    
	    if(role.equals("Parent"))
	    {	
	    	Thread.sleep(3000);
	    	Assert.assertEquals(priResLisMod.childAccessMsg.getText(), "Please access the content from your child's account.");
	    }
	    if(!role.equals("Parent"))
	    {	
	    	priResVieMod.clickOnVideoContent(driver, "Introduction to Indian History");
	    	priResVieMod.clickOnVideoContentandverJWPlayer(driver);
	    }	
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
		logMod.Login(role, "CBSE", "6", "Single", "Prime", "Yes");
		leaMod.clickOnLearnImage();
		leaMod.clickOnPrimeImage();
		        		
		Thread.sleep(3000);
		oriClaMod.clickOnClassContent(driver, "Class 10");
		priSubMod.clickOnSubject(driver, role, "Biology");
		priResLisMod.clickOnBookChapter(driver, role, "1. Life Processes");
		priResLisMod.clickOnBookTopicContent(driver, role, "Nutrition in Human Beings");
		Thread.sleep(2000);
		priResLisMod.clickOnTopicSynopsis();
		Thread.sleep(3000);
		
	    Assert.assertEquals(priResVieMod.synopsisHeading.getText(), "Nutrition In Human Being");
	
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
		logMod.Login(role, "CBSE", "6", "Single", "Prime", "Yes");
		
		if(!role.equals("Guest"))
	    	leaMod.clickOnLearnImage();

		leaMod.clickOnPrimeImage();
		        		
		Thread.sleep(3000);

		priSubMod.clickOnSubject(driver, role, "Social Studies");
		Thread.sleep(2000);
		priResLisMod.clickOnBookChapter(driver, role, "1. What, Where, How and When");
		
		priResLisMod.clickOnBookTopicContent(driver, role, "Where did people live and origin of the word India?");
		
		if(role.equals("Parent"))
		{	
			Thread.sleep(3000);
			Assert.assertEquals(priResLisMod.childAccessMsg.getText(), "Please access the content from your child's account.");
		}
		else if(!role.equals("Parent"))
		{	
			priResLisMod.clickOnTopicSynopsis();
			Thread.sleep(3000);
		    Assert.assertEquals(priResVieMod.synopsisHeading.getText(), "Where Did People Live And Origin Of The Word India..");
		}
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
		logMod.Login(role, "CBSE", "6", "Single", "Prime", "Yes");
		leaMod.clickOnLearnImage();
		leaMod.clickOnPrimeImage();
		        		
		Thread.sleep(3000);
		oriClaMod.clickOnClassContent(driver, "Class 10");
		priSubMod.clickOnSubject(driver, role, "Biology");
		priResLisMod.clickOnBookChapter(driver, role, "1. Life Processes");
		priResLisMod.clickOnBookTopicContent(driver, role, "Nutrition in Human Beings");
		Thread.sleep(2000);
		priResLisMod.clickOnMindMaps();
		Thread.sleep(3000);
		
	    Assert.assertEquals(priResVieMod.synopsisHeading.getText(), "Nutrition in Human Beings");	
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
		logMod.Login(role, "CBSE", "6", "Single", "Prime", "Yes");
		
		if(!role.equals("Guest"))
	    	leaMod.clickOnLearnImage();

		leaMod.clickOnPrimeImage();
		        		
		Thread.sleep(3000);

		priSubMod.clickOnSubject(driver, role, "Social Studies");
		Thread.sleep(2000);
		priResLisMod.clickOnBookChapter(driver, role, "1. What, Where, How and When");
		
		priResLisMod.clickOnBookTopicContent(driver, role, "Where did people live and origin of the word India?");
		
		if(role.equals("Parent"))
		{	
			Thread.sleep(3000);
			Assert.assertEquals(priResLisMod.childAccessMsg.getText(), "Please access the content from your child's account.");
		}
		else if(!role.equals("Parent"))
		{	
			priResLisMod.clickOnMindMaps();
			Thread.sleep(3000);
		    Assert.assertEquals(priResVieMod.synopsisHeading.getText(), "Where did people live and origin of the word India..");
		}
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
		logMod.Login(role, "CBSE", "6", "Single", "Prime", "Yes");
		leaMod.clickOnLearnImage();
		leaMod.clickOnPrimeImage();
		        		
		Thread.sleep(3000);
		oriClaMod.clickOnClassContent(driver, "Class 10");
		priSubMod.clickOnSubject(driver, role, "Biology");
		priResLisMod.clickOnBookChapter(driver, role, "1. Life Processes");
		priResLisMod.clickOnBookTopicContent(driver, role, "Nutrition in Human Beings");
		Thread.sleep(2000);
		priResLisMod.clickOnRealLife();
		Thread.sleep(3000);
		
	    Assert.assertEquals(priResVieMod.synopsisHeading.getText(), "Nutrition in Human Being");
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
		logMod.Login(role, "CBSE", "6", "Single", "Prime", "Yes");
		
		if(!role.equals("Guest"))
	    	leaMod.clickOnLearnImage();

		leaMod.clickOnPrimeImage();
		        		
		Thread.sleep(3000);

		priSubMod.clickOnSubject(driver, role, "Social Studies");
		Thread.sleep(2000);
		priResLisMod.clickOnBookChapter(driver, role, "1. What, Where, How and When");
		
		priResLisMod.clickOnBookTopicContent(driver, role, "Where did people live and origin of the word India?");
		
		if(role.equals("Parent"))
		{	
			Thread.sleep(3000);
			Assert.assertEquals(priResLisMod.childAccessMsg.getText(), "Please access the content from your child's account.");
		}
		else if(!role.equals("Parent"))
		{	
			priResLisMod.clickOnRealLife();
			Thread.sleep(3000);
		    Assert.assertEquals(priResVieMod.synopsisHeading.getText(), "Garo Hills, Indus River");
		}
	} 
	
	/**
	* verify Content Access message displayed to parent on Web, Android, iOS
	* @author Tarun Goswami
	* @since 2018-12-14
	* @throws InterruptedException 
	* @version 1.1
	* @throws IOException 
	*/
	@Test
	public void verifyAccessFromChildMessage() throws InterruptedException
	{
		String role = "Parent";
		logMod.Login(role, "CBSE", "6", "Single", "Prime", "Yes");

		leaMod.clickOnLearnImage();
	    leaMod.clickOnPrimeImage();
	    Thread.sleep(2000);
	    
		priSubMod.clickOnSubject(driver, role, "Social Studies");
		Thread.sleep(3000);
		Assert.assertEquals(priChaTopMod.childAccessTxt.getText(), "Please access the content from your child's account.");
	}		
}