Feature: Delete Method
  This feature will validate all DELETE methods in reqres.in

#  This Scenario status result should be 404 Not Found because logically API don't have user with
#  special character like examples below. Because QE Tester don't have PRD,
#  Tester just assume this scenario status will be 404 Not Found not 204 No Content

  @Tugas @Delete @DeleteUser @NegativeCase
  Scenario Outline: Delete User with Character
    Given Delete user with character <character>
    When Send request delete user
    Then Should return 404 Not Found
    Examples:
    |character|
    |@#$$     |
    |#$%^     |

