Feature: Get Method
  This feature will validate all GET methods in reqres.in


#  This Scenario below status result should be 404 Not Found because logically API don't have user with
#  special character like examples below. Because QE Tester don't have PRD,
#  Tester just assume this scenario status will be 404 Not Found not 200 OK
@Tugas @Get @Get_List_User @NegativeCase
Scenario Outline: Get List User with Special Character
  Given Get list user with special character <character>
  When Send request get list user char
  Then Status will return 400 Bad Request
  Examples:
  |character|
  |@#$%@@   |
  |*!^!$@^&@&*@|


@Tugas @Get @Get_Single_User @PositiveCase
Scenario Outline: Get Single User With Valid Id
Given Get single user with id <id>
When Send request get single user
Then Status should return 200 ok
And Response body contain <email> <first_name> <last_name> <avatar>
And Get single user json schema validator
Examples:
|id|        email           | first_name  |  last_name  |                 avatar                 |
|1 |george.bluth@reqres.in  |   George    |    Bluth    |https://reqres.in/img/faces/1-image.jpg |
|2 |janet.weaver@reqres.in  |   Janet     |    Weaver   |https://reqres.in/img/faces/2-image.jpg |
|3 |emma.wong@reqres.in     |   Emma      |    Wong     |https://reqres.in/img/faces/3-image.jpg |
|4 |eve.holt@reqres.in      |   Eve       |    Holt     |https://reqres.in/img/faces/4-image.jpg |
|5 |charles.morris@reqres.in|   Charles   |    Morris   |https://reqres.in/img/faces/5-image.jpg |


@Tugas @Get @Get_Single_User @NegativeCase
Scenario Outline: Get Single User with Invalid Id
Given Get single user with invalid id <id>
When Send request get single user
Then Status should return 404 Not Found
Examples:
|id|
|13|
|14|
|15|
|16|

@Tugas @Get @Get_Single_User @NegativeCase
Scenario Outline: Get Single User with Special Character
Given Get single user with special character <character>
When Send request get single user special character
Then Status should return 404 Not Found
Examples:
|character|
|@@@      |
|$#%@     |

@Tugas @Get @Get_Single_Resource @PositiveCase
Scenario Outline: Get Single Resource with Valid ID
Given Get single resource with valid id <id>
When Send request get single resource user with valid id
Then Status should return 200 ok
And Response body should be contain <name> <year> <color> <pantone_value>
And Get single resource json schema validation
Examples:
|id|    name       |  year    | color   | pantone_value   |
|1 | cerulean      |  2000    |#98B2D1  |    15-4020      |
|2 | fuchsia rose  |  2001    |#C74375  |    17-2031      |
|3 | true red      |  2002    |#BF1932  |    19-1664      |
|4 | aqua sky      |  2003    |#7BC4C4  |    14-4811      |
|5 | tigerlily     |  2004    |#E2583E  |    17-1456      |
|6 | blue turquoise|  2005    |#53B0AE  |    15-5217      |



@Tugas @Get @Get_Single_Resource @NegativeCase
Scenario Outline: Get Single Resource with Invalid ID
Given Get single resource with invalid id <id>
When Send request get single resource user with invalid id
Then Status should return 404 Not Found
Examples:
|id|
|13|
|14|
|15|
|16|


@Tugas @Get @Get_Single_Resource_Not_Found @PositiveCase
Scenario Outline: Get Single Resource Not Found with Invalid Id
Given Get single resource not found with id <id>
When Send request get single resource not found
Then Status should return 404 Not Found
Examples:
|id|
|13|
|14|
|15|
|16|
|17|
|18|
|19|

@Tugas @Get @Get_Single_Resource_Not_Found @NegativeCase
Scenario Outline: Get Single Resource Not Found with special character
Given Get single resource not found with special character <character>
When Send request get single resource not found with special character
Then Status should return 404 Not Found
Examples:
|character|
|@^&_&|
|$$$$ |


Scenario: Get Delayed Response
Given Get delayed response 3
When Send request get delayed response
Then Status should return 200 ok
And Get delay response json schema validator
