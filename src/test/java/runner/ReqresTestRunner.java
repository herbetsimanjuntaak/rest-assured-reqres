package runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "pretty",
                "html:reports/reqres-api-report.html",  // Laporan HTML
                "json:reports/reqres-api-report.json"   // Laporan JSON
        },
        glue = {"steps"},
        features = {"src/test/resources/features"},
        tags = "@Reqres"
)
public class ReqresTestRunner {
}
