package baserunner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(glue = "stepdefs",
                features ={"src/test/resources/features/contact_page.feature"})
public class ContactPageBaseRunner extends AbstractTestNGCucumberTests {
}
