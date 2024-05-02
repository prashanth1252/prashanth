package runnerclasses;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="C:\\unocareer\\eclipse-workspace\\bddcucumber\\src\\test\\resources\\featurefiles\\Google.feature",glue="stepdef")
public class Googlerunner {

	
}
