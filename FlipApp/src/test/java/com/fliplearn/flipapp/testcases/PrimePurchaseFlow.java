
package com.fliplearn.flipapp.testcases;
import static org.testng.Assert.assertEquals;



import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;

import org.testng.Assert;
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

public class PrimePurchaseFlow extends Base
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
  
	@Test (dataProvider="allusers_old") 
	public void verifyPrimePurchaseFlowWithoutCouponWithFirTab(String role) throws InterruptedException, IOException 
	{ 
	  logMod.Login(role, "CBSE", "12", "Single", "None", "Yes"); Thread.sleep(2000);
	  
	  try 
	  { 
		  if(priPurFloMod.cliOnSkiButt.isDisplayed()) 
			  priPurFloMod.clickOnSkip();
	  } 
	  catch(Exception e) 
	  { 
		  
	  } 
	  
	  leaMod.clickOnPrimeImage(); Thread.sleep(2000);
	  
	  if(role.equals("Admin" )|| role.equals("Principal")||role.equals("Teacher"))
	  { 
		  JavascriptExecutor js = (JavascriptExecutor) driver;
		  js.executeScript("window.scrollBy(0,1000)");
		  priClaMod.selectUserClass("Class 12"); Thread.sleep(2000);
	  }
	  
	  priSubMod.clickOnSubject(driver, role, "Biology");
	  assertEquals(generic.isElementDisplayed(driver, priPurFloMod.cliOnBuySubs), true); 
	  priPurFloMod.clickOnBuySubs();
	  
	  Thread.sleep(2000);
	  
	  if(role.equals("Parent")) 
	  {
		  Assert.assertEquals(priPurFloMod.Childmsgverify.getText(),"Please link your child to your account using the child's guardian code.");
		  priPurFloMod.clickOnCloseButton(); 
	  }
	  
	  else 
	  { 
		  assertEquals(priPurFloMod.verFlipPriSubs.getText(), "Fliplearn Prime Subscription"); priPurFloMod.clickOnConPay();
		  priPurFloMod.enterFirstName(); priPurFloMod.enterLastName();
	  
		  priPurFloMod.enteremailId(); priPurFloMod.enterMobileNo();
		  priPurFloMod.enterPinCode(); priPurFloMod.enterAddressLine();
		  Thread.sleep(5000); 
		  priPurFloMod.clickOnProceednPay();
	  
		  JavascriptExecutor js2= (JavascriptExecutor) driver;
		  js2.executeScript("arguments[0].click();", priPurFloMod.selDebitCard);
		  Thread.sleep(2000); 
		  priPurFloMod.clickOnPayNow();
	  } 
	}

	  @Test (dataProvider="allusers_old") 
	  public void verifyPrimePurchaseFlowWithoutCouponSecTab(String role) throws InterruptedException, IOException
	  { 
		  logMod.Login(role, "CBSE", "12", "Single", "None", "Yes");
	  
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
	* verify User apply and remove coupon PurchaseFlow
	* Environment: Web, Android, iOS  
	* Role: Admin, Principal, Teacher, Parent, Student, Guest
	* @author Jagrati
	* @since 2019-02-19
	* @throws InterruptedException 
	* @version 1.0
	* @throws IOException 
	*/
	
	@Test(dataProvider="allusers_old")
	public void verifyCouponApplyAndRemove(String role) throws InterruptedException, IOException 
	{
		logMod.Login(role, "CBSE", "12", "Single", "None", "Yes");
		leaMod.clickOnPrimeImage();
		
		if(role.equals("Admin" )|| role.equals("Principal")||role.equals("Teacher")) 
		{
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,1000)");
			priClaMod.selectUserClass("Class 12");
	        Thread.sleep(2000);
	        
	        priSubMod.clickOnSubject(driver, role, "Biology");
	        priPurFloMod.clickOnBuySubs();
			Thread.sleep(2000);
			priPurFloMod.enterCouponCode();
			priPurFloMod.clickOnApplyBtn();
			priPurFloMod.cliOnRemoveCoupon();
		}	
		else if(role.equals("Parent")) 
		{
			 priSubMod.clickOnSubject(driver, role, "English");
			 priPurFloMod.clickOnBuySubs();
			 Thread.sleep(5000);
			 Assert.assertEquals(priPurFloMod.Childmsgverify.getText(), "Please link your child to your account using the child's guardian code.");
	    	 priPurFloMod.clickOnCloseButton();
			 Thread.sleep(5000);

		}
	}
}	                                                                                                                                                                                        