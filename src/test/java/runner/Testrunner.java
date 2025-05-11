package Runner;





import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/java/Features/Login.feature",glue="stepdefinitions")
public class Testrunner {
}
