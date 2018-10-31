package com.fliplearn.flipapp.util;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.fliplearn.flipapp.helper.Base;
import com.fliplearn.flipapp.pagemodules.LearnModule;
import com.fliplearn.flipapp.pagemodules.LoginModule;

public class VideoUtil extends Base
{
	LoginModule logMod;
	LearnModule leaMod;
	
	@BeforeMethod
	public void preSubjectContent()
	{
		logMod = new LoginModule(driver);
		leaMod = new LearnModule(driver);
	}
	
	@Test
	public void playVideo() throws InterruptedException
	{
		String role = "Admin";
		
		logMod.Login(role, "Single", "None", "Yes");
		leaMod.clickOnLearnImage();
		leaMod.clickOnPrimeImage();
	
		List<WebElement> className = driver.findElements(By.xpath("//div[@class='panel-heading']//a"));
		
		  //elementName.size()
		  for (int i = 1; i < 2; i++) 
		  {
	            System.out.println("Class Name:" + className.get(i).getText());
	            
	            className.get(i).click();
	            String subjectPath = "(//div[@id='subjectsList"+i+"']/div/div/div/div/div)["+(i+1)+"]"; 
	            System.out.println("Subject path is:"+subjectPath);
	    		
	            List<WebElement> subjectName = driver.findElements(By.xpath(subjectPath));
	    		for (int j = 0; j < 1; j++) 
	  		  	{
	    			subjectName.get(j).click();
	    		
	    			String contentPath = "(//a[@class='collapsed ng-binding tab-closed'])";
		            System.out.println("Content path is:"+contentPath);

		    		List<WebElement> chapterContent = driver.findElements(By.xpath(contentPath));	
		    		for (int k = 0; k < chapterContent.size(); k++) 
		  		  	{
		    	   		List<WebElement> chapterContent0 = driver.findElements(By.xpath(contentPath));
		    			System.out.println("Size of chapter content list is:"+chapterContent.size());
		    			chapterContent0.get(k).click();
			    		List<WebElement> listContent = driver.findElements(By.xpath("//div[@id='collapseOne']//div[@class='col-sm-12 ng-scope']"));	
		    			chapterContent0.get(k).click();

			    		for (int l = 0; l < listContent.size(); l++) 
			  		  	{
				    		List<WebElement> chapterContent1 = driver.findElements(By.xpath(contentPath));	
			    			chapterContent1.get(k).click();
				    		List<WebElement> listContent1 = driver.findElements(By.xpath("//div[@id='collapseOne']//div[@class='col-sm-12 ng-scope']"));	

			    			System.out.println("Value of K:"+k);
			    	        JavascriptExecutor js = (JavascriptExecutor) driver;
			    	       // ((JavascriptExecutor)driver).executeScript("window.scrollBy(200,200)");
			    	        Thread.sleep(3000);
			    			listContent1.get(l).click();
			    			System.out.println("Value of L:"+l);
				    		driver.findElement(By.xpath("//div[@class='row learnResourcesInner']//h6[text()='Animation']")).click();
				    		Thread.sleep(5000);
				    		driver.findElement(By.xpath("(//div[@class='modal-content']//button[@class='close'])[2]")).click();
				    		driver.navigate().back();
				    		Thread.sleep(3000);
			  		  	}	
			    	
		  		  	}
	  		  	}
	      }

	}
	

}
