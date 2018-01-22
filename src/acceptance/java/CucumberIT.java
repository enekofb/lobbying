import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@CucumberOptions(plugin = { "pretty", "html:target/cucumber-html-report" },
		features = {"src/acceptance/resources/media/add-media-source.feature"})
@RunWith(Cucumber.class)
public class CucumberIT {

}