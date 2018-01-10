import com.opencredo.concursus.spring.events.EventSystemBeans;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
import org.lobbying.PolicyApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;

@CucumberOptions(plugin = { "pretty", "html:target/cucumber-html-report" }, features = {
		"src/test/resources/acceptance"})
@RunWith(Cucumber.class)
public class CucumberIT {

}