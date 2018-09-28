package com.fliplearn.flipapp.pagemodules;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.FindBy;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;

public class QuizDashBoardModule {
	
	public QuizDashBoardModule(WebDriver driver) {
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath="//*[text()='Quiz Dashboard']")
	@AndroidFindBy(id="//*[@text='Test and Improve your learning']") 
	@iOSFindBy(id="")
	public RemoteWebElement quizdashboardBtn;	
	
	@AndroidFindBy(id="//*[@text='Play Quiz']")
	public RemoteWebElement playQuizBtn;
	

}
