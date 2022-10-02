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

public class POSTStepDef {

    @Steps
    ReqresAPI reqresAPI;

    @Given("Post create user with empty name on json")
    public void postCreateUserWithEmptyNameOnJson() {
        File json = new File(ReqresAPI.JSON_FILE_POST + "/PostCreateNewUserEmptyName.json");
        reqresAPI.postRegisterUserSuccesful(json);}

    @When("Send request post create new user")
    public void sendRequestPostCreateNewUser() {
        SerenityRest.when().post(ReqresAPI.POST_CREATE_NEW_USER);
    }

    @Given("Post create user with empty job on json")
    public void postCreateUserWithEmptyJobOnJson() {
        File json = new File(ReqresAPI.JSON_FILE_POST + "/PostCreateUserWithEmptyJob.json");
        reqresAPI.postRegisterUserSuccesful(json);}

    @Then("Status will return {int} Not Found")
    public void statusWillReturnNotFound(int Not_Found) {
        SerenityRest.then().statusCode(Not_Found);
    }

    @Given("Post create user with empty value on json")
    public void postCreateUserWithEmptyValueOnJson() {
        File json = new File(ReqresAPI.JSON_FILE_POST + "/PostCreateUserEmptyValue.json");
        reqresAPI.postRegisterUserSuccesful(json);}

    @Given("Post register user successful")
    public void postRegisterUserSuccessful() {
        File json = new File(ReqresAPI.JSON_FILE_POST + "/PostRegisterUserSuccesful.json");
        reqresAPI.postRegisterUserSuccesful(json);}

    @When("Send request post register user")
    public void sendRequestPostRegisterUser() {
        SerenityRest.when().post(ReqresAPI.POST_REGISTER_USER);
    }


    @Then("Should return {int} OK")
    public void shouldReturnoK(int OK) {
        SerenityRest.then().statusCode(OK);
    }

    @And("Response body containing {} and {}")
    public void responseBodyContainingIdAndToken(int id, String token) {SerenityRest.then()
            .body(ReqresResponse.ID, equalTo(id))
            .body(ReqresResponse.TOKEN, equalTo(token));}

