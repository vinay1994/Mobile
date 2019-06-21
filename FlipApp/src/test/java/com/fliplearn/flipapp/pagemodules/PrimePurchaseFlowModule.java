package com.fliplearn.flipapp.pagemodules;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fliplearn.flipapp.helper.Base;
import com.fliplearn.flipapp.helper.GenericFunctions;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;

public class PrimePurchaseFlowModule extends Base{
	GenericFunctions generic = new GenericFunctions();
	
	@FindBy(xpath="//*[text()='Skip']")
	public RemoteWebElement cliOnSkiButt;
	
	@FindBy(xpath="//a[text()='Buy Subscription']")
	@AndroidFindBy()
	@iOSFindBy()
	public RemoteWebElement cliOnBuySubs;
	
	@FindBy(xpath="//div[text()='Close']")
	@AndroidFindBy()
	@iOSFindBy()
    public RemoteWebElement cliOnClose;	
	
	@FindBy(xpath="//*[text()='Fliplearn Prime Subscription']")
	@AndroidFindBy()
	@iOSFindBy()
	public RemoteWebElement verFlipPriSubs;
	
	@FindBy(xpath="//h1[@class='ng-binding' and text()='1 Year Subscription ']")
	@AndroidFindBy()
	@iOSFindBy()
	public RemoteWebElement compSubs;
	
	@FindBy(xpath=" //div[@class='border-blue-1 border-radius4 padding20']/h3[text()='1 Year Subscription']")
	@AndroidFindBy()
	@iOSFindBy()
	public RemoteWebElement compProducts;
	
	@FindBy(xpath="(//*[@class='border-blue-1 padding20 border-radius4 cursorPointer m-t-20 boxShadow ng-scope'])[1]")
	@AndroidFindBy()
	@iOSFindBy()
	public RemoteWebElement cliOnsubs;
	
	@FindBy(xpath="//*[contains(text(),'Please link your child to your account ')]")
	@AndroidFindBy()
	@iOSFindBy()
	public RemoteWebElement Childmsgverify;
	
	@FindBy(xpath="//button[text()='Confirm & Pay']")
	@AndroidFindBy()
	@iOSFindBy()
	public RemoteWebElement cliOnConPay;
	
	@FindBy(xpath="//button[contains(text(),'Checkout')]")
	@AndroidFindBy()
	@iOSFindBy()
	public RemoteWebElement cliOnCheOut;
	
    @FindBy(id="firstname")
	@AndroidFindBy()
	@iOSFindBy()
    public RemoteWebElement entfirname;
	
	@FindBy(id="lastname")
	@AndroidFindBy()
	@iOSFindBy()
	public RemoteWebElement entlasnam;
	
	@FindBy(id="email")
	@AndroidFindBy()
	@iOSFindBy()
	public RemoteWebElement entemailid;
	
	@FindBy(id="mobile")
	@AndroidFindBy()
	@iOSFindBy()
	public RemoteWebElement entmobno;
	
	@FindBy(id="pincode")
	@AndroidFindBy()
	@iOSFindBy()
	public RemoteWebElement entpincod;
	
	@FindBy(id="addressline1")
	@AndroidFindBy()
	@iOSFindBy()
	public RemoteWebElement entaddlin1;
	
	@FindBy(xpath="//button[contains(text(),'Proceed to Pay ')]")
	@AndroidFindBy()
	@iOSFindBy()
	public RemoteWebElement clickOnProPay;
	
	@FindBy(xpath="//label[text()='Debit Card']")
	@AndroidFindBy()
	@iOSFindBy()
	public RemoteWebElement selDebitCard;
	
	@FindBy(xpath="//*[text()='Pay Now']")
	@AndroidFindBy()
	@iOSFindBy()
	public RemoteWebElement cliOnPayNow;
	
	@FindBy(xpath="//*[text()='www.fliplearn.com']")
	@AndroidFindBy()
	@iOSFindBy()
	public RemoteWebElement payDiscard;
	
