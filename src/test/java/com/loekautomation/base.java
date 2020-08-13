package com.loekautomation;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Protocol;
import com.aventstack.extentreports.reporter.configuration.Theme;

//import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
//import com.relevantcodes.extentreports.ExtentReports;
//import com.relevantcodes.extentreports.ExtentTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class base {

	static WebDriver driver;
	WebDriverWait wait;
	protected Properties prop = new Properties();

	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest test;
	
	public static ExtentTest test2;
	public static ExtentTest test3;
	public static ExtentTest test4;
	public static ExtentTest test5;
	public static ExtentTest test6;

	public int WebDriverWaitTimeout = 300;
	public static boolean AssertEnable = false;
	public enum Environment {Test, Production}

	static DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy_HHmmss");

	@BeforeSuite
	public void before() throws Throwable {
//				htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "\\ExtentReports\\Automation_Report_" + dateFormat.format(new Date()) + ".html");
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "\\ExtentReports\\AutomationReport.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
//		htmlReporter.loadXMLConfig(".resources/extent-config.xml");
		
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setJS("js-string");
		htmlReporter.config().setProtocol(Protocol.HTTPS);

		
		htmlReporter.config().setReportName("Tarang | Automation Report");
		htmlReporter.config().setDocumentTitle("Extent-Automation Report");
		htmlReporter.config().setTheme(Theme.DARK);

		htmlReporter.config().setCSS("body > nav > div > a > img { content:url('http://tarangchokshi.in/img/favicon_png.png') }");

	}


	@AfterSuite
	public void extentReportClosure(){
		extent.flush();
		//						driver.close();
	}

	public WebDriver drivercall() {

		//		System.setProperty("webdriver.chrome.driver", "src\\main\\ChromeDriver\\chromedriver.exe");
		//				driver = new ChromeDriver();

		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		//		options.addArguments("headless");
		options.addArguments("disable-gpu");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver,100);
		wait = new WebDriverWait(driver,WebDriverWaitTimeout);

		return driver;

	}

	public WebDriver TestEnvironmentEntry() throws Throwable {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		ChromeOptions options = new ChromeOptions();
		//		options.addArguments("headless");
		options.addArguments("disable-gpu");
		wait = new WebDriverWait(driver,100);

		prop = TestEnvironmentProperties();


		System.out.println(prop.getProperty("URL"));
		driver.get(prop.getProperty("URL") + "/user/login" ) ; 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='midPaneContentWrapper']/h1/b")));
		Thread.sleep(3000);

		driver.findElement(By.xpath("//*[@id='txtUsername']")).sendKeys(prop.getProperty("User_Email"));
		driver.findElement(By.xpath("//*[@id='txtPassword']")).sendKeys(prop.getProperty("User_Password"));
		Thread.sleep(2000);
//		driver.findElement(By.xpath("//button[@id='submitInloggen']")).click();
		wait = new WebDriverWait(driver,WebDriverWaitTimeout);
		return driver;
	}


	public Properties TestEnvironmentProperties() {

		File file = new File("Library//Test_Environment.properties");
		FileInputStream fileInput = null;
		try {
			fileInput = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		try {
			prop.load(fileInput);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return prop;

	}


	public static String capture(WebDriver driver) throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File Dest = new File (System.getProperty("user.dir") + "/ScreenShots/" +  "ErrSnap_" + System.currentTimeMillis() + dateFormat.format(new Date()) +".png");
		String errflpath = Dest.getAbsolutePath();
		FileUtils.copyFile(scrFile, Dest);
		return errflpath;
	}





}
