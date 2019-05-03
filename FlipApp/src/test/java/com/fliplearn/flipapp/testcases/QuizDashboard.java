package com.fliplearn.flipapp.testcases;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.fliplearn.flipapp.helper.Base;
import com.fliplearn.flipapp.helper.GenericFunctions;
import com.fliplearn.flipapp.pagemodules.LearnModule;
import com.fliplearn.flipapp.pagemodules.LoginModule;
import com.fliplearn.flipapp.pagemodules.MobileNumberModule;
import com.fliplearn.flipapp.pagemodules.OnboardingModule;
import com.fliplearn.flipapp.pagemodules.QuizDashBoardModule;
import com.fliplearn.flipapp.pagemodules.QuizModule;
import com.fliplearn.flipapp.pagemodules.PrimeClassModule;
import com.fliplearn.flipapp.pagemodules.SignInAsModule;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class QuizDashboard extends Base 
{
	LoginModule logMod;
	OnboardingModule onbMod;
	LearnModule leaMod;
	MobileNumberModule mobNumMod;
	QuizModule quiMod;
	SignInAsModule sigInMod;
	PrimeClassModule selClaMod;
	QuizDashBoardModule quiDasMod;
	GenericFunctions generic;
	
	@BeforeMethod
	public void befQuiz()
	{
		logMod = new LoginModule(driver);
		onbMod = new OnboardingModule(driver);
		sigInMod = new SignInAsModule(driver);
		mobNumMod = new MobileNumberModule(driver);
		quiMod = new QuizModule(driver);
		selClaMod = new PrimeClassModule(driver);
		leaMod = new LearnModule(driver);
		quiDasMod = new QuizDashBoardModule(driver); 
		generic=new GenericFunctions();	
	}
	
	/**
	 * Verify Quiz Dashboard Classes for Admin, Principal and Teacher on Web, Android and iOS
	 * @author Durga
	 * @since 2018-10-30
	 * @version 1.1
	 * @throws InterruptedException 
	 * @throws IOException 
	 */

	@Test(dataProvider = "allusers")
	public void verifyQuizDashboardTileDisplayed(String role) throws InterruptedException, IOException
	{	
		logMod.Login(role, "CBSE", "6", "Single", "Prime", "Yes");
	
		if(!role.equals("Guest"))
		{	
			if(!platform.equals("Web"))
			{	
				generic.scrollBy(driver, 95, 50);
				
			}
		}	
		
		if(role.equals("Parent") || role.equals("Student") || role.equals("Guest"))
			Assert.assertEquals(generic.isElementDisplayed(driver, quiDasMod.quizDashboardTile), false);
		else
			Assert.assertEquals(generic.isElementDisplayed(driver, quiDasMod.quizDashboardTile), true);
			
	}

	/**
	 * Verify Quiz Dashboard Classes for Admin, Principal and Teacher on Web, Android and iOS
	 * @author Durga
	 * @since 2018-09-21
	 * Modified By: Tarun Goswami Date: 15 Dec 2018
	 * @version 1.5
	 * @throws InterruptedException 
	 * @throws IOException 
	 */

	@Test(dataProvider = "staff")
	public void verifyQuizDashboardClasses(String role) throws InterruptedException, IOException
	{	
		logMod.Login(role, "CBSE", "6", "Single", "Prime", "Yes");
	
		if(platform.equals("Web"))
		{	
			leaMod.clickOnLearnImage();
		}  
		else if(!platform.equals("Web"))
		{	
			generic.scrollBy(driver, 95, 50);
		}
		
		quiDasMod.clickOnQuizDashboardTile();
								
		generic.waitForElementVisibility(driver, quiDasMod.classListBtn);
		quiDasMod.clickOnClassLst();	

		String expectedList = readData(platform, role, "Quiz Dashboard Classes");
		Assert.assertEquals(generic.compareList(quiDasMod.quizDashboardClassLst, expectedList), true);	
	}
}