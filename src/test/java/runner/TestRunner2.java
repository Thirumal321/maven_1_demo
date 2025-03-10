package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/resources/features",
    glue = "stepDefinitions",
    plugin = {
        "pretty",
        "html:target/cucumber-reports",
        "json:target/Cucumber.json"
    }
)
public class TestRunner2 extends AbstractTestNGCucumberTests {
}
