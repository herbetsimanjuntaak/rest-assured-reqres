package page;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.Map;

import static helper.Endpoint.BASE_URL;
import static io.restassured.RestAssured.given;

public class ReqresApiPage {

    public static Response response;

    /**
     * Sets the RestAssured base URI by combining the base URL with the specified endpoint.
     *
     * @param endpoint The endpoint to append to the base URL.
     */
    public void setEndpoint(String endpoint) {
        RestAssured.baseURI = BASE_URL + endpoint;
    }

    /**
     * Sends a GET request and returns the response.
     *
     * @return The response from the GET request.
     */
    public Response sendGetRequest() {
        response = given()
                .when()
                .get()
                .then()
                .extract()
                .response();
        return response;
    }

    /**
     * Sends a GET request with a query parameter and returns the response.
     *
     * @param param The query parameter name.
     * @param value The query parameter value.
     * @return The response from the GET request.
     */
    public Response sendGetRequestQueryParam(String param, String value) {
        response = given()
                .queryParams(param, value)
                .when()
                .get()
                .then()
                .extract()
                .response();
        return response;
    }

    /**
     * Sends a GET request with multiple query parameters and returns the response.
     *
     * @param queryParams A map of query parameter names and values.
     * @return The response from the GET request.
     */
    public Response sendGetRequestQueryParams(Map<String, String> queryParams) {
        response = given()
                .queryParams(queryParams)
                .when()
                .get()
                .then()
                .extract()
                .response();
        return response;
    }

    /**
     * Sends a POST request with a JSON body and returns the response.
     *
     * @param requestBody A map representing the JSON body of the POST request.
     * @return The response from the POST request.
     */
    public Response sendPostRequest(Map<String, String> requestBody) {
        response = given()
                .header("Content-Type", "application/json")
                .body(requestBody)
                .when()
                .post()
                .then()
                .extract()
                .response();
        return response;
    }

    /**
     * Sends a PUT request with a JSON body and returns the response.
     *
     * @param requestBody A map representing the JSON body of the PUT request.
     * @return The response from the PUT request.
     */
    public Response sendPutRequest(Map<String, String> requestBody) {
        response = given()
                .header("Content-Type", "application/json")
                .body(requestBody)
                .when()
                .put()
                .then()
                .extract()
                .response();
        return response;
    }

    /**
     * Sends a DELETE request and returns the response.
     *
     * @return The response from the DELETE request.
     */
    public Response sendDeleteRequest() {
        response = given()
                .header("Content-Type", "application/json")
                .when()
                .delete()
                .then()
                .extract()
                .response();
        return response;
    }

}
