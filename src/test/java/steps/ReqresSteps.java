package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import org.junit.Assert;
import page.ReqresApiPage;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import static helper.Utils.getJSONFile;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ReqresSteps {

    ReqresApiPage reqresApiPage = new ReqresApiPage();
    private Response response;
    private Map<String, String> requestBody;

    @Given("I set the GET request for endpoint {string}")
    public void iSetTheGETRequestForEndpoint(String endpoint) {
        reqresApiPage.setEndpoint(endpoint);
    }

    @When("I send the GET request")
    public void iSendTheGETRequest() {
        response = reqresApiPage.sendGetRequest();
    }

    @When("I send the GET request with query parameters {string} and {string}")
    public void iSendTheGETRequestWithQueryParametersAnd(String param, String value) {
        response = reqresApiPage.sendGetRequestQueryParam(param, value);
    }

    @When("I send the GET request with query parameters:")
    public void iSendTheGETRequestWithQueryParameters(Map<String, String> queryParams) {
        response = reqresApiPage.sendGetRequestQueryParams(queryParams);
    }

    @Then("the response status code should be {int}")
    public void theResponseStatusCodeShouldBe(int statusCode) {
        int actualStatusCode = response.getStatusCode();
        System.out.println(response.getBody().asString());
        Assert.assertEquals(statusCode, actualStatusCode);
    }

    @And("the value of {string} should be {string}")
    public void theValueOfShouldBe(String jsonPath, String jsonPathValue) {
        response = ReqresApiPage.response;
        String actualJsonPathValues = response.jsonPath().get(jsonPath).toString();
        Assert.assertEquals(jsonPathValue, actualJsonPathValues);
    }

    @And("all fields in the {string} array should not be null")
    public void allFieldsInTheArrayShouldNotBeNull(String jsonPath) {
        List<Map<String, Object>> data = ReqresApiPage.response.jsonPath().getList(jsonPath);
        assertFalse("The data array is empty, but it should contain user objects", data.isEmpty());

        boolean allFieldsAreNotNull = data.stream().allMatch(
                user ->
                        user.values().stream().allMatch(Objects::nonNull));
        assertTrue("Some fields in the user data are null", allFieldsAreNotNull);
    }

    @And("the {string} array in the response body should be empty")
    public void theArrayInTheResponseBodyShouldBeEmpty(String jsonPath) {
        int size = response.jsonPath().getList(jsonPath).size();
        Assert.assertEquals("The " + jsonPath + " array is not empty", 0, size);
    }

    @And("the response body should be empty")
    public void theResponseBodyShouldBeEmpty() {
        String responseBody = response.getBody().asString();
        Assert.assertEquals("Response body is not empty", "", responseBody);
    }

    @And("the response body should be empty {string}")
    public void theResponseBodyShouldBeEmpty(String message) {
        String respondBody = response.getBody().asString();
        assertTrue(respondBody.contains(message));
    }

    @And("the response body should match the JSON Schema {string}")
    public void theResponseBodyShouldMatchTheJSONSchema(String fileName) {
        File JSONFile = getJSONFile(fileName);
        response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(JSONFile));
    }

    @Given("I set the POST request for endpoint {string}")
    public void iSetThePOSTRequestForEndpoint(String endpoint) {
        reqresApiPage.setEndpoint(endpoint);
    }

    @When("I send the POST request")
    public void iSendThePOSTRequest() {
        response = reqresApiPage.sendPostRequest(requestBody);
    }


    @And("I set the request body with:")
    public void iSetTheRequestBodyWith(Map<String, String> requestBody) {
        this.requestBody = requestBody;
    }

    @And("I set the request body with {string} and {string}")
    public void iSetTheRequestBodyWithNameAndJob(String name, String job) {
        Map<String, String> requestBody = new HashMap<>();
        requestBody.put("name", name);
        requestBody.put("job", job);
        this.requestBody = requestBody;
    }

    @When("I send the PUT request")
    public void iSendThePUTRequest() {
        response = reqresApiPage.sendPutRequest(requestBody);
    }

    @Given("I set the PUT request for endpoint {string} and {string}")
    public void iSetThePUTRequestForEndpointAnd(String endpoint, String id) {
        reqresApiPage.setEndpoint(endpoint + "/" + id);
    }

    @Given("I set the DELETE request for endpoint {string} and {string}")
    public void iSetTheDELETERequestForEndpointAnd(String endpoint, String id) {
        reqresApiPage.setEndpoint(endpoint + "/" + id);

    }

    @When("I send the DELETE request")
    public void iSendTheDELETERequest() {
        response = reqresApiPage.sendDeleteRequest();
    }


    @And("the response body should have valid fields {string}")
    public void theResponseBodyShouldHaveValidFields(String fields) {
        String[] fieldArray = fields.split(",");
        Map<String, Object> data = ReqresApiPage.response.jsonPath().getMap("data");
        for (String field : fieldArray) {
            field = field.trim();
            assertTrue("Field " + field + " is missing in the response.", data.containsKey(field));
        }
    }

    @And("the response body should contain {string}")
    public void theResponseBodyShouldContain(String text) {
        String respondBody = response.getBody().asString();
        Assert.assertTrue(respondBody.contains(text));
    }

    @And("I set the request body with email {string} and {string}")
    public void iSetTheRequestBodyWithEmailAnd(String arg0, String arg1) {
        Map<String, String> requestBody = new HashMap<>();
        requestBody.put("email", arg0);
        requestBody.put("password", arg1);
        this.requestBody = requestBody;
    }
}
