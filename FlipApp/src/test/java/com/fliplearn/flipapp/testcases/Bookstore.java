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
	
	/**
	 * To Verify Bookstore Server is up and running
	 * @author Tarun Goswami
	 * @since 2019-04-11
	 * @version 1.2
	 * @throws InterruptedException 
	 */
	@Test(dataProvider = "allusers")
	public void verifyBookstore(String role) throws InterruptedException
	{
		logMod.Login(role, "CBSE", "6", "Single", "Prime", "Yes");
		heaMod.buyBooksLnk.click();
		Assert.assertTrue(bookSchMod.bookstoreHeading.isDisplayed()) ;
	}
	
	/**
	 * To Verify Bookstore Server is up and running
	 * @author Tarun Goswami
	 * @since 2019-04-11
	 * @version 1.2
	 * @throws InterruptedException 
	 */
	@Test(dataProvider = "logout")
	public void verifyBookstoreLogout(String role) throws InterruptedException
	{
		heaMod.buyBooksLnk.click();
		Assert.assertTrue(bookSchMod.bookstoreHeading.isDisplayed()) ;
	}
	
	
	/**
	 * To Verify User can select school
	 * @author Tarun Goswami
	 * @since 2019-04-11
	 * @version 1.2
	 * @throws InterruptedException 
	 */
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
	
	/**
	 * To Verify User can select school
	 * @author Tarun Goswami
	 * @since 2019-04-11
	 * @version 1.2
	 * @throws InterruptedException 
	 */
	@Test(dataProvider = "logout")
	public void verifySchoolSelectionLogout(String role) throws InterruptedException
	{
		heaMod.buyBooksLnk.click();
		bookSchMod.selectSchool("Text", "The Shriram Millennium School, Gurgaon");
		bookSchMod.proceedBtn.click();
		Assert.assertTrue(bookProLisMod.productListLbl.isDisplayed());	
	}
	
	/**
	 * Add and remove cart item
	 * @author Tarun Goswami
	 * @since 2019-04-11
	 * @version 1.2
	 * @throws InterruptedException 
	 */
	@Test(dataProvider = "allusers")
	public void addRemoveCartItem(String role) throws InterruptedException
	{
		logMod.Login(role, "CBSE", "6", "Single", "Prime", "Yes");
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
	
	/**
	 * Add and remove cart item
	 * @author Tarun Goswami
	 * @since 2019-04-11
	 * @version 1.2
	 * @throws InterruptedException 
	 */
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
	
	/**
	 * Verify Cart Item and Message
	 * @author Tarun Goswami
	 * @since 2019-04-11
	 * @version 1.2
	 * @throws InterruptedException 
	 */
	@Test(dataProvider = "allusers")
	public void verifyCartItemAndMessage(String role) throws InterruptedException
	{
		logMod.Login(role, "CBSE", "6", "Single", "Prime", "Yes");
		
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
	
	/**
	 * Verify Cart Item and Message
	 * @author Tarun Goswami
	 * @since 2019-04-11
	 * @version 1.2
	 * @throws InterruptedException 
	 */
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
	
	/**
	 * Clear shopping cart using clear shopping cart button
	 * @author Tarun Goswami
	 * @since 2019-04-11
	 * @version 1.2
	 * @throws InterruptedException 
	 */
	@Test(dataProvider = "allusers")
	public void clearShoppingCart(String role) throws InterruptedException
	{
		logMod.Login(role, "CBSE", "6", "Single", "Prime", "Yes");
		heaMod.buyBooksLnk.click();
		bookSchMod.selectSchool("Text", "The Shriram Millennium School, Gurgaon");
		bookSchMod.proceedBtn.click();
		
		bookProLisMod.studentName.sendKeys("Fliplearn QA");
		bookProLisMod.admissionNo.sendKeys("123456");
		bookProLisMod.addToCart.click();

		generic.waitForElementVisibility(driver, bookCarMod.cartItemCount);
		bookCarMod.cartIcon.click();
		
		bookCarMod.clearShoppingCart.click();
		Assert.assertEquals("You have no items in your shopping cart.", bookCarMod.noItemText.getText());

	}
	
	/**
	 * Clear shopping cart using clear shopping cart button
	 * @author Tarun Goswami
	 * @since 2019-04-11
	 * @version 1.2
	 * @throws InterruptedException 
	 */
	@Test(dataProvider = "logout")
	public void clearShoppingCartLogout(String role) throws InterruptedException
	{
		heaMod.buyBooksLnk.click();
		bookSchMod.selectSchool("Text", "The Shriram Millennium School, Gurgaon");
		bookSchMod.proceedBtn.click();
		
		bookProLisMod.studentName.sendKeys("Fliplearn QA");
		bookProLisMod.admissionNo.sendKeys("123456");
		bookProLisMod.addToCart.click();

		generic.waitForElementVisibility(driver, bookCarMod.cartItemCount);
		bookCarMod.cartIcon.click();
		
		bookCarMod.clearShoppingCart.click();
		Assert.assertEquals("You have no items in your shopping cart.", bookCarMod.noItemText.getText());
	}
	
	/**
	 * User can continue shopping after cart is cleared
	 * @author Tarun Goswami
	 * @since 2019-04-11
	 * @version 1.2
	 * @throws InterruptedException 
	 */
	@Test(dataProvider = "allusers")
	public void continueShoppingClearCart(String role) throws InterruptedException
	{
		logMod.Login(role, "CBSE", "6", "Single", "Prime", "Yes");
		heaMod.buyBooksLnk.click();
		String schoolName = "The Shriram Millennium School, Gurgaon";
		bookSchMod.selectSchool("Text", schoolName);
		bookSchMod.proceedBtn.click();
		
		bookProLisMod.studentName.sendKeys("Fliplearn QA");
		bookProLisMod.admissionNo.sendKeys("123456");
		bookProLisMod.addToCart.click();

		generic.waitForElementVisibility(driver, bookCarMod.cartItemCount);
		bookCarMod.cartIcon.click();
		
		bookCarMod.clearShoppingCart.click();
		generic.waitForElementVisibility(driver, bookCarMod.noItemText);
		bookCarMod.continueShoppingLnk.click();
		generic.waitForElementVisibility(driver, bookProLisMod.productListLbl);
		Assert.assertEquals(schoolName, bookProLisMod.getSelectedSchool());
	}
	
	/**
	 * User can continue shopping after cart is cleared
	 * @author Tarun Goswami
	 * @since 2019-04-11
	 * @version 1.2
	 * @throws InterruptedException 
	 */
	@Test(dataProvider = "logout")
	public void continueShoppingClearCartLogout(String role) throws InterruptedException
	{
		heaMod.buyBooksLnk.click();
		
		String schoolName = "The Shriram Millennium School, Gurgaon";
		bookSchMod.selectSchool("Text", schoolName);
		bookSchMod.proceedBtn.click();
		
		bookProLisMod.studentName.sendKeys("Fliplearn QA");
		bookProLisMod.admissionNo.sendKeys("123456");
		bookProLisMod.addToCart.click();

		generic.waitForElementVisibility(driver, bookCarMod.cartItemCount);
		bookCarMod.cartIcon.click();
		
		bookCarMod.clearShoppingCart.click();
		generic.waitForElementVisibility(driver, bookCarMod.noItemText);
		bookCarMod.continueShoppingLnk.click();
		generic.waitForElementVisibility(driver, bookProLisMod.productListLbl);
		Assert.assertEquals(schoolName, bookProLisMod.getSelectedSchool());	
	}
	
	/**
	 * User can filter for class item
	 * @author Tarun Goswami
	 * @since 2019-04-11
	 * @version 1.2
	 * @throws InterruptedException 
	 */
	@Test(dataProvider = "allusers")
	public void filterForClassItem(String role) throws InterruptedException
	{
		logMod.Login(role, "CBSE", "6", "Single", "Prime", "Yes");
		heaMod.buyBooksLnk.click();
		
		String schoolName = "The Shriram Millennium School, Gurgaon";
		bookSchMod.selectSchool("Text", schoolName);
		bookSchMod.proceedBtn.click();
		
		String className = "Class 4";
		bookProLisMod.selectClass(className);
		bookProLisMod.verifyClassItem(className);
	}	
	
	/**
	 * User can filter for class item
	 * @author Tarun Goswami
	 * @since 2019-04-11
	 * @version 1.2
	 * @throws InterruptedException 
	 */
	@Test(dataProvider = "logout")
	public void filterForClassItemLogout(String role) throws InterruptedException
	{
		heaMod.buyBooksLnk.click();
		
		String schoolName = "The Shriram Millennium School, Gurgaon";
		bookSchMod.selectSchool("Text", schoolName);
		bookSchMod.proceedBtn.click();
		
		String className = "Class 4";
		bookProLisMod.selectClass(className);
		bookProLisMod.verifyClassItem(className);
	}
}
