package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.hamcrest.Matchers;
import utilities.Config;
import utilities.TestConfig;
import utilities.RequestSpec;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class weatherTest {

    public static Response response;

    @When("I access the London weather endpoint")
    public void i_access_the_London_weather_endpoint() {
        response = given()
                .spec(RequestSpec.getSpec())
                .when()
                .get(TestConfig.London_ENDPOINT());

    }

    @When("I access the Paris weather endpoint")
    public void i_access_the_Paris_weather_endpoint() {
        response = given()
                .spec(RequestSpec.getSpec())
                .when()
                .get(TestConfig.Paris_ENDPOINT());

    }

    @When("I access the New York weather endpoint")
    public void i_access_the_new_york_weather_endpoint() {
        response = given()
                .spec(RequestSpec.getSpec())
                .when()
                .get(TestConfig.NewYork_ENDPOINT());

    }

    @When("I access the Tokyo weather endpoint")
    public void i_access_the_tokyo_weather_endpoint() {
        System.out.println("This is When statement to access Tokyo endpoint"); // Invalid endpoint -> 404

        response = given()
                .spec(RequestSpec.getSpec())
                .when()
                .get(TestConfig.Tokyo_ENDPOINT());
    }
}