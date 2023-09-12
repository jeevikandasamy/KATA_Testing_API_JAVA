Feature: Pets APIs

  @get_pets
  Scenario: Get all the PETS
    When I want to know all the pets in the clinic
#    Then I should receive 13 pets
    Then I should receive the pets count

  @addnewpet
  Scenario Outline: add a new pet
    When user wants to add a new pet with "<addPetDetails>"

    Examples:
      | addPetDetails                    |
      | src/test/resource/addNewPet.json |