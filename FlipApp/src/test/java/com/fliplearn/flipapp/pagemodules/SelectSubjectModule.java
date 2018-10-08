package com.fliplearn.flipapp.pagemodules;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class SelectSubjectModule {
	
	@FindBy(xpath="//div[@id='subjectsList3']//div[@class='col-sm-4 ng-scope']//h3")
	@AndroidFindBy(id="")
	public List<RemoteWebElement> subjectList;
	
	public SelectSubjectModule(WebDriver driver)
	{
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
	

}
