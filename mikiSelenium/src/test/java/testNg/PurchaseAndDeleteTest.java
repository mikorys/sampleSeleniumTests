package testNg;

import java.util.concurrent.TimeUnit;


import org.testng.annotations.Test;



import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import automationPracticeTestNG.*;

public class PurchaseAndDeleteTest {
	private WebDriver driver;
	private static String baseUrl;
	private BasePage basePage;
	private SearchResultPage resultPage;
	private ShoppingCartSummary cartSummary;
	private static final Logger log= LogManager.getLogger(PurchaseAndDeleteTest.class);
	
  
  @BeforeClass
  public void beforeClass() {
	  
	  baseUrl="http://automationpractice.com/index.php";
  }
  @BeforeMethod
  public void beforeMethod() {
	  	driver= new ChromeDriver();
		basePage=new BasePage(driver);
		resultPage= new SearchResultPage(driver);
		cartSummary= new ShoppingCartSummary(driver);
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		driver.get(baseUrl);
		
  }
  
  @Test(dataProvider = "testData")
  public void testUno(String clothType, String clothColour, String clothQty, String clothPrice) throws InterruptedException {
	  
	  resultPage.enterTextIntoSearchBar(clothType)
		.clickSearchBtn();	  
	  
	  	Assert.assertTrue(resultPage.getResultFoundFieldTxt().matches(".* (result has|results have) been found."));
		log.info("Result has been found");
		
		resultPage.hoverOver(clothPrice)
				.clickAddToCartBtn(clothPrice);		
		
		Assert.assertTrue(resultPage.getProductAddedToCartConfirmationTxt().contains("Product successfully added to your shopping cart"));
		Assert.assertTrue(resultPage.getClothTypeTxt().contains(clothType));
		Assert.assertTrue(resultPage.getClothColourTxt().contains(clothColour));
		Assert.assertTrue(resultPage.getClothQtyTxt().contains(clothQty));
		Assert.assertTrue(resultPage.getClothPriceTxt().contains(clothPrice));
		
		resultPage.clickProceedToCheckoutBtn();		
		
		Assert.assertTrue(cartSummary.getCartSummaryText().contains("SHOPPING-CART SUMMARY"));
		
		cartSummary.clickAddUnitBtn(clothPrice)
					.clickProceedToCheckOutBtn();
		
		driver.navigate().back();	
		cartSummary.clickDeleteBtn(clothPrice);
		Assert.assertTrue(cartSummary.getAlertMsgTxt().contains("Your shopping cart is empty."));
		basePage.navigateToMainPage();
	  
  }

  @AfterMethod
  public void afterMethod() {
	 driver.quit();
  }


  @DataProvider(parallel=false)
  public Object[][] testData() {
    Object[][] data = new Object[2][4];
      data[0][0]="Blouse";
	  data[0][1]="Black"; 
	  data[0][2]="1"; 
	  data[0][3]="$27.00";
	  data[1][0]="Dress";
	  data[1][1]="Orange";
	  data[1][2]="1";
      data[1][3]="$26.00";
			 	 
   
	return data;
   
  }
  }
  


