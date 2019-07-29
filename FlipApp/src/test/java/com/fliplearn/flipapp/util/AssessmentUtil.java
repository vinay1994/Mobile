package com.fliplearn.flipapp.util;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.fliplearn.flipapp.helper.Base;
import com.fliplearn.flipapp.helper.GenericFunctions;
import com.fliplearn.flipapp.pagemodules.HomeModule;
import com.fliplearn.flipapp.pagemodules.LearnModule;
import com.fliplearn.flipapp.pagemodules.LoginModule;
import com.fliplearn.flipapp.pagemodules.MenuModule;
import com.fliplearn.flipapp.pagemodules.MobileNumberModule;
import com.fliplearn.flipapp.pagemodules.OnboardingModule;
import com.fliplearn.flipapp.pagemodules.PracticeChapterTopicModule;
import com.fliplearn.flipapp.pagemodules.PrimeChapterTopicModule;
import com.fliplearn.flipapp.pagemodules.PrimeClassModule;
import com.fliplearn.flipapp.pagemodules.PrimePurchaseFlowModule;
import com.fliplearn.flipapp.pagemodules.PrimeSubjectModule;

public class AssessmentUtil extends Base {
	LoginModule logMod;
	MobileNumberModule mobNumMod;
	MenuModule menMod;
	LearnModule leaMod;
	PrimeClassModule priClaMod;
	PrimeSubjectModule priSubMod;
	PrimePurchaseFlowModule priPurFloMod;
	GenericFunctions generic;
	PrimeChapterTopicModule priChaTopMod;
	OnboardingModule onbMod;
	PracticeChapterTopicModule praChaTopMod;
	HomeModule homMod;
	
	
@BeforeMethod
public void preVerifyPrimePurchaseFlow() 
	{	
	logMod = new LoginModule(driver);
	mobNumMod = new MobileNumberModule(driver);
	menMod = new MenuModule(driver);
	leaMod = new LearnModule(driver);
	priClaMod =	new PrimeClassModule(driver);
	priSubMod = new PrimeSubjectModule(driver); 
	priPurFloMod= new PrimePurchaseFlowModule(driver);
	generic=new GenericFunctions();
	onbMod = new OnboardingModule(driver);
	praChaTopMod=new PracticeChapterTopicModule(driver);
	homMod=new HomeModule(driver);
		 
	}
	@Test(invocationCount = 10)
	public void playAssessment() throws InterruptedException, IOException {
	logMod.Login("Student", "CBSE", "10", "Single", "Prime", "Yes");
  	Thread.sleep(6000);
  	priSubMod.clickOnSubject(driver, "Student", "Chemistry");
  	praChaTopMod.clickOnFirstTopic();;
  	Thread.sleep(3000);
  	praChaTopMod.clickOnLaunchTest();
  	WebElement frame=driver.findElement(By.id("practiceIframe"));
    driver.switchTo().frame(frame);
    Thread.sleep(2000);
  	List<WebElement> numclick= driver.findElements(By.xpath("//a[@title='Not yet answered'][@class='qnbutton notyetanswered free btn btn-secondary']"));
  	Iterator<WebElement> itr = numclick.iterator();
  		int i = 1;
  		while(i<5) {
  	    {
  	    Thread.sleep(3000);
  	WebElement ele= driver.findElement(By.xpath("(//a[@title='Not yet answered'][@class='qnbutton notyetanswered free btn btn-secondary'])["+i+"]"));
    ((JavascriptExecutor)driver).executeScript(
    "document.body.scrollTop = -1 >>> 1");
	Thread.sleep(3000);


    JavascriptExecutor executor = (JavascriptExecutor)driver; executor.executeScript("arguments[0].click();", ele);
  	    Thread.sleep(3000);
        i++; 
  	    System.out.println("value of i"+i);
  	    }}  
  	  Thread.sleep(2000);
  	driver.findElement(By.xpath("//input[@type='submit'][@name=\"next\"]")).click();
  	Thread.sleep(2000);
  	driver.findElement(By.xpath("//input[@type='submit'][@value='Submit all and finish']")).click();
  	Thread.sleep(2000);
  	driver.switchTo().defaultContent();
  	driver.findElement(By.xpath("//a[@class='btn-animation']")).click();
  	Thread.sleep(2000);
  	driver.switchTo().frame(frame);
  	driver.findElement(By.xpath("//input[@type='submit'][@value='Re-attempt quiz']")).click();	    
  		    
	}}


