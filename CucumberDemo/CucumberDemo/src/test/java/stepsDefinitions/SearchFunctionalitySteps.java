package stepsDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import Base.BaseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import Pages.Search;


public class SearchFunctionalitySteps {
	 WebDriver driver;
	 Search search;
	
	@Given ("the user is on the home page")
	public void theUserIsOnTheHomePage () {
		driver = BaseTest.getDriver();
        driver.get("https://tutorialsninja.com/demo/");
        search=new Search(driver);
		
	}
	

	// Combined step for entering any product name
    @When("the user enters a {string} product name in the search field")
    public void entersProductName(String type) {
        if(type.equalsIgnoreCase("existing")) {
            search.enterProductName("Samsung Galaxy Tab 10.1");
        } else if (type.equalsIgnoreCase("non-existing")) {
            search.enterProductName("car"); // non-existing product
        } else {
        	search.enterProductName("");        	
        }
    }
	

    @And ("clicks the Search button")
    public void clicksTheSearchButton () {
    	search.clickOnSearchButton();
    }
    
    @Then ("the user should see the relevant product displayed in the search results")
    public void productDisplayed(){
    	Assert.assertTrue(search.isProductDisplayed());
    }
    
    @Then ("the user should receive a message {string}")
    public void userShouldReceiveMessage(String expectedMessage) {
    	String actualMessage= search.getNoProductMessageText();
    	
    	Assert.assertEquals(actualMessage, expectedMessage, "Error message did not match!");
    }
}
    
