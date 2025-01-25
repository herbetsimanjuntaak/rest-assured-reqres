package page;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.Map;

import static helper.Endpoint.BASE_URL;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class ReqresApiPage {

    public static Response response;

    /**
     * Sets the base URI for RestAssured requests by appending the provided endpoint
     * to the base URL (GO_REST_BASE_URL).
     *
     * @param endpoint The endpoint to be appended to the base URL.
     */
    public void setEndpoint(String endpoint) {
        RestAssured.baseURI = BASE_URL + endpoint;
    }

    public Response sendGetRequest() {
        response = given()
                .when()
                .get()
                .then()
                .extract()
                .response();
        return response;
    }

    public Response sendGetRequestQueryParams(String param, String value) {
        response = given()
                .queryParams(param, value)
                .when()
                .get()
                .then()
                .extract()
                .response();
        return response;
    }

    public Response sendGetRequestQueryParamsGPT(Map<String, String> queryParams) {
        response = given()
                .queryParams(queryParams)
                .when()
                .get()
                .then()
                .extract()
                .response();
        return response;
    }

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
