Feature: Pets APIs

  @addspecialities @test
  Scenario Outline: Get all the vets
    When I want to know all the vets and specialities in the clinic
    Then I verify the status code of the response
    Then I want to add specialities "<vetToAdd>"
    Then verify the new specialities added to the vet

    Examples:
      | vetToAdd  |
      | src/test/resources/speciality_dentistry.json|
      | src/test/resources/speciality_radiology.json|
      | src/test/resources/speciality_surgery.json|
      | src/test/resources/speciality_radiology_and_dentistry.json|


