package JUnit;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class FilterTableFunctionality {
	private WebDriver driver;
	private Random rand;
	private ManageDashboardPage manageDash;
	private CertificationCompletionPage certCompletion;
	private SaveThisSearchPage thisSearch;
	private String baseUrl;
	private String saveNameSearch;
	private List<WebElement> objectiveUserNameList;
	private List<String> strngUserNameList;
	
	@Before
	public void setUp() {
		objectiveUserNameList=null;
		strngUserNameList=new ArrayList<String>();
		driver= new ChromeDriver();
		manageDash= new ManageDashboardPage(driver);
		certCompletion= new CertificationCompletionPage(driver);
		thisSearch= new SaveThisSearchPage(driver);
		rand= new Random();
		baseUrl="https://demo.totaralearning.com";
		saveNameSearch="Search Jason"+(Integer.toString(rand.nextInt(1000)+1));
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get(baseUrl);
		
	}

	

	@Test
	public void test() throws InterruptedException {
		
		
		manageDash.loginManager();																										//login as manager		
		manageDash.clickctificationCompletion();																						//pick certification completion		
		certCompletion.fullNameDropdownStartsWithOption(3)																				//select starts with option		
						.insertTextToFullNameTextField("Jason")																			//insert Jason to text field		
						.clickSearchBtn();																								//click search Btn		
		
		Assert.assertTrue(certCompletion.retriveColumnDataFromTable(3).contains("31 Dec 2019 at 00:00"));								//AssertDueDate
		
		certCompletion.clickUserPositionNameHeader();																					//click UserPositions Name
		
		Assert.assertTrue(certCompletion.retriveColumnDataFromTable(7).contains("Internal Helpdesk"));									//AssertUserOrganisationName 			
		
		certCompletion.clickSaveThisSearchBtn();																						//click Save this serarch btn			
		thisSearch.insertSearchedNameToNameField(saveNameSearch);																		//provide searched Name	
		thisSearch.clickSaveChangesBtn();																								//save changes			
		certCompletion.clickClearBtn()																									//Click Clear btn		
						.selectFirstStatusDropDownOption(1)																				//Set Status to is equal		
						.selectSecondStatusDropDownOption(4)																			//SetSecond Status to Expired		
						.clickSearchBtn();																								//Click Search		
		objectiveUserNameList= certCompletion.getFirstColumnValues(1);																	//retrive user Name into list		
		certCompletion.copyTextToAnotherList(objectiveUserNameList, strngUserNameList)													// add text elements from web element list to string list		
						.selectViewAndSearch(saveNameSearch);																			//from Select and View saved result		
		
		Assert.assertTrue(certCompletion.retriveColumnDataFromTable(1).contains("Jason Cochran"));										//assert 1st coulumn name is JasonConarch
		
		certCompletion.logOut();																										//logout from the page		
		System.out.println("List Content: ");
		certCompletion.printList(strngUserNameList);
		
	}

	
	
	
	
	
	@After
	public void tearDown() throws InterruptedException {
		driver.quit();
		
		
		
	}
}