package com.fliplearn.flipapp.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.fliplearn.flipapp.helper.Base;
import com.fliplearn.flipapp.helper.GenericFunctions;
import com.fliplearn.flipapp.pagemodules.BookstoreProductListModule;
import com.fliplearn.flipapp.pagemodules.BookstoreSchoolModule;
import com.fliplearn.flipapp.pagemodules.HeaderModule;
import com.fliplearn.flipapp.pagemodules.LoginModule;
import com.fliplearn.flipapp.pagemodules.MobileNumberModule;
import com.fliplearn.flipapp.pagemodules.OnboardingModule;
import com.fliplearn.flipapp.pagemodules.ProfileHomeModule;
import com.fliplearn.flipapp.pagemodules.QuizModule;
import com.fliplearn.flipapp.pagemodules.YourProfileModule;

public class Bookstore extends Base
{
	GenericFunctions generic;
	LoginModule logMod;
	OnboardingModule onbMod;
	MobileNumberModule mobNumMod;
	QuizModule quiMod;
	YourProfileModule youProMod;
	HeaderModule heaMod;
	ProfileHomeModule proHomMod;
	BookstoreSchoolModule bookSchMod;
	BookstoreProductListModule bookProLisMod;
	
	@BeforeMethod
	public void befMethod()
	{
		logMod = new LoginModule(driver);
		onbMod = new OnboardingModule(driver);
		mobNumMod = new MobileNumberModule(driver);
		quiMod = new QuizModule(driver);
		youProMod = new YourProfileModule(driver);
		heaMod = new HeaderModule(driver);
		generic = new GenericFunctions();
		proHomMod = new ProfileHomeModule(driver);
		bookSchMod = new BookstoreSchoolModule(driver);
		bookProLisMod = new BookstoreProductListModule(driver);
	}
	
	@Test(dataProvider = "allusers")
	public void verifyBookstore(String role) throws InterruptedException
	{
		logMod.Login(role, "CBSE", "6", "Single", "Prime", "Yes");
		heaMod.buyBooksLnk.click();
		Assert.assertTrue(bookSchMod.bookstoreHeading.isDisplayed()) ;
	}
	
	@Test(dataProvider = "logout")
	public void verifyBookstoreLogout(String role) throws InterruptedException
	{
		heaMod.buyBooksLnk.click();
		Assert.assertTrue(bookSchMod.bookstoreHeading.isDisplayed()) ;
	}
	
	@Test(dataProvider = "allusers")
	public void verifySchoolSelection(String role) throws InterruptedException
	{
		logMod.Login(role, "CBSE", "6", "Single", "Prime", "Yes");
		heaMod.buyBooksLnk.click();
		bookSchMod.selectSchool("Text", "Fliplearn qa Automation Testing School");
		bookSchMod.proceedBtn.click();
		Assert.assertTrue(bookProLisMod.productListLbl.isDisplayed());
	}
	
	@Test(dataProvider = "logout")
	public void verifySchoolSelectionLogout(String role) throws InterruptedException
	{
		heaMod.buyBooksLnk.click();
		bookSchMod.selectSchool("Text", "Fliplearn qa Automation Testing School");
		bookSchMod.proceedBtn.click();
		Assert.assertTrue(bookProLisMod.productListLbl.isDisplayed());	
	}
	
	@Test(dataProvider = "logout")
	public void addRemoveCartItem(String role)
	{
		heaMod.buyBooksLnk.click();
		bookSchMod.selectSchool("Text", "Fliplearn qa Automation Testing School");
		bookSchMod.proceedBtn.click();
	}
}
