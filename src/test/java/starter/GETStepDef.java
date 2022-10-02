package starter;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class GETStepDef {
    @Steps
    ReqresAPI reqresAPI;

    @Given("Get list user with special character{}")
    public void getListUserWithSpecialCharacter(String character) {reqresAPI.getListUserwithChar(character);}


    @When("Send request get list user char")
    public void sendRequestGetListUserChar() {SerenityRest.when().get(ReqresAPI.GET_LIST_USERS_CHAR);}

    @Given("Get single user with id {}")
    public void getSingleUserWithIdId(int id) {reqresAPI.getSingleUser(id);}
    @When("Send request get single user")
    public void sendRequestGetSingleUser() { SerenityRest.when().get(ReqresAPI.GET_SINGLE_USER);}
    @Then("Status should return {int} ok")
    public void statusShouldReturnOk(int ok) {SerenityRest.then().statusCode(ok);}
    @And("Response body contain {} {} {} {}")
    public void responseBodyPageShouldBe(String email, String first_name, String last_name, String avatar) {SerenityRest.then()
            .body(ReqresResponse.EMAIL, equalTo(email))
            .body(ReqresResponse.FIRTS_NAME, equalTo(first_name))
            .body(ReqresResponse.LAST_NAME, equalTo(last_name))
            .body(ReqresResponse.AVATAR, equalTo(avatar));}

    @And("Get single user json schema validator")
    public void getSingleUserJsonSchemaValidator() {
        File json = new File(ReqresAPI.JSON_SCHEMA_GET+ "/GetSingleUserValidIdSchemaValidation.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));}

    @Given("Get single user with invalid id {}")
    public void getSingleUserWithInvalidIdId(int id) {reqresAPI.getSingleUser(id);}

    @Then("Status should return {int} Not Found")
    public void statusShouldReturnNotFound(int Not_Found) {SerenityRest.then().statusCode(Not_Found);}

    @Given("Get single user with special character {}")
    public void getSingleUserWithSpecialCharacter(String character) {reqresAPI.getSingleUserWithSpecialCharacter(character);}

    @When("Send request get single user special character")
    public void sendRequestGetSingleUserSpecialCharacter() {SerenityRest.when().get(ReqresAPI.GET_SINGLE_USER_SPECIAL_CHAR);}

    @Given("Get single resource with valid id {}")
    public void getSingleResourceWithValidId(int id) {reqresAPI.getSingleResourceWithValidId(id);}

    @When("Send request get single resource user with valid id")
    public void sendRequestGetSingleResourceUserWithValidId() {SerenityRest.when().get(ReqresAPI.GET_SINGLE_RESOURCE);}

    @And("Response body should be contain {} {} {} {}")
    public void responseBodyShouldBeContain(String name, int year, String color, String pantone_value) {
        SerenityRest.then()
                .body(ReqresResponse.NAME_GET_SINGLE_RESOURCE, equalTo(name))
                .body(ReqresResponse.YEAR, equalTo(year))
                .body(ReqresResponse.COLOR, equalTo(color))
                .body(ReqresResponse.PANTONE_VALUE, equalTo(pantone_value));}
    @And("Get single resource json schema validation")
    public void getSingleResourceJsonSchemaValidation() { File json = new File(ReqresAPI.JSON_SCHEMA_GET+ "/GetSingleResourceSchemaValidation.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));}

    @Given("Get single resource with invalid id {}")
    public void getSingleResourceWithInvalidId(int id) {reqresAPI.getSingleResourceWithValidId(id);}

    @When("Send request get single resource user with invalid id")
    public void sendRequestGetSingleResourceUserWithInvalidId() {SerenityRest.when().get(ReqresAPI.GET_SINGLE_RESOURCE);}

    @Given("Get single resource not found with id {int}")
    public void getSingleResourceNotFoundWithIdId(int id) {
        reqresAPI.getSingleResourceNotFound(id);}
    @When("Send request get single resource not found")
    public void sendRequestGetSingleResourceNotFound() {SerenityRest.when().get(ReqresAPI.GET_SINGLE_RESOURCE_NOT_FOUND_ID);}

    @Then("Should return {int} Not Found")
    public void shouldReturnNotFound(int Not_Found) { SerenityRest.then().statusCode(Not_Found);}

    @Given("Get single resource not found with special character {}")
    public void getSingleResourceNotFoundWithSpecialIdId
    (String character) {reqresAPI.getSingleResourceNotFoundWithSpecialId(character);}

    @When("Send request get single resource not found with special character")
    public void sendRequestGetSingleResourceNotFoundWithSpecialCharacter() {
        SerenityRest.when().get(ReqresAPI.GET_SINGLE_RESOURCE_NOT_FOUND);}


    @Given("Get delayed response {}")
    public void getDelayedResponseId(int second) {reqresAPI.getDelayedResponse(second);}

    @When("Send request get delayed response")
    public void sendRequestGetDelayedResponse() throws InterruptedException {
        Thread.sleep(300);
        SerenityRest.when().get(ReqresAPI.GET_DELAYED);}


    @And("Get delay response json schema validator")
    public void getDelayResponseJsonSchemaValidator() {File json = new File(ReqresAPI.JSON_SCHEMA_GET+ "/GetDelayedSchemaValidation.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));}



}

