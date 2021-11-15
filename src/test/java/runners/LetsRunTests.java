package runners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin = {"html:target/cucumber-reports", "json:target/cucumber.json"},
		features="./src/test/resources/features",
		glue="step_definitions",
		dryRun=false,
		tags="@smokeTest"
		)
public class LetsRunTests {

}
