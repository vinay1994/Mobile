
package com.fliplearn.flipapp.pagemodules;

import java.text.DecimalFormat;
import java.util.List;

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

public class FeeModule extends Base {
	GenericFunctions generic=new GenericFunctions();
	
	@FindBy(css="a[ui-sref='feePayment']")
	@AndroidFindBy(id="") 
	@iOSFindBy(id="")
	public  RemoteWebElement feeModuleBtn; 
	
	
	@FindBy(css="a[id='feePay_icon']")
	@AndroidFindBy(id="") 
	@iOSFindBy(id="")
	public  RemoteWebElement feeModule1Btn;
	
	@FindBy(css="select[name='schoolName']")
	@AndroidFindBy(id="") 
	@iOSFindBy(id="")
	public  RemoteWebElement selectSchooldropDwn;
	
	@FindBy(css="input[id='identifierName']")
	@AndroidFindBy(id="") 
	@iOSFindBy(id="")
	public  RemoteWebElement admissionNum;    

	
	@FindBy(xpath="//button[text()='Proceed']")
	@AndroidFindBy(id="") 
	@iOSFindBy(id="")
	public  RemoteWebElement proceedBtn; 
	
	@FindBy(xpath="//p[@class='ng-binding']")
	@AndroidFindBy(id="") 
	@iOSFindBy(id="")
	public  List<RemoteWebElement> getFeeAmount; 
	
	
	@FindBy(xpath="//button[text()='Confirm & Proceed']")
	@AndroidFindBy(id="") 
	@iOSFindBy(id="")
	public  RemoteWebElement ConfAndProceedBtn;  
			
			
	@FindBy(css="input[id='parentName']")
	@AndroidFindBy(id="") 
	@iOSFindBy(id="")
	public  RemoteWebElement parentNameTxt;	
	
	@FindBy(css="input[id='parentMobile']")
	@AndroidFindBy(id="") 
	@iOSFindBy(id="")
	public  RemoteWebElement parentMobNumTxt;
	
	@FindBy(css="input[id='parentEmail']")
	@AndroidFindBy(id="") 
	@iOSFindBy(id="")
	public  RemoteWebElement parentEmailIdTxt;
	
	
	@FindBy(css="input[id='parentAddress']")
	@AndroidFindBy(id="") 
	@iOSFindBy(id="")
	public  RemoteWebElement addressTxt;
	
	
	@FindBy(css="select[name='stateName']")
	@AndroidFindBy(id="") 
	@iOSFindBy(id="")
	public  RemoteWebElement stateNameTxt;
	
	
	@FindBy(xpath="//label[text()='Debit Card']")
	@AndroidFindBy(id="") 
	@iOSFindBy(id="")
	public  RemoteWebElement debitcartRd;
	
	@FindBy(xpath="//label[text()='Net Banking']")
	@AndroidFindBy(id="") 
	@iOSFindBy(id="")
	public  RemoteWebElement NetBnkingRd;
	
	@FindBy(xpath="//label[text()='UPI']")
	@AndroidFindBy(id="") 
	@iOSFindBy(id="")
	public  RemoteWebElement upiRd;
	
	
	@FindBy(xpath="//label[text()='Credit Card']")
	@AndroidFindBy(id="") 
	@iOSFindBy(id="")
	public  RemoteWebElement creditCardRd;
	
	@FindBy(xpath="//label[text()='Visa/Master']")
	@AndroidFindBy(id="") 
	@iOSFindBy(id="")
	public  RemoteWebElement visaRd;
	
	@FindBy(xpath="//label[text()='Amex']")
	@AndroidFindBy(id="") 
	@iOSFindBy(id="")
	public  RemoteWebElement amexRd; 
	
	@FindBy(xpath="//strong[@class='ng-binding']")
	@AndroidFindBy(id="") 
	@iOSFindBy(id="")
	public  RemoteWebElement getTotalPayableFee; 
	
	@FindBy(xpath="//p[@class='ng-binding']")
	@AndroidFindBy(id="") 
	@iOSFindBy(id="")
	public  RemoteWebElement getTotalPayableFeeOnaddress; 
	
	
	@FindBy(xpath="//button[@ng-click='payFee(feesForm)']")
	@AndroidFindBy(id="") 
	@iOSFindBy(id="")
	public  RemoteWebElement payBtn;
				
	@FindBy(css="span[id='totalAmount']")
	@AndroidFindBy(id="") 
	@iOSFindBy(id="")
	public  RemoteWebElement gettotalAmOnPaymentGat;	
	
	
	@FindBy(xpath="//a[text()='www.fliplearn.com']")
	@AndroidFindBy(id="") 
	@iOSFindBy(id="")
	public  RemoteWebElement cancelBtn;
	
	
	public FeeModule(WebDriver driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	public void clickOnPayfeeMod() {
	/*	JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("document.getElementById('btn-next').focus();");
		jse.executeScript("arguments[0].click();", feeModuleBtn);*/
		feeModuleBtn.click();
	}

	public void clickOnPayfeeModForSchool() {
			feeModule1Btn.click();
			}


	public void selectSchoolToPayFee(String schoolName) {
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
	public void fillAddress() throws InterruptedException {
		Thread.sleep(3000);
		parentNameTxt.clear();
		parentNameTxt.sendKeys("vinay");
		parentMobNumTxt.clear();
		parentMobNumTxt.sendKeys("9713370507");
		parentEmailIdTxt.sendKeys("vinay.yadav@fliplearn.com");
		addressTxt.sendKeys("Udyog vihar");
		generic.selectByVisibleText(stateNameTxt, "Delhi");
	}
	public void selectDebitCard() {
		debitcartRd.click();
	}
	
	public void selectNetbanking() {
		NetBnkingRd.click();
	}
	public void selectUpi() {
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
	
	
}
