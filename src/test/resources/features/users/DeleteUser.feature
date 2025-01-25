@Reqres @Users @DeleteUser

Feature: Delete a user
  As a user of the Reqres API
  I want to delete an existing user using the Reqres API
  So that I can validate the API's DELETE functionality

  @ValidDeleteUser
  Scenario Outline: Verify successful user deletion
    Given I set the DELETE request for endpoint "/api/users" and "<id>"
    When I send the DELETE request
    Then the response status code should be 204
    And the response body should be empty
    Examples:
      | id  |
      | 1   |
      | 2   |

  @InvalidDeleteUser @BUG
  Scenario Outline: Verify unsuccessful user deletion for a non-existent user
    Given I set the DELETE request for endpoint "/api/users" and "<id>"
    When I send the DELETE request
    Then the response status code should be 204
    And the response body should be empty
    Examples:
      | id  |
      | 9999|
      | 1000|
