

package com.fliplearn.flipapp.testcases;


import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.fliplearn.flipapp.helper.Base;
import com.fliplearn.flipapp.pagemodules.FeeModule;
import com.fliplearn.flipapp.pagemodules.LoginModule;

public class Fee extends Base {
	FeeModule feeMod;
	LoginModule logMod;
	Base base;
	String schoolName;
	@BeforeMethod
	public void beforMethodFee() {
		feeMod=new FeeModule(driver);
		logMod = new LoginModule(driver);
		base=new Base();
		
	}
	
	/**
	 * Verify fee  login Student And Parent by selecting debit card on Web, Android and iOS
	 * @author vinay kumar 
	 * @since 2018-09-30
	 * @version 1.2
	 * @throws Throwable 
	 */
	
	@Test(dataProvider="group3")
	public void payFeeLoginStudentParentSelectedByDebitCard(String role) throws IOException, InterruptedException {
		base.readData(platform, "Guest", schoolName);
		logMod.Login(role, "Single", "None", "Yes");
		feeMod.clickOnPayfeeModForSchool();
		feeMod.selectSchoolToPayFee("Qa dashboard testing");
		feeMod.enterAdmission("1994");
		feeMod.clickOnProceedbtn();
		Assert.assertEquals(feeMod.getTotalFeeOnPopUp(),feeMod.getActualFeeOnPopUp());
		feeMod.fillAddress();
		feeMod.selectDebitCard();
		Assert.assertEquals(feeMod.getInternetPlusTotalOnAddressPage(), feeMod.gettotalFeeOnAddressPage());
		Assert.assertEquals(feeMod.gettotalFeeOnAddressPage(),feeMod.getTotalFeeOnPayBtn());
		feeMod.clickOnPayBtn();
		Assert.assertEquals(feeMod.getTotalFeeOnPayBtn(),feeMod.getTotalFeeOnPaymentGat());
		feeMod.clickOncancelBtn();

	}
	/**
	 * Verify fee without login  by selecting debit card on Web, Android and iOS
	 * @author vinay kumar 
	 * @since 2018-09-30
	 * @version 1.2
	 * @throws Throwable 
	 */
	
	@Test
	public void payFeeWithoutLoginSelectedByDebitCard() throws IOException, InterruptedException {
		base.readData(platform, "Guest", schoolName);
		feeMod.clickOnPayfeeMod();
		feeMod.selectSchoolToPayFee("Qa dashboard testing");
		feeMod.enterAdmission("1994");
		feeMod.clickOnProceedbtn();
		Assert.assertEquals(feeMod.getTotalFeeOnPopUp(),feeMod.getActualFeeOnPopUp());
		feeMod.fillAddress();
		feeMod.selectDebitCard();
		Assert.assertEquals(feeMod.getInternetPlusTotalOnAddressPage(), feeMod.gettotalFeeOnAddressPage());
		Assert.assertEquals(feeMod.gettotalFeeOnAddressPage(),feeMod.getTotalFeeOnPayBtn());
		feeMod.clickOnPayBtn();
		Assert.assertEquals(feeMod.getTotalFeeOnPayBtn(),feeMod.getTotalFeeOnPaymentGat());
		feeMod.clickOncancelBtn();
	}
	
	
	/**
	 * Verify fee login with student parent by selecting net banking  on Web, Android and iOS
	 * @author vinay kumar 
	 * @since 2018-09-30
	 * @version 1.2
	 * @throws Throwable 
	 */
	
	@Test(dataProvider="group3")
	public void payFeeLoginStudentParentSelectedByNetBanking(String role) throws IOException, InterruptedException {
		base.readData(platform, "Guest", schoolName);
		logMod.Login(role, "Single", "None", "Yes");
		feeMod.clickOnPayfeeModForSchool();
		feeMod.selectSchoolToPayFee("Qa dashboard testing");
		feeMod.enterAdmission("1994");
		feeMod.clickOnProceedbtn();
		Assert.assertEquals(feeMod.getTotalFeeOnPopUp(),feeMod.getActualFeeOnPopUp());
		feeMod.fillAddress();
		feeMod.selectNetbanking();
		Assert.assertEquals(feeMod.getInternetPlusTotalOnAddressPage(), feeMod.gettotalFeeOnAddressPage());
		Assert.assertEquals(feeMod.gettotalFeeOnAddressPage(),feeMod.getTotalFeeOnPayBtn());
		feeMod.clickOnPayBtn();
		Assert.assertEquals(feeMod.getTotalFeeOnPayBtn(),feeMod.getTotalFeeOnPaymentGat());
		feeMod.clickOncancelBtn();

	}
	/**
	 * Verify fee without login by selecting net banking  on Web, Android and iOS
	 * @author vinay kumar 
	 * @since 2018-09-30
	 * @version 1.2
	 * @throws Throwable 
	 */
	
