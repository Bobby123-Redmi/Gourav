package testClasses;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.swing.text.Utilities;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pageClasses.CartPage;
import pageClasses.CheckoutPage;
import pageClasses.PurchaseProductPage;
import pageClasses.StorePage;
import pageClasses.productPage;
import common.Exceldata;

public class PurchaseTest {
 
	 WebDriver driver;
	 Properties prop;
	 String products;
	 String Apparels;
	 StorePage storepage;
	 
	 static Logger log=LogManager.getLogger(PurchaseTest.class);
	 
	 @BeforeClass
	 @Parameters("browser")
	 public void init(String browser) {
		 DOMConfigurator.configure("D:\\New folder\\AvactisProject\\log4j.xml");
		 if(browser.equalsIgnoreCase("FireFox")) {
			 System.setProperty("webdriver.gecko.driver", "D:\\New folder\\AvactisProject\\src\\test\\java\\testResources\\geckodriver.exe");
			 log.info("system properties are set...");
			 driver=new FirefoxDriver();
			 log.info("firefox browser is launched...");
//			 Wait wait=new FluentWait<>(driver).ignoring(Exception.class);
		 }
		 else if(browser.equalsIgnoreCase("Chrome")) {
			 System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\Downloads\\ChromeDriver76\\chromedriver_win32 (1)\\chromedriver.exe");
			 log.info("system properties are set...");
			 driver=new ChromeDriver();
			 log.info("chrome browser is launched...");
		 }
		 
		 else if(browser.equalsIgnoreCase("InternetExplorer")) {
			 System.setProperty("webdriver.ie.driver", "C:\\Users\\HP\\Downloads\\IEDriverServer_Win32_3.0.0\\IEDriverServer.exe");
			 log.info("system properties are set...");
			 driver=new InternetExplorerDriver();
			 log.info("InternetExplorer is launched...");
			 
		 }
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 driver.manage().window().maximize();
		 log.info("window is maximiesed...");
		
	 }

	 
	 @Test(dataProviderClass=Exceldata.class, dataProvider="provideDataFromExcel")
	 public void selectProductcategory(String category,String productcategory, String product, String value1, String value2, String value3, String value4, String name,String Quantity) {
		 storepage=new StorePage(driver);
		 storepage.get();
		 try {
			Exceldata.takeScreenshot(driver, "C:\\Users\\HP\\Downloads\\screenshot\\Avactis\\GuestPurchasetest\\","storepage");
			
		} catch (IOException e) {
			log.error("Exception occured:"+e);
		}
		 log.info("storepage opened successfully...");
		 log.info("storepage captured successfully....");
		 
		
		 storepage.clickproductcategory(category);
		 Assert.assertEquals(driver.getCurrentUrl(),category );
		 log.info("category link successfully clicked...");
		 
		 
		 productPage apppage=new productPage(driver);
		 try {
			Exceldata.takeScreenshot(driver, "C:\\Users\\HP\\Downloads\\screenshot\\Avactis\\GuestPurchasetest\\","prodcategorypage");
			log.info("prodcategory page successfully opened...");
			log.info("prodcategory page captured successfully...");
		} catch (IOException e) {
			log.error("Exception occured:"+e);
		}
		 
		 apppage.selectproduct(productcategory);
		 Assert.assertEquals(driver.getCurrentUrl(), productcategory);
		 
		 
		 try {
			 Exceldata.takeScreenshot(driver, "C:\\Users\\HP\\Downloads\\screenshot\\Avactis\\GuestPurchasetest\\","prodinprodcategory");
			 log.info("prodinprodcategory page successfully opened...");
			 log.info("prodinprodcategory page captured successfully...");
		 }
		 catch(IOException E) {
			 log.error("Exception occured:"+E);
		 }
		 
		 apppage.selectproduct(product);
		 Assert.assertEquals(driver.getCurrentUrl(), product);
		 
		 
		 PurchaseProductPage purchase=new PurchaseProductPage(driver);
		 try {
			Exceldata.takeScreenshot(driver, "C:\\Users\\HP\\Downloads\\screenshot\\Avactis\\GuestPurchasetest\\","product");
			
		} catch (IOException e) {
			log.error("Exception occured:"+e);
		}
		 
		 purchase.purchaseproduct(value1, value2, value3,value4);
		
		 
		 storepage=new StorePage(driver);
		 storepage.get();
		 try {
			 Exceldata.takeScreenshot(driver, "C:\\Users\\HP\\Downloads\\screenshot\\Avactis\\GuestPurchasetest\\", "storepage2");
			 log.info("storepage again opened successfully...");
			 log.info("storepage again captured successfully....");
		 }
		 catch(Exception e) {
			 log.error("Exception occured:"+e);
			
		 }
		 	
		 storepage.clickviewcart(product,name,Quantity);
		 try {
			 Exceldata.takeScreenshot(driver, "C:\\Users\\HP\\Downloads\\screenshot\\Avactis\\GuestPurchasetest\\", "cartpage");
			 log.info("cartpage opened successfully...");
			 log.info("cartpage captured successfully....");
		 }
		 catch(Exception e) {
			 log.error("Exception occured:"+e);
			
		 }
		 try {
			 CheckoutPage checkoutpage=new CheckoutPage(driver);
			 checkoutpage.provideAddress();
			 log.info("Billing and shipping address details captured successfully...");
				 
		 }
		 catch(Exception e) {
			 log.error("Exception occured:"+e);
		 }
		 
		
	 }
}