    @And("Post register user successful json schema validator")
    public void postRegisterUserSuccessfulJsonSchemaValidator() {
        File json = new File(ReqresAPI.JSON_SCHEMA_POST + "/PostRegisterSuccessfulSchemaValidation.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));}

    @Given("Post register user unsuccessful invalid email")
    public void postRegisterUserUnsuccessfulInvalidEmail() {
        File json = new File(ReqresAPI.JSON_FILE_POST + "/PostRegisterUserSuccessfulInvalidEmail.json");
        reqresAPI.postRegisterUserSuccessfulInvalidEmail(json);}

    @Then("Status will return {int} Bad Request")
    public void statusWillReturnBadRequest(int Bad_Request) {
        SerenityRest.then().statusCode(Bad_Request);
    }

    @And("Response body will be contain description {string}")
    public void responseBodyWillContainDescription(String error) {
        SerenityRest.then().body(ReqresResponse.Note_Only_defined_users_succeed_registration, equalTo(error));}

    @And("Post register user successful invalid email json schema validator")
    public void postRegisterUserSuccessfulInvalidEmailJsonSchemaValidator() {
        File json = new File(ReqresAPI.JSON_SCHEMA_POST + "/PostRegisterSuccessfulWithInvalidEmailSchemaValidation.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));}

    @Given("Post register user unsuccessful with empty email")
    public void postRegisterUserUnsuccessfulWithEmptyEmail() {
        File json = new File(ReqresAPI.JSON_FILE_POST + "/PostRegisterUserSuccessfulWithEmptyEmail.json");
        reqresAPI.postRegisterUserSuccessfulWithEmptyEmail(json);}

    @When("Send request post register user successful")
    public void sendRequestPostRegisterUserSuccessful() {
        SerenityRest.when().post(ReqresAPI.POST_REGISTER_USER);
    }

    @And("Response body will be contain {string}")
    public void responseBodyWillContain(String error) {
        SerenityRest.then().body(ReqresResponse.Missing_email_or_username, equalTo(error));}

    @And("Post register user successful with empty email json schema validator")
    public void postRegisterUserSuccessfulWithEmptyEmailJsonSchemaValidator() {
        File json = new File(ReqresAPI.JSON_SCHEMA_POST + "/PostRegisterUserSuccessfulWithEmptyEmailSchemaValidation.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));}

    @Given("Post register user")
    public void postRegisterUser() {
        File json = new File(ReqresAPI.JSON_FILE_POST + "/PostRegisterUnsuccessfulwithEmptyPassword.json");
        reqresAPI.postRegisterUser(json);}

    @When("Send request post register")
    public void sendRequestPostRegister() {
        SerenityRest.when().post(ReqresAPI.POST_REGISTER_USER);
    }

    @Then("Should return {int} Bad Request")
    public void shouldReturnBadRequest(int Bad_Request) {
        SerenityRest.then().statusCode(Bad_Request);}

    @And("Response body contain {string}")
    public void responseBodyContainError(String error) {
        SerenityRest.then().body(ReqresResponse.MISSING_PASSWORD, equalTo(error));}

    @And("Post register unsuccessful json schema validator")
    public void postRegisterUnsuccessfulJsonSchemaValidator() {
        File json = new File(ReqresAPI.JSON_SCHEMA_POST + "/PostRegisterUnsuccessfulSchemaValidation.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));}


    @Given("Post register user unsuccessful empty value")
    public void postRegisterUserUnsuccessfulEmptyValue() {File json = new File(ReqresAPI.JSON_FILE_POST + "/PostRegisterUnsuccessfulwithEmptyValue.json");
        reqresAPI.postRegisterUser(json);}

    @And("Post register unsuccessful empty value json schema validator")
    public void postRegisterUnsuccessfulEmptyValueJsonSchemaValidator() {File json = new File(ReqresAPI.JSON_SCHEMA_POST + "/PostRegisterUnsuccessfulwithEmptyValueSchemaValidation.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));}


    @Given("Post login user successful with valid data json")
    public void postLoginUserSuccessfulWithValidDataJson() {File json = new File(ReqresAPI.JSON_FILE_POST + "/PostLoginValidData.json");
        reqresAPI.postLoginUser(json);}
    @When("Send request post login")
    public void sendRequestPostLogin() { SerenityRest.when().post(ReqresAPI.POST_LOGIN);}

    @And("Response body contain token {}")
    public void responseBodyWillContainToken(String token) {SerenityRest.then().body(ReqresResponse.TOKEN, equalTo(token));}

    @And("Post login json schema validator")
    public void postLoginJsonSchemaValidator() {File json = new File(ReqresAPI.JSON_SCHEMA_POST + "/PostLoginSchemaValidation.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));}


    @Given("Post login user unsuccessful with invalid data json")
    public void postLoginUserUnsuccessfulWithInvalidDataJson() {File json = new File(ReqresAPI.JSON_FILE_POST + "/PostLoginUserInvalidData.json");
        reqresAPI.postLoginUser(json);}

    @When("Send request post login unsuccessful")
    public void sendRequestPostLoginUnsuccessful() {SerenityRest.when().post(ReqresAPI.POST_LOGIN);}

    @And("Response body will containing {}")
    public void responseBodyWillContainString(String error) {SerenityRest.then().body(ReqresResponse.User_Not_Found, equalTo(error));}

    @And("Post login unsuccessful json schema validation")
    public void postLoginUnsuccessfulJsonSchemaValidation() {File json = new File(ReqresAPI.JSON_SCHEMA_POST + "/PostLoginUnsuccessfulSchemaValidation.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));}


    @Given("Post login user unsuccessful with empty email json")
    public void postLoginUserUnsuccessfulWithEmptyEmailJson() {File json = new File(ReqresAPI.JSON_FILE_POST + "/PostLoginUnsuccessfulwithEmptyEmail.json");
        reqresAPI.postLoginUser(json);}

    @And("Response contain {}")
    public void responseBodyContainMissingEmailOrUsername(String error ) {SerenityRest.then().body(ReqresResponse.MISSING_PASSWORD, equalTo(error));
    }

    @And("Post login unsuccessful empty email json schema validator")
    public void postLoginUnsuccessfulEmptyEmailJsonSchemaValidator() {File json = new File(ReqresAPI.JSON_SCHEMA_POST + "/PostLoginUnsuccessfulwithEmptyEmailSchemaValidation.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));}


    @Given("Post login user unsuccessful with empty password json")
    public void postLoginUserUnsuccessfulWithPasswordEmailJson() {File json = new File(ReqresAPI.JSON_FILE_POST + "/PostLoginUnsuccessfulwithEmptyPassword.json");
        reqresAPI.postLoginUser(json);}
    @When("Send request post login unsuccessful empty password")
    public void sendRequestPostLoginUnsuccessfulEmptyPassword() {SerenityRest.when().post(ReqresAPI.POST_LOGIN);}

    @And("Response body will be containing {string}")
    public void responseBodyWillBeContaining(String error) {SerenityRest.then().body(ReqresResponse.MISSING_PASSWORD, equalTo(error));}

    @And("Post login unsuccessful empty password json schema validator")
    public void postLoginUnsuccessfulEmptyPasswordJsonSchemaValidator() {File json = new File(ReqresAPI.JSON_SCHEMA_POST + "/PostLoginUnsuccessfulwithEmptyPasswordSchemaValidation.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));}

    @Given("Post login user unsuccessful with empty email and username json")
    public void postLoginUserUnsuccessfulWithEmptyEmailAndUsernameJson() {File json = new File(ReqresAPI.JSON_FILE_POST + "/PostLoginUnsuccessfulwithEmptyEmailandPassword.json");
        reqresAPI.postLoginUser(json);}

    @And("Post login unsuccessful empty email and password json schema validator")
    public void postLoginUnsuccessfulEmptyEmailAndPasswordJsonSchemaValidator() {File json = new File(ReqresAPI.JSON_SCHEMA_POST + "/PostLoginUnsuccessfulEmptyEmailandPasswordSchemaValidation.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));}

    @Given("Post login user unsuccessful with invalid email format")
    public void postLoginUserUnsuccessfulWithInvalidEmailFormat() {File json = new File(ReqresAPI.JSON_FILE_POST + "/PostLoginUnsuccessfulwithInvalidEmailFormat.json");
        reqresAPI.postLoginUser(json);}



}
