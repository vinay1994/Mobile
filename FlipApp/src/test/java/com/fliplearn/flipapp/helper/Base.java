package com.fliplearn.flipapp.helper;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.internal.IResultListener;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.fliplearn.flipapp.util.ConfigUtil;
import com.fliplearn.flipapp.util.SendReportUtil;

import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.StartsActivity;
import io.appium.java_client.remote.MobileCapabilityType;


public class Base implements IResultListener
{
	   
	public static Properties aConfig = null;
	public static Properties eConfig = null;
	public static FileInputStream input = null;
		
	public static boolean isInitialized = false;
	public static boolean isBrowserOpened = false;
			
	String server;
	public static String platform;
	String deviceName;
	public static String browser;
	String appPath;
	public static String environment;
	public static String url;
	public static WebDriver driver;
	public static String emailIds;
	public static String suiteType;
	public static String sendReport;
	
	static String fileExtension = GenericFunctions.formatDateToString();
	static String reportFileName = "AutomationReport" + "_" + fileExtension + ".html";
	
	// initialize the HtmlReporter
	ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("C:\\tomcat\\webapps\\fliplearn\\latestreport\\" + reportFileName);

	// initialize ExtentReports and attach the HtmlReporter
	public static ExtentReports extentReports = new ExtentReports();
	public static ExtentTest extentTest;
	ITestResult result;

	/**
	 * This will set Driver based on capabilities and configuration
	 * @author Tarun Goswami
	 * @since 2018-09-20
	 * @version 1.0
	 */
	public void setDriver() throws MalformedURLException
	{
		server = eConfig.getProperty("SERVER");
		platform = eConfig.getProperty("PLATFORM");
		browser = eConfig.getProperty("BROWSER");
		deviceName = eConfig.getProperty("DEVICENAME");
		environment = eConfig.getProperty("ENVIRONMENT");
		emailIds = eConfig.getProperty("EMAIL");
		suiteType = eConfig.getProperty("SUITETYPE");
		sendReport = eConfig.getProperty("SENDREPORT");
		
		url = aConfig.getProperty(platform+"_"+environment+"_URL");
		
		appPath = System.getProperty("user.dir") + "\\apps\\"+platform.toLowerCase()+"_"+environment.toLowerCase()+".apk";
			
		if(platform.equals("ANDROID"))
		{
			DesiredCapabilities cap = new DesiredCapabilities();
			cap.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
//			cap.setCapability(MobileCapabilityType.APP, appPath);
			
			cap.setCapability("appPackage", "com.elss.educomp"); 
		    cap.setCapability("appActivity","com.elss.educomp.prelogin.ui.SplashActivity"); 
		    cap.setCapability("noSign", true);
		    
			driver = new AndroidDriver<AndroidElement>(new URL("http://0.0.0.0:4723/wd/hub"), cap);
			 
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}
		
		else if(server.equals("WINDOWS") & platform.equals("WEB") & browser.equals("CHROME"))
		{
			ChromeOptions options = new ChromeOptions();
			options.addArguments("start-maximized");
			
            System.setProperty("webdriver.chrome.driver", Constants.WINDOWS_CHROME_EXE);
            driver = new ChromeDriver();
        
            driver.get(url);
            
            driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}
		
		else if(server.equals("LINUX") & platform.equals("WEB"))
	    {
				if(browser.equals("CHROME"))
				{
					ChromeOptions options = new ChromeOptions();
					options.addArguments("start-maximized");
			
					System.setProperty("webdriver.chrome.driver", Constants.LINUX_CHROME_EXE);
					driver = new ChromeDriver();
				}
				else if(browser.equals("Firefox")) 
				{
					FirefoxOptions options = new FirefoxOptions();
					options.addArguments("start-maximized");
			
					System.setProperty("webdriver.gecko.driver", Constants.LINUX_FIREFOX_EXE);
					driver = new FirefoxDriver();
				}	
				

				driver.get(url);
			
        driver.manage().window().maximize();
		}		
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}
	
	
	/**
	 * This will intialize config file
	 * @author Tarun Goswami
	 * @since 2018-09-20
	 * @version 1.0
	 */
	public static void Initialize() 
	{
		if (!isInitialized) 
		{
			try 
			{					
				ConfigUtil.loadProperty(); 			
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		}	
	}
	

	/**
	 * Execute before any test method
	 * @author Tarun Goswami
	 * @since 2018-09-20
	 * @version 1.0
	 */
	@BeforeMethod
	public void befo() throws MalformedURLException 
	{
	
		Base base = new Base();
		Base.Initialize();
		base.setDriver();
		extentReports.attachReporter(htmlReporter);	
	}

	public void onTestStart(ITestResult result) 
	{
		extentTest = extentReports.createTest(result.getMethod().getMethodName(), "Some description");
		extentTest.log(Status.INFO, "Platform is:"+platform);
		
		if(platform.equals("WEB"))
		{	
			extentTest.log(Status.INFO, "Browser is:"+browser);
			extentTest.log(Status.INFO, "URL is:"+url);
		}
	}

	public void onTestSuccess(ITestResult result) 
	{
		extentTest.log(Status.PASS, "Test Pass.");
	}

	public void onTestFailure(ITestResult result)
	{
		extentTest.log(Status.FAIL, "Test Failed.");
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) 
	{
		extentReports.flush();
		
	}

	public void onConfigurationSuccess(ITestResult itr) {
		// TODO Auto-generated method stub
		
	}

	public void onConfigurationFailure(ITestResult itr) {
		// TODO Auto-generated method stub
		
	}

	public void onConfigurationSkip(ITestResult itr) {
		// TODO Auto-generated method stub
		
	}
	
	@AfterMethod
	public void getResult() throws IOException
	{
		driver.quit();
		extentTest.log(Status.INFO, "Browser/Application Closed.");
	}
	
	@AfterSuite
	public void aftSuite() throws InterruptedException, IOException
	{
		if(sendReport.equals("TRUE"))
			SendReportUtil.emailReport();
	}
}