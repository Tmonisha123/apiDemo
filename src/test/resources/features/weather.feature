@regression
Feature: Verify endpoint response text (Weather)

  I want to retrieve weather information for supported cities
  So that I can view the temperature and conditions

@smoke
  Scenario: Retrieve weather for London
  Given the endpoint URL is available
  When I access the London weather endpoint
  Then the response status code should be 200
  And the response body should contain "Temperature"
  And the response body should contain "Condition"
  And the response body should contain "cloudy"

  Scenario: Get weather for Paris
    Given the endpoint URL is available
    When I access the Paris weather endpoint
    Then the response status code should be 200
    And the response body should contain "Temperature"
    And the response body should contain "Condition"
    And the response body should contain "sunny"

  Scenario: Get weather for New York
    Given the endpoint URL is available
    When I access the New York weather endpoint
    Then the response status code should be 200
    And the response body should contain "Temperature"
    And the response body should contain "Condition"
    And the response body should contain "rainy"

  Scenario: Wrong Tokyo Endpoint displays expected text on access
    Given the endpoint URL is available
    When I access the Tokyo weather endpoint
    Then the response status code should be 404
    And the response error should contain "Not Found"
    And the response message should contain "No static resource tokyo"