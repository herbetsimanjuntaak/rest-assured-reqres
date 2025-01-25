@Reqres @Users @CreateUser

Feature: Create a user
  As a user of the Reqres API
  I want to create a new user using the Reqres API
  So that I can validate the API's POST functionality

  @ValidCreateUser
  Scenario Outline: Verify successful user creation
    Given I set the POST request for endpoint "/api/users"
    And I set the request body with name "<name>" and job "<job>"
    When I send the POST request
    Then the response status code should be 201
    And the value of "name" should be "<name>"
    And the value of "job" should be "<job>"
    And the response body should match the JSON Schema "create_user_schema.json"
    Examples:
      | name     | job     |
      | morpheus | leader  |
      | neo      | the one |

  @InvalidCreateUser @BUG
  Scenario Outline: Verify unsuccessful user creation due to missing required fields
    Given I set the POST request for endpoint "/api/users"
    And I set the request body with name "<name>" and job "<job>"
    When I send the POST request
    Then the response status code should be 201
    And the value of "name" should be "<name>"
    And the value of "job" should be "<job>"
    And the response body should match the JSON Schema "create_user_schema.json"
    Examples:
      | name     | job    |
      |          | leader |
      | morpheus |        |
      |          |        |