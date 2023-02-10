package stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TestSteps {
	@Given("Team RCB Player List")
	public void team_rcb_player_list() {
		System.out.println("Inside Step 1");
	}

	@When("The name and location of RCB as follows")
	public void the_name_and_location_of_rcb_as_follows() {
		System.out.println("Inside Step 2");
	}

	@And("get the count of international players for RCB")
	public void get_the_count_of_international_players_for_rcb() {
		System.out.println("Inside Step 3");
	}

	@Then("validate for the count of international players is four")
	public void validate_for_the_count_of_international_players_is_four() {
		System.out.println("Inside Step 4");
	}

}
