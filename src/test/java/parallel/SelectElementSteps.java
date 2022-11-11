package parallel;

import org.testng.Assert;

import com.DriverFactory.DriverFactory;
import com.PageFactory.SelectElementPage;

import io.cucumber.java.en.*;

public class SelectElementSteps {
	
	private SelectElementPage page=new SelectElementPage(DriverFactory.getDriver());
	
	
	@Given("User redirected to Practice page")
	public void user_redirected_to_practice_page() {
	   DriverFactory.getDriver()
	     .navigate().to("https://courses.letskodeit.com/practice");
	}

	@When("User is rediredted to page")
	public void user_is_rediredted_to_page() {
		String expectedvalue="Practice Page";
		String actualvalue=DriverFactory.getDriver().getTitle();
		System.out.println(actualvalue);
		Assert.assertEquals(expectedvalue, actualvalue);
	}
	

	@Then("User select the radio button")
	public void user_select_the_radio_button() {
		page.getradioFunction();
	    
	}

	@Then("User select the value from dropdown")
	public void user_select_the_value_from_dropdown() {
		page.getselectdrop();    
	}

	@Then("User select option from dropdown")
	public void user_select_option_from_dropdown() {
		page.getMultipleDropdown();
	    
	}

	@Then("User select checkbox option from options")
	public void user_select_checkbox_option_from_options() {
		page.getCheckbox();	    
	}

}
