package parallel;

import java.util.Properties;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import com.DriverFactory.DriverFactory;
import com.Utility.ConfigReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class AppHook
{
	public WebDriver driver;
	private DriverFactory factory;
	private ConfigReader reader;
	Properties prop;
	
	@Before(order=0)
	public void reader()
	{
		reader=new ConfigReader();
		prop=reader.init_prop();
	}
	
	@Before(order=1)
	public void launch()
	{
		String browserName=prop.getProperty("browser");
		factory=new DriverFactory();
		driver = factory.init_browser(browserName);
	}
	
	@After(order=0)
	public void quitBrowser()
	{
		driver.quit();
	}
	
	@After(order=1)
	public void tearDown(Scenario scenario)
	{
		if(scenario.isFailed()) {
		String sourcepath=scenario.getName().replaceAll(" ", "_");
		byte[] destpath=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
	    scenario.attach(destpath, "image/jpg", sourcepath);
		}
	}
}
