package stepdefinations;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.LoginPage;

public class LoginFeature {
	
	WebDriver driver;
	
	@Given("User navigated to login page")
	public void user_navigated_to_login_page() {
		
		driver = DriverFactory.getDriver();
		
		HomePage hp = new HomePage(driver);
		hp.clickonAccountoption();
		hp.clickonLoginOption();
		
//		driver.findElement(By.xpath("//span[text()='My Account']")).click();
//		driver.findElement(By.linkText("Login")).click();
	    
	}

	@When("User enters valid email address {string} in email filed")
	public void user_enters_valid_email_address_in_email_filed(String emailtext) {
		
		LoginPage lp = new LoginPage(driver);
		lp.enterEmail(emailtext);
		
		
	//	driver.findElement(By.id("input-email")).sendKeys(emailtext);
	    
	}
	
	@And("User enters valid password {string} in password filed")
	public void user_enters_valid_password_in_password_filed(String password) {
		
		LoginPage lp = new LoginPage(driver);
		lp.enterPassword(password);
		
		//driver.findElement(By.id("input-password")).sendKeys(password);
	    
	}

	@And("User clicks on login button")
	public void user_clicks_on_login_button() {
		
		LoginPage lp = new LoginPage(driver);
		lp.clickonLoginButton();
	    
		//driver.findElement(By.xpath("//input[@value='Login']")).click();
		
	}

	@Then("User should get sucessfull logged in")
	public void user_should_get_sucessfull_logged_in() {
		
		Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());
	    
	}
	
	

	@When("User enters invalid email address {string} in email filed")
	public void user_enters_invalid_email_address_in_email_filed(String invalidEmail) {
		
		LoginPage lp = new LoginPage(driver);
		lp.enterInvalidEmail(invalidEmail);
		
		//driver.findElement(By.id("input-email")).sendKeys(invalidEmail);
	   
	}

	@And("User enters invalid password {string} in password filed")
	public void user_enters_invalid_password_in_password_filed(String invalidPass) {
		
		LoginPage lp = new LoginPage(driver);
		lp.enterInvalidPassword(invalidPass);
		
		//driver.findElement(By.id("input-password")).sendKeys(invalidPass);
	    
	}

	@Then("User should get proper warning message about credentials mismatch")
	public void user_should_get_proper_warning_message_about_credentials_mismatch() {
		
		Assert.assertTrue(driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).isDisplayed());
	    
	}

	
	@When("User dont enters email address into email filed")
	public void user_dont_enters_email_address_into_email_filed() {
	   // intenstionally this field kept empty
	}

	@And("User dont enters valid password into password filed")
	public void user_dont_enters_valid_password_into_password_filed() {
		// intenstionally this field kept empty
	}

}
