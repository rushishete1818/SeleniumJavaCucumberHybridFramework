package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features="src/test/resources/features",
        glue={"stepdefinations","hooks"},
      //  tags="@smoke or regression",
        plugin={"pretty","html:target/cucumber-report.html"},
//		plugin={"pretty","io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"},  // for allure report
		publish=true,
        monochrome=true)
public class TestRunners extends AbstractTestNGCucumberTests {
	

}
