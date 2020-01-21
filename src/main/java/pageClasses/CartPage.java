package pageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.testng.Assert;

public class CartPage extends LoadableComponent<CartPage> {
	
	WebDriver driver;	    
    
	public CartPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
		
	
	
	@Override
	protected void load() {
		driver.get("http://localhost/Avactis/cart.php");
		
	}

	@Override
	protected void isLoaded() throws Error {
		Assert.assertEquals(driver.getCurrentUrl(), "http://localhost/Avactis/cart.php");
		
	}
	
	
}
