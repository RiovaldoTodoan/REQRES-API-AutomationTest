package starter;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class PATCHStepDef {

    @Steps
    ReqresAPI reqresAPI;

    @Given("Patch user data json")
    public void patchUserDataJson() {
        File json = new File(ReqresAPI.JSON_FILE_PATCH + "/PatchUserData.json");
        reqresAPI.patchUserDataJson(json);}

    @When("Send request patch user data")
    public void sendRequestPatchUserData() {
        SerenityRest.when().patch(ReqresAPI.PATCH_USER);}

    @And("response body will contain {} and {}")
    public void responseBodyWillContainStringStringAndString(String name, String job) {SerenityRest.then()
            .body(ReqresResponse.NAME, equalTo(name))
            .body(ReqresResponse.JOB, equalTo(job));}
    @And("Patch updated json schema validator")
    public void patchUpdatedJsonSchemaValidator() { File json = new File(ReqresAPI.JSON_SCHEMA_PATCH + "/PatchUpdatedJsonSchemaValidator.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));}

    @Given("Patch user data with empty name value json")
    public void patchUserDataWithEmptyNameValueJson() {File json = new File(ReqresAPI.JSON_FILE_PATCH + "/PatchUserDataWithEmptyNameValue.json");
        reqresAPI.patchUserDataJson(json);}

    @Given("Patch user data with empty job value json")
    public void patchUserDataWithEmptyJobValueJson() {File json = new File(ReqresAPI.JSON_FILE_PATCH + "/PatchUserDataWithEmptyJobValue.json");
        reqresAPI.patchUserDataJson(json);}

    @Given("Patch user data with empty name and job value json")
    public void patchUserDataWithEmptyNameAndJobValueJson() {File json = new File(ReqresAPI.JSON_FILE_PATCH + "/PatchUserDatawithEmptyNameandJobValues.json");
        reqresAPI.patchUserDataJson(json);}


}
