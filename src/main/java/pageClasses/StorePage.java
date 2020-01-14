package pageClasses;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.testng.Assert;

public class StorePage extends LoadableComponent<StorePage>{

	WebDriver driver;
    Actions builder;
    WebElement table;
    List<WebElement> rows; 
	int rowcount;
	 WebElement secondcol;
	
	@FindBy(xpath="//a[contains(text(),'Sign In')]")
	WebElement Signinlink;
	
	@FindBy(xpath="//a[@class=\"top-cart-info-count\"]")
	WebElement Cartinfocount;
	
	@FindBy(xpath="//a[@href='http://localhost/Avactis/cart.php']")
	WebElement Viewcart;
	

	public StorePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickSigninlink() {
		Signinlink.click();
	}
	
	public void clickproductcategory(String Category) {
	    String locator="//a[@href='"+Category+"']";
	    driver.findElement(By.xpath(locator)).click();
	    Assert.assertEquals(driver.getCurrentUrl(),Category );
	}
	
	public void clickviewcart() {
		builder=new Actions(driver);
		builder.moveToElement(Cartinfocount).moveToElement(Viewcart).click().build().perform();
		Assert.assertEquals(driver.getCurrentUrl(), "http://localhost/Avactis/cart.php");
		
//	    table=driver.findElement(By.xpath("//table[@summary='Shopping cart']//tbody"));
//	    rows=table.findElements(By.tagName("tr"));
//	    rowcount=rows.size();
//	    
//	    for(int i=1;i<=rowcount;i++) {
//			  WebElement row=rows.get(i);
//			  driver.navigate().refresh();
//			  secondcol=row.findElement(By.xpath("//tbody//a[@href='"+PRODUCT+"']"));
//			  secondcol.click();
//			  Assert.assertEquals(driver.getCurrentUrl(), PRODUCT);
//			
//
//		  }
		
	}
	
	
	@Override
	protected void load() {
		
		driver.get("http://localhost/Avactis/");
	}

	@Override
	protected void isLoaded() throws Error {
		Assert.assertEquals(driver.getTitle(), "Avactis Demo Store");
		
	}


}
