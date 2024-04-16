package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumDriver {
	
	private static SeleniumDriver seleniumDriver;
	private static WebDriver driver;
	private static WebDriverWait waitDriver;
	public static Properties config = new Properties();
	public static Properties OR = new Properties(); 
	private FileInputStream fis;
	
	private SeleniumDriver() {
		
		
		
		try {
			fis = new FileInputStream("/Users/vikashsharma/Documents/AutomationTesting/EclipseWorkspace/cucumberpageobjectmodelselenium/src/main/resources/properties/OR.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			OR.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			fis = new FileInputStream("/Users/vikashsharma/Documents/AutomationTesting/EclipseWorkspace/cucumberpageobjectmodelselenium/src/main/resources/properties//config.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			config.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (config.getProperty("browser").equals("chrome")){
			
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		
		else if (config.getProperty("browser").equals("firefox")){
			
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		waitDriver = new WebDriverWait(driver, Duration.ofSeconds(Integer.parseInt(config.getProperty("explicit.wait"))));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(config.getProperty("implicit.wait"))));
		
		}
	
		
		public static WebDriver getDriver() {
		return driver;
		}
		
		public static void setUpDriver() {
			
			
			if (seleniumDriver ==null) 
				seleniumDriver = new SeleniumDriver();
		}
		
		public static void openpage(String url) {
			
			driver.get(url);
			
		}
		
		
	public static void tearDown() {
		if(driver!=null) {
			driver.close();
			driver.quit();
			
		}
		seleniumDriver = null;
	}
	
	
	
	

}
