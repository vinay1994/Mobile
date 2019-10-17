
package com.fliplearn.flipapp.testcases;
import static org.testng.Assert.assertEquals;



import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.fliplearn.flipapp.helper.Base;
import com.fliplearn.flipapp.helper.GenericFunctions;
import com.fliplearn.flipapp.pagemodules.LearnModule;
import com.fliplearn.flipapp.pagemodules.LoginModule;
import com.fliplearn.flipapp.pagemodules.MenuModule;
import com.fliplearn.flipapp.pagemodules.MobileNumberModule;
import com.fliplearn.flipapp.pagemodules.OnboardingModule;
import com.fliplearn.flipapp.pagemodules.PrimeChapterTopicModule;
import com.fliplearn.flipapp.pagemodules.PrimeClassModule;
import com.fliplearn.flipapp.pagemodules.PrimePurchaseFlowModule;
import com.fliplearn.flipapp.pagemodules.PrimeSubjectModule;

public class PrimePurchaseFlow extends Base{
	
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
		 onbMod = new OnboardingModule(driver);;	 
	}

	
	
	  
	  @Test (dataProvider="allusers_old") public void
	  verifyPrimePurchaseFlowWithoutCouponWithFirTab(String role) throws
	  InterruptedException, IOException { 
		  
		  logMod.Login(role, "CBSE", "12",
	  "Single", "None", "Yes"); Thread.sleep(2000);
	  
	  try { if(priPurFloMod.cliOnSkiButt.isDisplayed()) priPurFloMod.clickOnSkip();
	  } catch(Exception e) { }
	  
	  leaMod.clickOnPrimeImage(); Thread.sleep(2000);
	  
	  if(role.equals("Admin" )|| role.equals("Principal")||role.equals("Teacher"))
	  { JavascriptExecutor js = (JavascriptExecutor) driver;
	  js.executeScript("window.scrollBy(0,1000)");
	  priClaMod.selectUserClass("Class 12"); Thread.sleep(2000);}
	  
	  priSubMod.clickOnSubject(driver, role, "Biology");
	  
	  assertEquals(generic.isElementDisplayed(driver, priPurFloMod.cliOnBuySubs),
	  true); priPurFloMod.clickOnBuySubs();
	  
	  Thread.sleep(2000);
	  
	  if(role.equals("Parent")) {
	  Assert.assertEquals(priPurFloMod.Childmsgverify.getText(),
	  "Please link your child to your account using the child's guardian code.");
	  priPurFloMod.clickOnCloseButton(); }
	  
	  else { assertEquals(priPurFloMod.verFlipPriSubs.getText()
	  ,"Fliplearn Prime Subscription"); priPurFloMod.clickOnConPay();
	  priPurFloMod.enterFirstName(); priPurFloMod.enterLastName();
	  
	  priPurFloMod.enteremailId(); priPurFloMod.enterMobileNo();
	  priPurFloMod.enterPinCode(); priPurFloMod.enterAddressLine();
	  Thread.sleep(5000); priPurFloMod.clickOnProceednPay();
	  
	  JavascriptExecutor js2= (JavascriptExecutor) driver;
	  js2.executeScript("arguments[0].click();", priPurFloMod.selDebitCard);
	  Thread.sleep(2000); priPurFloMod.clickOnPayNow();
	  //priPurFloMod.paymentDiscard();
	  
	  } }
	 
	
	
	  @Test (dataProvider="allusers_old") public void
	  verifyPrimePurchaseFlowWithoutCouponSecTab(String role) throws
	  InterruptedException, IOException{ 
		 
		  
		  logMod.Login(role, "CBSE", "12", "Single",
	  "None", "Yes");
	  
	  Thread.sleep(6000); try { if(priPurFloMod.cliOnSkiButt.isDisplayed())
	  priPurFloMod.clickOnSkip(); } catch(Exception e) { } Thread.sleep(2000);
	  
	  
	  leaMod.clickOnPrimeImage();
	  
	  JavascriptExecutor js = (JavascriptExecutor) driver;
	  js.executeScript("window.scrollBy(0,1000)");
	  
	  
	  
	  if(role.equals("Admin") || role.equals("Teacher") ||
	  role.equals("Principal")) { Thread.sleep(2000);
	  priClaMod.selectUserClass("Class 12"); } Thread.sleep(2000);
	  
	  
	  priSubMod.clickOnSubject(driver, role, "Biology"); Thread.sleep(2000);
	  
	  
	  js.executeScript("window.scrollBy(0,500)");
	  
	  
	  priPurFloMod.clickOnChapter(); priPurFloMod.clickOnTopic();
	  
	  Thread.sleep(2000);
	  
	  if(role.equals("Parent")) {
	  Assert.assertEquals(priPurFloMod.Childmsgverify.getText(),
	  "Please link your child to your account using the child's guardian code.");
	  priPurFloMod.clickOnCloseButton(); }
	  
	  else {
	  
	  assertEquals(priPurFloMod.verBuySubsMess.getText()
	  ,"Buy Fliplearn subscription and get World-class curated digital learning resources"
	  ); Thread.sleep(2000); priPurFloMod.clicOnSecBuySubs();
	  //priPurFloMod.clickOnSubs();
	  //assertEquals(priPurFloMod.compSubs.getText().trim(),priPurFloMod.
	  //compProducts.getText()); priPurFloMod.clickOnConPay();
	  //priPurFloMod.clickOnCheckOut(); priPurFloMod.enterFirstName();
	  priPurFloMod.enterLastName();
	  
	  priPurFloMod.enteremailId(); priPurFloMod.enterMobileNo();
	  priPurFloMod.enterPinCode(); priPurFloMod.enterAddressLine();
	  Thread.sleep(5000); priPurFloMod.clickOnProceednPay();
	  
	  JavascriptExecutor js2= (JavascriptExecutor) driver;
	  js2.executeScript("arguments[0].click();", priPurFloMod.selDebitCard);
	  Thread.sleep(2000); priPurFloMod.clickOnPayNow();
	  //priPurFloMod.paymentDiscard();
	  
	  } }
	 
	
	/**
	* verify PurchaseFlow on Web, Android, iOS  
	* @author Jagrati
	* @since 2019-01-18
	* @throws InterruptedException 
	* @version 1.3
	 * @throws IOException 
	
	*/
	
	@Test (dataProvider="allusers")
	public void verifyPrimePurchaseFlowWithCouponSecTab(String role) throws InterruptedException, IOException
	{
		//String role = "Student";
		logMod.Login(role, "CBSE", "12", "Single", "None", "Yes");	
		    		
		if(role.equals("Admin") || role.equals("Teacher") || role.equals("Principal")) 
		{
			leaMod.clickOnPrimeImage();
			Thread.sleep(2000);
			priClaMod.selectUserClass("Class 12");
		}
		Thread.sleep(2000);
		 
		
		priSubMod.clickOnSubject(driver, role, "Biology");
		Thread.sleep(2000);
			
		priPurFloMod.clickOnChapter();
		priPurFloMod.clickOnTopic();

		Thread.sleep(2000);
		
    	if(role.equals("Parent")) {
	    Assert.assertEquals(priPurFloMod.Childmsgverify.getText(), "Please link your child to your account using the child's guardian code.");
        priPurFloMod.clickOnCloseButton();
		}
		
		else {
	    
		assertEquals(priPurFloMod.verBuySubsMess.getText(),"Buy Fliplearn subscription and get World-class curated digital learning resources");
		Thread.sleep(2000);
		priPurFloMod.clicOnSecBuySubs();
		//priPurFloMod.clickOnSubs();
		priPurFloMod.enterCouponCode();
		priPurFloMod.cliOnAplButt();
		priPurFloMod.cliOnRemoveCoupon();
		
		}}

	/**
	* verify PurchaseFlow on Web, Android, iOS  
	* @author Jagrati
	* @since 2019-02-19
	* @throws InterruptedException 
	* @version 1.0
	 * @throws IOException 

	*/
	
	@Test (dataProvider="allusers_old")
	public void verifyPrimePurchaseFlowWithCouponWithFirTab(String role) throws InterruptedException, IOException {
		logMod.Login(role, "CBSE", "12", "Single", "None", "Yes");
		Thread.sleep(2000);
		    try 
	 	    {
	 	        if(priPurFloMod.cliOnSkiButt.isDisplayed()) 
	 	        	priPurFloMod.clickOnSkip();	
	 	    }
	 	    catch(Exception e) 
	 	    {
	 	    }
		leaMod.clickOnPrimeImage();
		Thread.sleep(2000);
		if(role.equals("Admin" )|| role.equals("Principal")||role.equals("Teacher")) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,1000)");
		//if(role.equals("Admin") || role.equals("Teacher") || role.equals("Principal")) {
			priClaMod.selectUserClass("Class 12");
	        Thread.sleep(2000);}
