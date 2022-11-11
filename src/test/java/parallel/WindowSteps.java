package parallel;

import com.DriverFactory.DriverFactory;
import com.PageFactory.WindowPage;

import io.cucumber.java.en.*;

public class WindowSteps {
	
	WindowPage windowpage=new WindowPage(DriverFactory.getDriver());
	
	@Then("User retrive data From WebTable")
	public void user_retrive_data_from_web_table() throws InterruptedException {
		windowpage.getTableElement();
	  
	}

	@When("User click on hidden button")
	public void user_click_on_hidden_button() {
	    windowpage.gethiddenButton();
	}

	@Then("User click on show button")
	public void user_click_on_show_button() {
		windowpage.getShowButton();
	   
	}

	@Then("User click on hidden top button")
	public void user_click_on_hidden_top_button() {
	    windowpage.getMouse();
	    windowpage.getTopButton();
	}

	@Then("User click on hidden reload button to reload page")
	public void user_click_on_hidden_reload_button_to_reload_page() {
		windowpage.getReloadButton();   
	}


}
