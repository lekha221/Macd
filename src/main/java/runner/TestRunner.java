package runner;

import org.junit.runner.RunWith;
import cucumber.api.junit.Cucumber;
import cucumber.api.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "resources"
		,glue={"steps"}
		//,tags={"@FirstScenario , @SecondScenario"}
		,tags={"@CompleteTest"}
		)
public class TestRunner {}