//		 if(role.equals("Parent")) {
//			 JavascriptExecutor js1 = (JavascriptExecutor) driver;
//				js1.executeScript("window.scrollBy(0,1000)");
//				}
//		
		priSubMod.clickOnSubject(driver, role, "Biology");
		
		
		assertEquals(generic.isElementDisplayed(driver, priPurFloMod.cliOnBuySubs), true);
		priPurFloMod.clickOnBuySubs();
		
		
		Thread.sleep(2000);
		
		if(role.equals("Parent")) {
	    	Assert.assertEquals(priPurFloMod.Childmsgverify.getText(), "Please link your child to your account using the child's guardian code.");
            priPurFloMod.clickOnCloseButton();
		}
		
		else {
			
       assertEquals(priPurFloMod.verFlipPriSubs.getText(),"Fliplearn Prime Subscription");
   	   //priPurFloMod.clickOnSubs();
		priPurFloMod.enterCouponCode();
		priPurFloMod.cliOnAplButt();
		priPurFloMod.cliOnRemoveCoupon();}}
	
	@Test (dataProvider="allusers_old")
	public void verifyPrimePurchaseFlowWithDiscountCouponFirTab(String role) throws InterruptedException, IOException {
		logMod.Login(role, "CBSE", "12", "Single", "None", "Yes");
		Thread.sleep(2000);
		    try 
	 	    {
	 	        if(priPurFloMod.cliOnSkiButt.isDisplayed()) 
	 	        	priPurFloMod.clickOnSkip();	
	 	    }
	 	    catch(Exception e) 
	 	    {
	 	    }
		leaMod.clickOnPrimeImage();
		Thread.sleep(2000);
		if(role.equals("Admin" )|| role.equals("Principal")||role.equals("Teacher")) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,1000)");
		//if(role.equals("Admin") || role.equals("Teacher") || role.equals("Principal")) {
			priClaMod.selectUserClass("Class 12");
	        Thread.sleep(2000);}
