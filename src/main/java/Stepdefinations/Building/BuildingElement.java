package Stepdefinations.Building;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Models.BuildingUnit.BuildingUnitElementModel;
import Stepdefinations.Base;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class BuildingElement extends Base {
	int initialCount;
	int finalCount;
	int removeCount;
	WebDriver driver;
	BuildingUnitElementModel modelBuildingUnitElement=new BuildingUnitElementModel();
	@Given("^user click on the Element tab$")
	public void user_click_on_the_Element_tab() throws Throwable {
		SetProperty();
		driver = Login();
		wait = new WebDriverWait(driver,WebDriverWaitTimeout);
		Thread.sleep(3000);		
	}

	@When("^User click on the MyApplication and select the buildings$")
	public void user_click_on_the_MyApplication_and_select_the_building() throws Throwable {
		GoToModule(Module.Building,driver);
		driver.get(BuildingDetailPath);
		Thread.sleep(2000);
	}
	
	@Then("^click on the element from sidebar$")
	public void click_on_the_element_from_sidebar() throws Throwable {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='container-main']/div[4]/div[1]/div/ul/li[4]/a")).click();
		Thread.sleep(3000);
		initialCount = GetLocatedElementCount();
		System.out.println("\n Initial Row Counts  :: " +initialCount);
	}

	// ******Check Validation
	@Then("^click on the add new elements$")
	public void click_on_the_add_new_elements() throws Throwable {
		driver.navigate().refresh();
		Thread.sleep(3000);
		OpenContactForm();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='page-modal']/div/div/form/div[2]/div/div[5]/div/div/div/div[1]")));
		driver.findElement(By.xpath("//*[@id='page-modal']/div/div/form/div[2]/div/div[5]/div/div/div/div[1]")).click();
		driver.findElement(By.xpath("//*[@id='page-modal']/div/div/form/div[2]/div/div[5]/div/div/div/div[2]/div/div[4]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='page-modal']/div/div/form/div[2]/div/div[6]/div/div/div/div[1]")).click();
		driver.findElement(By.xpath(".//*[@id='page-modal']/div/div/form/div[2]/div/div[6]/div/div/div/div[2]/div/div[1]")).click();
		Thread.sleep(1000);
	}

	@Then("^click submit$")
	public void click_on_the_submit() throws Throwable {
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='page-modal']/div/div/form/div[3]/input[2]")));
		driver.findElement(By.xpath(".//*[@id='page-modal']/div/div/form/div[3]/input[2]")).click();
	}

	@Then("^verify that it should shows the validation error while required field is empty$")
	public void verify_that_it_should_shows_the_validation_error_while_required_field_is_empty() throws Throwable {

		WebElement expected = driver.findElement(By.xpath("//input[@id='Element_Maker']"));
		String errorMessage = expected.getAttribute("data-val-required");
		Assert.assertEquals(errorMessage, modelBuildingUnitElement.getErrorMessage());
		if (errorMessage.equals(modelBuildingUnitElement.getErrorMessage())) {
			System.out.println("--------Test Case Pass -------");
		} else {
			System.out.println("--------Test Case Fail -------");
		}
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@id='page-modal']/div/div/form/div[3]/input[1]")).click();
	}
	
	public void OpenContactForm() throws Throwable {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,600)");
		driver.findElement(By.xpath(".//*[@id='button-add']")).click();
		OpenChildWindow(driver);
		Thread.sleep(2000);
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("window.scrollBy(0,600)");
		
	}

	// **********Add Element
	@Then("^click on the add new element$")
	public void click_on_the_add_new_element() throws Throwable {
		
		initialCount = GetLocatedElementCount();
		System.out.println("Initial count::" + initialCount);
		Thread.sleep(3000);
		OpenContactForm();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='page-modal']/div/div/form/div[2]/div/div[1]/div/div/div/div[1]"))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@id='page-modal']/div/div/form/div[2]/div/div[1]/div/div/div/div[2]/div/div")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='page-modal']/div/div/form/div[2]/div/div[4]/div/div/div/div[1]/div")).click();
		driver.findElement(By.xpath(".//*[@id='page-modal']/div/div/form/div[2]/div/div[4]/div/div/div/div[2]/div/div[3]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='page-modal']/div/div/form/div[2]/div/div[5]/div/div/div/div[1]")).click();
		driver.findElement(By.xpath("//*[@id='page-modal']/div/div/form/div[2]/div/div[5]/div/div/div/div[2]/div/div[4]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='page-modal']/div/div/form/div[2]/div/div[6]/div/div/div/div[1]")).click();
		driver.findElement(By.xpath("//*[@id='page-modal']/div/div/form/div[2]/div/div[6]/div/div/div/div[2]/div/div[3]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='Element_Maker']")).sendKeys(modelBuildingUnitElement.getElementMaker());
		driver.findElement(By.xpath(".//*[@id='Element_Model']")).sendKeys(modelBuildingUnitElement.getElementModel());
		driver.findElement(By.xpath(".//*[@id='Element_Type']")).sendKeys(modelBuildingUnitElement.getElementType());
		driver.findElement(By.xpath(".//*[@id='Element_Size']")).sendKeys(modelBuildingUnitElement.getElementSize());
		driver.findElement(By.xpath(".//*[@id='Element_Orientation']")).sendKeys(modelBuildingUnitElement.getElementOrientation());
		Thread.sleep(3000);
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("window.scrollBy(0,200)");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='page-modal']/div/div/form/div[3]/input[2]")));
		driver.findElement(By.xpath("//*[@id='page-modal']/div/div/form/div[3]/input[2]")).click();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loading-overlay")));
		Thread.sleep(2000);
		finalCount = GetLocatedElementCount();
	}

	public int GetLocatedElementCount() {
		int counter = 0;
		List<WebElement> locatedElements = driver.findElements(By.xpath(".//*[@id='container-main']/div[4]/div[2]/table/tbody/tr"));

		for (WebElement locatedElement : locatedElements) {
			List<WebElement> innerElements = locatedElement.findElements(By.xpath("//td"));
			if (innerElements.size() != 1) {
				counter++;
			}
		}
		return counter;
	}

	@Then("^verify that it shows the toast message element added successfully$")
	public void verify_that_it_shows_the_toast_message_element_added_successfully() throws Throwable {

		if (finalCount > initialCount) {
			System.out.println("--------Test Case Pass -------");
		} else {
			System.out.println("--------Test Case Fail -------");
		}
		Thread.sleep(2000);
		Assert.assertEquals(finalCount > initialCount, true);

		System.out.println("After Adding new connection Finalcount:: " + finalCount);

	}	

	// ************Delete Record
	@Then("^click on the delete button$")
	public void click_on_the_delete_button() throws Throwable {
		
		Thread.sleep(3000);
		List<WebElement> trElements = driver.findElements(By.xpath("//*[@id='container-main']/div[4]/div[2]/table/tbody/tr"));
		if (trElements.size() > 0) {
			WebElement lastElement = driver.findElement(By.xpath("(.//*[@id='container-main']/div[4]/div[2]/table/tbody/tr)[last()]/td[last()]/a[last()]"));
			if (lastElement != null) {
				lastElement.click();
				Thread.sleep(3000);
				System.out.println("------Element Removed------");
			}
		}
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loading-overlay")));
		removeCount = GetLocatedElementCount();
		Assert.assertEquals(removeCount < finalCount,true);
		Thread.sleep(3000);
		driver.close();
	}
}
