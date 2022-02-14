import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/features",
        glue = {"stepdefinitions", "hooks"},
        tags = "@AmazonTest",
        plugin = {"pretty",
                "html:target/systemTestReports/html",
                "json:target/systemTestReports/json/report.json",
                "junit:target/systemTestReports/junit/report.xml"})
public class RunnerTest {
}
