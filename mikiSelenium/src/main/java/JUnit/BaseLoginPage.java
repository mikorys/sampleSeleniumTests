package JUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BaseLoginPage {
	protected WebDriver driver;

	public BaseLoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
///////////////////////////////////////////////////SELECTORS\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
	@FindBy(xpath="//input[@value='Administrator']")
	protected WebElement adminLogin;
	
	@FindBy(xpath="//input[@value='Manager']")
	protected WebElement managerLogin;
	
	@FindBy(xpath="//input[@value='Course Creator']")
	protected WebElement courseCreatorLogin;

	@FindBy(xpath="//input[@value='Learner']")
	protected WebElement learnerLogin;
/////////////////////////////////////////////////////SELECTORS END\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
	
////////////////////////////////////////////////////METHODS\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
	public BaseLoginPage loginAdmin()
	{
		adminLogin.click();
		return this;
	}
	
	public BaseLoginPage loginManager()
	{
		managerLogin.click();
		return this;
	}
	
	public BaseLoginPage loginCourseCreator()
	{
		courseCreatorLogin.click();
		return this;
	}
	
	
	public BaseLoginPage loginLearner()
	{
		learnerLogin.click();
		return this;
	}
/////////////////////////////////////////////////////METHODS END\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\	
	
	
	
	
}