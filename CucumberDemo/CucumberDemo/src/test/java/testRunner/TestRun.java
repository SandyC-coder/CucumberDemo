package testRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/features",
    //features={".//features/login.feature"},
    glue = {"stepsDefinitions","hooks"},
    plugin = {"pretty", "html:target/cucumber-report.html",
    		"rerun:target/rerun.txt",},
    monochrome = true,
    tags = "@searchTest"
)
public class TestRun {
}