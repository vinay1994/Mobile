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
	public void verifyDoubtForumTab(String role) throws InterruptedException, IOException  
	{	
		logMod.Login(role, "CBSE", "10", "Single", "Prime", "Yes");
		    Thread.sleep(6000);
		    try 
	 	    {
	 	        if(priPurFloMod.cliOnSkiButt.isDisplayed()) 
	 	        	priPurFloMod.clickOnSkip();	
	 	    }
	 	    catch(Exception e) 
	 	    {
	 	    }
		    
		    JavascriptExecutor jse = (JavascriptExecutor)driver;
		    jse.executeScript("window.scrollBy(0,250)", "");
		   
		   
			Assert.assertTrue(douForMod.clickOnDouFor.isDisplayed());
			Assert.assertTrue(douForMod.verDouFormImg.isDisplayed());
			douForMod.clickOnDoubtForumBtn();
			
			Assert.assertTrue(douForMod.verFlipGuruTxt.isDisplayed());
			//Assert.assertTrue(douForMod.verAskImg.isDisplayed());

	}
	
	@Test(dataProvider="doubt_staff")
	public void verifyCountOfDoubtTabs(String role) throws InterruptedException, IOException 
	{
	        logMod.Login(role, "CBSE", "10", "Single", "Prime", "Yes");
	        Thread.sleep(6000);
	        try 
	 	    {
	 	        if(priPurFloMod.cliOnSkiButt.isDisplayed()) 
	 	        	priPurFloMod.clickOnSkip();	
	 	    }
	 	    catch(Exception e) 
	 	    {
	 	    }
//	        if (priPurFloMod.cliOnSkiButt.size() != 0) return true;
//	        return false;
	        
	        Thread.sleep(2000);
	        JavascriptExecutor jse = (JavascriptExecutor)driver;
		    jse.executeScript("window.scrollBy(0,250)", "");
            Thread.sleep(2000);
            douForMod.clickOnDoubtForumBtn();
          
            String expectedList = readData(platform, role, "DoubtForum Tabs");
       	 System.out.println("Expected List:"+expectedList);
       	 
       	 Assert.assertEquals(generic.compareList(douForMod.verNoOfTab, expectedList), true);
	}
          
    @Test(dataProvider="doubt_staff")
    public void createDoubtWithoutSearchTextWithoutImg(String role) throws InterruptedException, IOException 
    {
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
 	    
 	    JavascriptExecutor jse = (JavascriptExecutor)driver;
 		jse.executeScript("window.scrollBy(0,250)", "");
        Thread.sleep(2000);
        douForMod.clickOnDoubtForumBtn();
        Assert.assertTrue(douForMod.verFlipGuruTxt.isDisplayed());
        douForMod.clickOnAskYourDoubt();
        Thread.sleep(2000);
        Assert.assertTrue(douForMod.vercreateDoubtFrame.isDisplayed());
        String expectedTitle = douForMod.enterAskYourDoubtText();
        douForMod.clickOnSearchButtn();
        douForMod.selectSubjectFromDropDwn();
        generic.waitForElementVisibility(driver, douForMod.slectChap);
        douForMod.selectChapFromDropdwn();
        douForMod.clickOnCreateButton();
        Thread.sleep(4000);
        generic.waitForElementVisibility(driver, douForMod.verExpDouPost);
        
             
        if(platform.equals("Web"))
     	{	
     		int i = 0;
     			
     		String  ActualTitle=douForMod.verExpDouPost.getText();
     		
     		while(!(ActualTitle.equalsIgnoreCase(ActualTitle)) && i < 2)
     		{
     			driver.navigate().refresh();
     			i++;
     		}
     		
     		System.out.println(ActualTitle);
     		System.out.println(expectedTitle);
            Assert.assertEquals(ActualTitle, expectedTitle);
            Assert.assertTrue(douForMod.verFollCount.isDisplayed());
            douForMod.clickOnMyDoubt();
            Assert.assertTrue(douForMod.verFollCount.isDisplayed());
            douForMod.clickOnMyDoubt();
            }}
        
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
            douForMod.clickOnDoubtForumBtn();
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
            douForMod.clickOnDoubtForumBtn();
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
            

   

            
		
		
		
		
		
		
		
		
	
	