	@Test
	public void payFeeWithoutLoginSelectedByNetBnking() throws IOException, InterruptedException {
		base.readData(platform, "Guest", schoolName);
		feeMod.clickOnPayfeeMod();
		feeMod.selectSchoolToPayFee("Qa dashboard testing");
		feeMod.enterAdmission("1994");
		feeMod.clickOnProceedbtn();
		Assert.assertEquals(feeMod.getTotalFeeOnPopUp(),feeMod.getActualFeeOnPopUp());
		feeMod.fillAddress();
		feeMod.selectNetbanking();
		Assert.assertEquals(feeMod.getInternetPlusTotalOnAddressPage(), feeMod.gettotalFeeOnAddressPage());
		Assert.assertEquals(feeMod.gettotalFeeOnAddressPage(),feeMod.getTotalFeeOnPayBtn());
		feeMod.clickOnPayBtn();
		Assert.assertEquals(feeMod.getTotalFeeOnPayBtn(),feeMod.getTotalFeeOnPaymentGat());
		feeMod.clickOncancelBtn();

	}
	
	
	/**
	 * Verify fee  login with student and parent by selecting upi  on Web, Android and iOS
	 * @author vinay kumar 
	 * @since 2018-09-30
	 * @version 1.2
	 * @throws Throwable 
	 */
	@Test(dataProvider="group3")
	public void payFeeLoginStudentParentSelectedByUpi(String role) throws IOException, InterruptedException {
		base.readData(platform, "Guest", schoolName);
		logMod.Login(role, "Single", "None", "Yes");
		feeMod.clickOnPayfeeModForSchool();
		feeMod.selectSchoolToPayFee("Qa dashboard testing");
		feeMod.enterAdmission("1994");
		feeMod.clickOnProceedbtn();
		Assert.assertEquals(feeMod.getTotalFeeOnPopUp(),feeMod.getActualFeeOnPopUp());
		feeMod.fillAddress();
		feeMod.selectUpi();
		Assert.assertEquals(feeMod.getInternetPlusTotalOnAddressPage(), feeMod.gettotalFeeOnAddressPage());
		Assert.assertEquals(feeMod.gettotalFeeOnAddressPage(),feeMod.getTotalFeeOnPayBtn());
		feeMod.clickOnPayBtn();
		Assert.assertEquals(feeMod.getTotalFeeOnPayBtn(),feeMod.getTotalFeeOnPaymentGat());
		feeMod.clickOncancelBtn();

	}
	/**
	 * Verify fee without login by selecting upi  on Web, Android and iOS
	 * @author vinay kumar 
	 * @since 2018-09-30
	 * @version 1.2
	 * @throws Throwable 
	 */
	@Test
	public void payFeeWithoutLoginSelectedByUpi() throws IOException, InterruptedException {
		base.readData(platform, "Guest", schoolName);
		feeMod.clickOnPayfeeMod();
		feeMod.selectSchoolToPayFee("Qa dashboard testing");
		feeMod.enterAdmission("1994");
		feeMod.clickOnProceedbtn();
		Assert.assertEquals(feeMod.getTotalFeeOnPopUp(),feeMod.getActualFeeOnPopUp());
		feeMod.fillAddress();
		feeMod.selectUpi();
		Assert.assertEquals(feeMod.getInternetPlusTotalOnAddressPage(), feeMod.gettotalFeeOnAddressPage());
		Assert.assertEquals(feeMod.gettotalFeeOnAddressPage(),feeMod.getTotalFeeOnPayBtn());
		feeMod.clickOnPayBtn();
		Assert.assertEquals(feeMod.getTotalFeeOnPayBtn(),feeMod.getTotalFeeOnPaymentGat());
		feeMod.clickOncancelBtn();

	}
	
	
	
	/**
	 * Verify fee  login with student parent by selecting visa/master card on Web, Android and iOS
	 * @author vinay kumar 
	 * @since 2018-09-30
	 * @version 1.2
	 * @throws Throwable 
	 */
	
