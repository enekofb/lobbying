import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@CucumberOptions(plugin = { "pretty", "html:target/cucumber-html-report" },
		features = {"src/acceptance/resources/citizen/track-policy.feature"})
@RunWith(Cucumber.class)
public class LobbyingIT {

}