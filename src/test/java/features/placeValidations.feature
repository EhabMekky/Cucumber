﻿Feature: Validating Place APIs

  Scenario Outline: Verify if place is being successfully added using AddPlaceAPI
    Given Add Place Payload with "<name>" "<language>" "<address>"
    When User calls "AddPlaceAPI" with POST http request
    Then the API call is success with status code 200
    And "status" in response body is "OK"
    And "scope" in response body is "APP"

    Examples:
      | name    | language | address |
      | AAhouse | English  | World cross center |
#	|BBhouse | Spanish  |Sea cross center  |