	@Test(dataProvider="group3")
	public void payFeeLoginWithStudentParentSelectedByVisa(String role) throws IOException, InterruptedException {
		base.readData(platform, "Guest", schoolName);
		logMod.Login(role, "Single", "None", "Yes");
		feeMod.clickOnPayfeeModForSchool();
		feeMod.selectSchoolToPayFee("Qa dashboard testing");
		feeMod.enterAdmission("1994");
		feeMod.clickOnProceedbtn();
		Assert.assertEquals(feeMod.getTotalFeeOnPopUp(),feeMod.getActualFeeOnPopUp());
		feeMod.fillAddress();
		feeMod.selectVisa();
		Assert.assertEquals(feeMod.getInternetPlusTotalOnAddressPage(), feeMod.gettotalFeeOnAddressPage());
		Assert.assertEquals(feeMod.gettotalFeeOnAddressPage(),feeMod.getTotalFeeOnPayBtn());
		feeMod.clickOnPayBtn();
		Assert.assertEquals(feeMod.getTotalFeeOnPayBtn(),feeMod.getTotalFeeOnPaymentGat());
		feeMod.clickOncancelBtn();

	}
	/**
	 * Verify fee without login by selecting visa/master card on Web, Android and iOS
	 * @author vinay kumar 
	 * @since 2018-09-30
	 * @version 1.2
	 * @throws Throwable 
	 */
	
	@Test
	public void payFeeWithoutLoginSelectedByVisa() throws IOException, InterruptedException {
		base.readData(platform, "Guest", schoolName);
		feeMod.clickOnPayfeeMod();
		feeMod.selectSchoolToPayFee("Qa dashboard testing");
		feeMod.enterAdmission("1994");
		feeMod.clickOnProceedbtn();
		Assert.assertEquals(feeMod.getTotalFeeOnPopUp(),feeMod.getActualFeeOnPopUp());
		feeMod.fillAddress();
		feeMod.selectVisa();
		Assert.assertEquals(feeMod.getInternetPlusTotalOnAddressPage(), feeMod.gettotalFeeOnAddressPage());
		Assert.assertEquals(feeMod.gettotalFeeOnAddressPage(),feeMod.getTotalFeeOnPayBtn());
		feeMod.clickOnPayBtn();
		Assert.assertEquals(feeMod.getTotalFeeOnPayBtn(),feeMod.getTotalFeeOnPaymentGat());
		feeMod.clickOncancelBtn();

	}
	
	
	/**
	 * Verify fee login with Student parent by selecting visa/master card on Web, Android and iOS
	 * @author vinay kumar 
	 * @since 2018-09-30
	 * @version 1.2
	 * @throws Throwable 
	 */
	
	@Test(dataProvider="group3")
	public void payFeeLoginWithSelectedByVisa(String role) throws IOException, InterruptedException {
		base.readData(platform, "Guest", schoolName);
		logMod.Login(role, "Single", "None", "Yes");
		feeMod.clickOnPayfeeModForSchool();
		feeMod.selectSchoolToPayFee("Qa dashboard testing");
		feeMod.enterAdmission("1994");
		feeMod.clickOnProceedbtn();
		Assert.assertEquals(feeMod.getTotalFeeOnPopUp(),feeMod.getActualFeeOnPopUp());
		feeMod.fillAddress();
		feeMod.selectVisa();
		Assert.assertEquals(feeMod.getInternetPlusTotalOnAddressPage(), feeMod.gettotalFeeOnAddressPage());
		Assert.assertEquals(feeMod.gettotalFeeOnAddressPage(),feeMod.getTotalFeeOnPayBtn());
		feeMod.clickOnPayBtn();
		Assert.assertEquals(feeMod.getTotalFeeOnPayBtn(),feeMod.getTotalFeeOnPaymentGat());
		feeMod.clickOncancelBtn();

	}
	/**
	 * Verify fee without login by selecting Amex card on Web, Android and iOS
	 * @author vinay kumar 
	 * @since 2018-09-30
	 * @version 1.2
	 * @throws Throwable 
	 */
	
