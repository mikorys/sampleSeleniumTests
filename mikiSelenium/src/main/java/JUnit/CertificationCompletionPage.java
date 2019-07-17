package JUnit;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CertificationCompletionPage {
	private WebDriver driver;
	private List<WebElement> userData=new ArrayList<WebElement>();

	public CertificationCompletionPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
///////////////////////////////////////////////////SELECTORS\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
	@FindBy(id="id_user-fullname_op")
	private WebElement dropDown;
	@FindBy(id="id_certcompletion-status_op")
	private WebElement firstStatusDropDown;
	@FindBy(id="id_certcompletion-status")
	private WebElement secondStatusDropDown;	
	@FindBy(id="id_user-fullname")
	private WebElement fullNameTextField;
	@FindBy(id="id_submitgroupstandard_addfilter")
	private WebElement searchBtn;
	@FindBy(id="report_certification_completion")
	private WebElement table;
	@FindBy(xpath="//a[contains(text(),\"User's Position Name(s)\")]")
	private WebElement userPositionsNameHeader;
	@FindBy(xpath="/html[1]/body[1]/div[5]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[1]/input[1]")
	private WebElement saveThisSearchBtn;
	@FindBy(id="id_submitgroupstandard_clearstandardfilters")
	private WebElement clearBtn;
	@FindBy(xpath="//select[@class='custom-select singleselect']")
	private WebElement viewAndSearchSelect;
	@FindBy(xpath="//a[@class=\"toggle-display textmenu\"]")
	private WebElement dropDownMenuBtn;
	@FindBy(xpath="//li[31]//a[1]")
	private WebElement logOutBtn;
/////////////////////////////////////////////////////SELECTORS END\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\	
	
////////////////////////////////////////////////////METHODS\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\	
	public CertificationCompletionPage fullNameDropdownStartsWithOption(int option) {
		Select sel = new Select(dropDown);
		sel.selectByIndex(option);//select starts with
		return this;
	}
	
	public CertificationCompletionPage selectFirstStatusDropDownOption(int option) {
		Select sel = new Select(firstStatusDropDown);
		sel.selectByIndex(option);//select starts with
		return this;
	}
	
	public CertificationCompletionPage selectSecondStatusDropDownOption(int option) {
		Select sel = new Select(secondStatusDropDown);
		sel.selectByIndex(option);//select starts with
		return this;
		
	}
	
	public CertificationCompletionPage selectViewAndSearch(String optionsText) {
		Select sel= new Select(viewAndSearchSelect);
		sel.selectByVisibleText(optionsText);
		return this;
	}
	
	public CertificationCompletionPage insertTextToFullNameTextField(String fullNameText) {
		fullNameTextField.sendKeys(fullNameText);
		return this;
	}
	
	public CertificationCompletionPage clickSearchBtn() {
		searchBtn.click();
		return this;
	}
	
	public CertificationCompletionPage clickUserPositionNameHeader() {
		userPositionsNameHeader.click();
		return this;
	}
	
	public CertificationCompletionPage clickSaveThisSearchBtn() {
		if(saveThisSearchBtn.isDisplayed())
			saveThisSearchBtn.click();
		else
			System.out.println("Save this search Btn is not diplayed");
		return this;
	}
	
	public CertificationCompletionPage clickClearBtn() {
		if(clearBtn.isDisplayed())
			clearBtn.click();
		return this;
	}
	
	public String retriveColumnDataFromTable(int columnNo){
		WebElement columnData = null;
		List<WebElement>tableRows=table.findElements(By.xpath("//table[@id='report_certification_completion']//tbody//tr"));
		
		for(WebElement rowElem:tableRows)
		{	
			List<WebElement>tableColumns=rowElem.findElements(By.tagName("td"));
			
			columnData=tableColumns.get(columnNo-1);
			
		}
		return columnData.getText();
	}
	
	public List<WebElement> getFirstColumnValues(int columnNo){
		
		List<WebElement>tableRows=table.findElements(By.xpath("//table[@id='report_certification_completion']//tbody//tr"));
		for(WebElement rowElem:tableRows)
		{   
			List<WebElement>tableColumns=rowElem.findElements(By.tagName("td"));
			
			userData.add(tableColumns.get(columnNo-1));
			
		}
		
		return userData;
		
	}
	
	public CertificationCompletionPage printList(List<String> lista) {//print list //print list 
		for(String elem:lista) {
			System.out.println(elem);
			
		}
		return this;
	}
	

	public CertificationCompletionPage copyTextToAnotherList(List<WebElement> lista,List<String> targetList ) {
		for(WebElement elem:lista) {
			targetList.add(elem.getText());
			
		}
		return this;
	}
	
	public CertificationCompletionPage logOut() throws InterruptedException {
		dropDownMenuBtn.click();
		
		logOutBtn.click();
		return this;
	}
/////////////////////////////////////////////////////METHODS END\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\	
}