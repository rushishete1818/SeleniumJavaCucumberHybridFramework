package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.ElementUtils;

public class LoginPage {
	
	WebDriver driver;
	private ElementUtils elementUtils;
	
	public LoginPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtils(driver);
		
	}
	
	@FindBy(id="input-email")
	private WebElement emailField;
	
	public void enterEmail(String emailtext) {
		elementUtils.typetextintoElement(emailField, emailtext, 15);  // in this line we create typetextintoElement() method in ElementUtils class and by using create of that class in this class we call that method
	//	emailField.sendKeys(emailtext);
	}
	
	@FindBy(id="input-password")
	private WebElement passwordField;
	
	public void enterPassword(String password) {
		elementUtils.typetextintoElement(passwordField, password, 15);
	//	passwordField.sendKeys(password);
	}
	
	@FindBy(xpath ="//input[@value='Login']")
	private WebElement loginOption;
	
	public void clickonLoginButton() {
		elementUtils.clickOnElement(loginOption, 15);
	//	loginOption.click();
	}
	
	
	@FindBy(id="input-email")
	private WebElement invalidEmailField;
	
	public void enterInvalidEmail(String invalidEmail) {   
		invalidEmailField.sendKeys(invalidEmail);
	}
	
	
	@FindBy(id="input-password")
	private WebElement invalidpasswordField;
	
	public void enterInvalidPassword(String invalidPass) {
		invalidpasswordField.sendKeys(invalidPass);
	}
	
	
	
	
	
	

}
