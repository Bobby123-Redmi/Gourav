package pageClasses;

import java.util.Arrays;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class CheckoutPage{

WebDriver driver;	
Select select;
JavascriptExecutor js;
WebDriverWait wait;

     @FindBy(name="billingInfo[Firstname]")
     WebElement BFirstname;
     
     @FindBy(name="billingInfo[Lastname]")
     WebElement BLastname;
     
     @FindBy(name="billingInfo[Email]")
     WebElement BEmail;
     
     @FindBy(name="billingInfo[Country]")
     WebElement BCountry;
     
     WebElement BIndia;
     
     @FindBy(name="billingInfo[Postcode]")
     WebElement BZipcode;
     
     @FindBy(name="billingInfo[Statemenu]")
     WebElement BState;
     
     WebElement BMaharashtra;
     
     @FindBy(name="billingInfo[City]")
     WebElement BCity;
     
     @FindBy(name="billingInfo[Streetline1]")
     WebElement BStreetline1;
     
     @FindBy(name="billingInfo[Streetline2]")
     WebElement BStreetline2;
     
     @FindBy(name="billingInfo[Phone]")
     WebElement BPhone;
     
     @FindBy(name="shippingInfo[Firstname]")
     WebElement SFirstname;
     
     @FindBy(name="shippingInfo[Lastname]")
     WebElement SLastname;
     
     @FindBy(name="shippingInfo[Email]")
     WebElement SEmail;
     
     @FindBy(name="shippingInfo[Country]")
     WebElement SCountry;
     
     @FindBy(name="shippingInfo[Postcode]")
     WebElement SZipcode;
     
     @FindBy(name="shippingInfo[Statemenu]")
     WebElement SState;
     
     WebElement SIndia;
     
     @FindBy(name="shippingInfo[City]")
     WebElement SCity;
     
     @FindBy(name="shippingInfo[Streetline1]")
     WebElement SStreetline1;
     
     @FindBy(name="shippingInfo[Streetline2]")
     WebElement SStreetline2;
     
     @FindBy(name="shippingInfo[Phone]")
     WebElement SPhone;
     
     @FindBy(xpath="(//input[@value='Continue Checkout'])[1]")
     WebElement CheckoutButton;
     
     @FindBy(xpath="(//input[@name='shippingModuleAndMethod[method_code]'])[1]")
     WebElement NPA;
     
     @FindBy(xpath="(//input[@name='shippingModuleAndMethod[method_code]'])[2]")
     WebElement GS;
     
     @FindBy(xpath="(//input[@name='shippingModuleAndMethod[method_code]'])[3]")
     WebElement DNBD;

     @FindBy(xpath="(//input[@value='Continue Checkout'])[2]")
     WebElement CheckoutButton2;
     
     @FindBy(xpath="//strong[contains(text(),'$462.99')]")
     WebElement SUBTOTAL;
     
     @FindBy(xpath="//strong[contains(text(),'$13.89')]")
     WebElement SHIPHANDLE;
     
     @FindBy(xpath="//strong[contains(text(),'$476.88')]")
     WebElement ORDERTOTAL;
     
     @FindBy(xpath="//input[@value='Place Order']")
     WebElement PLACEORDER;
     
     
     
     public CheckoutPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void provideAddress() {
		BFirstname.sendKeys("Gourav");
		BLastname.sendKeys("Shrivas");
		BEmail.sendKeys("Gauravcool.1306@gmail.com");
		select=new Select(BCountry);
		select.getOptions().get(6).click();
		BZipcode.sendKeys("411057");
		select=new Select(BState);
		select.getOptions().get(20).click();
		BCity.sendKeys("Pune");
		BStreetline1.sendKeys("Flat A13 Building 203");
	   // Assert.assertTrue(BStreetline1.getText().equals("Flat A13 Building 203"), "Address is not same");
		BStreetline2.sendKeys("Megapolis Sparklet Hinjewadi phase 3");
		BPhone.sendKeys("8878399445");
		
		
		SFirstname.sendKeys("Gourav");
		SLastname.sendKeys("Shrivas");
		SEmail.sendKeys("Gauravcool.1306@gmail.com");
		select=new Select(SCountry);
		select.getOptions().get(6).click();
		SZipcode.sendKeys("411057");
		select=new Select(SState);
		select.getOptions().get(20).click();
		SCity.sendKeys("Pune");
		SStreetline1.sendKeys("Flat A13 Building 203");
		SStreetline2.sendKeys("Megapolis Sparklet Hinjewadi phase 3");
		SPhone.sendKeys("8878399445");
//		Assert.assertEquals(SStreetline1.getText(), "Flat A13 Building 203");
		CheckoutButton.click();
		Assert.assertEquals(driver.getCurrentUrl(), "http://localhost/Avactis/checkout.php");
		
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-300)");
		wait.until(ExpectedConditions.elementToBeClickable(NPA)).click();
		wait.until(ExpectedConditions.elementToBeClickable(CheckoutButton2)).click();
		
		String []s1=SUBTOTAL.getText().split("$");
		String s2=Arrays.toString(s1);
		double subtotal=Double.parseDouble(s2);
		Assert.assertEquals(subtotal, 462.99, .99);
		
		
		
	}

}
	
	

