@Reqres @Users @GetSingleUser

Feature: Get Single User API
  As a user of the Reqres API
  I want to retrieve details of a single user by their ID
  So that I can view the user's information such as email, name, and avatar

  @ValidSingleUser
  Scenario: Verify response for a valid single user request
    Given I set the GET request for endpoint "/api/users"
    When I send the GET request with query parameters "id" and "2"
    Then the response status code should be 200
    And the value of "data.id" should be "2"
    And the value of "data.email" should be "janet.weaver@reqres.in"
    And the value of "data.first_name" should be "Janet"
    And the value of "data.last_name" should be "Weaver"
    And the value of "data.avatar" should be "https://reqres.in/img/faces/2-image.jpg"
    And the response body should have valid fields "id, email, first_name, last_name, avatar"
    And the response body should match the JSON Schema "single_user_schema.json"

  @InvalidSingleUser
  Scenario Outline: Verify response for an invalid single user request
    Given I set the GET request for endpoint "/api/users"
    When I send the GET request with query parameters "id" and "<Value>"
    Then the response status code should be 404
    And the response body should be empty "{}"
    Examples:
      | Value |
      | -1    |
      | abc   |
      | 9999  |
