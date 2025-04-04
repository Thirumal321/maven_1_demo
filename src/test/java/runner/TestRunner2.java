package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/resources/features",
    glue = "stepDefinitions",
   // plugin = {"pretty", "html:target/cucumber-reports/cucumber.html"}
    plugin = {"pretty", "json:target/cucumber-reports/cucumber.json"}
)
public class TestRunner2 extends AbstractTestNGCucumberTests {
}
