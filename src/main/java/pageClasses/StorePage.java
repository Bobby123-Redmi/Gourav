package pageClasses;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class StorePage extends LoadableComponent<StorePage>{

	WebDriver driver;
	WebDriverWait wait;
    Actions builder;
    WebElement table;
    List<WebElement> rows; 
    List<WebElement> links;
	int rowcount;
	 WebElement secondcol;
	 JavascriptExecutor js;
	 
	
	@FindBy(xpath="//a[contains(text(),'Sign In')]")
	WebElement Signinlink;
	
	@FindBy(xpath="(//a[@href='javascript:void(0);'])[2]")
	WebElement Cartinfocount;
	
	@FindBy(xpath="//a[@href='http://localhost/Avactis/cart.php']")
	WebElement Viewcart;
	
	@FindBy(xpath="(//a[contains(text(),'Checkout')])[3]")
	WebElement Checkout;
	

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
//	    Assert.assertEquals(driver.getCurrentUrl(),Category );
	}
	
	public void clickviewcart(String PRODUCT, String NAME, String QUANTITY) {
		builder=new Actions(driver);
		wait=new WebDriverWait(driver, 20);
		builder.moveToElement(Cartinfocount).moveToElement(Viewcart).build().perform();
		wait.until(ExpectedConditions.elementToBeClickable(Viewcart)).click();
		 links = driver.findElements(By.tagName("a"));
		 for(WebElement ele: links) 
		    {
		         if(ele.getAttribute("href")==PRODUCT) {
				 Assert.assertEquals(ele.getText(), NAME);
			 }
		    }
		if(QUANTITY.equals("three")) {
			js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,300)");
			wait.until(ExpectedConditions.elementToBeClickable(Checkout)).click();
			Assert.assertEquals(driver.getCurrentUrl(), "http://localhost/Avactis/checkout.php");
		}
	
		
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
