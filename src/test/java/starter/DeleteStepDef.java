package starter;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

public class DeleteStepDef {
     @Steps
    ReqresAPI reqresAPI;

    @Given("Delete user with character {}")
    public void deleteUserWithCharacter(String character) {reqresAPI.deleteUser(character);}
    @When("Send request delete user")
    public void sendRequestDeleteUser() {
        SerenityRest.when().delete(ReqresAPI.DELETE_USER);}

}
