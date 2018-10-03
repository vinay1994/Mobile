package com.fliplearn.flipapp.testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.fliplearn.flipapp.helper.Base;
import com.fliplearn.flipapp.helper.GenericFunctions;
import com.fliplearn.flipapp.pagemodules.LearnModule;
import com.fliplearn.flipapp.pagemodules.LoginModule;
import com.fliplearn.flipapp.pagemodules.MobileNumberModule;
import com.fliplearn.flipapp.pagemodules.OnboardingModule;
import com.fliplearn.flipapp.pagemodules.QuizDashBoardModule;
import com.fliplearn.flipapp.pagemodules.QuizModule;
import com.fliplearn.flipapp.pagemodules.SelectClassModule;
import com.fliplearn.flipapp.pagemodules.SignInAsModule;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class QuizDashboard extends Base 
{
	LoginModule logMod;
	OnboardingModule onbMod;
	LearnModule leaMod;
	MobileNumberModule mobNumMod;
	QuizModule quiMod;
	SignInAsModule sigInMod;
	SelectClassModule selClaMod;
	QuizDashBoardModule quiDasMod;
	
	@BeforeMethod
	public void befQuiz()
	{
		logMod = new LoginModule(driver);
		onbMod = new OnboardingModule(driver);
		sigInMod = new SignInAsModule(driver);
		mobNumMod = new MobileNumberModule(driver);
		quiMod = new QuizModule(driver);
		selClaMod = new SelectClassModule(driver);
		leaMod = new LearnModule(driver);
		quiDasMod = new QuizDashBoardModule(driver); 
		
	}

	/**
	 * Verify Quiz Dashboard Classes for Admin, Principal and Teacher on Web, Android and iOS
	 * @author Durga
	 * @since 2018-09-21
	 * @version 1.3
	 * @throws InterruptedException 
	 * @throws IOException 
	 */

	@Test(dataProvider = "group2")
	public void verifyQuizDashboardClasses(String role) throws InterruptedException, IOException
	{				
		logMod.Login(role);
	 		if(platform.equals("Android"))
		leaMod.learnImg.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
          		
        //WebElement Element = quiDasMod.quizDashboardBtn;
        //js.executeScript("arguments[0].scrollIntoView();", Element);	
		js.executeScript("scroll(0, -250);");
        
		quiDasMod.quizDashboardBtn.click();
						
		GenericFunctions.waitForElementVisibility(driver, quiDasMod.classListBtn);
		quiDasMod.classListBtn.click();
    
		String expectedList = readData(platform, role, "Quiz Dashboard Classes");
		System.out.println("Expected List is:"+expectedList);
    	Assert.assertEquals(GenericFunctions.compareList(quiDasMod.quizDashboardClassList, expectedList), true);		
	}
}