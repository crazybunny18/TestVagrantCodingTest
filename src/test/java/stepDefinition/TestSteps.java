package stepDefinition;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Logger;

import org.json.simple.parser.ParseException;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.logging.Logger;

public class TestSteps {
	static StepBuilder sb = new StepBuilder();
	static int countInternationalPlayrs;
	static int countWicketKeepers;

	@Given("Team RCB Player List")
	public void team_rcb_player_list() {
		try {
			sb.init();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	@When("The name and location of RCB as follows")
	public void the_name_and_location_of_rcb_as_follows() {
		try {
			sb.countInternationalPlayers();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@And("get the count of international players for RCB")
	public void get_the_count_of_international_players_for_rcb() {
		try {
			sb.displayPlayersDetails(countInternationalPlayrs);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	@Then("validate for the count of international players is four")
	public void validate_for_the_count_of_international_players_is_four() {
		try {
			sb.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	@When("The role of RCB as follows")
	public void the_role_of_rcb_as_follows() {
		try {
			sb.countWicketKeeper();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	@And("get the count of Weeket Keepers for RCB")
	public void get_the_count_of_weeket_keepers_for_rcb() {
		try {
			sb.displayWicketKeeperDetails(countWicketKeepers);
			;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	@Then("validate for the count of Wicket Keepers is not less than one")
	public void validate_for_the_count_of_wicket_keepers_is_not_less_than_one() {
		try {
			sb.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
