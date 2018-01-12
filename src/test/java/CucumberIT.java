import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@CucumberOptions(plugin = { "pretty", "html:target/cucumber-html-report" },
		features = {"src/test/resources/acceptance/create-policy.feature"})
@RunWith(Cucumber.class)
public class CucumberIT {

}