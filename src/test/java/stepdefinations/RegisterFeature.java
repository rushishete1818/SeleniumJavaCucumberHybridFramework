package stepdefinations;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.RegisterPage;
import utils.CommonUtils;

public class RegisterFeature {
	
	WebDriver driver;
	
	
	
	@Given("User navigate to register account page")
	public void user_navigate_to_register_account_page() {
		
		driver = DriverFactory.getDriver();
		HomePage hp = new HomePage(driver);
		hp.clickonAccountoption();
		hp.clickonRegisterOption();
		
//		driver.findElement(By.xpath("//span[text()='My Account']")).click();
//		driver.findElement(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']//a[text()='Register']")).click();
	   
	}
	
	
	
	@When("User enters the details into below fileds")
	public void user_enters_the_details_into_below_fileds(DataTable dataTable) throws InterruptedException {
		
		Map<String, String> datamap = dataTable.asMap(String.class,String.class);

		    

		        RegisterPage rp = new RegisterPage(driver);

		        rp.enterFname(datamap.get("fname"));
		        rp.enterlname(datamap.get("lname"));
		        rp.enterEmail(CommonUtils.timeStamp());
		        rp.enterTelephone(datamap.get("telephone"));
		        rp.enterpassword(datamap.get("password"));
		        rp.enterConpassword(datamap.get("password"));
		        
		        
	 }
	    
	

//	@When("User enters the details into below fileds")
//	public void user_enters_the_details_into_below_fileds(DataTable dataTable) throws InterruptedException {
//		
//		Map<String, String> datamap = dataTable.asMap(String.class,String.class);
//		
//		// below type is driverfactory type
//		RegisterPage rp = new RegisterPage(driver);
//		rp.enterFname(datamap.get("fname"));
//		rp.enterlname(datamap.get("lname"));
//		rp.enterEmail(CommonUtils.timeStamp());
//		rp.enterTelephone(datamap.get("telephone"));
//		rp.enterpassword(datamap.get("password"));
//		rp.enterConpassword(datamap.get("password"));
//		Thread.sleep(4000);
//		
////		driver.findElement(By.id("input-firstname")).sendKeys(datamap.get("fname"));
////		driver.findElement(By.id("input-lastname")).sendKeys(datamap.get("lname"));
////		driver.findElement(By.id("input-email")).sendKeys(datamap.get("email"));
////		driver.findElement(By.id("input-telephone")).sendKeys(datamap.get("telephone")); 
////		driver.findElement(By.id("input-password")).sendKeys(datamap.get("password"));
////		driver.findElement(By.id("input-confirm")).sendKeys(datamap.get("password"));
//	    
//	}
	
	@Test()
	@When("User enters the details iwith same email and below fileds")
	public void user_enters_the_details_iwith_same_email_and_below_fileds(DataTable dataTable) {
		
		Map<String, String> datamap = dataTable.asMap(String.class,String.class);
		
		// below type is driverfactory type
		RegisterPage rp = new RegisterPage(driver);
		rp.enterFname(datamap.get("fname"));
		rp.enterlname(datamap.get("lname"));
		rp.enterEmail(datamap.get("email"));
		rp.enterTelephone(datamap.get("telephone"));
		rp.enterpassword(datamap.get("password"));
		rp.enterConpassword(datamap.get("password"));
		
	}

	@And("User selects privacy policy")
	public void user_selects_privacy_policy() {
		
		RegisterPage rp = new RegisterPage(driver);
		rp.clickonPrivacyPolicy();
		
		//driver.findElement(By.xpath("//input[@name='agree']")).click();
	    
	}

	@And("User click on continue button")
	public void user_click_on_continue_button() throws InterruptedException {
		
		RegisterPage rp = new RegisterPage(driver);
		rp.clickoncontinueButton();
		Thread.sleep(4000);
		
		//driver.findElement(By.xpath("//input[@class='btn btn-primary']")).click();
	    
	}

	@Then("User account should get create successfully")
	public void user_account_should_get_create_successfully() {
		
		//Assert.assertTrue(driver.findElement(By.xpath("//h1[text()='Your Account Has Been Created!']")).isDisplayed());
		Assert.assertEquals("Congratulations! Your new account has been successfully created!", driver.findElement(By.xpath("(//div[@id='content']/p)[1]")).getText());
	   
	}

	@And("User selects yes for newsletter")
	public void user_selects_yes_for_newsletter() {
		
		RegisterPage rp = new RegisterPage(driver);
		rp.clickonNewsLetterOption();
		
		//driver.findElement(By.xpath("(//input[@name='newsletter'])[1]")).click();
	    
	}

	@Then("User should get a proper warning  about duplicate email")
	public void user_should_get_a_proper_warning_about_duplicate_email() {
		
		Assert.assertTrue(driver.findElement(By.xpath("//div[contains(text(),'Warning: E-Mail Address is already registered!')]")).isDisplayed());
	    
	}

	@When("User dont enters any details into fileds")
	public void user_dont_enters_any_details_into_fileds() {
	    // inteionally this is empty  
	}

	@Then("User should get a proper warning  messages for every mandatary filed")
	public void user_should_get_a_proper_warning_messages_for_every_mandatary_filed() {
		
		RegisterPage rp = new RegisterPage(driver);
		
		
		Assert.assertTrue(rp.privacyPolicyWarningMessage());	 
		Assert.assertEquals("First Name must be between 1 and 32 characters!", rp.fnameWarningMessage());
		Assert.assertEquals("Last Name must be between 1 and 32 characters!", rp.lnameWarningMessage());
		Assert.assertEquals("E-Mail Address does not appear to be valid!", rp.emailWarningMessage());
		Assert.assertEquals("Telephone must be between 3 and 32 characters!", rp.telephoneWarningMessage());
		Assert.assertEquals("Password must be between 4 and 20 characters!", rp.passwordWarningMessage());
		
//		Assert.assertTrue(driver.findElement(By.xpath("//div[contains(@class,'alert-danger')]")).isDisplayed());	 
//		Assert.assertEquals("First Name must be between 1 and 32 characters!", driver.findElement(By.xpath("//input[@id='input-firstname']/following-sibling::div")).getText());
//		Assert.assertEquals("Last Name must be between 1 and 32 characters!", driver.findElement(By.xpath("//input[@id='input-lastname']/following-sibling::div")).getText());
//		Assert.assertEquals("E-Mail Address does not appear to be valid!", driver.findElement(By.xpath("//input[@id='input-email']/following-sibling::div")).getText());
//		Assert.assertEquals("Telephone must be between 3 and 32 characters!", driver.findElement(By.xpath("//input[@id='input-telephone']/following-sibling::div")).getText());
//		Assert.assertEquals("Password must be between 4 and 20 characters!", driver.findElement(By.xpath("//input[@id='input-password']/following-sibling::div")).getText());
	}

}
