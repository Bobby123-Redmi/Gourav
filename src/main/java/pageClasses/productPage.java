package pageClasses;

import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class productPage {

	WebDriver driver;	
	WebDriverWait wait;
	WebElement Productlink;
	Actions builder;
	static Logger log=LogManager.getLogger(productPage.class);
	
	public productPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public void selectproduct(String product) {
		 DOMConfigurator.configure("D:\\New folder\\AvactisProject\\log4j.xml");
		try {
			String locator="(//div[@class='content']//a[@href='"+product+"'])[2]";
			wait=new WebDriverWait(driver, 20);
			Productlink= wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
			builder=new Actions(driver);
		    builder.moveToElement(Productlink).click(Productlink).build().perform();
		    Thread.sleep(5000);
			log.info("product link successfully clicked...");
			log.info("product1 page successfully opened...");
//			Assert.assertEquals(driver.getCurrentUrl(), product);
		}
		catch(Exception e) {
			log.error("Exception occurred is:"+e);
		}
		
		}
		
	


}
