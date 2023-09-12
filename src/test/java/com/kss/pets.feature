Feature: Pets APIs

  @get_pets @addnewpet @invalidreqtoaddpet
  Scenario: Get all the PETS
    When I want to know all the pets in the clinic
#    Then I should receive 13 pets
    Then I should receive the pets count

  @addnewpet
  Scenario Outline: add a new pet
    When user wants to add a new pet with "<addPetDetails>"
    Then verify the pet record added in the list

    Examples:
      | addPetDetails                    |
      | src/test/resources/addNewPet.json |


  @invalidreqtoaddpet
  Scenario Outline: add a new pet without all necessary values
    When user wants to add a new pet without all necessary values "<addInvalidPetDetail>"
    Then verify the bad request

    Examples:
      | addInvalidPetDetail                    |
      | src/test/resources/invalid_pet_details.json |