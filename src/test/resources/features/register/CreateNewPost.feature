@Reqres @Users @Register
Feature: Register a user
  As a user of the Reqres API
  I want to register a new user
  So that I can validate the registration API's POST functionality

  @ValidRegisterUser
  Scenario: Verify successful user registration
    Given I set the POST request for endpoint "/api/register"
    And I set the request body with email "eve.holt@reqres.in" and "password123"
    When I send the POST request
    Then the response status code should be 200
    And the response body should contain "id"
    And the response body should contain "token"
    And the response body should match the JSON Schema "create_register_schema.json"

  @InvalidRegisterUser
  Scenario Outline: Verify unsuccessful user registration due to empty required fields
    Given I set the POST request for endpoint "/api/register"
    And I set the request body with email "<Email>" and "<Password>"
    When I send the POST request
    Then the response status code should be 400
    And the value of "error" should be "<Message>"
    Examples:
      | Email         | Password | Message                                       |
      | sydney@fife   |          | Missing password                              |
      |               | pistol   | Missing email or username                     |
      |               |          | Missing email or username                     |
      | invalid_email | pistol   | Note: Only defined users succeed registration |

