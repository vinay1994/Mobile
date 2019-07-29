package com.fliplearn.flipapp.testcases;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Test;

import com.fliplearn.flipapp.helper.Base;
import com.fliplearn.flipapp.helper.GenericFunctions;
import com.fliplearn.flipapp.pagemodules.DoubtForumModule;
import com.fliplearn.flipapp.pagemodules.HomeModule;
import com.fliplearn.flipapp.pagemodules.LearnModule;
import com.fliplearn.flipapp.pagemodules.LoginModule;
import com.fliplearn.flipapp.pagemodules.MenuModule;
import com.fliplearn.flipapp.pagemodules.MobileNumberModule;
import com.fliplearn.flipapp.pagemodules.OnboardingModule;
import com.fliplearn.flipapp.pagemodules.PracticeChapterTopicModule;
import com.fliplearn.flipapp.pagemodules.PrimeChapterTopicModule;
import com.fliplearn.flipapp.pagemodules.PrimeClassModule;
import com.fliplearn.flipapp.pagemodules.PrimePurchaseFlowModule;
import com.fliplearn.flipapp.pagemodules.PrimeSubjectModule;


public class DoubtForum extends Base
{
	LoginModule logMod;
	MobileNumberModule mobNumMod;
	MenuModule menMod;
	LearnModule leaMod;
	PrimeClassModule priClaMod;
	PrimeSubjectModule priSubMod;
	PrimePurchaseFlowModule priPurFloMod;
	GenericFunctions generic;
	PrimeChapterTopicModule priChaTopMod;
	OnboardingModule onbMod;
	PracticeChapterTopicModule praChaTopMod;
	HomeModule homMod;
	DoubtForumModule douForMod;

	
	@BeforeMethod
	public void preVerifyDoubtForum() 
	{	
		logMod = new LoginModule(driver);
		mobNumMod = new MobileNumberModule(driver);
		menMod = new MenuModule(driver);
		leaMod = new LearnModule(driver);
		priClaMod =	new PrimeClassModule(driver);
		priSubMod = new PrimeSubjectModule(driver); 
		priPurFloMod= new PrimePurchaseFlowModule(driver);
		generic=new GenericFunctions();
		onbMod = new OnboardingModule(driver);
		praChaTopMod=new PracticeChapterTopicModule(driver);
		homMod=new HomeModule(driver);
		douForMod=new DoubtForumModule();
	}

	@Test(dataProvider="doubt_staff")
	public void verifyDoubtForumTabs(String role) throws InterruptedException, IOException  
	{	
		logMod.Login(role, "CBSE", "10", "Single", "Prime", "Yes");
		
		generic.waitForElementVisibility(driver, douForMod.doubtForumTileTxt);
		douForMod.clickOnDoubtForumTile();
		
		generic.waitForElementVisibility(driver, douForMod.doubtForumHeading);
		String expectedList = readData(platform, role, "DoubtForum Tabs");
				
		Assert.assertEquals(generic.compareList(douForMod.doubtForumTabs, expectedList), true);
	}
	      
    @Test(dataProvider="doubt_staff")
    public void createDoubtWhenTextAndImageNotFoundMandatory(String role) throws InterruptedException, IOException 
    {
    	logMod.Login(role, "CBSE", "10", "Single", "Prime", "Yes");
 	    
    	generic.waitForElementVisibility(driver, douForMod.doubtForumTileTxt);
		douForMod.clickOnDoubtForumTile();    
		douForMod.clickOnAskYourDoubtBtn();

		String expectedTitle = douForMod.enterAskYourDoubtText();
		douForMod.closeTipsToAskDoubtPopUp();
        douForMod.clickOnSearchBtn();     
        douForMod.selectSubjectFromDrp();
        
        generic.waitForElementVisibility(driver, douForMod.selectChapterDrp);
        douForMod.selectChapFromDrp();
        
        douForMod.clickOnCreateBtn();
        generic.waitForElementVisibility(driver, douForMod.verExpDouPost);
                    
        int i = 0;
     		
     	while(!(douForMod.verExpDouPost.getText().equalsIgnoreCase(expectedTitle)) && i < 3)
     	{
     		driver.navigate().refresh();
     		i++;
     	}
     	
     	String ActualTitle = douForMod.verExpDouPost.getText();
     	
     	System.out.println(ActualTitle);
     	System.out.println(expectedTitle);
     	
     	Assert.assertEquals(ActualTitle, expectedTitle);
    }
        
        @Test(dataProvider="doubt_staff")
        public void verifyUserCanPostAnswer(String role) throws InterruptedException, IOException {
        	logMod.Login(role, "CBSE", "10", "Single", "Prime", "Yes");
     	    Thread.sleep(6000);
     	    try 
     	    {
     	        if(( priPurFloMod.cliOnSkiButt).isDisplayed()) 
     	        	priPurFloMod.clickOnSkip();	
     	    }
     	    catch(Exception e) 
     	    {
     	    }
     	    
     	    JavascriptExecutor jse1 = (JavascriptExecutor)driver;
     		jse1.executeScript("window.scrollBy(0,250)", "");
            douForMod.clickOnDoubtForumTile();
            douForMod.clickOnMyDoubt();
            try {
            douForMod.clickOnPostYourAns();
            }catch(Exception e) {
            }
            }
        @Test(dataProvider="doubt_staff")
        public void verifyUnFollowPost(String role) throws InterruptedException, IOException {
        	logMod.Login(role, "CBSE", "10", "Single", "Prime", "Yes");
     	    Thread.sleep(6000);
     	    try 
     	    {
     	        if(( priPurFloMod.cliOnSkiButt).isDisplayed()) 
     	        	priPurFloMod.clickOnSkip();	
     	    }
     	    catch(Exception e) 
     	    {
     	    }
     	    
     	    JavascriptExecutor jse1 = (JavascriptExecutor)driver;
     		jse1.executeScript("window.scrollBy(0,250)", "");
            douForMod.clickOnDoubtForumTile();
            Thread.sleep(2000);
            douForMod.clickOnMyDoubt();
            
            String verPost=douForMod.FirMyDoubtPost.getText();
            System.out.println(verPost);
            
            douForMod.verifyUnFollPost();
            douForMod.clickOnMyDoubt();
            driver.navigate().refresh();
            douForMod.clickOnMyDoubt();
           
            
            Thread.sleep(2000);
            Assert.assertNotSame(verPost,false);
            System.out.println(douForMod.FirMyDoubtPost.getText());
            Thread.sleep(2000);
          }
            
            }
            

   

            
		
		
		
		
		
		
		
		
	
	