	@Test
	public void payFeeWithoutLoginSelectedByAmex() throws IOException, InterruptedException {
		base.readData(platform, "Guest", schoolName);
		feeMod.clickOnPayfeeMod();
		feeMod.selectSchoolToPayFee("Qa dashboard testing");
		feeMod.enterAdmission("1994");
		feeMod.clickOnProceedbtn();
		Assert.assertEquals(feeMod.getTotalFeeOnPopUp(),feeMod.getActualFeeOnPopUp());
		feeMod.fillAddress();
		feeMod.selectAmex();
		Assert.assertEquals(feeMod.getInternetPlusTotalOnAddressPage(), feeMod.gettotalFeeOnAddressPage());
		Assert.assertEquals(feeMod.gettotalFeeOnAddressPage(),feeMod.getTotalFeeOnPayBtn());
		feeMod.clickOnPayBtn();
		Assert.assertEquals(feeMod.getTotalFeeOnPayBtn(),feeMod.getTotalFeeOnPaymentGat());
		feeMod.clickOncancelBtn();

	}
	
	/**
	 * Verify fee pay fee Login With Student amd parent  Selected By Amex login by selecting Amex card on Web, Android and iOS
	 * @author vinay kumar 
	 * @since 2018-09-30
	 * @version 1.2
	 * @throws Throwable 
	 */
	
	@Test(dataProvider = "group3")
	public void payLoginWithStudentSelectedByAmex(String role) throws IOException, InterruptedException {
		base.readData(platform, "Guest", schoolName);
		logMod.Login(role, "Single", "None", "Yes");
		feeMod.clickOnPayfeeModForSchool();
		feeMod.selectSchoolToPayFee("Qa dashboard testing");
		feeMod.enterAdmission("1994");
		feeMod.clickOnProceedbtn();
		Assert.assertEquals(feeMod.getTotalFeeOnPopUp(),feeMod.getActualFeeOnPopUp());
		feeMod.fillAddress();
		feeMod.selectAmex();
		Assert.assertEquals(feeMod.getInternetPlusTotalOnAddressPage(), feeMod.gettotalFeeOnAddressPage());
		Assert.assertEquals(feeMod.gettotalFeeOnAddressPage(),feeMod.getTotalFeeOnPayBtn());
		feeMod.clickOnPayBtn();
		Assert.assertEquals(feeMod.getTotalFeeOnPayBtn(),feeMod.getTotalFeeOnPaymentGat());
		feeMod.clickOncancelBtn();

	}
	
	
	/**
	 * Verify fee  login with guest by selecting debit card on Web, Android and iOS
	 * @author vinay kumar 
	 * @since 2018-09-30
	 * @version 1.2
	 * @throws Throwable 
	 */

	@Test(dataProvider="group4")
	public void payFeeLoginWithGuestSelectedByAmex(String role) throws IOException, InterruptedException {
		base.readData(platform, "Guest", schoolName);
		logMod.Login(role, "Single", "None", "Yes");
		feeMod.clickOnPayfeeMod();
		feeMod.selectSchoolToPayFee("Qa dashboard testing");
		feeMod.enterAdmission("1994");
		feeMod.clickOnProceedbtn();
		Assert.assertEquals(feeMod.getTotalFeeOnPopUp(),feeMod.getActualFeeOnPopUp());
		feeMod.fillAddress();
		feeMod.selectAmex();
		Assert.assertEquals(feeMod.getInternetPlusTotalOnAddressPage(), feeMod.gettotalFeeOnAddressPage());
		Assert.assertEquals(feeMod.gettotalFeeOnAddressPage(),feeMod.getTotalFeeOnPayBtn());
		feeMod.clickOnPayBtn();
		Assert.assertEquals(feeMod.getTotalFeeOnPayBtn(),feeMod.getTotalFeeOnPaymentGat());
		feeMod.clickOncancelBtn();

	}
	/**
	 * Verify fee  login with guest by selecting debit card on Web, Android and iOS
	 * @author vinay kumar 
	 * @since 2018-09-30
	 * @version 1.2
	 * @throws Throwable 
	 */

	@Test(dataProvider="group4")
	public void payFeeLoginWithGuestSelectedByVisa(String role) throws IOException, InterruptedException {
		base.readData(platform, "Guest", schoolName);
		logMod.Login(role, "Single", "None", "Yes");
		feeMod.clickOnPayfeeMod();
		feeMod.selectSchoolToPayFee("Qa dashboard testing");
		feeMod.enterAdmission("1994");
		feeMod.clickOnProceedbtn();
		Assert.assertEquals(feeMod.getTotalFeeOnPopUp(),feeMod.getActualFeeOnPopUp());
		feeMod.fillAddress();
		feeMod.selectVisa();
		Assert.assertEquals(feeMod.getInternetPlusTotalOnAddressPage(), feeMod.gettotalFeeOnAddressPage());
		Assert.assertEquals(feeMod.gettotalFeeOnAddressPage(),feeMod.getTotalFeeOnPayBtn());
		feeMod.clickOnPayBtn();
		Assert.assertEquals(feeMod.getTotalFeeOnPayBtn(),feeMod.getTotalFeeOnPaymentGat());
		feeMod.clickOncancelBtn();

	}
	/**
	 * Verify fee  login with guest by selecting debit card on Web, Android and iOS
	 * @author vinay kumar 
	 * @since 2018-09-30
	 * @version 1.2
	 * @throws Throwable 
	 */

