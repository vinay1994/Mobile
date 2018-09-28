package com.fliplearn.flipapp.pagemodules;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class SelectClassModule 
{
	
	@AndroidFindBy(id="com.elss.educomp:id/tv_content_class_model")
	public List<RemoteWebElement> classList;
	@FindBy(xpath="//*[text()='Quiz']")
	public List<RemoteWebElement> quizHead;
	
	public SelectClassModule(WebDriver driver)
	{
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
}
