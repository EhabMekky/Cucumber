package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources.TestDataBuild;
import resources.Utilities;

import java.io.FileNotFoundException;
import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class stepDestination extends Utilities {
    Response response;
    ResponseSpecification resSpec;
    RequestSpecification res;

    public stepDestination() throws FileNotFoundException {
    }

    @Given("Add Place Payload with {string} {string} {string}")
    public void add_place_payload_with(String name, String language, String address) throws IOException {
        res = given().spec(requestSpecification()).body(TestDataBuild.addPlacePayload(name, language, address));
    }

    @When("User calls {string} with POST http request")
    public void userCallsWithPOSTHttpRequest(String arg0) {
        resSpec = new ResponseSpecBuilder().expectStatusCode(200).build();
        response = res.when().post("/maps/api/place/add/json")
                .then().spec(resSpec).extract().response();
    }

    @Then("the API call is success with status code {int}")
    public void theAPICallIsSuccessWithStatusCode(int arg0) {
        assertEquals(200, response.getStatusCode());
    }

    @Then("{string} in response body is {string}")
    public void inResponseBodyIs(String key, String expected) {
        String responseString = response.asString();
        JsonPath js = new JsonPath(responseString);
        //assertEquals(js.get(key).toString(), expected);
    }
}
