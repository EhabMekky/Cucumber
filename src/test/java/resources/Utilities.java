package resources;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;

import java.io.*;
import java.util.Properties;

public class Utilities {
    RequestSpecification req;
    PrintStream log = new PrintStream(new FilterOutputStream(new FileOutputStream("logging.txt")));
    ResponseLoggingFilter responseLogFilter = new ResponseLoggingFilter(log);
    public Utilities() throws FileNotFoundException {
    }

    public RequestSpecification requestSpecification() throws IOException {

        req = new RequestSpecBuilder()
                .setBaseUri(getGlobalValue("baseUrl"))
                .addQueryParam("key","qaclick123")
                .addFilter(RequestLoggingFilter.logRequestTo(log))
                .addFilter(responseLogFilter)
                .setContentType("application/json").build();
        return req;
    }

    public static String getGlobalValue(String key) throws IOException {
        Properties prop = new Properties();
        FileInputStream fileInputStream = new FileInputStream("src/test/java/resources/global.properties");
        prop.load(fileInputStream);
        return prop.getProperty(key);
    }
}