	@Test(dataProvider="group4")
	public void payFeeLoginWithGuestSelectedByUpi(String role) throws IOException, InterruptedException {
		base.readData(platform, "Guest", schoolName);
		logMod.Login(role, "Single", "None", "Yes");
		feeMod.clickOnPayfeeMod();
		feeMod.selectSchoolToPayFee("Qa dashboard testing");
		feeMod.enterAdmission("1994");
		feeMod.clickOnProceedbtn();
		Assert.assertEquals(feeMod.getTotalFeeOnPopUp(),feeMod.getActualFeeOnPopUp());
		feeMod.fillAddress();
		feeMod.selectUpi();
		Assert.assertEquals(feeMod.getInternetPlusTotalOnAddressPage(), feeMod.gettotalFeeOnAddressPage());
		Assert.assertEquals(feeMod.gettotalFeeOnAddressPage(),feeMod.getTotalFeeOnPayBtn());
		feeMod.clickOnPayBtn();
		Assert.assertEquals(feeMod.getTotalFeeOnPayBtn(),feeMod.getTotalFeeOnPaymentGat());
		feeMod.clickOncancelBtn();

	}
	


	/**
	 * Verify fee  login with guest by selecting debit card on Web, Android and iOS
	 * @author vinay kumar 
	 * @since 2018-09-30
	 * @version 1.2
	 * @throws Throwable 
	 */

	@Test(dataProvider="group4")
	public void payFeeLoginWithGuestSelectedByNetBanking(String role) throws IOException, InterruptedException {
		base.readData(platform, "Guest", schoolName);
		logMod.Login(role, "Single", "None", "Yes");
		feeMod.clickOnPayfeeMod();
		feeMod.selectSchoolToPayFee("Qa dashboard testing");
		feeMod.enterAdmission("1994");
		feeMod.clickOnProceedbtn();
		Assert.assertEquals(feeMod.getTotalFeeOnPopUp(),feeMod.getActualFeeOnPopUp());
		feeMod.fillAddress();
		feeMod.selectNetbanking();
		Assert.assertEquals(feeMod.getInternetPlusTotalOnAddressPage(), feeMod.gettotalFeeOnAddressPage());
		Assert.assertEquals(feeMod.gettotalFeeOnAddressPage(),feeMod.getTotalFeeOnPayBtn());
		feeMod.clickOnPayBtn();
		Assert.assertEquals(feeMod.getTotalFeeOnPayBtn(),feeMod.getTotalFeeOnPaymentGat());
		feeMod.clickOncancelBtn();

	}
	
	/**
	 * Verify fee  login with guest by selecting debit card on Web, Android and iOS
	 * @author vinay kumar 
	 * @since 2018-09-30
	 * @version 1.2
	 * @throws Throwable 
	 */

	@Test(dataProvider="group4")
	public void payFeeLoginWithGuestSelectedByDebitCard(String role) throws IOException, InterruptedException {
		base.readData(platform, "Guest", schoolName);
		logMod.Login(role, "Single", "None", "Yes");
		feeMod.clickOnPayfeeMod();
		feeMod.selectSchoolToPayFee("Qa dashboard testing");
		feeMod.enterAdmission("1994");
		feeMod.clickOnProceedbtn();
		Assert.assertEquals(feeMod.getTotalFeeOnPopUp(),feeMod.getActualFeeOnPopUp());
		feeMod.fillAddress();
		feeMod.selectDebitCard();
		Assert.assertEquals(feeMod.getInternetPlusTotalOnAddressPage(), feeMod.gettotalFeeOnAddressPage());
		Assert.assertEquals(feeMod.gettotalFeeOnAddressPage(),feeMod.getTotalFeeOnPayBtn());
		feeMod.clickOnPayBtn();
		Assert.assertEquals(feeMod.getTotalFeeOnPayBtn(),feeMod.getTotalFeeOnPaymentGat());
		feeMod.clickOncancelBtn();

	}
	
	
}

