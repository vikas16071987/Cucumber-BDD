package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/resources/features", glue= {"stepdefinations"},plugin= {"html:target/cucumber-reports/cucumber-html-reports.html","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})

public class Runcuke extends AbstractTestNGCucumberTests {
	
	

}
