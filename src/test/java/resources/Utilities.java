package resources;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.specification.RequestSpecification;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.PrintStream;

public class Utilities {
    RequestSpecification req;
    PrintStream log = new PrintStream(new FilterOutputStream(new FileOutputStream("logging.txt")));

    public Utilities() throws FileNotFoundException {
    }

    public RequestSpecification requestSpecification() throws FileNotFoundException {

        req = new RequestSpecBuilder()
                .setBaseUri("https://rahulshettyacademy.com")
                .addQueryParam("key","qaclick123")
                .addFilter(RequestLoggingFilter.logRequestTo(log))
                .setContentType("application/json").build();
        return req;
    }
}
