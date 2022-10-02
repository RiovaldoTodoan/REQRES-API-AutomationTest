package starter;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import static org.hamcrest.Matchers.equalTo;
import net.thucydides.core.annotations.Steps;
import io.restassured.module.jsv.JsonSchemaValidator;


import java.io.File;

public class ReqresLatihanStepDef {

    @Steps
    ReqresAPI reqresAPI;

    //Latihan
    //Scenario 1
    @Given("Get list user with parameter page {int}")
    public void getListUserWithParameterPage(int page) {
        reqresAPI.getListUsers(page);
    }

    @When("Send request get list user")
    public void sendRequestGetListUser() {
        SerenityRest.when().get(ReqresAPI.GET_LIST_USERS);
    }

    @Then("Should return {int} ok")
    public void shouldReturnOK(int ok) {
        SerenityRest.then().statusCode(ok);
    }

    @And("Response body page should be {int}")
    public void responseBodyPageShouldBe(int page) {
        SerenityRest.then().body(ReqresResponse.PAGE, equalTo(page));
    }

    @And("Get list user json schema validator")
    public void getListUserJsonSchemaValidator() {
        File json = new File(ReqresAPI.JSON_SCHEMA_LATIHAN + "/GetListUserSchemaValidator.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    //Scenario 2 Post Create User
    @Given("Post create new user")
    public void postCreateNewUser() {
        File json = new File(ReqresAPI.JSON_FILE_POST + "/PostCreateNewUser.json");
        reqresAPI.postCreateNewUser(json);
    }



    @Then("Should return {int} created")
    public void shouldReturnCreated(int created) {
        SerenityRest.then().statusCode(created);
    }

    @And("Response body should contain {string} and {string}")
    public void responseBodyShouldContainNameAndJob(String name, String job) {
        SerenityRest.then()
                .body(ReqresResponse.NAME, equalTo(name))
                .body(ReqresResponse.JOB, equalTo(job));
    }

    @And("Post create json schema validator")
    public void postCreateJsonSchemaValidator() {
        File json = new File(ReqresAPI.JSON_SCHEMA_LATIHAN + "/PostCreateSchemaValidation.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    //Scenario 3 Put Update User
    @Given("Put update user with id {int}")
    public void putUpdateUserWithIdId(int id) {
        File json = new File(ReqresAPI.JSON_SCHEMA_LATIHAN + "/PutUpdateUser.json");
        reqresAPI.putUpdateUser(id, json);}

    @When("Send request put update user")
    public void sendRequestPutUpdateUser() {
        SerenityRest.when().put(ReqresAPI.PUT_UPDATE_USER);}



}