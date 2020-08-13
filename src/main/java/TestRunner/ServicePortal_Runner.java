package TestRunner;

import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;

import Stepdefinations.Base;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(		
		features = {
				"src\\main\\java\\Feature\\ServicePortal\\ServicePortalCreate.feature",
				"src\\main\\java\\Feature\\ServicePortal\\ServicePortalMaintainance.feature",
				"src\\main\\java\\Feature\\ServicePortal\\ServicePortalNews.feature",
				"src\\main\\java\\Feature\\ServicePortal\\ServicePortalCreateTicket.feature"
				},
		glue={"Stepdefinations.ServicePortal"},
		format= {"pretty","html:test-outout", "json:json_output/cucumber.json", "junit:junit_xml/cucumber.xml"}, 
		plugin = {"com.cucumber.listener.ExtentCucumberFormatter:output/LoekAutomationReport.html"}
		)

public class ServicePortal_Runner{

	@AfterClass
	public static void teardown() throws Throwable {
		Reporter.loadXMLConfig(new File("src/test/resources/extent-config.xml"));
		Reporter.setSystemInfo("User", System.getProperty("user.name"));
		Reporter.setSystemInfo("OS", System.getProperty("os.name"));
		Reporter.setSystemInfo("version", System.getProperty("java.runtime.version"));
		Base.GenerateReport();
	}	
}