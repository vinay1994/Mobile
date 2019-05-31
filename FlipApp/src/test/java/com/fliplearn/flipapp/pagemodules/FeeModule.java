
package com.fliplearn.flipapp.pagemodules;

import java.text.DecimalFormat;
import java.util.List;

import org.apache.xmlbeans.impl.xb.ltgfmt.FileDesc.Role;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.fliplearn.flipapp.helper.Base;
import com.fliplearn.flipapp.helper.GenericFunctions;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;

public class FeeModule extends Base {
	GenericFunctions generic=new GenericFunctions();
	
	@FindBy(xpath="//li/a[text()='Pay Fee']")
	public  RemoteWebElement feeModuleBtn; 
	
	
	@FindBy(css="a[id='feePay_icon']")
	public  RemoteWebElement feeModule1Btn;
	
	@FindBy(css="select[name='schoolName']")
	public  RemoteWebElement selectSchooldropDwn;
	
	@FindBy(css="input[id='identifierName']")
	public  RemoteWebElement admissionNum;    

	
	@FindBy(xpath="//button[text()='Proceed']")
	public  RemoteWebElement proceedBtn; 
	
	@FindBy(xpath="//p[@class='ng-binding']")
	public  List<RemoteWebElement> getFeeAmount; 
	
	
	@FindBy(xpath="//button[text()='Confirm & Proceed']")
	public  RemoteWebElement ConfAndProceedBtn;  
			
			
	@FindBy(css="input[id='parentName']")
	public  RemoteWebElement parentNameTxt;	
	
	@FindBy(css="input[id='parentMobile']")
	public  RemoteWebElement parentMobNumTxt;
	
	@FindBy(css="input[id='parentEmail']")
	public  RemoteWebElement parentEmailIdTxt;
	
	
	@FindBy(css="input[id='parentAddress']")
	public  RemoteWebElement addressTxt;
	
	
	@FindBy(css="select[name='stateName']")
	public  RemoteWebElement stateNameTxt;
	
	
	@FindBy(xpath="//label[text()='Debit Card']")
	public  RemoteWebElement debitcartRd;
	
	@FindBy(xpath="//label[text()='Net Banking']")
	public  RemoteWebElement NetBnkingRd;
	
	@FindBy(xpath="//label[text()='UPI']")
	public  RemoteWebElement upiRd;
	
	
	@FindBy(xpath="//label[text()='Credit Card']")
	public  RemoteWebElement creditCardRd;
	
	@FindBy(xpath="//label[text()='Visa/Master']")
	public  RemoteWebElement visaRd;
	
	@FindBy(xpath="//label[text()='Amex']")
	public  RemoteWebElement amexRd; 
	
	@FindBy(xpath="//strong[@class='ng-binding']")
	public  RemoteWebElement getTotalPayableFee; 
	
	@FindBy(xpath="//p[@class='ng-binding']")
	public  RemoteWebElement getTotalPayableFeeOnaddress; 
	
	
	@FindBy(xpath="//button[@ng-click='payFee(feesForm)']")
	public  RemoteWebElement payBtn;
				
