package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class helloTest {
    @Given("the endpoint URL is available")
    public void the_endpoint_url_is_available() {
        System.out.println("This is Given statement and url is available");
    }
    @When("I access the hello endpoint")
    public void i_access_the_hello_endpoint() {
        System.out.println("This is When statement to access hello endpoint");

    }
    @When("I access the hola endpoint")
    public void i_access_the_hola_endpoint() {
        System.out.println("This is When statement to access hola endpoint");
    }
    @When("I access the namaste endpoint")
    public void i_access_the_namaste_endpoint() {
        System.out.println("This is When statement to access namaste endpoint");
    }
    @Then("the response status code should be {int}")
    public void the_response_status_code_should_be(Integer int1) {
        System.out.println("This is Then statement to check that response code " + int1 + " is displayed");
    }
    @Then("the response body should contain {string}")
    public void the_response_body_should_contain(String string) {
        System.out.println("This is Then statement to check test " + string + "i s displayed");
    }
}