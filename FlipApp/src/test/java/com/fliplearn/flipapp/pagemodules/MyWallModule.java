package com.fliplearn.flipapp.pagemodules;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class MyWallModule 
{
	/*@FindBy(xpath="//li[@id='wall-feed']")
	@AndroidFindBy(xpath="//li[@id='wall-feed']")
	public RemoteWebElement myWallTab;*/
	
	@FindBy(xpath="(//*[text()='My Wall '])[2]")
	//@AndroidFindBy(id="com.elss.educomp:id/btn_finish")
	//@AndroidFindBy(className="android.widget.ImageButton")
	public static RemoteWebElement myWall;
	
		
	@FindBy(xpath="(//*[text()='My Wall'])[1]")
	public static RemoteWebElement guestWall;
	
	@FindBy(xpath="(//*[@class='likeComment ng-binding ng-scope'])[1]")
	public static RemoteWebElement likeComment;
	
	@FindBy(xpath="(//*[@placeholder='Add a comment...'])[1]")
	public static RemoteWebElement comment;
	
	@FindBy(xpath="(//*[text()='Like']/preceding::i)[2]")
	public static RemoteWebElement clickonLike;
	
	@FindBy(xpath="(//i[contains(@class,'fa fa-heart liked')])[1]")
	public static RemoteWebElement clickForDisLike;
	
	public MyWallModule(WebDriver driver)
	{
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
	
		
	public void myWall()
	{
		myWall.click();
	}
	
	public static void guestWall()
	{
		guestWall.click();
	}
	
	public void likeComment()
	{
		likeComment.click();
	}
	
	public void Comment()
	{
		comment.click();
	}
	
	public static void clickonLike()
	{
		clickonLike.click();
	}
	
	public static void clickForDisLike(WebDriver driver, String classN)
	{
		System.out.println("Value of class:"+classN);
		
		
		driver.findElement(By.className(classN)).click();
		
		String z=classN.substring(0, classN.indexOf("fa-heart"));
		
		System.out.println("dttrttttttttt: "+z);
	}
	

		
}
