package parallel;

import org.junit.runner.RunWith;
import org.testng.annotations.DataProvider;
import io.cucumber.junit.Cucumber;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(
		  features= {"src/test/resources/parallel"},
		  glue= {"parallel"},
		  plugin= {"pretty",
				  "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				  "timeline:test-output-thread/"
		  },
		  monochrome=true,
		  dryRun=false
		)
public class TestRunner extends AbstractTestNGCucumberTests{
	
    @DataProvider(parallel=true)
	public Object[][] scenario()
	{
		return super.scenarios();
	}

}
