package automationPracticeTestNG;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class SearchResultPage extends BasePage  {
	
	public SearchResultPage(WebDriver driver) {
		super(driver);		
				
				
	}
	private WebDriverWait wait = new WebDriverWait(driver, 5);
	private Actions action = new Actions(driver);
	
	
	
	
////////////////////////////////////////////WEBELEMENNTS\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
	private WebElement resultFoundField() {
		return driver.findElement(By.cssSelector(".heading-counter"));
	}
	
	private WebElement elementToHoverOver(String clothPrice)
	{
		return driver.findElement(By.xpath("//div[@class='right-block']//span[@class='price product-price'][contains(text(),'"
						+clothPrice+"')]"));
	}
	
	private WebElement addToCartBtn(String clothPrice) {
		return driver.findElement(By.xpath("//div[@class='right-block']//span[contains(text(),'"+clothPrice+"')]"
				+ "//parent::div//following-sibling::div//a/span[contains(text(),'Add to cart')]"));
	}
	private WebElement proceedToCheckoutBtn() {
		
		return driver.findElement(By.cssSelector("a[title='Proceed to checkout']"));
	}
	private WebElement productAddedToCartConfirmation()
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("icon-ok")));
		return driver.findElement(By.xpath("//i[@class='icon-ok']//parent::h2"));
	}
	
	private WebElement clothType()
	{
		return driver.findElement(By.id("layer_cart_product_title"));
	}
	
	private WebElement clothColour() {
		return driver.findElement(By.id("layer_cart_product_attributes"));
	}
	
	private WebElement clothQty() {
		return driver.findElement(By.id("layer_cart_product_quantity"));
	}
	
	private WebElement clothPrice() {
		return driver.findElement(By.id("layer_cart_product_price"));
	}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
////////////////////////////////////////METHODS\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
	
	public SearchResultPage hoverOver(String clothPrice){
		action.moveToElement(elementToHoverOver(clothPrice)).build().perform();
		return this;
	}
	
	
	public SearchResultPage clickAddToCartBtn(String clothPrice) {
		addToCartBtn(clothPrice).click();
		return this;
	}

	public SearchResultPage clickProceedToCheckoutBtn(){
		proceedToCheckoutBtn().click();		
		return this;
	}
	
	public String getResultFoundFieldTxt() {
		return resultFoundField().getText();
	}
	public String getProductAddedToCartConfirmationTxt() {
		return productAddedToCartConfirmation().getText();
	}
	public String getClothTypeTxt() {
		return clothType().getText();
	}
	public String getClothColourTxt() {
		return clothColour().getText();
	}
	public String getClothQtyTxt() {
		return clothQty().getText();
	}
	public String getClothPriceTxt() {
		return clothPrice().getText();
	}
	

}
