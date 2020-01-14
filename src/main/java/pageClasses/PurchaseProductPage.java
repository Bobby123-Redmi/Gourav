package pageClasses;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class PurchaseProductPage {
	WebDriver driver;
	Select select;
	WebElement selectedsize;
	List<WebElement> list;
	WebElement Selectedquan;
	WebElement Cartvalue;
	Select select1;
	int quantity;
	WebDriverWait wait;
	WebElement Size;
	WebElement Value3;
	WebElement Value2;
	
	 static Logger log=LogManager.getLogger(PurchaseProductPage.class);
	 
	
	@FindBy(xpath="//select[@name='po[18]']")
	WebElement size;
	
	@FindBy(name="po[164]")
	WebElement processor;
	
	@FindBy(name="po[165]")
	WebElement memory;
	
	@FindBy(name="po[166]")
	WebElement harddrive;
	
	
//	@FindBy(name="po[19]")
//	WebElement choosefile;
	
//	@FindBy(name="po[20][val]")
//	WebElement Comments;
	

	
	@FindBy(xpath="//input[@value='Add To Cart']")
	WebElement Submitt;
	
//	@FindBy(xpath="(//a[contains(text(),'Computers')])[2]")
//	WebElement Computers;
	
	public PurchaseProductPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	

	public void purchaseproduct(String value1,String value2,String value3, String value4) {
//		choosefile.sendKeys(file);
		DOMConfigurator.configure("D:\\New folder\\AvactisProject\\log4j.xml");
		try{

			String locator="//option[@value='"+value1+"]";
			wait=new WebDriverWait(driver, 10);
		    Size=wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
		    Size.click();
		}
		catch(Exception e){
			log.error("Exception occured:"+e);
		}
		
		try {
			String locator="//option[@value='"+value2+"]";
			wait=new WebDriverWait(driver, 10);
		    Value2=wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
		    Value2.click();
		}
		catch(Exception E) {
			log.error("Exception occured:"+E);
		}
		try {
			String locator="//option[@value='"+value3+"]";
			wait=new WebDriverWait(driver, 10);
		    Value3=wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
		    Value3.click();
		}
		catch(Exception E) {
			log.error("Exception occured:"+E);
		}

		try{
			
			String locator="//option[@value='"+value4+"]";
			wait=new WebDriverWait(driver, 10);

			Cartvalue=wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
			Cartvalue.click();
			

		}
		catch(Exception e1) {
			log.error("Exception occured:"+e1);
		}
			
		Submitt.click();
		log.info("product successfully added to cart...");

	}
}
