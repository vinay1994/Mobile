
package com.fliplearn.flipapp.pagemodules;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;

public class SynopsisModule {
	
	//@FindBy(xpath="//a[text()='Class 12']")
	@FindBy(xpath="//a[contains(@class,'ng-binding collapsed')]")
	@AndroidFindBy()
	@iOSFindBy()
	public List<RemoteWebElement> cliOncla12;
	//public RemoteWebElement cliOncla12;
	
	@FindBy(xpath="(//div[@class='col-md-9 col-sm-8 col-xs-8']//h3[text()='Chemistry'])[4]")
	@AndroidFindBy()
	@iOSFindBy()
	public RemoteWebElement clickOnChemSubj;
	
	@FindBy(xpath="//a[text()='1. The Solid State")
	@AndroidFindBy()
	@iOSFindBy()
	public RemoteWebElement clickOnsolidchapter;
	
	@FindBy(xpath="//li[text()='Crystal Lattices and Unit Cells']")
	@AndroidFindBy()
	@iOSFindBy()
	public RemoteWebElement clickOntopic;
	
	@FindBy(xpath="//h6[text()='Real Life Application']")
	@AndroidFindBy()
	@iOSFindBy()
	public RemoteWebElement clickOnRealLifApp;
	
	@FindBy(xpath="//div[@id='demo-html']//h3")
	public RemoteWebElement synopsisHeading;
	
	@FindBy(xpath="//div[@id='demo-html']//h3")
	public RemoteWebElement synopsisHeadingStudent;

	
	@FindBy(xpath="//button[@type='button'])[4]")
	@AndroidFindBy()
	@iOSFindBy()
	public RemoteWebElement closeRealLifeSyn;
	
	@FindBy(xpath="//h6[text()='Topic Synopsis']")
	@AndroidFindBy()
	@iOSFindBy()
	public RemoteWebElement clickOnTopicSynop;
	
	@FindBy(xpath="(//button[@class='close'])[3]")
	@AndroidFindBy()
	@iOSFindBy()
	public RemoteWebElement closeTopSyn;
	
	@FindBy(xpath="//h6[text()='Web Links']")
	@AndroidFindBy()
	@iOSFindBy()
	public RemoteWebElement clickOnWebLink;
	
	@FindBy(xpath="//button[@class='close']")
	@AndroidFindBy()
	@iOSFindBy()
	public RemoteWebElement closeWebLink;
	
	
	public void clickOnClass() {
		cliOncla12.get(10).click();
	}
	
	public void clickOnSubject() {
		clickOnChemSubj.click();
		
	}
	public void clickOnConTopic() {
		clickOntopic.click();
	}
		
		public void clickRealLifeSynop() {
			clickOnRealLifApp.click();
			}
		
		public void closeRealLifeSyn() {
			closeRealLifeSyn.click();
			
		}
		public void clickOnTopicSyn() {
			clickOnTopicSynop.click();
		}
		public void closeTopicSyn() {
			closeTopSyn.click();
		}
		public void clickOnWebLink() {
			clickOnWebLink.click();
			
			}
		public void closeWebLink() {
			
			
		}
		
		public SynopsisModule(WebDriver driver)
		{
	        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	    }
	}
	
	
	

	
	
	
	
	
	
	
	
	
	
	



	
	


