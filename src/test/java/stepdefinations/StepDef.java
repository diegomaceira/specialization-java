package stepdefinations;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:features/Registration.feature",glue = "stepdefinations",plugin = {"pretty","html:target/test-report.html"})
public class StepDef {
}
