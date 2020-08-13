//package Stepdefinations;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.Select;
//
//import cucumber.api.java.en.Given;
//import cucumber.api.java.en.Then;
//import cucumber.api.java.en.When;
//import junit.framework.Assert;
//
//public class Register {
//
//	
//	WebDriver driver = new ChromeDriver();
//	
//	@Given("^Open the registration link$")
//	public void open_the_registration_link() throws Throwable {
//
////		System.setProperty("webdriver.chrome.driver", "E:\\Alljar\\Driver\\chromedriver_win32\\chromedriver.exe");
////		driver = new ChromeDriver();
//	    driver.manage().window().maximize();
//		driver.get("https://test.loekonline.nl/");
//	}
//
//	@When("^User click on the registration button and fill the valid detail$")
//	public void user_click_on_the_registration_button_and_fill_the_valid_detail() throws Throwable {
//		Thread.sleep(3000);
//		driver.findElement(By.xpath(".//*[@id='nav-menu-item-21483']/a/span[1]")).click();
//		driver.findElement(By.xpath(".//*[@id='voornaam']")).sendKeys("Test1");
//		driver.findElement(By.xpath(".//*[@id='achternaam']")).sendKeys("abcd");
//		driver.findElement(By.xpath(".//*[@id='emailadres']")).sendKeys("dhavalpatel904@ifour.com");
//        driver.findElement(By.xpath(".//*[@id='wachtwoord']")).sendKeys("test@1234");
//		driver.findElement(By.xpath(".//*[@id='wachtwoordrepeat']")).sendKeys("test@1234");
//		Thread.sleep(2000);
//		driver.findElement(By.xpath(".//*[@id='submitAanmelden']")).click();
//		System.out.println("Registration Done Successfully!");
//        Thread.sleep(5000);
//       }
//
//	@Then("^user got the registration successfully done message$")
//	public void user_got_the_registration_successfully_done_message() throws Throwable {
//        String actualmsg = driver.findElement(By.xpath("//div/a[@href='/User/Login']")).getText();
//		String errorMsg = "INLOGGEN";
//
//		if (actualmsg.equals(errorMsg)) {
//			System.out.println("Test Case Passed");
//		} else {
//			System.out.println("Test Case Failed");
//		}
//
//		//Assert.assertEquals("Test Is Pass",errorMsg,actualmsg);
//	}
//
//	@When("^Enter all valid input and incorrect Email$")
//	public void enter_all_valid_input_and_incorrect_Email() throws Throwable {
//
//		driver.findElement(By.xpath(".//*[@id='nav-menu-item-21483']/a/span[1]")).click();
//		driver.findElement(By.xpath(".//*[@id='voornaam']")).sendKeys("Test1");
//		driver.findElement(By.xpath(".//*[@id='achternaam']")).sendKeys("abcd");
//		driver.findElement(By.xpath(".//*[@id='emailadres']")).sendKeys("dhavalpatel0451@ifour");
//
//		driver.findElement(By.xpath(".//*[@id='wachtwoord']")).sendKeys("test@1234");
//		driver.findElement(By.xpath(".//*[@id='wachtwoordrepeat']")).sendKeys("test@1234");
//		Thread.sleep(2000);
//		
//     	driver.findElement(By.xpath(".//*[@id='submitAanmelden']")).click();
//	}
//
//	@Then("^user should get the validation error for the Email$")
//	public void user_should_get_the_validation_error_for_the_Email() throws Throwable {
//
//		String actualmsg = driver.findElement(By.xpath(".//*[@id='validation-tooltip']/div[2]")).getText();
//		String expectmsg = "Uw e-mailadres is ongeldig";
//		Assert.assertEquals("Test Pass", expectmsg, actualmsg);
//    }
//	
//	@When("^Enter all valid input and incorrect password$")
//	public void enter_all_valid_input_and_incorrect_password() throws Throwable {
//		driver.findElement(By.xpath(".//*[@id='nav-menu-item-21483']/a/span[1]")).click();
//		driver.findElement(By.xpath(".//*[@id='voornaam']")).sendKeys("Test1");
//		driver.findElement(By.xpath(".//*[@id='achternaam']")).sendKeys("abcd");
//		driver.findElement(By.xpath(".//*[@id='emailadres']")).sendKeys("dhavalpatel21@ifour");
//
//		driver.findElement(By.xpath(".//*[@id='wachtwoord']")).sendKeys("test@1234");
//		driver.findElement(By.xpath(".//*[@id='wachtwoordrepeat']")).sendKeys("test@1239");
//		Thread.sleep(2000);
//		driver.findElement(By.xpath(".//*[@id='submitAanmelden']")).click();
//		System.out.println("please enter correct password");
//	}
//
//	@Then("^user should get the validation error password does not match$")
//	public void user_should_get_the_validation_error_password_does_not_match() throws Throwable {
//		String actualmsg = driver.findElement(By.xpath(".//*[@id='validation-tooltip']/div[2]")).getText();
//		String expectmsg = "Wachtwoorden komen niet overeen.";
//		Assert.assertEquals("Test Pass", expectmsg, actualmsg);
//    }
//
//	@When("^Enter allvalid input and uncheck checkbox then clik on signup button$")
//	public void enter_all_valid_all_valid_input_and_clik_on_signupbutton() throws Throwable {
//		
//		driver.findElement(By.xpath(".//*[@id='nav-menu-item-21483']/a/span[1]")).click();
//		driver.findElement(By.xpath(".//*[@id='voornaam']")).sendKeys("Test1");
//		driver.findElement(By.xpath(".//*[@id='achternaam']")).sendKeys("abcd");
//		driver.findElement(By.xpath(".//*[@id='emailadres']")).sendKeys("dhavalpatel361@ifour");
//		driver.findElement(By.xpath(".//*[@id='wachtwoord']")).sendKeys("test@1234");
//		driver.findElement(By.xpath(".//*[@id='wachtwoordrepeat']")).sendKeys("test@1239");
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//div/label[@id='SubscribeNewsLetter']")).click();
//		Thread.sleep(3000);
//		driver.findElement(By.xpath("//div/label[@id='TermandtoCondition']")).click();
//		driver.findElement(By.xpath(".//*[@id='submitAanmelden']")).click();
//
//	}
//
//	@Then("^it shows the validation error below the checkbox$")
//	public void it_shows_the_validation_error_below_the_checkbox() throws Throwable {
//    
//		String actualmsg = driver.findElement(By.xpath("//div/label[@id='ErrorMessage']")).getText();
//		String expectmsg = "Vink het vakje aan om door te gaan";
//		Assert.assertEquals("Test Pass", expectmsg, actualmsg);
//	}
//
//	// @When("^Enter all valid input field value and use the already used email address in the email field$")
//	// public void
//	// enter_all_valid_input_field_value_and_use_the_already_used_email_adress_in_the_email_field()
//	// throws Throwable {
//	//
//	//
//	// }
//	//
//	// @Then("^it shows the notification email already used$")
//	// public void it_shows_the_notification_email_already_used() throws
//	// Throwable {
//	//
//	// }
//	//
//	// @When("^Observe the header$")
//	// public void observe_the_header() throws Throwable {
//	//
//	// }
//	//
//	// @Then("^it should be Free registration$")
//	// public void it_should_be_Free_registration() throws Throwable {
//	//
//	// }
//
//}
