package JUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ManageDashboardPage extends BaseLoginPage{
	private WebDriver driver;
	
	public ManageDashboardPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
///////////////////////////////////////////////////SELECTORS\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\	
	@FindBy(xpath="//div[@id='page']//li[1]//a[1]")
	private WebElement certificationCompletion;
	@FindBy(xpath="//button[contains(text(),'End tour')]")
	private WebElement endTourBtn;

/////////////////////////////////////////////////////SELECTORS END\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\	
	
////////////////////////////////////////////////////METHODS\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\		
	public ManageDashboardPage clickctificationCompletion() {
		certificationCompletion.click();
		return this;
	}
	/*
	 * public ManageDashboardPage clickEndTourBtn() { WebDriverWait wait = new
	 * WebDriverWait(driver, 5); WebElement
	 * elem=wait.until(ExpectedConditions.elementToBeClickable(By.
	 * xpath("//button[contains(text(),'End tour')]"))); endTourBtn.click(); return
	 * this; }
	 */
	
	
	

}
