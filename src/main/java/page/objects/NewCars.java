package page.objects;

import pages.base.BasePage;

public class NewCars extends BasePage {
	
	public ToyotaCar goToToyota(){
		
		click("toyota_XPATH");
		return new ToyotaCar();
		
	}
	public BMWCar goToBMW(){
		click("bmw_XPATH");
		return new BMWCar();
		
	}
	public KiaCar goToKia(){
		
		click("kia_XPATH");
		return new  KiaCar();
	
	}
	

	public MGCar goToMG(){
		click("mg_XPATH");
		return new MGCar();
	
	}
	
	

}
