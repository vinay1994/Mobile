package com.fliplearn.flipapp.pagemodules;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.fliplearn.flipapp.helper.Base;
import com.fliplearn.flipapp.helper.GenericFunctions;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class PrimePurchaseFlowModule extends Base
{
	GenericFunctions generic = new GenericFunctions();
	
	@FindBy(xpath="//*[text()='Skip']")
	public RemoteWebElement cliOnSkiButt;
	
	@FindBy(xpath="//*[text()='Buy Subscription']")
	public RemoteWebElement cliOnBuySubs;
	
	@FindBy(xpath="//*[text()='1 Year Subscription ']")
	public RemoteWebElement clickOnSub;
	
	
	@FindBy(name="state")
	public RemoteWebElement stateSelection;
	
	
	@FindBy(xpath="//div[text()='Close']")
    public RemoteWebElement cliOnClose;	
	
	@FindBy(xpath="//*[text()='Fliplearn Prime Subscription']")
	public RemoteWebElement verFlipPriSubs;
	
	@FindBy(xpath="//h1[@class='ng-binding' and text()='1 Year Subscription ']")
	public RemoteWebElement compSubs;
	
	@FindBy(xpath=" //div[@class='border-blue-1 border-radius4 padding20']/h3[text()='1 Year Subscription']")
	public RemoteWebElement compProducts;
	
	@FindBy(xpath="(//*[@class='border-blue-1 padding20 border-radius4 cursorPointer m-t-20 boxShadow ng-scope'])[1]")
	public RemoteWebElement cliOnsubs;
	
	@FindBy(xpath="//*[contains(text(),'Please link your child to your account ')]")
	public RemoteWebElement Childmsgverify;
	
	
	@FindBy(xpath="//*[contains(text(),'Transaction ID')]")
	public RemoteWebElement transActionText;
	
	@FindBy(xpath="//div[@id='cashcard']//a[contains(text(),'www.fliplearn.com')]")
	public RemoteWebElement cancelOrdr;
	
	@FindBy(xpath="//*[contains(text(),'Sorry, your payment could not be processed.')]")
	public RemoteWebElement cancelordrtxt;
	
	@FindBy(xpath="//button[text()='Confirm & Pay']")
	public RemoteWebElement cliOnConPay;
	
	@FindBy(xpath="//button[contains(text(),'Checkout')]")
	public RemoteWebElement cliOnCheOut;
	
    @FindBy(id="firstname")
    public RemoteWebElement entfirname;
	
	@FindBy(id="lastname")
	public RemoteWebElement entlasnam;
	
	@FindBy(id="email")
	public RemoteWebElement entemailid;
	
	@FindBy(id="mobile")
	public RemoteWebElement entmobno;
	
	@FindBy(id="pincode")
	public RemoteWebElement entpincod;
	
	@FindBy(id="addressline1")
	public RemoteWebElement entaddlin1;
	
	@FindBy(xpath="//button[contains(text(),'Proceed to Pay ')]")
	public RemoteWebElement clickOnProPay;
	
	@FindBy(xpath="//label[text()='Debit Card']")
	public RemoteWebElement selDebitCard;
	
	@FindBy(xpath="//*[text()='Pay Now']")
	public RemoteWebElement cliOnPayNow;
	
	@FindBy(xpath="//*[text()='www.fliplearn.com']")
	public RemoteWebElement payDiscard;
	
	@FindBy(xpath="(//h4[@class='panel-title'])[2]")
	public RemoteWebElement clickOnChap;
	
	@FindBy(xpath="//*[text()='Flower: A Fascinating Organ of Angiosperms']")
	public RemoteWebElement clickOnTop;
	
	@FindBy(xpath="//*[contains(text(),'Buy Fliplearn subscription and get World')]")
	public RemoteWebElement verBuySubsMess;
	
	@FindBy(xpath="//*[text()='Buy Fliplearn Subscription']")
	public RemoteWebElement cliOnBuyFliSub;
	
	@FindBy(xpath="//*[contains(text(),'Get 1 Year of Fliplearn Prime Subscription')]")
	public RemoteWebElement Oneyearsubscriptionlink;
	
	@FindBy(xpath="//*[@placeholder='Promotion Code']")
	public RemoteWebElement entCoupCode;
	
	@FindBy(css="button[class='btn btn-primary'][type='button']")
	public RemoteWebElement applyBtn;	
	
	@FindBy(xpath="//*[text()='Remove']")
	public RemoteWebElement removeCoupon;
	
	@FindBy(xpath="(//h1[@class='ng-binding'])[1]")
	public RemoteWebElement firstProductInList;
	
	
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
	
	public void cancelingOrder() {
		cancelOrdr.click();
		
		}
	
	
	
	  public void clickOnBuySubs()
	  { 
		  cliOnBuySubs.click(); 
	  }
	 
	
	public void clickOnSubsription() {
		
		clickOnSub.click();
		
	}
	public void selectingState() {
		Select drpState = new Select(stateSelection);
		drpState.selectByVisibleText("Andaman Nicobar");
		
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
	
	public void clickFirstSubscription()
	{
		firstProductInList.click();
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
		Oneyearsubscriptionlink.click();
		Thread.sleep(3000);
		entCoupCode.sendKeys("prime100");
	
	}
	
    public void clickOnApplyBtn() throws InterruptedException 
    {
    	Thread.sleep(3000);
    	applyBtn.click();
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


