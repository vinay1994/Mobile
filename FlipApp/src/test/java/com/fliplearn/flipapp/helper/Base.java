package com.fliplearn.flipapp.helper;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.IInvokedMethod;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.internal.IResultListener;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.fliplearn.flipapp.util.ConfigUtil;
import com.fliplearn.flipapp.util.ExcelUtil;
import com.fliplearn.flipapp.util.Screenshots;
import com.fliplearn.flipapp.util.SendReportUtil;

import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.StartsActivity;
import io.appium.java_client.remote.MobileCapabilityType;


public class Base implements ITestListener
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
	public static String testName;
	
	static GenericFunctions generic=new GenericFunctions();
	
	static String fileExtension = generic.formatDateToString();
	static String reportFileName = "AutomationReport" + "_" + fileExtension + ".html";
	static String reportPath = generic.reportPath();
	// initialize the HtmlReporter
	ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(reportPath() + reportFileName);

	// initialize ExtentReports and attach the HtmlReporter
	public static ExtentReports extentReports = new ExtentReports();
	public static ExtentTest extentTest;
	ITestResult result;
	ITestContext iTestContext;

	public static String reportPath()
	{
		if(System.getProperty("os.name").equals("Linux"))
				return System.getProperty("user.dir") + "/reports/";
		else
				return "C:\\tomcat\\webapps\\fliplearn\\latestreport\\";
	}
	/**
	 * This will set Driver based on capabilities and configuration
	 * @author Tarun Goswami
	 * @since 2018-09-20
	 * @version 1.2
	 */
	public void setDriver() throws MalformedURLException
	{
		server = eConfig.getProperty("Server");
		platform = eConfig.getProperty("Platform");
		browser = eConfig.getProperty("Browser");
		deviceName = eConfig.getProperty("DeviceName");
		environment = eConfig.getProperty("Environment");
		emailIds = eConfig.getProperty("Email");
		suiteType = eConfig.getProperty("SuiteType");
		sendReport = eConfig.getProperty("SendReport");
		
		url = aConfig.getProperty(platform+"_"+environment+"_Url");
		
		appPath = System.getProperty("user.dir") + "\\apps\\"+platform.toLowerCase()+"_"+environment.toLowerCase()+".apk";
			
		if(platform.equals("Android"))
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
		
		else if(server.equals("Windows") &
				platform.equals("Web") & browser.equals("Chrome"))
		{
			ChromeOptions options = new ChromeOptions();
			options.addArguments("start-maximized");
			
            System.setProperty("webdriver.chrome.driver", Constants.WINDOWS_CHROME_EXE);
            driver = new ChromeDriver();
        
            driver.get(url);
            
            driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}
		
		else if(server.equals("Linux") & platform.equals("Web"))
	    {
				if(browser.equals("Chrome"))
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
	 * @version 1.1
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
	 * This read excel data
	 * @author Tarun Goswami
	 * @since 2018-09-20
	 * @version 1.1
	 */
	public String readData(String platform, String role, String key) throws IOException
	{
		String methodName = new Exception().getStackTrace()[1].getMethodName();
		System.out.println("Calling method name:"+methodName);
		
	 	 Map<String, String> testMap = new HashMap<String, String>();
    	 ExcelUtil excUti = new ExcelUtil();
    	 testMap = excUti.readKeyValue(platform, role, methodName);
    	 
    	 return testMap.get(key);
	}
	/**
	 * Execute before any test method
	 * @author Tarun Goswami
	 * @since 2018-09-20
	 * @version 1.1
	 */
	@BeforeMethod
	public void befo(ITestContext it) throws MalformedURLException 
	{
		testName = it.getName();
		System.out.println("TestName is:"+testName);
		Base base = new Base();
		Base.Initialize();
		base.setDriver();
		extentReports.attachReporter(htmlReporter);	
	}

	/**
	 * Before any test method
	 * @author Tarun Goswami
	 * @since 2018-09-30
	 * @version 1.2
	 */
	public void onTestStart(ITestResult result) 
	{
		extentTest = extentReports.createTest(result.getMethod().getMethodName(), "Some Description");
		
		extentTest.log(Status.INFO, "Platform is:"+platform);
		
		if(platform.equals("WEB"))
		{	
			extentTest.log(Status.INFO, "Browser is:"+browser);
			extentTest.log(Status.INFO, "URL is:"+url);
		}
	}

	
	/**
	 * After any test method
	 * @author Tarun Goswami
	 * @since 2018-09-30
	 * @version 1.2
	 */
	@AfterMethod
	public void getResult() throws IOException
	{
		driver.quit();
		extentTest.log(Status.INFO, "Browser/Application Closed.");
	}
	
	/**
	 * After Test Suite
	 * @author Tarun Goswami
	 * @since 2018-09-30
	 * @version 1.2
	 */
	@AfterSuite
	public void aftSuite() throws InterruptedException, IOException
	{
		if(sendReport.equals("True"))
			SendReportUtil.emailReport();
	}


	/**
	 * On Test Failure
	 * @author Tarun Goswami
	 * @since 2018-09-30
	 * @version 1.2
	 */
	@Override
	public void onTestFailure(ITestResult result) 
	{
		extentTest.log(Status.FAIL, "Test Failed");	
        String captureScreenshot;
     	
        try 
        {
        	String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
			captureScreenshot = Screenshots.captureScreenshot(driver,result.getName() + timeStamp);
			extentTest.log(Status.FAIL, result.getThrowable());
			extentTest.log(Status.FAIL, "Snapshot"+extentTest.addScreenCaptureFromPath(captureScreenshot));
		} 
        catch (IOException e) 
        {
			e.printStackTrace();
		}

	}


	@Override
	public void onTestSkipped(ITestResult result) 
	{
		// TODO Auto-generated method stub	
	}


	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	
	@Override
	public void onTestSuccess(ITestResult result) 
	{
		extentTest.log(Status.PASS, "Test Failed");	
		String captureScreenshot;
     	
        try 
        {
        	String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
        	captureScreenshot = Screenshots.captureScreenshot(driver,result.getName() + timeStamp);
			extentTest.log(Status.PASS, "Snapshot"+extentTest.addScreenCaptureFromPath(captureScreenshot));
		} 
        catch (IOException e) 
        {
			e.printStackTrace();
		}
	}


	@Override
	public void onStart(ITestContext context) 
	{
		// TODO Auto-generated method stub	
	}


	/**
	 * On Finish
	 * @author Tarun Goswami
	 * @since 2018-09-30
	 * @version 1.2
	 */
	@Override
	public void onFinish(ITestContext context) 
	{
		extentReports.flush();		
	}
	

	@DataProvider(name = "group0")
	public static Object[] group0() 
	{
		  return new Object[][]
		  { 
			  { "Admin" }, { "Principal" }, { "Teacher" }, { "Parent" }, { "Student" }, { "Guest" }
		  }; 
	}
	
	@DataProvider(name = "group1")
	public static Object[] group1() 
	{
		  return new Object[][]
		  { 
			  { "Admin" }, { "Principal" }, { "Teacher" }, { "Parent" }, { "Student" }
		  }; 
	}
	
	@DataProvider(name = "group2")
	public static Object[] group2() 
	{
		  return new Object[][]
		  { 
			  { "Admin" }, { "Principal" }, { "Teacher" }
		  }; 
	}
	
	@DataProvider(name = "group3")
	public static Object[] group3() 
	{
		  return new Object[][]
		  { 
			  { "Parent" }, { "Student" }, { "Guest" }
		  }; 
	}

}