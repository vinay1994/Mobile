package com.fliplearn.flipapp.pagemodules;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;

public class QuizDashBoardModule {
	
	@FindBy(xpath="//*[text()='Quiz Dashboard']")
	@AndroidFindBy(xpath="//*[@text='Test and Improve your learning']") 
	@iOSFindBy(id="")
	public RemoteWebElement quizDashBoardBtn;	
	
	@AndroidFindBy(id="//*[@text='Play Quiz']")
	public RemoteWebElement playQuizBtn;
	
	@FindBy(xpath="//ul[@class='dropdown-menu quizMobileDropdown']/li/a")
	public List<RemoteWebElement> dashboardClassList;
	
	@FindBy(xpath="//div[@class='dropdown section-dropdown']/button")
	public RemoteWebElement classListBtn;
	
	public QuizDashBoardModule(WebDriver driver) 
	{
		 PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}


}
