package starter;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import java.io.File;



public class ReqresAPI {
    public static String URl = "https://reqres.in";
    public static final String DIR = System.getProperty("user.dir");
    public static final String JSON_FILE_POST = DIR + "/src/test/resources/JSON/BodyResponse/POST";

    public static final String JSON_FILE_PATCH = DIR + "/src/test/resources/JSON/BodyResponse/PATCH";
    public static final String JSON_SCHEMA_GET = DIR + "/src/test/resources/JSON/SchemaValidation/GET";
    public static final String JSON_SCHEMA_POST = DIR + "/src/test/resources/JSON/SchemaValidation/POST";
    public static final String JSON_SCHEMA_PATCH = DIR + "/src/test/resources/JSON/SchemaValidation/PATCH";
    public static final String JSON_SCHEMA_LATIHAN = DIR + "/src/test/resources/JSON/SchemaValidation/Latihan";
    public static String GET_LIST_USERS = URl + "/api/users?page={page}";
    public static String GET_LIST_USERS_CHAR = URl + "/api/users?page={character}";

    public static String GET_SINGLE_USER = URl + "/api/users/{id}";
    public static String GET_SINGLE_USER_SPECIAL_CHAR = URl + "/api/users/{character}";
    public static String GET_SINGLE_RESOURCE = URl + "/api/unknown/{id}";
    public static String GET_SINGLE_RESOURCE_NOT_FOUND = URl + "/api/unknown/{character}";
    public static String GET_SINGLE_RESOURCE_NOT_FOUND_ID = URl + "/api/unknown/{id}";
    public static String POST_CREATE_NEW_USER = URl + "/api/users";
    public static String POST_REGISTER_USER = URl + "/api/register";
    public static String POST_LOGIN = URl + "/api/login";
    public static String PUT_UPDATE_USER = URl + "/api/users/{id}";
    public static String PATCH_USER = URl + "/api/users/";
    public static String DELETE_USER = URl + "/api/users/{character}";
    public static String GET_DELAYED = URl + "/api/users?delay={second}";


    //Latihan


    @Step("Getlist User with Char")
    public void getListUserwithChar(String character) {
        SerenityRest.given().pathParam("character", character);
    }

    @Step("Get List users")
    public void getListUsers(int page) {
        SerenityRest.given().pathParam("page", page);
    }

    @Step("Post create new user")
    public void postCreateNewUser(File json) {
        SerenityRest.given().contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Put update user")
    public void putUpdateUser(int id, File json) {
        SerenityRest.given()
                .pathParam("id", id)
                .contentType(ContentType.JSON)
                .body(json);
    }


    @Step("Get single resource not found")
    public void getSingleResourceNotFound(int id) {
        SerenityRest.given().pathParam("id", id);
    }


    @Step("Post register user succesful")
    public void postRegisterUserSuccesful(File json) {
        SerenityRest.given().contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Post register user")
    public void postRegisterUser(File json) {
        SerenityRest.given().contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Post register user successfull invalid email")
    public void postRegisterUserSuccessfulInvalidEmail(File json) {
        SerenityRest.given().contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Post register user successful with empty email")
    public void postRegisterUserSuccessfulWithEmptyEmail(File json) {
        SerenityRest.given().contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Get single resource not found with special id")
    public void getSingleResourceNotFoundWithSpecialId(String character) {
        SerenityRest.given().pathParam("character", character);
    }


    @Step("Get Single User")
    public void getSingleUser(int id) {
        SerenityRest.given().pathParam("id", id);
    }

    @Step("Get Single User With Special Character")
    public void getSingleUserWithSpecialCharacter(String character) {
        SerenityRest.given().pathParam("character", character);
    }

    @Step("Get single resource with valid id")
    public void getSingleResourceWithValidId(int id) {
        SerenityRest.given().pathParam("id", id);
    }

    @Step("Patch user data json")
    public void patchUserDataJson(File json) {
        SerenityRest.given().contentType(ContentType.JSON).body(json);
    }


    @Step("Post login user")
    public void postLoginUser(File json) {
        SerenityRest.given().contentType(ContentType.JSON).body(json);
    }


    @Step("Delete user")
    public void deleteUser(String character) {
        SerenityRest.given().pathParam("character", character);
    }

    @Step("Get Delayed Response ")
    public void getDelayedResponse(int second) {
        SerenityRest.given().pathParam("second", second);}

}







