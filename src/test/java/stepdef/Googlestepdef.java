package stepdef;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.cucumber.java.en.*;

public class Googlestepdef {
	public WebDriver driver;
	public String actT;
	@Given("Browser should open app should launch")
	public void browser_should_open_app_should_launch() {
	   driver =new EdgeDriver();
	  driver.get("https://www.google.com");
	  
	}

	@When("User captures Title of google page")
	public void user_captures_title_of_google_page() {
	    actT = driver.getTitle();
	}

	@Then("Excepted and Actual Title should match")
	public void excepted_and_actual_title_should_match() {
	   if(actT.contains("Google")) {
	   System.out.println("TC is pass");
	   }  else{
		   System.out.println("Tc is fail");
	   }

	}
}
