package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.Config;
import utilities.ResponseContext;
import utilities.TestConfig;
import utilities.RequestSpec;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;

public class weatherTest {

    Response weatherResponse = ResponseContext.getResponse(); //

    @When("I access the London weather endpoint")
    public void i_access_the_London_weather_endpoint() {
        Response response = given()
                .spec(RequestSpec.getSpec())
                .when()
                .get(TestConfig.London_ENDPOINT());

        ResponseContext.setResponse(response);
    }

    @When("I access the Paris weather endpoint")
    public void i_access_the_Paris_weather_endpoint() {
        Response response = given()
                .spec(RequestSpec.getSpec())
                .when()
                .get(TestConfig.Paris_ENDPOINT());

        ResponseContext.setResponse(response);
    }

    @When("I access the New York weather endpoint")
    public void i_access_the_new_york_weather_endpoint() {
        Response response = given()
                .spec(RequestSpec.getSpec())
                .when()
                .get(TestConfig.NewYork_ENDPOINT());

        ResponseContext.setResponse(response);
    }

    @When("I access the Tokyo weather endpoint")
    public void i_access_the_tokyo_weather_endpoint() {
        System.out.println("This is When statement to access Tokyo endpoint"); // Invalid endpoint -> 404

        Response response = given()
                .spec(RequestSpec.getSpec())
                .when()
                .get(Config.namasteyEndpoint());

        ResponseContext.setResponse(response);

    }

//    @Then("the response body should contain {string}")
//    public void the_weather_response_body_should_contain(String string) {
//        System.out.println("This is Then statement to check test " + string + "is displayed");
//    }
//
//    @Then("the response error should contain {string}")
//    public void the_weather_response_error_should_contain(String expectedText) {
//        String body = weatherResponse.getBody().asString();
//        System.out.println(">>> RESPONSE BODY:\n" + body);
//
//        assertThat(body, org.hamcrest.Matchers.containsString(expectedText));
//    }
//
//    @Then("the response message should contain {string}")
//    public void the_weather_response_message_should_contain(String expectedText) {
//        String body = weatherResponse.getBody().asString();
//
//        assertThat(body, org.hamcrest.Matchers.containsString(expectedText));
//    }
}
