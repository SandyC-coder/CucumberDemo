package stepsDefinitions;

import java.util.List;
import java.util.Map;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class LoginSteps {
	
	@Given ("the user enters login data")
	public void theUserEntersLoginData (DataTable table) {
		List<Map<String, String>> data= table.asMaps(String.class, String.class);
		
		for(Map<String,String> user:data) {
			System.out.println(user.get("username"));
			System.out.println(user.get("password"));
		}
	}
	}
	
	

/*
	@Given("the user enters username {string}")
	public void theUserEntersUsername (String username) {
		System.out.println(username);
	}
	
	@And ("the user enters password {string}")
	public void theUserEntersPassword(String password) {
		System.out.println(password);
	}
    @Then ("login should be successful")
    public void loginShouldBeSuccessful () {
    	System.out.println("Login Successful");
    }
}
*/