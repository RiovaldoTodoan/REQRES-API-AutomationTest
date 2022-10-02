Feature: Patch Method
  This feature will validate all PATCH methods in reqres.in

  @Tugas @Patch @Patch_Update_Data @PositiveCase
  Scenario: Patch user data with valid value json
    Given Patch user data json
    When Send request patch user data
    Then Should return 200 ok
    And response body will contain Liverpool and football
    And Patch updated json schema validator

#  This Scenario below status result should be 400 Not Found not 200 OK because API can not
#  send request when json value parameter incomplete
  @Tugas @Patch @Patch_Update @NegativeCase
  Scenario: Patch User Data with empty name json
    Given Patch user data with empty name value json
    When Send request patch user data
    Then Should return 400 Bad Request

#  This Scenario below status result should be 400 Not Found because API can not
#  send request when json value parameter incomplete
  @Tugas @Patch @Patch_Update @NegativeCase
  Scenario: Patch User Data with empty job value json
    Given Patch user data with empty job value json
    When Send request patch user data
    Then Should return 400 Bad Request

#  This Scenario below status result should be 400 Not Found because API can not
#  send request when json value parameter incomplete
  @Tugas @Patch @Patch_Update @NegativeCase
  Scenario: Patch User Data with Empty Name and Job Value Json
    Given Patch user data with empty name and job value json
    When Send request patch user data
    Then Should return 400 Bad Request
