package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
	
	WebDriver driver;
	
	public SearchPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);  
		
	}

	
	@FindBy(xpath="//input[@name='search']")
	private WebElement validProductName;
	
	public void enterValidProductName(String productvalidname) {
		validProductName.sendKeys(productvalidname);
	}
	
	
	@FindBy(xpath="//button[@class='btn btn-default btn-lg']")
	private WebElement searchButton;
	
	public void clickonSearch() {
		searchButton.click();
	}
	
	
	@FindBy(xpath="//input[@name='search']")
	private WebElement invalidProductName;
	
	public void enterInvalidProductName(String productinvalidname) {
		invalidProductName.sendKeys(productinvalidname);
	}
	
	
}
