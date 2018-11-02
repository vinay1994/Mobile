package com.fliplearn.flipapp.pagemodules;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;

public class SelectSubjectModule 
{
	
	@FindBy(xpath="//div[@id='subjectsList3']//div[@class='col-sm-4 ng-scope']//h3")
//	@AndroidFindBy(id="")
	public List<RemoteWebElement> subjectList;
	
	@FindBy(xpath="//div[@class='col-md-9 col-sm-8 col-xs-9']/h3")
//	@AndroidFindBy(id="")
	public List<RemoteWebElement> studentSubjectList;
	
	public SelectSubjectModule(WebDriver driver)
	{
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

	@FindBy(xpath="//select[@id='selectTerm2']")
//	@AndroidFindBy(xpath="")
//	@iOSFindBy(id="")
	public List<RemoteWebElement> classLst;
	
	public void clickOnSubject(WebDriver driver, String role, String subjectName)
    {
		if(role.equals("Student")||role.equals("Parent")||role.equals("Guest"))
			driver.findElement(By.xpath("//h3[text()='"+subjectName+"']")).click();
		else
			driver.findElement(By.xpath("//div[@class='panel-collapse collapse in']//h3[text()='"+subjectName+"']")).click();
    }

}
