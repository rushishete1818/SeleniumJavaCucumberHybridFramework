package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
	
	static WebDriver driver;  //This creates one static driver variable for the whole class.
//	Meaning:
//		There is only one driver object
//		Every method in this class uses the same driver
	
	public static void initializeBrowser(String browserName) {
		
		
		
		if(browserName.equalsIgnoreCase("chrome")) {   
			
			driver = new ChromeDriver();
			
		} else if(browserName.equalsIgnoreCase("edge")) {
			
			driver = new EdgeDriver();
			
		} else if(browserName.equalsIgnoreCase("firefox")) {
			
			driver = new FirefoxDriver();
		} 
		
	
		
	}
	
	public static WebDriver getDriver() {
		
		return driver;    //This method does NOT create a browser.
                           //It simply returns the driver that was already created
		
	}

}
