
package com.fliplearn.flipapp.pagemodules;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fliplearn.flipapp.helper.Base;
import com.fliplearn.flipapp.helper.GenericFunctions;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;

public class PrimeResourceListModule extends Base {
	GenericFunctions generic = new GenericFunctions();
	@FindBy(xpath = "//*[text()='Fliplearn Prime']")
	public RemoteWebElement flipLearnPrimeTile;

	@FindBy(xpath = "//*[text()='Mathematics']")
	public RemoteWebElement primeSubject;

	@FindBy(xpath = "//*[text()='View all sample content']")
	public RemoteWebElement viewAllSampleTxt;

	@FindBy(css = "#bookstore-icon")
	public RemoteWebElement buyBook;

	@FindBy(xpath = "//*[text()='Fliplearn Book Store']")
	public RemoteWebElement textOnBuyBookPage;
	
	@FindBy(xpath = "//*[text()='Proceed to Checkout']")
	public RemoteWebElement proceedToCheckoutButton;
	
	@FindBy(xpath = "//*[text()='Next']")
	public RemoteWebElement nextButton;
	
	@FindBy(xpath = "//*[text()='Apply Discount Code']")
	public RemoteWebElement applyDiscountCodeDropDown;
	
	@FindBy(css = "#discount-code")
	public RemoteWebElement discountCodeField;
	
	@FindBy(xpath = "//*[text()='Apply Discount']")
	public RemoteWebElement applyDiscountButton;
	
	@FindBy(xpath = "//*[text()='Invalid Coupon Code']")
	public RemoteWebElement invalidCouponMsg;
	
	@FindBy(css = ".uk-icon-cart-arrow-down")
	public RemoteWebElement cartOption;

	@FindBy(xpath = "//h4[@class='ng-scope']")
	public RemoteWebElement textToIdentifyParent;

	@FindBy(xpath = "//*[text()='Basic concept of Decimal']")
	public RemoteWebElement demoVideo;

	@FindBy(xpath = "//a[contains(text(),'Class 10')]")
	@AndroidFindBy(xpath = "//*[@text='Class 7']")
	public RemoteWebElement claConMod;

	@FindBy(xpath = "(//div[@class='col-md-9 col-sm-8 col-xs-8']//h3[text()='Biology'])[2]")
	@AndroidFindBy(xpath = "//*[@text='Mathematics']")
	public RemoteWebElement cliOnSubCon;

	@FindBy(xpath = "//a[text()='1. Life Processes']")
	@AndroidFindBy(xpath = "//*[@text='Integers']")
	public RemoteWebElement cliOnBook;

	@FindBy(xpath = "//li[text()='Nutrition in Human Beings']")
	@AndroidFindBy(xpath = "//*[@text='Integers']")
	public RemoteWebElement cliOnBookTopCon;

	@FindBy(xpath = "//h4[text()='Digestion']")
	@AndroidFindBy(xpath = "(//*[@text='Animation'])[1]")
	public RemoteWebElement cliOnVidCon;

	@FindBy(xpath = "//div[@class='row learnResourcesInner']//h6[text()='Real Life Application']")
	@AndroidFindBy(xpath = "//*[@text='Real Life Application']")
	public RemoteWebElement realLife;

	@FindBy(xpath = "//div[@class='row learnResourcesInner']//h6[text()='Topic Synopsis']/preceding-sibling::img")
	@AndroidFindBy(xpath = "//*[@text='Topic Synopsis']")
	public RemoteWebElement topicSynopsis;

	@FindBy(xpath = "//div[@class='row learnResourcesInner']//h6[text()='Mind Maps']")
	@AndroidFindBy(xpath = "//*[@text='Mind Maps']")
	public RemoteWebElement mindMaps;

	@FindBy(xpath = "//div[@class='row learnResourcesInner']//h6[text()='Interactive Worksheet']")
	@AndroidFindBy(xpath = "//*[@text='Mind Maps']")
	public RemoteWebElement interactiveWorksheet;

	@FindBy(xpath = "(//div[@class='modal-body head_bottom'])[4]//h4")
	public RemoteWebElement childAccessMsg;

	public PrimeResourceListModule(WebDriver driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	public void clickOnClassContent() {
		claConMod.click();
	}

	public void clickOnSubjectContent() {
		cliOnSubCon.click();

	}

	public void clickOnBookChapter(WebDriver driver, String chapterName) throws InterruptedException {
		if (platform.equals("Web"))
			driver.findElement(By.partialLinkText(chapterName)).click();

		else if (platform.equals("iOS"))
			driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='" + chapterName + "']")).click();

		else
			driver.findElement(By.xpath("//*[@text='" + chapterName + "']")).click();
		;
	}

	public void clickOnChapterTopic(WebDriver driver, String topicName) {
		if (platform.equals("Web"))
			driver.findElement(By.xpath("//li[text()='" + topicName + "']")).click();
		else if (platform.equals("iOS"))
			driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='" + topicName + "']")).click();
		else
			driver.findElement(By.xpath("//*[@text='" + topicName + "']")).click();
		;
	}

	public void clickOnTopicResource(WebDriver driver, String resource) {
		if (platform.equals("Web"))
			driver.findElement(By.xpath("//h4[text()='" + resource + "']")).click();
		else if (platform.equals("iOS"))
			driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='" + resource + "']")).click();
		else
			driver.findElement(By.xpath("//*[@text='" + resource + "']")).click();
		;
	}

	public void clickOnVideoContent() throws InterruptedException {
		generic.waitForElementVisibility(driver, cliOnVidCon);
		cliOnVidCon.click();
	}

	public void clickOnRealLifeApplication() throws InterruptedException {
		generic.waitForElementVisibility(driver, realLife);
		realLife.click();
		Thread.sleep(3000);
	}

	public void clickOnInteractiveWorksheet() throws InterruptedException {
		generic.waitForElementVisibility(driver, interactiveWorksheet);
		interactiveWorksheet.click();
		Thread.sleep(3000);
	}

	public void clickOnTopicSynopsis() throws InterruptedException {
		generic.waitForElementVisibility(driver, topicSynopsis);
		topicSynopsis.click();
		Thread.sleep(3000);
	}

	public void clickOnMindMaps() throws InterruptedException {
		generic.waitForElementVisibility(driver, mindMaps);
		mindMaps.click();
		Thread.sleep(3000);
	}

	public void clickOnViewAllSample(WebDriver driver) {
		driver.findElement(By.linkText("View all sample content")).click();
	}

	public void clickOnPrimeTile() {

		flipLearnPrimeTile.click();
		primeSubject.click();

	}

	public void playingDemoVideos() throws InterruptedException {

		demoVideo.click();
		generic.verifyVideoContent(driver);

	}

	public void clickingOnBuyBookOption() {
		buyBook.click();
	}

	public void clickingOnCartMenu() {
		cartOption.click();

	}
	
	
	public void enterIncorrectCouponCode() throws InterruptedException {
		//Thread.sleep(3000);
		proceedToCheckoutButton.click();
		Thread.sleep(3000);

		nextButton.click();
		Thread.sleep(3000);

		applyDiscountCodeDropDown.click();
		//Thread.sleep(3000);

		discountCodeField.sendKeys("xyz");
		//Thread.sleep(3000);

		applyDiscountButton.click();
		//Thread.sleep(3000);

	}
	
	
	

}
