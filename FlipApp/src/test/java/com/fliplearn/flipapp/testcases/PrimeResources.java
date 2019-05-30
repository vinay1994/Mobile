package com.fliplearn.flipapp.testcases;

import java.io.IOException;

import org.openqa.selenium.By;
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
	PrimeClassModule priClaMod;
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
	//	priResVieMod = new PrimeResourceViewModule(driver);
		signInMod = new SignInAsModule(driver);
		leaMod = new LearnModule(driver);
		priClaMod =	new PrimeClassModule(driver);
		priSubMod = new PrimeSubjectModule(driver);  
		priResLisMod = new PrimeResourceListModule(driver);
		priChaTopMod = new PrimeChapterTopicModule(driver);
		youProMod=new YourProfileModule(driver);
		heaMod=new HeaderModule(driver);
	}
	
	/**
	* verify PrimeVideo on Web, Android, iOS when Admin, Principal, Teacher, Parent, Student and Guest click on Video Content
	* @author Jagrati
	* @since 2018-10-14
	* @throws InterruptedException 
	* @version 1.2
	* @throws IOException 
	* @modifiedBy Tarun Goswami on 2019-04-10
	*/

	@Test(dataProvider ="allusers_old")
	public void playPrimeVideo_Old(String role) throws IOException, InterruptedException
	{
		logMod.Login(role, "CBSE", "6", "Single", "Prime", "Yes");
	    
		if(platform.equals("Web"))
		{	
			if(!role.equals("Guest"))
		    	leaMod.clickOnLearnImage();
		}	
	    
		leaMod.clickOnPrimeImage();
	        		
	    Thread.sleep(3000);
	    
		if(role.equals("Admin") || role.equals("Principal") || role.equals("Teacher"))
			priClaMod.selectUserClass("Class 6");
	   
		priSubMod.clickOnSubject(driver, role, "Mathematics");
		

	    
		if(role.equals("Parent"))
		{
			priResLisMod.clickOnBookChapter(driver, "Whole numbers");
			priResLisMod.clickOnChapterTopic(driver, "Predecessor and Successor");	
			priResLisMod.clickOnTopicResource(driver, "Predecessor and Successor");
		}
		else
		{
			priResLisMod.clickOnBookChapter(driver, "Knowing Our Numbers");
			priResLisMod.clickOnChapterTopic(driver, "Comparing Numbers");
			priResLisMod.clickOnTopicResource(driver, "Numeral System");
		}   
		
	    if(role.equals("Parent"))
	    {	
	    	if(platform.equals("Web"))
	    	{
	    		Thread.sleep(3000);
	    		Assert.assertEquals(priResLisMod.childAccessMsg.getText(), "Please access the content from your child's account.");
	    	}
	    	else
	    	{
	    		Assert.assertEquals(0, driver.findElements(By.xpath("//*[@text='Animation']")).size());
	    	}
	    }
	    else
	    {
		    priResVieMod.clickOnVideoContent(driver, "Numeral System");
		    Thread.sleep(3000);
	    	priResVieMod.verifyVideoContent(driver, "Numeral System");
	    }
	}
	
	/**
	* verify Topic Synopsis on Web, Android, iOS for Admin, Principal, Teacher
	* @author Jagrati
	* @since 2018-10-14
	* @throws InterruptedException 
	* @version 1.1
	* @throws IOException 
	* @modifiedBy Tarun Goswami on 2019-04-10
	*/
	/*@Test(dataProvider="allusers_old")
	public void verifyTopicSynopsis_Old(String role) throws InterruptedException, IOException
	{
		logMod.Login(role, "CBSE", "6", "Single", "Prime", "Yes");
	    
		if(platform.equals("Web"))
		{	
			if(!role.equals("Guest"))
		    	leaMod.clickOnLearnImage();
		}	
	    
		leaMod.clickOnPrimeImage();
	        		
	    Thread.sleep(3000);
	    
		if(role.equals("Admin") || role.equals("Principal") || role.equals("Teacher"))
			priClaMod.selectUserClass("Class 6");
	   
		priSubMod.clickOnSubject(driver, role, "Mathematics");
	    
		if(role.equals("Parent"))
		{
			priResLisMod.clickOnBookChapter(driver, "Whole numbers");
			priResLisMod.clickOnChapterTopic(driver, "Predecessor and Successor");	
		}
		else
		{
			priResLisMod.clickOnBookChapter(driver, "Knowing Our Numbers");
			priResLisMod.clickOnChapterTopic(driver, "Roman Numerals");
		}  
	   	    
	    if(role.equals("Parent"))
	    {	
	    	if(platform.equals("Web"))
	    	{
	    		Thread.sleep(3000);
	    		Assert.assertEquals(priResLisMod.childAccessMsg.getText(), "Please access the content from your child's account.");
	    	}
	    	else
	    	{
	    		Assert.assertEquals(0, driver.findElements(By.xpath("//*[@text='Topic Synopsis']")).size());
	    	}
	    }
	    else
	    {
	    	generic.waitForElementVisibility(driver, priResLisMod.topicSynopsis);
			priResLisMod.clickOnTopicSynopsis();
			Thread.sleep(5000);
	    	Assert.assertEquals(priResVieMod.synopsisHeading.getText(), "Roman Numerals");

	    	
	    	if(platform.equals("Web"))
	    	{
	    		driver.switchTo().frame("myFrame");

	    		Assert.assertTrue(priResVieMod.synopsisTitle.isDisplayed());
	    	}	
	    }	
	}
	*/
	/**
	* verify Mind Maps on Web, Android, iOS for Admin, Principal, Teacher
	* @author Jagrati
	* @since 2018-10-14
	* @throws InterruptedException 
	* @version 1.1
	* @throws IOException 
	* @modifiedBy Tarun Goswami on 2019-04-10
	*/
	@Test(dataProvider="allusers_old")
	public void verifyMindMaps_Old(String role) throws InterruptedException, IOException
	{
	logMod.Login(role, "CBSE", "6", "Single", "Prime", "Yes");
	    
		if(platform.equals("Web"))
		{	
			if(!role.equals("Guest"))
		    	leaMod.clickOnLearnImage();
		}	
	    
		leaMod.clickOnPrimeImage();
	        		
	    Thread.sleep(3000);
	    
		if(role.equals("Admin") || role.equals("Principal") || role.equals("Teacher"))
			priClaMod.selectUserClass("Class 6");
	   
		priSubMod.clickOnSubject(driver, role, "Mathematics");
	    
		if(role.equals("Parent"))
		{
			priResLisMod.clickOnBookChapter(driver, "Whole numbers");
			priResLisMod.clickOnChapterTopic(driver, "Predecessor and Successor");	
		}
		else
		{
			priResLisMod.clickOnBookChapter(driver, "Knowing Our Numbers");
			priResLisMod.clickOnChapterTopic(driver, "Roman Numerals");
		} 
	   	    
	    if(role.equals("Parent"))
	    {	
	    	if(platform.equals("Web"))
	    	{
	    		Thread.sleep(3000);
	    		Assert.assertEquals(priResLisMod.childAccessMsg.getText(), "Please access the content from your child's account.");
	    	}
	    	else
	    	{
	    		Assert.assertEquals(0, driver.findElements(By.xpath("//*[@text='Mind Maps']")).size());
	    	}
	    }
	    else
	    {
	    	generic.waitForElementVisibility(driver, priResLisMod.mindMaps);
			priResLisMod.clickOnMindMaps();	
			Thread.sleep(5000);
	    	Assert.assertEquals(priResVieMod.synopsisHeading.getText(), "Roman Numerals");
	    	
	    	if(platform.equals("Web"))
	    	{
	    		driver.switchTo().frame("myFrame");
	    		Assert.assertTrue(priResVieMod.mindMapsTitle.isDisplayed());
	    	}	
	    }
	}

	
	/**
	* verify Real Life Cotent on Web, Android, iOS for Admin, Principal, Teacher
	* @author Jagrati
	* @since 2018-10-14
	* @throws InterruptedException 
	* @version 1.1
	* @throws IOException 
	* @modifiedBy Tarun Goswami on 2019-04-10
	*/
	/*@Test(dataProvider="allusers_old")
	public void verifyRealLifeApplication_Old(String role) throws InterruptedException, IOException
	{
		logMod.Login(role, "CBSE", "6", "Single", "Prime", "Yes");
	    
		if(platform.equals("Web"))
		{	
			if(!role.equals("Guest"))
		    	leaMod.clickOnLearnImage();
		}	
	    
		leaMod.clickOnPrimeImage();
	        		
	    Thread.sleep(3000);
	    
		if(role.equals("Admin") || role.equals("Principal") || role.equals("Teacher"))
			priClaMod.selectUserClass("Class 6");
	   
		priSubMod.clickOnSubject(driver, role, "Mathematics");
	    
		if(role.equals("Parent"))
		{
			priResLisMod.clickOnBookChapter(driver, "Whole numbers");
			priResLisMod.clickOnChapterTopic(driver, "Predecessor and Successor");	
		}
		else
		{
			priResLisMod.clickOnBookChapter(driver, "Knowing Our Numbers");
			priResLisMod.clickOnChapterTopic(driver, "Roman Numerals");
		} 
	   	    
	    if(role.equals("Parent"))
	    {	
	    	if(platform.equals("Web"))
	    	{
	    		Thread.sleep(3000);
	    		Assert.assertEquals(priResLisMod.childAccessMsg.getText(), "Please access the content from your child's account.");
	    	}
	    	else
	    	{
	    		Assert.assertEquals(0, driver.findElements(By.xpath("//*[@text='Real Life Application']")).size());
	    	}
	    }
	    else
	    {
	    	generic.waitForElementVisibility(driver, priResLisMod.realLife);
			priResLisMod.clickOnRealLifeApplication();	
			Thread.sleep(5000);
	    	Assert.assertEquals(priResVieMod.synopsisHeading.getText(), "Roman Numerals");
	    	
	    	if(platform.equals("Web"))
	    	{
	    		driver.switchTo().frame("myFrame");
	    		Assert.assertTrue(priResVieMod.realLifeApplicationTitle.isDisplayed());
	    	}	
	    }
	}*/
	 
	/**
	* verify Interactive Worksheet on Web, Android, iOS for Admin, Principal, Teacher
	* @author Jagrati
	* @since 2018-10-14
	* @throws InterruptedException 
	* @version 1.1
	* @throws IOException 
	* @modifiedBy Tarun Goswami on 2019-04-10
	*/
	@Test(dataProvider="allusers_old")
	public void verifyInteractiveWorksheet_Old(String role) throws InterruptedException, IOException
	{
		logMod.Login(role, "CBSE", "6", "Single", "Prime", "Yes");
	    
		if(platform.equals("Web"))
		{	
			if(!role.equals("Guest"))
		    	leaMod.clickOnLearnImage();
		}	
	    
		leaMod.clickOnPrimeImage();
	        		
	    Thread.sleep(3000);
	    
		if(role.equals("Admin") || role.equals("Principal") || role.equals("Teacher"))
			priClaMod.selectUserClass("Class 6");
	   
		priSubMod.clickOnSubject(driver, role, "Mathematics");
	    
		if(role.equals("Parent"))
		{
			priResLisMod.clickOnBookChapter(driver, "Whole numbers");
			priResLisMod.clickOnChapterTopic(driver, "Predecessor and Successor");	
		}
		else
		{
			priResLisMod.clickOnBookChapter(driver, "Knowing Our Numbers");
			priResLisMod.clickOnChapterTopic(driver, "Roman Numerals");
		} 
	   	    
	    if(role.equals("Parent"))
	    {	
	    	if(platform.equals("Web"))
	    	{
	    		Thread.sleep(3000);
	    		Assert.assertEquals(priResLisMod.childAccessMsg.getText(), "Please access the content from your child's account.");
	    	}
	    	else
	    	{
	    		Assert.assertEquals(0, driver.findElements(By.xpath("//*[@text='Interactive Worksheet']")).size());
	    	}
	    }
	    else
	    {
	    	generic.waitForElementVisibility(driver, priResLisMod.interactiveWorksheet);
			priResLisMod.clickOnInteractiveWorksheet();
			Thread.sleep(5000);
	    	Assert.assertEquals(priResVieMod.synopsisHeading.getText(), "Roman Numerals-Drag and Drop");
	    	
	    	if(platform.equals("Web"))
	    	{
	    		driver.switchTo().frame("myFrame");
	    		Assert.assertTrue(priResVieMod.interactiveWorksheetTitle.isDisplayed());
	    	}	
	    }
	}
	
	/**
	* verify Content Access message displayed to parent on Web, Android, iOS
	* @author Jagrati Mishra
	* @since 2018-12-14
	* @throws InterruptedException 
	* @version 1.1
	* @throws IOException 
	*/
	@Test
	public void verifyAccessFromChildMessage() throws InterruptedException, IOException
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