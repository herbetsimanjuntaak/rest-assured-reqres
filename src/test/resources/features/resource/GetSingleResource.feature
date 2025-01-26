@Reqres @Resources @SingleResource

Feature: Retrieve a single resource
  As a user of the Reqres API
  I want to retrieve a single resource using the Reqres API
  So that I can validate the API's GET functionality for individual resources

  @ValidSingleResource
  Scenario Outline: Verify successful retrieval of a single resource
    Given I set the GET request for endpoint "/api/unknown"
    When I send the GET request with query parameters "id" and "<Value>"
    Then the response status code should be 200
    And the response body should have valid fields "id, name, year, color, pantone_value"
    And the value of "data.id" should be "<Value>"
    And the response body should match the JSON Schema "single_resource_schema.json"
    Examples:
      | Value |
      | 1     |
      | 2     |
      | 3     |

  @InvalidSingleResource
  Scenario Outline: Verify unsuccessful retrieval with a non-existent or invalid resource ID
    Given I set the GET request for endpoint "/api/unknown"
    When I send the GET request with query parameters "id" and "<Value>"
    Then the response status code should be 404
    And the response body should be empty "{}"
    Examples:
      | Value |
      | 9999  |
      | -1    |
      | abc   |
