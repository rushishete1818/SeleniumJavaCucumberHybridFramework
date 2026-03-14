package hooks;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.ConfigReader;


public class Myhooks {
	
	WebDriver driver;
	
	@Before
	public void setUp() {
		
		Properties prop = ConfigReader.initializeProperties();
		DriverFactory.initializeBrowser(prop.getProperty("browsername"));
		driver = DriverFactory.getDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
		
	}
	
//	@After
//	public void tearDown() {
//		driver.quit();
//	}
	 
	@After
    public void tearDown(Scenario scenario) {

        if (scenario.isFailed()) {

            TakesScreenshot ts = (TakesScreenshot) driver;
            byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);

            scenario.attach(screenshot, "image/png", scenario.getName());
        }

        driver.quit();
    }

}
