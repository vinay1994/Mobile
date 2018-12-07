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
		String role = "Admin";
		
		logMod.Login(role, "CBSE", "6", "Single", "Prime", "Yes");
		leaMod.clickOnLearnImage();
		leaMod.clickOnPrimeImage();
	
		
		List<WebElement> className = driver.findElements(By.xpath("//div[@class='panel-heading']//a"));
		
		  //elementName.size()
		int count = 0; 
		
		for (int cla = 6; cla < 7; cla++) 
		  {
	            System.out.println("Class Name:" + className.get(cla).getText());
	            
	            className.get(cla).click();
	            String subjectPath = "//div[@id='subjectsList"+cla+"']/div/div/div/div/div"; 
	            System.out.println("Subject path is:"+subjectPath);
	    		
	            List<WebElement> subjectName = driver.findElements(By.xpath(subjectPath));
	          
	    		for (int sub = 0; sub < subjectName.size(); sub++) 
	    		{
	    			Thread.sleep(2000);
		            List<WebElement> subjectName1 = driver.findElements(By.xpath(subjectPath));
	    			System.out.println("Number of subjects are:"+subjectName.size());
	    			subjectName1.get(sub).click();
	    		
	    			String contentPath = "(//a[@class='collapsed ng-binding tab-closed'])";
		            System.out.println("Content path is:"+contentPath);

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
			    				for(int v = 0; v < 1; v++)
			    				{	
			    					System.out.println("Size of video list:"+videoList.size());
			    					videoList.get(v).click();
				    		
			    					//Wait for seconds after clicking on Animation
			    					Thread.sleep(12000);
				    		
			    					//Close Video Popup
			    					driver.findElement(By.xpath("(//div[@class='modal-content']//button[@class='close'])[2]")).click();
			    					
			    					//Increase video played counter
						    		count = count + 1;
						    		
						    		//Write to extent report
						    		extentTest.log(Status.INFO, Integer.toString(count));
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