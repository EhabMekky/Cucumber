package stepDestinations;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class stepDestination {
    @Given("Add Place Payload")
    public void addPlacePayload() {
    }

    @When("User calls {string} with POST http request")
    public void userCallsWithPOSTHttpRequest(String arg0) {
    }

    @Then("the API call is success with status code {int}")
    public void theAPICallIsSuccessWithStatusCode(int arg0) {
    }

    @And("{string} in response body is {string}")
    public void inResponseBodyIs(String arg0, String arg1) {
    }

}
