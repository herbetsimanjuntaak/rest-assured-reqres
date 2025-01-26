@Reqres @Resources @ListResources

Feature: List Resources
  As a user of the Reqres API
  I want to retrieve a list of resources using the Reqres API
  So that I can validate the API's GET functionality

  @ValidListResources
  Scenario: Verify successful retrieval of resource list
    Given I set the GET request for endpoint "/api/unknown"
    When I send the GET request
    Then the response status code should be 200
    Then the response status code should be 200
    And the value of "page" should be "1"
    And the value of "per_page" should be "6"
    And the value of "total" should be "12"
    And the value of "total_pages" should be "2"
    And all fields in the "data" array should not be null
    And the response body should match the JSON Schema "resources_list_schema.json"


  @ValidListResourcesQuery
  Scenario: Verify successful retrieval of the resource list with query parameters
    Given I set the GET request for endpoint "/api/unknown"
    When I send the GET request with query parameters:
      | key  | value |
      | page | 2     |
    Then the response status code should be 200
    And the value of "page" should be "2"
    And the value of "per_page" should be "6"
    And the value of "total" should be "12"
    And the value of "total_pages" should be "2"
    And all fields in the "data" array should not be null
    And the response body should match the JSON Schema "resources_list_schema.json"

  @InvalidListResourcesQuery
  Scenario: Verify unsuccessful retrieval with an invalid page number
    When I send the GET request with query parameters "page" and "9999"
    When I send the GET request
    Then the response status code should be 200
    And the "data" array in the response body should be empty

