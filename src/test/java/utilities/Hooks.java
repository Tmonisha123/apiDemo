package utilities;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import static io.restassured.RestAssured.*;

public class Hooks {

    public static int noOfTimes = 0;

    @Before
    public void setup() {
        noOfTimes++;
//        String baseURI = "http://localhost";
        String baseURI = Config.baseUrl();
        port = 8080;
        System.out.println("I am executed {noOfTimes}");
    }

    @After
    public void afterScenario(Scenario scenario) {
        scenario.log("Scenario executed");
    }
}
