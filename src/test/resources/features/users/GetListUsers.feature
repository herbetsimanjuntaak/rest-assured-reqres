@Reqres @Users @GetListUsers

Feature: Get List of Users API
  As a user of the Reqres API
  I want to retrieve a list of users
  So that I can view and interact with user data

  @ValidListUsers
  Scenario: Verify successful retrieval of the user list
    Given I set the GET request for endpoint "/api/users"
    When I send the GET request
    Then the response status code should be 200
    And the value of "page" should be "1"
    And the value of "per_page" should be "6"
    And the value of "total" should be "12"
    And the value of "total_pages" should be "2"
    And all fields in the "data" array should not be null
    And the response body should match the JSON Schema "user_list_schema.json"

  @ValidListUsersQuery
  Scenario: Verify successful retrieval of the user list with query parameters
    Given I set the GET request for endpoint "/api/users"
    When I send the GET request with query parameters:
      | key  | value |
      | page | 2     |
    Then the response status code should be 200
    And the value of "page" should be "2"
    And the value of "per_page" should be "6"
    And the value of "total" should be "12"
    And the value of "total_pages" should be "2"
    And all fields in the "data" array should not be null
    And the response body should match the JSON Schema "user_list_schema.json"

  @InvalidListUsersQuery
  Scenario: Verify handling of invalid query parameters in user list request
    Given I set the GET request for endpoint "/api/users"
    When I send the GET request with query parameters "page" and "9999"
    Then the response status code should be 200
    And the value of "page" should be "9999"
    And the value of "per_page" should be "6"
    And the value of "total" should be "12"
    And the value of "total_pages" should be "2"
    And the "data" array in the response body should be empty
    And the response body should match the JSON Schema "user_list_invalid_schema.json"


