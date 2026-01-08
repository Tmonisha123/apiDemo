@regression
Feature: Verify endpoint response text

@smoke
    Scenario: Hello Endpoint displays expected text on access
    Given the endpoint URL is available
    When I access the hello endpoint
    Then the response status code should be 200
    And the response body should contain "hello"
@sanity
    Scenario: Hola Endpoint displays expected text on access
    Given the endpoint URL is available
    When I access the hola endpoint
    Then the response status code should be 200
    And the response body should contain "hola"

    Scenario: Namaste Endpoint displays expected text on access
    Given the endpoint URL is available
    When I access the namaste endpoint
    Then the response status code should be 200
    And the response body should contain "namaste"