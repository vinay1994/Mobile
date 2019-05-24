package com.fliplearn.flipapp.util;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
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
				
		int maxCount = Integer.parseInt(vConfig.getProperty("Count")); 
		System.out.println("Max Count is: "+maxCount);

		int classId = Integer.parseInt(vConfig.getProperty("Class"));
		System.out.println("Class Id is:"+classId);

		String environment = vConfig.getProperty("Environment");
		System.out.println("Environment is:"+environment);
		
		url = aConfig.getProperty("Web"+"_"+environment+"_Url");
		System.out.println("Url is:"+url);
		driver.get(url);
		
		String role = "Admin";
		logMod.Login(role, "CBSE", "6", "Single", "Prime", "Yes");
		System.out.println("Logged in with:"+role);
		
		leaMod.clickOnLearnImage();
		System.out.println("Clicked on Learn Image");
		
		leaMod.clickOnPrimeImage();
		System.out.println("Clicked on Prime Image");

		int count = 0; 
		
		List<WebElement> className = driver.findElements(By.xpath("//div[@class='panel-heading']//a"));
		System.out.println("Total number of classes are:"+className.size()+1);

		for (int cla = classId; cla < classId+1; cla++) 
		{
			System.out.println("Selected Class Name is:" + className.get(cla).getText());
	        className.get(cla).click();
	        
	        String subjectPath = "//div[@id='subjectsList"+cla+"']/div/div/div/div/div"; 
	    	List<WebElement> subjectName = driver.findElements(By.xpath(subjectPath));
	          
	    	for (int sub = 0; sub < subjectName.size(); sub++) 
	    	{
	    		Thread.sleep(2000);
		        List<WebElement> subjectName1 = driver.findElements(By.xpath(subjectPath));
	    		System.out.println("Number of subjects are:"+subjectName.size());
	    		
	    		subjectName1.get(sub).click();
	    		String contentPath = "(//a[@class='collapsed ng-binding tab-closed'])";
		          
		    	List<WebElement> chapterContent = driver.findElements(By.xpath(contentPath));	
		    	for (int chap = 0; chap < chapterContent.size(); chap++) 
		  		{
		    		List<WebElement> chapterContent0 = driver.findElements(By.xpath(contentPath));
		    		System.out.println("Size of chapter content list is:"+chapterContent.size());
		    		
		    		chapterContent0.get(chap).click();
			    	
		    		List<WebElement> listContent = driver.findElements(By.xpath("//div[@id='collapseOne']//div[@class='col-sm-12 ng-scope']"));	
		    		chapterContent0.get(chap).click();

			    	for (int l = 0; l < listContent.size(); l++) 
			  		{
				    	//Getting chapter again to avoid stale element exception
			    		List<WebElement> chapterContent1 = driver.findElements(By.xpath(contentPath));	
			    			
			    		//Click on nth chapter content
			    		chapterContent1.get(chap).click();
				    		
			    		//Getting list content again to avoid stale element exception
			    		List<WebElement> listContent1 = driver.findElements(By.xpath("//div[@id='collapseOne']//div[@class='col-sm-12 ng-scope']"));	
			    	    Thread.sleep(2000);
			    	        
			    	    //Click on nth topic
			    	    listContent1.get(l).click();
			    			
			    		List<WebElement> videoList = driver.findElements(By.xpath("//div[@class='row learnResourcesInner']//h6[text()='Animation']"));
			    			
			    		if(videoList.size() > 0)
			    		{	
			    			for(int v = 0; v <videoList.size() ; v++)
			    			{	
			    				System.out.println("Size of video list:"+videoList.size());
			    				try {
			    				videoList.get(v).click();
			    				List<WebElement> resources = driver.findElements(By.xpath("//div[@class='row learnResourcesInner']//h4[@class='ng-binding']"));
			    				System.out.println(resources.size());
				    		for(int r=0; r<resources.size(); r++) {
				    			Thread.sleep(30000);
			    				resources.get(r).click();
			    				System.out.println("Waiting for 20 seconds to play video");
			    				Thread.sleep(10000);
			    		try {
			    			driver.findElement(By.xpath("(//div[@class='modal-content']//button[@class='close'])[2]")).click();
			    				System.out.println("Video Popup closed");
			    		}
			    		catch(Exception e) {
			    			driver.findElement(By.xpath("(//div[@class='modal-content']//button[@class='close'])[3]")).click();
		    				System.out.println("Synopsis Popup closed");
			    		}
				    		}
				    		driver.navigate().back();
				    		driver.navigate().back();
			    				}
			    				catch(Exception e) {
			    					System.out.println("contet is not playing "+videoList.get(v).getText());
			    				}
						    	count = count + 1;
						    	System.out.println("Total video played till now:"+count);
						    	
						    	if(count == maxCount)
						    	{	
						    		System.out.println("Video count is" +count);
						    		return;
						    	}			
			    			}
			    			//Back to previous page
					    	driver.navigate().back();
					    	Thread.sleep(3000);
			    		}
			    		else
			    		{	
			    			driver.navigate().back();
			    			Thread.sleep(3000);
			    		}	
			    	}
			    					
				    //Wait for content to load
				    Thread.sleep(3000);
				 }	
		    		driver.navigate().back();
		    		Thread.sleep(3000);
		    		List<WebElement> className1 = driver.findElements(By.xpath("//div[@class='panel-heading']//a"));
		            className1.get(cla).click();
			    }
		    }
		}		
	}