	@FindBy(xpath="//*[text()='2. Sexual Reproduction in Flowering Plants']")
	@AndroidFindBy()
	@iOSFindBy()
	public RemoteWebElement clickOnChap;
	
	@FindBy(xpath="//*[text()='Flower: A Fascinating Organ of Angiosperms']")
	@AndroidFindBy()
	@iOSFindBy()
	public RemoteWebElement clickOnTop;
	
	@FindBy(xpath="//*[contains(text(),'Buy Fliplearn subscription and get World')]")
	@AndroidFindBy()
	@iOSFindBy()
	public RemoteWebElement verBuySubsMess;
	
	@FindBy(xpath="//*[text()='Buy Fliplearn Subscription']")
	@AndroidFindBy()
	@iOSFindBy()
	public RemoteWebElement cliOnBuyFliSub;
	
	@FindBy(xpath="//*[@placeholder='Promotion Code']")
	@AndroidFindBy()
    @iOSFindBy()
	public RemoteWebElement entCoupCode;
	
	@FindBy(xpath="//*[text()='Apply']")
	@AndroidFindBy()
	@iOSFindBy()
	public RemoteWebElement clicOnApply;	
	
	@FindBy(xpath="//*[text()='Remove']")
	@AndroidFindBy()
	@iOSFindBy()
	public RemoteWebElement removeCoupon;
	
	
	public PrimePurchaseFlowModule(WebDriver driver)
	{
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
	
	public void clickOnChapter() throws InterruptedException {
		generic.waitForElementVisibility(driver, clickOnChap);
		Actions action = new Actions(driver);
		action.moveToElement(clickOnChap).click().perform();
		
		
	}
	
	public void clickOnTopic() {
		clickOnTop.click();
		
	}
	
	
	public void clickOnBuySubs() {
		cliOnBuySubs.click();
		}
	
	public void clickOnCloseButton() {
		cliOnClose.click();
	}
	public void clickOnSubs() {
		cliOnsubs.click();
	}
	public void clickOnConPay() throws InterruptedException {
		Thread.sleep(2000);
		cliOnConPay.sendKeys(Keys.ENTER);
	}
	public void clickOnCheckOut() {
		cliOnCheOut.click();
	}
	public void enterFirstName() {
		entfirname.sendKeys("Auto");
		
    }
	public void enterLastName() {
	entlasnam.sendKeys("mation");
	}
	public void enteremailId() {
		entemailid.clear();
	entemailid.sendKeys("automation@fliplearn.com");
	}
	public void enterMobileNo() {
		entmobno.clear();
	entmobno.sendKeys("9650423377");
    }
	public void enterPinCode() {
	entpincod.sendKeys("122002");
    }
	public void enterAddressLine() {
	entaddlin1.sendKeys("fliplearn");
	}
	public void clickOnProceednPay() {
		//clickOnProPay.sendKeys(Keys.ENTER);
		clickOnProPay.click();
	}
	//public void selectDebitCard() {
		
		//selDebitCard.click();
	//}
	public void clickOnPayNow() {
		cliOnPayNow.click();
	}
	public void paymentDiscard() {
		payDiscard.click();
	}
	
	public void clicOnSecBuySubs() {
		cliOnBuyFliSub.click();
	}
	
	public void enterCouponCode() throws InterruptedException {
		Thread.sleep(3000);
		entCoupCode.sendKeys("vinay-100");
	
	}
	
    public void cliOnAplButt() {
    	clicOnApply.click();
	}
    
    public void cliOnRemoveCoupon() {
    	removeCoupon.click();
    }
    
    public void entdisCoupCode() throws InterruptedException {
    	Thread.sleep(3000);
    	entCoupCode.sendKeys("vinay30");
    	
    }

	public void clickOnSkip() {
		cliOnSkiButt.click();
		
		
	}
    
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


