package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
// The annotations above connect Gherkin steps to Java methods

import utilities.Config;
import utilities.RequestSpec;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/*
* This class contains Cucumber step definitions (glue code) for testing greeting APIs like:
*    - /hello
*    - /hola
*    - /namaste
*
* It uses:
*    - Cucumber for BDD step mapping (@Given, @When, @Then)
*    - REST Assured for making HTTP API calls
*    - Hamcrest for assertions
*
* Each @Given/@When/@Then method is triggered by a matching
* step in a .feature file.
*
*  NOTE:
*  - The 'response' field stores the HTTP response so it can
*    be reused across steps in the same scenario.
*  - All endpoints are defined in utilities.Config
*  - Common request settings (base URI, headers, etc.) are
*    defined in utilities.RequestSpec
*/
public class helloTest {

    Response response; //

    @Given("the endpoint URL is available")
    public void the_endpoint_url_is_available() {
        System.out.println("This is Given statement and url is available");
    }

    @When("I access the hello endpoint")
    public void i_access_the_hello_endpoint() {
        System.out.println("This is When statement to access hello endpoint");

        response = given()
                .spec(RequestSpec.getSpec())
                .when()
                .get(Config.helloEndpoint()); // How the response is captured
                // A proper rest assured framework - can be used anywhere
    }

    @When("I access the hola endpoint")
    public void i_access_the_hola_endpoint() {

        System.out.println("This is When statement to access hola endpoint");
        response = given()
                .spec(RequestSpec.getSpec())
                .when()
                .get(Config.holaEndpoint());
    }

    @When("I access the namaste endpoint")
    public void i_access_the_namaste_endpoint() {
        System.out.println("This is When statement to access namaste endpoint");
        response = given()
                .spec(RequestSpec.getSpec())
                .when()
                .get(Config.namasteEndpoint());
    }

//    @When("I access the namastey endpoint")
//    public void i_access_the_namastey_endpoint() {
//        System.out.println("This is When statement to access namastey endpoint"); // Invalid endpoint -> 404
//    }

    @When("I access the namastey endpoint")
    public void i_access_the_namastey_endpoint() {
        System.out.println("This is When statement to access namastey endpoint"); // Invalid endpoint -> 404

        response = given()
                .spec(RequestSpec.getSpec())
                .when()
                .get(Config.namasteyEndpoint());
    }

//    @Then("the response status code should be {int}")
//    public void the_response_status_code_should_be(Integer int1) {
//        System.out.println("This is Then statement to check that response code " + int1 + " is displayed"); // Need to verify the 200 status code.
//        assertThat(response.getStatusCode(), equalTo(int1));
//    }

    @Then("the response status code should be {int}")
    public void the_response_status_code_should_be(Integer int1) {
        int actual = response.getStatusCode();
        System.out.println(">>> ACTUAL STATUS CODE = " + actual);

        assertThat(actual, equalTo(int1));
    }

    @Then("the response body should contain {string}")
    public void the_response_body_should_contain(String string) {
        System.out.println("This is Then statement to check test " + string + "i s displayed");
    }

    @Then("the response error should contain {string}")
    public void the_response_error_should_contain(String expectedText) {
        String body = response.getBody().asString();
        System.out.println(">>> RESPONSE BODY:\n" + body);

        assertThat(body, org.hamcrest.Matchers.containsString(expectedText));
    }

    @Then("the response message should contain {string}")
    public void the_response_message_should_contain(String expectedText) {
        String body = response.getBody().asString();

        assertThat(body, org.hamcrest.Matchers.containsString(expectedText));
    }
}