package com.fliplearn.flipapp.testcases;

import java.io.IOException;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.fliplearn.flipapp.helper.Base;
import com.fliplearn.flipapp.helper.GenericFunctions;
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

public class PrimePractice extends Base{
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
	
	
	@BeforeMethod
	public void preVerifyPrimePurchaseFlow() 
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
	}
	@Test(dataProvider = "nostaff_new")
	public void verifyRecommendedTopic(String role) throws InterruptedException, IOException {
		logMod.Login(role, "CBSE", "10", "Single", "Prime", "Yes");
		Thread.sleep(6000);
		priSubMod.clickOnSubject(driver, role, "Biology");
		Assert.assertTrue(praChaTopMod.verSubPage.isDisplayed());
		Assert.assertTrue(praChaTopMod.verrecomTopText.isDisplayed());
		
		}
	@Test(dataProvider = "nostaff_new")
	public void verifyPracticeSubjectTopicScreen(String role) throws InterruptedException, IOException {
	logMod.Login(role, "CBSE", "10", "Single", "Prime", "Yes");
	Thread.sleep(6000);
	priSubMod.clickOnSubject(driver, role, "Biology");
    
	Boolean ImagePresent = (Boolean) ((JavascriptExecutor)driver).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", praChaTopMod.verRecommImg);  
	    if (!ImagePresent)
	    {
	         System.out.println("Image not displayed.");
	    }
	    else
	    {
	        System.out.println("Image displayed.");
	   
	    }
	    Assert.assertTrue(praChaTopMod.verRecTopTil.isDisplayed());
	    
	    Thread.sleep(2000);
	    Assert.assertEquals(praChaTopMod.verTextTakeTest.getText(), "Take basic test to reach Earth orbit");
	    Thread.sleep(2000);
        Assert.assertEquals(praChaTopMod.verFliText.getText(), "You have to start your flight");
        
       Boolean ImagePresent1 = (Boolean) ((JavascriptExecutor)driver).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", praChaTopMod.verEasMedDiffImg);  
	    
      
        if (!ImagePresent1)
	    {
	         System.out.println("Image not displayed.");
	    }
	    else
	    {
	        System.out.println("Image displayed.");
	   
	    }
	    
	    String expectedTitle = praChaTopMod.verrecomTopText.getText();
	    String expectedTitle1=praChaTopMod.verRecommImg.getAttribute("src");
	  
	    praChaTopMod.clickOnRecommTopic();
	    
	    Assert.assertTrue(  praChaTopMod.verTopOnLauScreen.getText().contains(expectedTitle));
	    Assert.assertEquals(praChaTopMod.verImgOnLaunchScreen.getAttribute("src"),expectedTitle1);
}	    
	   
	  @Test(dataProvider = "nostaff_new")
	  public void verifyBackwardFlowOfSubjScreen(String role) throws InterruptedException, IOException {
		  logMod.Login(role, "CBSE", "10", "Single", "Prime", "Yes");
		  Thread.sleep(6000);
			priSubMod.clickOnSubject(driver, role, "Biology");
			praChaTopMod.clickOnTopic2();
			Thread.sleep(3000);
		    praChaTopMod.clickOnLaunchTest();
		    Thread.sleep(6000);
		    generic.waitForElementVisibility(driver, praChaTopMod.closeLauTest);
		    praChaTopMod.clickOnCloseLaunchTest();
		    Thread.sleep(2000);
		    
		   String expectedTitle1=praChaTopMod.verTopOnLauScreen.getText();
		    System.out.println(expectedTitle1);
		 
		    praChaTopMod.clickOnBackButton();
		    Thread.sleep(2000);
		  
		    Assert.assertTrue(expectedTitle1.contains(praChaTopMod.verrecomTopText.getText()));
		    
		    Assert.assertTrue(praChaTopMod.verRecommImg.isDisplayed());
		    Assert.assertTrue(praChaTopMod.verRecTopTil.isDisplayed());
		    Thread.sleep(2000);
		    Assert.assertEquals(praChaTopMod.verTextTakeTest.getText(), "Take basic test to reach Earth orbit");
		    Thread.sleep(2000);
	        Assert.assertEquals(praChaTopMod.verFliText.getText(), "You have to start your flight");
	        String expectedTitle2 = praChaTopMod.verrecomTopText.getText();
	  	  
		    praChaTopMod.clickOnRecommTopic();
		    
		    Assert.assertTrue(  praChaTopMod.verTopOnLauScreen.getText().contains(expectedTitle2));}
	  
	      @Test(dataProvider = "nostaff_new")
	      public void verPracticeModeTopScreen(String role) throws InterruptedException, IOException {
	    	  logMod.Login(role, "CBSE", "10", "Single", "Prime", "Yes");
			  Thread.sleep(6000);
			  praChaTopMod.switchToPractMod();
			  Thread.sleep(2000);
			  priSubMod.clickOnSubject(driver, role, "Biology");
			  Assert.assertEquals(praChaTopMod.verLearnText.getText(), "Continue your Learning Flight");
			  praChaTopMod.switchToPractMod();
			  Thread.sleep(2000);
			  System.out.println(praChaTopMod.verFirstChapter);
			  Assert.assertTrue(praChaTopMod.verFirstChapter.isDisplayed());
			  Assert.assertTrue(praChaTopMod.verEarthIcon.isDisplayed());
	          praChaTopMod.clickOnFirstTopic();
	          Assert.assertEquals(praChaTopMod.verFliText.getText(), "You have to start your flight");
	          Thread.sleep(2000);
	          Assert.assertTrue(praChaTopMod.verFirSteImg.isDisplayed());
	      }
	      
	          @Test(dataProvider="nostaff_new")
	          public void verifyLaunchTestScrwithEarthLev(String role) throws InterruptedException, IOException{
	        	  logMod.Login(role, "CBSE", "10", "Single", "Prime", "Yes");
	    		  Thread.sleep(6000);
	    			priSubMod.clickOnSubject(driver, role, "Biology");
	    			praChaTopMod.clickOnSecTopic();
	    			Assert.assertEquals(praChaTopMod.verReaEarText.getText(),"You have reached Earth orbit");
	    			Assert.assertEquals(praChaTopMod.verInterLevelText.getText(),"Score 60% marks in intermediate level test to reach Moon orbit");
	    			Assert.assertTrue(praChaTopMod.verSecLevImg.isDisplayed());
	    			Assert.assertTrue(praChaTopMod.verAutoImgOnSubScr.isDisplayed());
	    			Assert.assertTrue(praChaTopMod.verTopicOnLauScr.isDisplayed());
	    			Thread.sleep(2000);
	                Assert.assertTrue(praChaTopMod.cliOnLauTest.isDisplayed());
	    			 }
	          
	            @Test(dataProvider="nostaff_new")
	            public void verifyLauScrWithMoonLev(String role) throws InterruptedException, IOException {
	            	logMod.Login(role, "CBSE", "10", "Single", "Prime", "Yes");
		    		  Thread.sleep(6000);
		    			priSubMod.clickOnSubject(driver, role, "Biology");
		    			praChaTopMod.clickOnThirTopic();
		    			Assert.assertTrue(praChaTopMod.verMoonTopic.isDisplayed());
		    			Assert.assertTrue(praChaTopMod.verMoonOrbText.isDisplayed());
		    			Assert.assertEquals(praChaTopMod.verDiffLevText.getText(),"Score 60% marks in difficult level test to reach Mars orbit");
		    			Assert.assertTrue(praChaTopMod.verThiSteImg.isDisplayed());
		    			Assert.assertTrue(praChaTopMod.cliOnLauTest.isDisplayed());
		    			
		    			
	            	
	            	
	            }
	          
	          
	          
			  
			  
			  
			  
	    	  
	      }
	  
	        
		    
		    
		    
			
	  
	    
	
	

