package automationPracticeTestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {
	
	protected WebDriver driver;
	
	public BasePage(WebDriver driver){
		this.driver=driver;
		
	}
	
	//////////////////////////////WebElements\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
	protected WebElement searchField() {
		return driver.findElement(By.cssSelector("#search_query_top"));		
		
	}
	protected WebElement searchBtn() {
		return driver.findElement(By.cssSelector("button[name=submit_search]"));
	}
	protected WebElement mainPageButton() {
		return driver.findElement(By.cssSelector(".logo.img-responsive"));
	}
	////////////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////METHODS\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
	public BasePage enterTextIntoSearchBar(String text) {
		searchField().sendKeys(text);
		return this;
	}
	public BasePage clickSearchBtn() {
		searchBtn().click();
		return this;
	}
	public BasePage navigateToMainPage() {
		mainPageButton().click();
		return this;
	}
	
	
	
	
	

}
