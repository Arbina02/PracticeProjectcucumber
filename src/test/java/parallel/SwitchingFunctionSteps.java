package parallel;

import com.DriverFactory.DriverFactory;
import com.PageFactory.SwitchingWindowPage;
import io.cucumber.java.en.*;

public class SwitchingFunctionSteps {
	
	private SwitchingWindowPage windowpage=new SwitchingWindowPage(DriverFactory.getDriver());
	
	@When("User click on Open window button")
	public void user_click_on_open_window_button() {		
	    windowpage.getWindow();
	}

	@Then("User will navigate to new window")
	public void user_will_navigate_to_new_window() {
		windowpage.getChildwidow();	
	}

	@When("User click on Open Tab button")
	public void user_click_on_open_tab_button() {
		windowpage.getTab();
	   
	}

	@Then("User will navigate to new Tab")
	public void user_will_navigate_to_new_tab() {
		windowpage.getChildTab();    
	}

	@When("User click on Alert option")
	public void user_click_on_alert_option() {
	    windowpage.getAlertAccept();
	}

	@Then("User  click on confirm option")
	public void user_click_on_confirm_option() {
		windowpage.getAlertDismiss();
	    
	}

	@Then("User Add data and perform related function")
	public void user_add_data_and_perform_related_function() {
	    windowpage.getAlertsend();
	}

}
