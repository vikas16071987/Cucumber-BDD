package stepdefinations;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.SeleniumDriver;

public class Hooks {
	
	public WebDriver driver; 
	@Before
	public void setUp() {
		SeleniumDriver.setUpDriver();
	}
	@After
	public void tearDown(Scenario scenario) {
		
		
		if(scenario.isFailed()) {
			
			driver = SeleniumDriver.getDriver();
			byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", "screeshot");
		}
		
		
		
		SeleniumDriver.tearDown();
	}

}
