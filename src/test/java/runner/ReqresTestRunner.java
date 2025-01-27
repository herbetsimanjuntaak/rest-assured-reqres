package runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "pretty",
                "html:target/reqres-api-reports.html",  // Laporan HTML
                "json:target/reqres-api-reports.json"   // Laporan JSON
        },
        glue = {"steps"},
        features = {"src/test/resources/features"},
        tags = "@Reqres"
)
public class ReqresTestRunner {
}
