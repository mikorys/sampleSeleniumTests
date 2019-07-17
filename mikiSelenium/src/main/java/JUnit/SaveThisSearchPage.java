package JUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SaveThisSearchPage {
	private WebDriver driver;

	public SaveThisSearchPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
///////////////////////////////////////////////////SELECTORS\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\	
	@FindBy(id="id_name")
	private WebElement searchTextField;
	
	@FindBy(id="id_submitbutton")
	private WebElement saveChangesBtn;
	
/////////////////////////////////////////////////////SELECTORS END\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\	
	
////////////////////////////////////////////////////METHODS\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\	
	public void insertSearchedNameToNameField(String searchedName) {
		searchTextField.sendKeys(searchedName);
	}
	
	public void clickSaveChangesBtn() {
		saveChangesBtn.click();
	}
/////////////////////////////////////////////////////METHODS END\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\		
	

}