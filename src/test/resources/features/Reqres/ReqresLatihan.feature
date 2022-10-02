Feature: features to testing reqres
#  Latihan

@Latihan
Scenario Outline: Get list user with valid parameter page
  Given Get list user with parameter page <page>
  When Send request get list user
  Then Should return 200 ok
  And Response body page should be <page>
  And Get list user json schema validator

    Examples:
      |page|
      |2   |
      |3   |

@Latihan
Scenario: Post create new user with valid json
  Given Post create new user
  When Send request post create new user
  Then Should return 201 created
  And  Response body should contain "Riovaldo" and "QA Engineer"
  And Post create json schema validator

@Latihan
Scenario Outline: Put update user with valid json
  Given Put update user with id <id>
  When Send request put update user
  Then Should return 200 ok
  And Response body should contain "Riovaldo" and "Liverpool"
  Examples:
    |id|
    |1 |
    |2 |
    |3 |






