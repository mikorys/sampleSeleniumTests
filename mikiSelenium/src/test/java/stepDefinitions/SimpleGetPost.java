package stepDefinitions;

import io.cucumber.java.en.*;

public class SimpleGetPost {
	  @Given("^I perform GET operation for \"([^\"]*)\"$")
	  public void given() throws Throwable {
		  System.out.println("Odplaopny given");
	  }

	  @Then("^I perform GET for the post number \"([^\"]*)\"$")
	  public void then() throws Throwable {
		  System.out.println("Odplaopny then");
	  }

	  @And("^I should see the author name as \"([^\"]*)\"$")
	  public void and() throws Throwable {
		  System.out.println("Odplaopny and");
	  }

	  
	  
	  
	  
	}
