package stepdefinations;

import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import page.objects.HomePage;
import page.objects.NewCars;
import page.objects.ToyotaCar;
import pages.base.BasePage;
import utils.SeleniumDriver;

public class CarwaleSteps {
	
	HomePage home = new HomePage();
	NewCars newCar;
	
	@Given("user navigates to carwale website")
	public void user_navigates_to_carwale_website() {
		
		SeleniumDriver.openpage(SeleniumDriver.config.getProperty("testsiteurl"));
	   
	}
	@Then("user mouseover to newcars")
	public void user_mouseover_to_newcars() {
		
		home.mouseoverNewCar();
	 
	}
	@Then("users clicks on FindnewCars")
	public void users_clicks_on_findnew_cars() {
		newCar = home.findNewcar();
	
		
	   
	}
	@And("user clicks on {string} car")
	public void user_clicks_on_car(String carBrand) {
		
		if(carBrand.equals("Toyota")) {
			newCar.goToToyota();
		}else if(carBrand.equals("BMW")) {
			newCar.goToBMW();
		}else if(carBrand.equals("KIA")) {
			newCar.goToKia();
		}else if(carBrand.equals("MG")) {
			newCar.goToMG();
		}
		
		
	}
	@And("user validates carTitle as {string}")
	public void user_validates_car_title_as(String carTitle) {
		System.out.println("Car Title is "+ BasePage.carBase.getCarTitle());
		Assert.assertTrue(BasePage.carBase.getCarTitle().equals(carTitle));
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	  
	}

}
