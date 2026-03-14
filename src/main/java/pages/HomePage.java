package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//span[text()='My Account']")
	private WebElement accountMenuDropdown;
	
	public void clickonAccountoption() {
		accountMenuDropdown.click();
	}
	
	@FindBy(linkText="Login")
	private WebElement loginOption;
	
	public void clickonLoginOption() {
		loginOption.click();
	}
	
	@FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right']//a[text()='Register']")
	private WebElement registerOption;
	
	public void clickonRegisterOption() {
		registerOption.click();
	}

}
