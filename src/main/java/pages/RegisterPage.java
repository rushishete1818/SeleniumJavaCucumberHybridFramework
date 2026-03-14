package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	
	WebDriver driver;
	
	public RegisterPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(id="input-firstname")
	private WebElement fnameField;
	
	public void enterFname(String fname) {
		fnameField.sendKeys(fname);
	}
	
	@FindBy(id="input-lastname")
	private WebElement lnameField;
	
	public void enterlname(String lname) {
		lnameField.sendKeys(lname);
	}
	
	@FindBy(id="input-email")
	private WebElement emailField;
	
	public void enterEmail(String email) {
		emailField.sendKeys(email);
	}
	
	@FindBy(id="input-telephone")
	private WebElement telephoneField;
	
	public void enterTelephone(String telephone) {
		telephoneField.sendKeys(telephone);
	}
	
	@FindBy(id="input-password")
	private WebElement passwordField;
	
	public void enterpassword(String password) {
		passwordField.sendKeys(password);
	}
	
	@FindBy(id="input-confirm")
	private WebElement confirmPassField;
	
	public void enterConpassword(String password) {
		confirmPassField.sendKeys(password);
	}

	
	@FindBy(xpath="//input[@name='agree']")
	private WebElement privacyPolicyOption;
	
	public void clickonPrivacyPolicy() {
		privacyPolicyOption.click();  
	}
	
	@FindBy(xpath="//input[@class='btn btn-primary']")
	private WebElement continueButton;
	
	public void clickoncontinueButton() {
		continueButton.click();  
	}
	
	@FindBy(xpath="(//input[@name='newsletter'])[1]")
	private WebElement newsLetterOption;
	
	public void clickonNewsLetterOption() {
		newsLetterOption.click();  
	}
	
	
	//Assertion
	
	@FindBy(xpath="//div[contains(@class,'alert-danger')]")
	private WebElement warningmessageForPrivacyPolicy;
	
	@FindBy(xpath="//input[@id='input-firstname']/following-sibling::div")
	private WebElement warningmessageForFname;
	
	@FindBy(xpath="//input[@id='input-lastname']/following-sibling::div")
	private WebElement warningmessageForLname;
	
	@FindBy(xpath="//input[@id='input-email']/following-sibling::div")
	private WebElement warningmessageForEmail;
	
	@FindBy(xpath="//input[@id='input-telephone']/following-sibling::div")
	private WebElement warningmessageForTelephone;
	
	@FindBy(xpath="//input[@id='input-password']/following-sibling::div")
	private WebElement warningmessageForPassword;
	
	
	public boolean privacyPolicyWarningMessage() {
		return warningmessageForPrivacyPolicy.isDisplayed();
	}
	
	public String fnameWarningMessage() {
		return warningmessageForFname.getText();
	}
	
	public String lnameWarningMessage() {
	    return	warningmessageForLname.getText();
	}
	
	public String emailWarningMessage() {
		return warningmessageForEmail.getText();
	}
	
	public String telephoneWarningMessage() {
		return warningmessageForTelephone.getText();
	}
	
	public String passwordWarningMessage() {
		return warningmessageForPassword.getText();
	}
	
	
	
	
	
	
	
}
