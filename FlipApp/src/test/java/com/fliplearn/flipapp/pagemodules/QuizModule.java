package com.fliplearn.flipapp.pagemodules;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class QuizModule
{

	@AndroidFindBy(id="com.elss.educomp:id/skip_button")
	public RemoteWebElement skipBtn;
	
	@AndroidFindBy(xpath="//*[@text='Test and Improve your learning']")
	public RemoteWebElement quizGamesTile;
	
	@AndroidFindBy(id="com.elss.educomp:id/first_splash_nanja")
	public RemoteWebElement firstSplashNinjaImg;
		
	public QuizModule(WebDriver driver)
	{
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

}
