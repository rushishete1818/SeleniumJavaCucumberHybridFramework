package stepdefinations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.SearchPage;

public class SearchFeature {
	
	
	WebDriver driver;
	//private SearchPage sp;
	
	@Given("User opens the application")
	public void user_opens_the_application() {
		
		driver = DriverFactory.getDriver();
		
		//driver.get("https://tutorialsninja.com/demo/");
	    
	}

	@When("User enters valid product {string} into search box field")
	public void user_enters_valid_product_into_search_box_field(String productvalidname) {
		SearchPage sp = new SearchPage(driver);
		sp.enterValidProductName(productvalidname);
		//driver.findElement(By.xpath("//input[@name='search']")).sendKeys(productvalidname);
	    
	}

	@And("User clicks on search button")
	public void user_clicks_on_search_button() {
		SearchPage sp = new SearchPage(driver);
		sp.clickonSearch();
		
		//driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']")).click();
	    
	}

	@Then("User should get valid product display in search result")
	public void user_should_get_valid_product_display_in_search_result() {
		
	    Assert.assertTrue(driver.findElement(By.linkText("HP LP3065")).isDisplayed());
	    
	}
	
	@When("User enters invalid product {string} into search box field")
	public void user_enters_invalid_product_into_search_box_field(String productinvalidname) {
		
		SearchPage sp = new SearchPage(driver);
		sp.enterInvalidProductName(productinvalidname);
		
		//driver.findElement(By.xpath("//input[@name='search']")).sendKeys(productinvalidname);
	    
	}

	@Then("User should get message about no prodct matching")
	public void user_should_get_message_about_no_prodct_matching() {
		
		Assert.assertEquals("There is no product that matches the search criteria.", driver.findElement(By.xpath("(//div[@id='content']//following-sibling::p)[2]")).getText());
	   
	}

	@When("User dont enter any product name into search box field")
	public void user_dont_enter_any_product_name_into_search_box_field() {
		
		// intenstionally this filled get empty
	   
	}

}
