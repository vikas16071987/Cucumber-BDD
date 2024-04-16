package page.objects;
import pages.base.BasePage;

public class HomePage extends BasePage{
	
	
	
	public void mouseoverNewCar() {	
		
		mouseOver("newCarMenu_XPATH");
		
	}
	
	public NewCars findNewcar() {
		
		click("findNewCar_XPATH");
		return new NewCars();

		
	} 

}
