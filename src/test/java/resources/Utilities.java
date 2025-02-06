package resources;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class Utilities {
    RequestSpecification req;

    public RequestSpecification requestSpecification() {
        req = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").addQueryParam("key","qaclick123")
                .setContentType("application/json").build();
        return req;
    }
}
