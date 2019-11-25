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

public class PrimeDemoModule extends Base {
	GenericFunctions generic = new GenericFunctions();

	@FindBy(xpath = "//*[text()='Fliplearn Prime']")
	public RemoteWebElement flipLearnPrimeTile;

	@FindBy(xpath = "//*[text()='Mathematics']")
	public RemoteWebElement primeSubject;

	
	@FindBy(xpath = "//h4[@class='ng-scope']")
	public RemoteWebElement textToIdentifyParent;
	
	@FindBy(xpath = "//*[text()='Basic concept of Decimal']")
	public RemoteWebElement demoVideo;

	public PrimeDemoModule(WebDriver driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	public void clickOnPrimeTile(){

		flipLearnPrimeTile.click();
		primeSubject.click();
		
	}
	
	public void playingDemoVideos() throws InterruptedException {
		
		demoVideo.click();
		generic.verifyVideoContent(driver);
		
	}

}
