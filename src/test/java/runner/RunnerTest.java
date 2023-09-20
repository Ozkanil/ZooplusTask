package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "html:target/default-cucumber-reports.html",
                "junit:target/xml-report/cucumber.xml"
        },
        features = "./src/test/resources/features",
        glue = {"stepdefinitions", "hooks"},
        tags = "@check_price",
        dryRun = false
)
public class RunnerTest {
}