//		 if(role.equals("Parent")) {
//			 JavascriptExecutor js1 = (JavascriptExecutor) driver;
//				js1.executeScript("window.scrollBy(0,1000)");
//				}
//		
		priSubMod.clickOnSubject(driver, role, "Biology");
		
		
		assertEquals(generic.isElementDisplayed(driver, priPurFloMod.cliOnBuySubs), true);
		priPurFloMod.clickOnBuySubs();
		
		
		Thread.sleep(2000);
		
		if(role.equals("Parent")) {
	    	Assert.assertEquals(priPurFloMod.Childmsgverify.getText(), "Please link your child to your account using the child's guardian code.");
            priPurFloMod.clickOnCloseButton();
		}
		
		else {
			
       assertEquals(priPurFloMod.verFlipPriSubs.getText(),"Fliplearn Prime Subscription");
       //priPurFloMod.clickOnSubs();
		 priPurFloMod.entdisCoupCode();
		 priPurFloMod.cliOnAplButt();
		 priPurFloMod.cliOnRemoveCoupon();
 	}}
		

       @Test (dataProvider="allusers_old")
public void verifyPrimePurchaseFlowWithDiscountCouponWithSecTab(String role) throws InterruptedException, IOException{
    	   logMod.Login(role, "CBSE", "12", "Single", "None", "Yes");
   		
    	   Thread.sleep(6000);
		    try 
	 	    {
	 	        if(priPurFloMod.cliOnSkiButt.isDisplayed()) 
	 	        	priPurFloMod.clickOnSkip();	
	 	    }
	 	    catch(Exception e) 
	 	    {
	 	    }
       	 

  		 
  	    leaMod.clickOnPrimeImage();
  	    
  	    
  	    JavascriptExecutor js = (JavascriptExecutor) driver;
  		js.executeScript("window.scrollBy(0,1000)");
  	    
  	    
  			
  		if(role.equals("Admin") || role.equals("Teacher") || role.equals("Principal")) {
  		Thread.sleep(2000);
  		priClaMod.selectUserClass("Class 12");
  		}
  		Thread.sleep(2000);
  		 
  		
  		priSubMod.clickOnSubject(driver, role, "Biology");
  		Thread.sleep(2000);
  		
  		
  		js.executeScript("window.scrollBy(0,500)");
  		
  	
  		priPurFloMod.clickOnChapter();
  		priPurFloMod.clickOnTopic();

  		Thread.sleep(2000);
  		
      	if(role.equals("Parent")) {
  	    Assert.assertEquals(priPurFloMod.Childmsgverify.getText(), "Please link your child to your account using the child's guardian code.");
          priPurFloMod.clickOnCloseButton();
  		}
  		
  		else {
  	    
  		assertEquals(priPurFloMod.verBuySubsMess.getText(),"Buy Fliplearn subscription and get World-class curated digital learning resources");
  		Thread.sleep(2000);
		 priPurFloMod.clicOnSecBuySubs();
		 //priPurFloMod.clickOnSubs();
		 priPurFloMod.entdisCoupCode();
		 priPurFloMod.cliOnAplButt();
		 priPurFloMod.cliOnRemoveCoupon();
   	}}
       }




                                                                                                                                                                                                