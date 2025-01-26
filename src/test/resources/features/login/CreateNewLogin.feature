@Reqres @Users @Login
Feature: Login a user
  As a user of the Reqres API
  I want to log in with my credentials
  So that I can validate the login API's POST functionality

  @ValidLoginUser
  Scenario: Verify successful user login
    Given I set the POST request for endpoint "/api/login"
    And I set the request body with email "eve.holt@reqres.in" and "cityslicka"
    When I send the POST request
    Then the response status code should be 200
    And the response body should contain "token"
    And the response body should match the JSON Schema "create_login_schema.json"

  @InvalidLoginUser
  Scenario Outline: Verify unsuccessful user login due to empty required fields
    Given I set the POST request for endpoint "/api/login"
    And I set the request body with email "<Email>" and "<Password>"
    When I send the POST request
    Then the response status code should be 400
    And the value of "error" should be "<Message>"
    Examples:
      | Email              | Password | Message                   |
      | eve.holt@reqres.in |          | Missing password          |
      |                    | pistol   | Missing email or username |
      |                    |          | Missing email or username |
      | invalid_user       | pistol   | user not found            |