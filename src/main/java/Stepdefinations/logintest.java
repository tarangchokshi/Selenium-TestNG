//package Stepdefinations;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//
//import cucumber.api.java.en.Given;
//import cucumber.api.java.en.Then;
//import cucumber.api.java.en.When;
//
//public class logintest {
//
//	WebDriver driver = new ChromeDriver();
//
//	@Given("^Open the application$")
//	public void open_the_application() throws Throwable {
//
//		System.setProperty("webdriver.chrome.driver", "E:\\Alljar\\Driver\\chromedriver_win32\\chromedriver.exe");
//		driver = new ChromeDriver();
//		driver.manage().window().maximize();
//		driver.get("https://apptest.loekonline.nl/user/login");
//	}
//
//	@When("^User click on the loginbutton and login with valid credential$")
//	public void user_click_on_the_loginbutton_and_login_with_valid_credential() throws Throwable {
//
//		driver.findElement(By.xpath("//input[@name='Email']")).sendKeys("testtarang7@loekonline.onmicrosoft.com");
//		driver.findElement(By.xpath("//input[@name='Password']")).sendKeys("qwerty");
//	}
//
//	@Then("^User rediret on Homepage$")
//	public void user_click_on_the_Login_button() throws Throwable {
//		driver.findElement(By.xpath("//button[@id='submitInloggen']")).click();
//		Thread.sleep(3000);
//		driver.findElement(By.xpath("//a[@href='/User/LogOff']")).click();
//    }
//	
//	@When("^User click on the loginbutton and login with invalid credential$")
//	public void user_click_on_the_loginbutton_and_login_with_invalid_credential() throws Throwable {
//		driver.findElement(By.xpath("//input[@name='Email']")).sendKeys("testtarang17@loekonline.onmicrosoft.com");
//		driver.findElement(By.xpath("//input[@name='Password']")).sendKeys("qwerty");
//	}
//
//	@Then("^User should get the proper validation error$")
//	public void user_should_get_the_proper_validation_error() throws Throwable {
//		driver.findElement(By.xpath("//button[@id='submitInloggen']")).click();
//		
//		String actualMsg = driver
//				.findElement(By.xpath("//div[@class='validation-summary-errors']"))
//				.getText();
//		String errorMsg = "Ongeldige gebruikersnaam en/of wachtwoord.";
//
//		if (actualMsg.equals(errorMsg)) {
//			System.out.println("Test Case Passed");
//		} else {
//			System.out.println("Test Case Failed");
//		}	
//        driver.quit();
//	}
//
//}
