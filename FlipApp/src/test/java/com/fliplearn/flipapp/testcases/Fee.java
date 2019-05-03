package com.fliplearn.flipapp.testcases;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.fliplearn.flipapp.helper.Base;
import com.fliplearn.flipapp.pagemodules.FeeModule;
import com.fliplearn.flipapp.pagemodules.LoginModule;

public class Fee extends Base 
{
	FeeModule feeMod;
	LoginModule logMod;
	Base base;
	String schoolName;

	@BeforeMethod
	public void beforMethodFee() 
	{
		feeMod=new FeeModule(driver);
		logMod = new LoginModule(driver);
		base=new Base();
	}
	
	/**
	 * Verify fee login Student And Parent by selecting debit card on Web, Android and iOS
	 * @author vinay kumar 
	 * @since 2018-09-30
	 * @version 1.3
	 * @throws Throwable 
	 */
	
	@Test(dataProvider="nostaff")
	public void payFeeLoginDebitCard(String role) throws IOException, InterruptedException 
	{
		logMod.Login(role, "CBSE", "6", "Single", "Prime", "Yes");
		feeMod.payFee(role, "Debit Card");
	}
	
	/**
	 * Verify fee without login  by selecting debit card on Web, Android and iOS
	 * @author vinay kumar 
	 * @since 2018-09-30
	 * @version 1.2
	 * @throws Throwable 
	 */
	
	@Test
	public void payFeeLogoutDebitCard() throws IOException, InterruptedException 
	{
		String role = "Logout";
		feeMod.payFee(role, "Debit Card");
	}
	
	
	/**
	 * Verify fee login with student parent by selecting net banking  on Web, Android and iOS
	 * @author vinay kumar 
	 * @since 2018-09-30
	 * @version 1.2
	 * @throws Throwable 
	 */
	
	@Test(dataProvider="nostaff")
	public void payFeeLoginNetBanking(String role) throws IOException, InterruptedException 
	{
		logMod.Login(role, "CBSE", "6", "Single", "Prime", "Yes");
		feeMod.payFee(role, "Net Banking");
	}
	/**
	 * Verify fee without login by selecting net banking  on Web, Android and iOS
	 * @author vinay kumar 
	 * @since 2018-09-30
	 * @version 1.2
	 * @throws Throwable 
	 */
	
	@Test
	public void payFeeLogoutNetBanking() throws IOException, InterruptedException 
	{
		String role = "Logout";
		feeMod.payFee(role, "Debit Card");
	}		
	
	
	/**
	 * Verify fee  login with student and parent by selecting upi  on Web, Android and iOS
	 * @author vinay kumar 
	 * @since 2018-09-30
	 * @version 1.3
	 * @throws Throwable 
	 */
	@Test(dataProvider="nostaff")
	public void payFeeLoginUPI(String role) throws IOException, InterruptedException
	{
		logMod.Login(role, "CBSE", "6", "Single", "Prime", "Yes");
		feeMod.payFee(role, "UPI");
	}
	
	/**
	 * Verify fee without login by selecting upi  on Web, Android and iOS
	 * @author vinay kumar 
	 * @since 2018-09-30
	 * @version 1.2
	 * @throws Throwable 
	 */
	@Test
	public void payFeeLogoutUPI() throws IOException, InterruptedException 
	{
		String role = "Logout";
		feeMod.payFee(role, "UPI");
	}
	
	/**
	 * Verify fee  login with student parent by selecting visa/master card on Web, Android and iOS
	 * @author vinay kumar 
	 * @since 2018-09-30
	 * @version 1.3
	 * @throws Throwable 
	 */
	
	@Test(dataProvider="nostaff")
	public void payFeeLoginVISA(String role) throws IOException, InterruptedException 
	{
		logMod.Login(role, "CBSE", "6", "Single", "Prime", "Yes");
		feeMod.payFee(role, "VISA");
	}
	
	/**
	 * Verify fee without login by selecting visa/master card on Web, Android and iOS
	 * @author vinay kumar 
	 * @since 2018-09-30
	 * @version 1.2
	 * @throws Throwable 
	 */
	
	@Test
	public void payFeeLogoutVISA() throws IOException, InterruptedException 
	{
		String role = "Logout";
		feeMod.payFee(role, "VISA");
	}
	
	
	/**
	 * Verify fee pay fee Login With Student amd parent  Selected By Amex login by selecting Amex card on Web, Android and iOS
	 * @author vinay kumar 
	 * @since 2018-09-30
	 * @version 1.2
	 * @throws Throwable 
	 */
	
	@Test(dataProvider = "nostaff")
	public void payFeeLoginAmex(String role) throws IOException, InterruptedException 
	{
		logMod.Login(role, "CBSE", "6", "Single", "Prime", "Yes");
		feeMod.payFee(role, "Amex");
	}

	
	/**
	 * Verify fee without login by selecting Amex card on Web, Android and iOS
	 * @author vinay kumar 
	 * @since 2018-09-30
	 * @version 1.3
	 * @throws Throwable 
	 */
	
	@Test
	public void payFeeLogoutAmex() throws IOException, InterruptedException 
	{
		String role = "Logout";
		feeMod.payFee(role, "Amex");
	}	
}

