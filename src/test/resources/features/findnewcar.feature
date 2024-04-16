Feature: Searching for New Car

  Scenario Outline: Finding New Car
    Given user navigates to carwale website
    Then user mouseover to newcars
    Then users clicks on FindnewCars
    And user clicks on "<carBrand>" car
    And user validates carTitle as "<carTitle>"

    Examples: 
      | carBrand | carTitle    |  |
      | Toyota   | Toyota Cars |  |
      | BMW      | BMW Cars    |  |
      | KIA      | Kia Cars    |  |
      | MG       | MG Cars     |  |
