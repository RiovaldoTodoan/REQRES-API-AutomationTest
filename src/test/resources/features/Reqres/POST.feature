Feature: POST Method
  This feature will validate all POST methods in reqres.in

  #BUG ON REQRES. IT SHOULD BE 404 NOT FOUND
  @Tugas @Post @Post_Create_User @NegativeCase
  Scenario: Post Create Users with Empty Name
    Given Post create user with empty name on json
    When Send request post create new user
    Then Status will return 404 Not Found

#BUG ON REQRES. IT SHOULD BE 404 NOT FOUND
  @Tugas @Post @Post_Create_User @NegativeCase
  Scenario: Post Create User with job Password
    Given Post create user with empty job on json
    When Send request post create new user
    Then Status will return 404 Not Found


#BUG ON REQRES. IT SHOULD BE 404 NOT FOUND
@Tugas @Post @Post_Create_User @NegativeCase
  Scenario: Post Create New User with Empty Value
    Given Post create user with empty value on json
    When Send request post create new user
    Then Status will return 404 Not Found


  @Tugas @Post  @Post_Register_Succesfull @PositiveCase
  Scenario: Post Register User Successful with Valid Json
    Given Post register user successful
    When Send request post register user
    Then Should return 200 OK
    And Response body containing 4 and QpwL5tke4Pnpja7X4
    And Post register user successful json schema validator

  @Tugas @Post  @Post_Register_Unsuccessfull @NegativeCase
  Scenario: Post Register User Unsuccessful with Invalid Email Json
    Given Post register user unsuccessful invalid email
    When Send request post register user
    Then Status will return 400 Bad Request
    And Response body will be contain description "Note: Only defined users succeed registration"
    And Post register user successful invalid email json schema validator

  @Tugas @Post  @Post @Post_Register_Unsuccessful @NegativeCase
  Scenario: Post Register user Unsuccessful with empty email json
    Given Post register user unsuccessful with empty email
    When Send request post register user successful
    Then Should return 400 Bad Request
    And Response body will be contain "Missing email or username"
    And Post register user successful with empty email json schema validator

  @Tugas @Post  @Post_Register_Unsuccessful @NegativeCase
  Scenario: Post register User Unsuccessful with Empty Password
    Given Post register user
    When Send request post register
    Then Should return 400 Bad Request
    And Response body contain "Missing password"
    And Post register unsuccessful json schema validator

  @Tugas @Post  @Post_Register_Unsuccessful @NegativeCase
    Scenario: Post Register User Unsuccessful with Empty Value Json
      Given Post register user unsuccessful empty value
      When Send request post register
      Then Should return 400 Bad Request
      And Response body will containing Missing email or username
      And Post register unsuccessful empty value json schema validator


@Tugas @Post  @Post_Login_Successful @PositiveCase
  Scenario: Post Login Successful with valid data json
    Given Post login user successful with valid data json
    When Send request post login
    Then Should return 200 OK
    And Response body contain token QpwL5tke4Pnpja7X4
    And Post login json schema validator

  @Tugas @Post  @Post_Login_Successful @NegativeCase
  Scenario: Post Login Unsuccessful with invalid data json
    Given Post login user unsuccessful with invalid data json
    When Send request post login unsuccessful
    Then Should return 400 Bad Request
    And Response body will containing user not found
    And Post login unsuccessful json schema validation

  @Tugas @Post @Post_Login_Successful @NegativeCase
  Scenario: Post Login Unsuccessful with Empty Email value json
    Given Post login user unsuccessful with empty email json
    When Send request post login unsuccessful
    Then Should return 400 Bad Request
    And Response contain Missing email or username
    And Post login unsuccessful empty email json schema validator

  @Tugas @Post  @Post_Login_Successful @NegativeCase
  Scenario: Post Login Unsuccessful with Empty Password Value Json
    Given Post login user unsuccessful with empty password json
    When Send request post login unsuccessful empty password
    Then Should return 400 Bad Request
    And Response body will be containing "Missing password"
    And Post login unsuccessful empty password json schema validator

  @Tugas @Post  @Post_Login_Successful @NegativeCase
  Scenario: Post Login Unsuccessful with Empty Email and Username Value Json
    Given Post login user unsuccessful with empty email and username json
    When Send request post login
    Then Should return 400 Bad Request
    And Response body will containing Missing email or username
    And Post login unsuccessful empty email and password json schema validator

  @Tugas @Post @Post_Login_Successful @NegativeCase
  Scenario: Post Login Unsuccessful with Invalid Email Format Json
    Given Post login user unsuccessful with invalid email format
    When Send request post login
    Then Should return 400 Bad Request
    And Response body will containing user not found
    And Post login unsuccessful json schema validation





