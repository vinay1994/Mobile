package com.fliplearn.flipapp.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.fliplearn.flipapp.helper.Base;
import com.fliplearn.flipapp.helper.GenericFunctions;
import com.fliplearn.flipapp.pagemodules.BookstoreCartModule;
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
	BookstoreCartModule bookCarMod;
	
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
		bookCarMod = new BookstoreCartModule(driver);
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
		Thread.sleep(5000);
		heaMod.buyBooksLnk.click();
		bookSchMod.selectSchool("Text", "The Shriram Millennium School, Gurgaon");
		bookSchMod.proceedBtn.click();
		Assert.assertTrue(bookProLisMod.productListLbl.isDisplayed());
	}
	
	@Test(dataProvider = "logout")
	public void verifySchoolSelectionLogout(String role) throws InterruptedException
	{
		heaMod.buyBooksLnk.click();
		bookSchMod.selectSchool("Text", "The Shriram Millennium School, Gurgaon");
		bookSchMod.proceedBtn.click();
		Assert.assertTrue(bookProLisMod.productListLbl.isDisplayed());	
	}
	
	@Test(dataProvider = "allusers")
	public void addRemoveCartItem(String role) throws InterruptedException
	{
		logMod.Login(role, "CBSE", "6", "Single", "Prime", "Yes");
		Thread.sleep(5000);
		heaMod.buyBooksLnk.click();
		bookSchMod.selectSchool("Text", "The Shriram Millennium School, Gurgaon");
		bookSchMod.proceedBtn.click();
		
		bookProLisMod.studentName.sendKeys("Fliplearn QA");
		bookProLisMod.admissionNo.sendKeys("123456");
		bookProLisMod.addToCart.click();

		generic.waitForElementVisibility(driver, bookCarMod.cartItemCount);
		bookCarMod.cartIcon.click();
		
		bookCarMod.removeCartItem("All");
		Assert.assertEquals("You have no items in your shopping cart.", bookCarMod.noItemText.getText());

	}
	
	@Test(dataProvider = "logout")
	public void addRemoveCartItemLogout(String role) throws InterruptedException
	{
		heaMod.buyBooksLnk.click();
		bookSchMod.selectSchool("Text", "The Shriram Millennium School, Gurgaon");
		bookSchMod.proceedBtn.click();
		
		bookProLisMod.studentName.sendKeys("Fliplearn QA");
		bookProLisMod.admissionNo.sendKeys("123456");
		bookProLisMod.addToCart.click();

		generic.waitForElementVisibility(driver, bookCarMod.cartItemCount);
		bookCarMod.cartIcon.click();
		
		bookCarMod.removeCartItem("All");
		Assert.assertEquals("You have no items in your shopping cart.", bookCarMod.noItemText.getText());

	}
	
	@Test(dataProvider = "allusers")
	public void verifyCartItemAndMessage(String role) throws InterruptedException
	{
		logMod.Login(role, "CBSE", "6", "Single", "Prime", "Yes");
		Thread.sleep(5000);
		
		heaMod.buyBooksLnk.click();
		bookSchMod.selectSchool("Text", "The Shriram Millennium School, Gurgaon");
		bookSchMod.proceedBtn.click();
		
		String itemTitle = bookProLisMod.ItemTitle.get(0).getText();
		System.out.println("Item Title is:"+itemTitle);
		String expectedTitle = "You have added " + itemTitle + " to your shopping cart.";
		System.out.println("Expected Title is:"+expectedTitle);
		
		bookProLisMod.studentName.sendKeys("Fliplearn QA");
		bookProLisMod.admissionNo.sendKeys("123456");
		bookProLisMod.addToCart.click();

		generic.waitForElementVisibility(driver, bookCarMod.cartItemCount);	
		String ExpectedCount = bookCarMod.cartItemCount.getText();
				
		if(Integer.parseInt(ExpectedCount) >= 3)
		{
			String expectedText = bookCarMod.cartItemMessage.getText();
			Assert.assertEquals(expectedText, expectedTitle);
		}
		
		generic.waitForElementVisibility(driver, bookCarMod.cartItemCount);
		bookCarMod.cartIcon.click();
		
		bookCarMod.removeCartItem("All");
	}
	
	@Test(dataProvider = "logout")
	public void verifyCartItemAndMessageLogout(String role) throws InterruptedException
	{
		heaMod.buyBooksLnk.click();
		bookSchMod.selectSchool("Text", "The Shriram Millennium School, Gurgaon");
		bookSchMod.proceedBtn.click();
		
		String itemTitle = bookProLisMod.ItemTitle.get(0).getText();
		System.out.println("Item Title is:"+itemTitle);
		String expectedTitle = "You have added " + itemTitle + " to your shopping cart.";
		System.out.println("Expected Title is:"+expectedTitle);
		
		bookProLisMod.studentName.sendKeys("Fliplearn QA");
		bookProLisMod.admissionNo.sendKeys("123456");
		bookProLisMod.addToCart.click();

		generic.waitForElementVisibility(driver, bookCarMod.cartItemCount);	
		String ExpectedCount = bookCarMod.cartItemCount.getText();
				
		if(Integer.parseInt(ExpectedCount) >= 3)
		{
			String expectedText = bookCarMod.cartItemMessage.getText();
			Assert.assertEquals(expectedText, expectedTitle);
		}
		
		generic.waitForElementVisibility(driver, bookCarMod.cartItemCount);
		bookCarMod.cartIcon.click();
		
		bookCarMod.removeCartItem("All");
	}
	
	
}