	@FindBy(css="span[id='totalAmount']")
	public  RemoteWebElement gettotalAmOnPaymentGat;	
	
	
	@FindBy(xpath="//a[text()='www.fliplearn.com']")
	public  RemoteWebElement cancelBtn;
	
	
	public FeeModule(WebDriver driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	public void clickOnPayfeeMod() throws InterruptedException 
	{
		Thread.sleep(2000);
		feeModuleBtn.click();
	}

	public void clickOnPayfeeModForSchool() {
			feeModule1Btn.click();
			}


	public void selectSchoolToPayFee(String schoolName) throws InterruptedException {
		generic.waitForElementVisibility(driver, selectSchooldropDwn);
		System.out.println(schoolName);
     generic.selectByVisibleText(selectSchooldropDwn, schoolName);
		
	}
	

	public void enterAdmission(String admNum) throws InterruptedException {
		Thread.sleep(2000);


		admissionNum.sendKeys(admNum);
	}
	public void clickOnProceedbtn() {
		proceedBtn.click();
	}
	
	public String getTotalFeeOnPopUp() throws InterruptedException {
		Thread.sleep(3000);
		Float totalAdmissinfee =Float.parseFloat(getFeeAmount.get(2).getText().substring(1));
		Float Totalcharge=Float.parseFloat(getFeeAmount.get(3).getText().substring(1));
		Float totalFee=totalAdmissinfee+Totalcharge;
		System.out.println("Before Format:"+totalFee);
		System.out.println(String.format("%.2f", totalFee));
		ConfAndProceedBtn.click();
		return String.format("%.2f", totalFee);
	}
	public String getActualFeeOnPopUp() {
		String tot = getFeeAmount.get(4).getText().substring(1);
		System.out.println(tot);
		return tot;
	}
	
	public String internetFeeOnAddressPage() {
		return getFeeAmount.get(1).getText().substring(1);
		
	}
	public String getInternetPlusTotalOnAddressPage() {
		float tot = (Float.parseFloat(internetFeeOnAddressPage()) + Float.parseFloat(getFeeAmount.get(0).getText().substring(1)));					
		return String.format("%.2f", tot);
		
	}
	public String gettotalFeeOnAddressPage() {
		return getTotalPayableFee.getText().substring(1);
		
	}
	public void fillAddress(String role) throws InterruptedException {
		Thread.sleep(3000);
		if(!role.equals("Logout"))
		driver.navigate().refresh();
		parentNameTxt.clear();
		parentNameTxt.sendKeys("Fliplearn QA");
		parentMobNumTxt.clear();
		parentMobNumTxt.sendKeys("9650423377");
		parentEmailIdTxt.sendKeys("qa@fliplearn.com");
		addressTxt.sendKeys("Dynamic House");
		generic.selectByVisibleText(stateNameTxt, "Delhi");
	}
	public void selectDebitCard() {
		debitcartRd.click();
	}
	
	public void selectNetbanking() {
		NetBnkingRd.click();
	}
	public void selectUPI() {
		upiRd.click();
	}
	public void selectVisa() {
		creditCardRd.click();
		visaRd.click();
	}
	
	public void selectAmex() {
		creditCardRd.click();
		amexRd.click();
	}
	public void clickOnPayBtn() {
		payBtn.click();
		
	}
	public String getTotalFeeOnPayBtn() {
		String tot = payBtn.getText().substring(5);
		return tot;
	}
	public void clickOncancelBtn() {
		cancelBtn.click();
		
	}
	public String getTotalFeeOnPaymentGat() {
		String tot = gettotalAmOnPaymentGat.getText().substring(0);
		return tot;
	}
	
	
	public void selectCardType(String cardType)
	{
		switch(cardType)
		{
			case "Debit Card": 
				selectDebitCard();
				break;
			case "Net Banking": 
				selectNetbanking();	
				break;
			case "UPI": 
				selectUPI();	
				break;	
			case "VISA": 
				creditCardRd.click();
				selectVisa();	
				break;	
			case "Amex":
				creditCardRd.click();
				selectAmex();
				break;	
			default:
				break;
		}
	}
	
	public void payFee(String role, String cardType) throws InterruptedException
	{
		
		if(role.equals("Guest") || role.equals("Logout"))
			clickOnPayfeeMod();
		else
			clickOnPayfeeModForSchool();
		
		selectSchoolToPayFee("Qa dashboard testing");
		enterAdmission("1994");
		clickOnProceedbtn();
		Assert.assertEquals(getTotalFeeOnPopUp(),getActualFeeOnPopUp());
		fillAddress(role);
		selectCardType(cardType);
		Assert.assertEquals(getInternetPlusTotalOnAddressPage(), gettotalFeeOnAddressPage());
		Assert.assertEquals(gettotalFeeOnAddressPage(),getTotalFeeOnPayBtn());
		clickOnPayBtn();
		Assert.assertEquals(getTotalFeeOnPayBtn(), getTotalFeeOnPaymentGat());
		clickOncancelBtn();
	}
}
