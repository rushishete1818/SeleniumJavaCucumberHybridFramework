package utils;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;



public class ElementUtils {
	
	WebDriver driver;
	
	public ElementUtils(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickOnElement(WebElement element, long durationinSeconds) {
		
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationinElement));
//		WebElement webelement = wait.until(ExpectedConditions.elementToBeClickable(element));
		WebElement webelement = waitForElement(element, durationinSeconds);  // insted of upper two lines create for that seprate method waitForElement() and call that element
		
		
		webelement.click();
			
	}
	
	
	public void typetextintoElement(WebElement element,String textTobeTyped ,long durationinSeconds) {
		
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationinElement));
//		WebElement webelement = wait.until(ExpectedConditions.elementToBeClickable(element));
		WebElement webelement = waitForElement(element, durationinSeconds);  // insted of upper two lines create for that seprate method waitForElement() and call that element
		
		webelement.click();
		webelement.clear();
		webelement.sendKeys(textTobeTyped);
		
	}
	
	
	public void selectOptionfromDropdownMenu(WebElement element,String dropDownOption ,long durationinSeconds) {
		
		WebElement webelement = waitForElement(element, durationinSeconds);
		
		Select select = new Select(webelement);
		select.selectByVisibleText(dropDownOption);
		
	}
	
	
	public WebElement waitForElement(WebElement element, long durationinSeconds) {
		
		WebElement webelement = null;
		
		try {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationinSeconds));
		webelement = wait.until(ExpectedConditions.elementToBeClickable(element));
		} catch(Throwable e) {
			e.printStackTrace();
		}
		return webelement;
	}
	
	
	
	
	public void acceptAlert(long durationinSeconds) {
		
		Alert alert = waitForAlert(durationinSeconds);
		alert.accept();
		
	}
	
	public void dismissAlert(long durationinSeconds) {
		
		Alert alert = waitForAlert(durationinSeconds);
		alert.dismiss();
		
	}
	
	public Alert waitForAlert(long durationinSeconds) {
		
		Alert alert = null;
		
		try {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationinSeconds));
		alert = wait.until(ExpectedConditions.alertIsPresent());
		} catch(Throwable e) {
			e.printStackTrace();
		}
		return alert;
	}
	
	
	
	public void mouseHoverandClick(WebElement element, long durationinSeconds) {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationinSeconds));
		WebElement weblement = wait.until(ExpectedConditions.visibilityOf(element));
		
		Actions option = new Actions(driver);
		option.moveToElement(weblement).click().build().perform();
		
	}
	
	
	public void javascriptClick(WebElement element, long durationinSeconds) {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationinSeconds));
		WebElement weblement = wait.until(ExpectedConditions.visibilityOf(element));
		
		JavascriptExecutor jse = ((JavascriptExecutor)driver); 
		jse.executeScript("arguments[0].click();", weblement);
		
	}

}
