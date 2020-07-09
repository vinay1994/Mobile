package com.fliplearn.flipapp.testcases;

import java.io.IOException;

import org.openqa.selenium.Keys;
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

public class PrimeSearch extends Base
{
	GenericFunctions generic;
	LoginModule logMod;
	MobileNumberModule mobNumMod;
	MenuModule menMod;
	LearnModule leaMod;
	SignInAsModule signInMod;
	YourProfileModule youProMod;
	HeaderModule heaMod;
	PrimeClassModule priClaMod;
	PrimeSubjectModule priSubMod;
	PrimeChapterTopicModule priChaTopMod;
	PrimeResourceListModule priResLisMod;
	PrimeResourceViewModule priResVieMod;
	//test
	@BeforeMethod
	public void prePrimeSearch()
	{
		generic = new GenericFunctions();
		logMod = new LoginModule(driver);
		mobNumMod = new MobileNumberModule(driver);
		menMod = new MenuModule(driver);
		signInMod = new SignInAsModule(driver);
		leaMod = new LearnModule(driver);
		priClaMod =	new PrimeClassModule(driver);
		priSubMod = new PrimeSubjectModule(driver);  
		priChaTopMod = new PrimeChapterTopicModule(driver);
		priResLisMod = new PrimeResourceListModule(driver);
		priResVieMod = new PrimeResourceViewModule(driver);
		youProMod=new YourProfileModule(driver);
		heaMod=new HeaderModule(driver);
	}
	
	/**
	* verify User able to search and view content on Web, Android, iOS when Admin, Principal, Teacher click on Video Content
	* @author Tarun Goswami
	* @since 2018-12-14
	* @throws InterruptedException 
	* @version 1.0
	* @throws IOException 
	*/
	@Test(dataProvider ="staff")
	public void searchAndViewContentSchool_Old(String role) throws IOException, InterruptedException
	{		
		logMod.Login(role, "CBSE", "6", "Single", "Prime", "Yes");
	    leaMod.clickOnLearnImage();
	    leaMod.clickOnPrimeImage();
	        		
	    Thread.sleep(2000);
	    
	    String title = readData(platform, role, "Search String");
	    
	    priClaMod.selectUserClass("Class 10");
	    priSubMod.clickOnSubject(driver, role, "Biology");
	    priChaTopMod.searchContent(title);
	    Thread.sleep(3000);
	    priChaTopMod.selectFirstSearchedContent(title);
		
	    Thread.sleep(3000);
	    Assert.assertEquals(priResVieMod.synopsisHeading.getText(), title);	    
	}
	
	/**
	* verify User able to search and view content on Web, Android, iOS when Admin, Principal, Teacher click on Video Content
	* @author Tarun Goswami
	* @since 2018-12-14
	* @throws InterruptedException 
	* @version 1.0
	* @throws IOException 
	*/
	@Test//(dataProvider ="nostaff")
	public void searchAndViewContentStudent_Old() throws IOException, InterruptedException
	{		
		String role = "Parent";
		logMod.Login(role, "CBSE", "6", "Single", "Prime", "Yes");
		
		if(!role.equals("Guest"))
	    	leaMod.clickOnLearnImage();

	    leaMod.clickOnPrimeImage();
	        		
	    Thread.sleep(2000);

	    String title = readData(platform, role, "Search String");
	    
		priSubMod.clickOnSubject(driver, role, "Social Studies");
		   priChaTopMod.searchContent(title);
			 
		if(role.equals("Parent"))
		{	
			Thread.sleep(7000);
			Assert.assertEquals(priChaTopMod.childAccessPopup.getText(), "Please access the content from your child's account.");
		}
		else
		{	
			priChaTopMod.selectFirstSearchedContent(title);
		
			Thread.sleep(3000);
			Assert.assertEquals(priResVieMod.synopsisHeading.getText(), title);	    
		}	
	}

}
