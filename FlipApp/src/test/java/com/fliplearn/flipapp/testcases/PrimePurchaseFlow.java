package com.fliplearn.flipapp.testcases;

import static org.testng.Assert.assertEquals;

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
import com.fliplearn.flipapp.pagemodules.OnboardingModule;
import com.fliplearn.flipapp.pagemodules.PrimeChapterTopicModule;
import com.fliplearn.flipapp.pagemodules.PrimeClassModule;
import com.fliplearn.flipapp.pagemodules.PrimePurchaseFlowModule;
import com.fliplearn.flipapp.pagemodules.PrimeSubjectModule;

import com.fliplearn.flipapp.pagemodules.SignInAsModule;

import com.fliplearn.flipapp.pagemodules.YourProfileModule;

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
	public void preVerifyPrimePurchaseFlow() {
		
		
		logMod = new LoginModule(driver);
		mobNumMod = new MobileNumberModule(driver);
		menMod = new MenuModule(driver);
		leaMod = new LearnModule(driver);
		priClaMod =	new PrimeClassModule(driver);
		priSubMod = new PrimeSubjectModule(driver); 
		priPurFloMod= new PrimePurchaseFlowModule(driver);
		onbMod = new OnboardingModule(driver);
		 generic=new GenericFunctions();
		 
	}
	@Test (dataProvider="group0")
	public void verifyPrimePurchaseFlowWithoutCoupon(String role) throws InterruptedException {
		logMod.Login(role, "CBSE", "6", "Single", "None", "Yes");
		
        Thread.sleep(2000);
        onbMod.skipBtn.click();
		leaMod.clickOnLearnImage();
		leaMod.clickOnPrimeImage();
		if(role.equals("Admin") || role.equals("Teacher") || role.equals("Principal")) {
		priClaMod.selectUserClass("Class 6");}
		
		priSubMod.clickOnSubject(driver, role, "English");
		assertEquals(generic.isElementDisplayed(driver, priPurFloMod.cliOnBuySubs), true);
		priPurFloMod.clickOnBuySubs();
		
		if(role.equals("Parent")) {
	    	Assert.assertEquals(priPurFloMod.Childmsgverify.getText(), "Please link your child to your account using the child's guardian code.");
          priPurFloMod.clickOnCloseButton();
		}
		
		else {
		priPurFloMod.clickOnSubs();
		priPurFloMod.clickOnConPay();
		priPurFloMod.clickOnCheckOut();
		priPurFloMod.enterFirstName();
		priPurFloMod.enterLastName();
		
		priPurFloMod.enteremailId();
		priPurFloMod.enterMobileNo();
		priPurFloMod.enterPinCode();
		priPurFloMod.enterAddressLine();
		Thread.sleep(5000);
		priPurFloMod.clickOnProceednPay();
		priPurFloMod.selectDebitCard();
		Thread.sleep(5000);
		//priPurFloMod.ClickOnPayNow();
		//priPurFloMod.paymentDiscard();
		
		
		}
		
		}
	}


