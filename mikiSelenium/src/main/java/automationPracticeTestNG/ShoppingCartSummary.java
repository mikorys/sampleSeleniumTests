package automationPracticeTestNG;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShoppingCartSummary {
	
	public ShoppingCartSummary(WebDriver driver) {
		this.driver=driver;
		
	}

	private WebDriver driver;
	//private WebDriverWait wait = new WebDriverWait(driver, 5);
	
	
///////////////////////////////WEB ELEMENTS\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
	private WebElement cartSummaryText() {
		return driver.findElement(By.id("cart_title"));
	}
	private WebElement addUnitButton(String itemPrice) {
		return driver.findElement(By.xpath("//span[contains(text(),'"+itemPrice
				+"')]//parent::span//parent::td//following-sibling::td//a[@title='Add']"));
	}
	private WebElement proceedToCheckOutBtn(){
		return driver.findElement(By.xpath("//a[@class='button btn btn-default standard-checkout button-medium']"));
	}
	
	private WebElement trashBtn(String itemPrice) {
		return driver.findElement(By.xpath("//td[@class='cart_unit']//span[@class='price']/span[contains(text(), '"+itemPrice
				+"')]//parent::span//parent::td//following-sibling::td[@class='cart_delete text-center']//a[@class='cart_quantity_delete']"));
		
	}
	private WebElement alertMsg() {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".alert.alert-warning")));
		return driver.findElement(By.cssSelector(".alert.alert-warning"));
	}
///////////////////////////////////////////////////////////////////////////////////////////////
	
////////////////////////////////////METHODS\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
	public ShoppingCartSummary clickAddUnitBtn(String clothPrice) {
		addUnitButton(clothPrice).click();
		return this;
	}
	
	public ShoppingCartSummary clickProceedToCheckOutBtn() {
		proceedToCheckOutBtn().click();
		return this;
	}
	
	public ShoppingCartSummary clickDeleteBtn(String clothPrice) {
		trashBtn(clothPrice).click();
		return this;
	}
	public String getAlertMsgTxt() {
		return alertMsg().getText();
	}
	public String getCartSummaryText() {
		return cartSummaryText().getText();
	}	
	
	//well thought info is an alert but apparently its not
	public boolean isAlertPresent() 
	{ 
	    try 
	    { 
	        driver.switchTo().alert(); 
	        return true; 
	    }   // try 
	    catch (NoAlertPresentException Ex) 
	    { 
	        return false; 
	    }   
	  }
	
	
}
