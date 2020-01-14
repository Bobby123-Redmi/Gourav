package pageClasses;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.testng.Assert;

public class CartPage extends LoadableComponent<CartPage> {
	
	WebDriver driver;	
	WebElement table;
	List<WebElement> rows; 
    int rowcount;
	WebElement secondcol;
	WebElement secondcol1;
    static Logger log=LogManager.getLogger(CartPage.class);
    
    
	public CartPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void Verifyitems(String PRODUCT) {
		
		table=driver.findElement(By.xpath("//table[@summary='Shopping cart']//tbody"));
	    rows=table.findElements(By.tagName("tr"));
	    rowcount=rows.size();
	    
	    for(int i=1;i<=rowcount;i++) {
			  WebElement row=rows.get(i);
			  secondcol=row.findElement(By.xpath("//tbody//a[@href='"+PRODUCT+"']"));
			  secondcol.click();
			  secondcol1=row.findElement(By.xpath("//tbody//a[@href='"+PRODUCT+"']"));
			  secondcol1.click();
			  Assert.assertEquals(driver.getCurrentUrl(),PRODUCT);
			  driver.get("http://localhost/Avactis/cart.php");
	}
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
