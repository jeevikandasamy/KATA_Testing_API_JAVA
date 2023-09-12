package step_definitions;

import com.jayway.restassured.response.ResponseBody;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import dto.Pet;
import dto.Pets;
import org.junit.Assert;
import support.MyConfig;
import support.SupportFunctions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PetsStepDef {

    private static ResponseBody body;
    public int petsCount;

    @When("^I want to know all the pets in the clinic$")
    public void i_want_to_know_all_the_pets_in_the_clinic() throws Throwable {
        body = SupportFunctions.get(MyConfig.Endpoint + "api/pets");
        System.out.println(body.asString());

    }

//    @Then("^I should receive 13 pets$")
//    public void i_should_receive_pets() throws Throwable {
//        Pet[] petsDTO = SupportFunctions.convertResponseArray(Pet[].class);
//        int amountOfPets = petsDTO.length;
//        Assert.assertEquals("the amount of pets is 13 | ",13,amountOfPets);
//    }

    @Then("^I should receive the pets count$")
    public void i_should_receive_pets() throws Throwable {
        Pet[] petsDTO = SupportFunctions.convertResponseArray(Pet[].class);
        int amountOfPets = petsDTO.length;
        System.out.print("the amount of pets is  " + amountOfPets);
        petsCount = amountOfPets;
    }


    @When("^user wants to add a new pet with \"([^\"]*)\"$")
    public void user_wants_to_add_new_pet_with(String addPetDetails) throws Throwable {
        String requestPetObject = null;
        requestPetObject = SupportFunctions.getDatafromJsonFile(addPetDetails);
        System.out.println("Read data: " + requestPetObject);
        body = SupportFunctions.post(MyConfig.Endpoint + "api/pets", requestPetObject);
        System.out.println("Api response code: " + SupportFunctions.getResponseCode());
        Assert.assertEquals("Response Code", 201, SupportFunctions.getResponseCode());
    }
}
