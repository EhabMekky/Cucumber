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

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class stepDestination extends Utilities {
    Response response;
    ResponseSpecification resSpec;
    RequestSpecification res;

    @Given("Add Place Payload")
    public void addPlacePayload() {
         resSpec = new ResponseSpecBuilder().expectStatusCode(200).build();
         res = given().spec(requestSpecification()).body(TestDataBuild.addPlacePayload());
    }

    @When("User calls {string} with POST http request")
    public void userCallsWithPOSTHttpRequest(String arg0) {
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
