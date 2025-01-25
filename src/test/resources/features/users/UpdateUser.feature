@Reqres @Users @UpdateUser

Feature: Update a user
  As a user of the Reqres API
  I want to update an existing user using the Reqres API
  So that I can validate the API's PUT functionality

  @ValidUpdateUser
  Scenario Outline: Verify successful user update
    Given I set the PUT request for endpoint "/api/users" and "<id>"
    And I set the request body with name "<name>" and job "<job>"
    When I send the PUT request
    Then the response status code should be 200
    And the value of "name" should be "<name>"
    And the value of "job" should be "<job>"
    And the response body should match the JSON Schema "update_user_schema.json"
    Examples:
      | id | name     | job     |
      | 1  | morpheus | leader  |
      | 2  | neo      | the one |

  @InvalidUpdateUser @BUG
  Scenario Outline: Verify unsuccessful user update due to empty required fields
    Given I set the PUT request for endpoint "/api/users" and "<id>"
    And I set the request body with name "<name>" and job "<job>"
    When I send the PUT request
    Then the response status code should be 200
    And the value of "name" should be "<name>"
    And the value of "job" should be "<job>"
    And the response body should match the JSON Schema "update_user_schema.json"
    Examples:
      | id | name     | job    |
      | 2  |          | leader |
      | 3  | morpheus |        |
      | 4  |          |        |
