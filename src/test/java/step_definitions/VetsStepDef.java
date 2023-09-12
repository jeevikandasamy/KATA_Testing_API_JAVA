package step_definitions;


import com.jayway.restassured.response.ResponseBody;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import support.MyConfig;
import support.SupportFunctions;

public class VetsStepDef {

    private static ResponseBody body;
    private static String addedVetDetails = null;


    @When("^I want to know all the vets and specialities in the clinic$")
    public void i_want_to_know_all_the_vets_and_specialities_in_the_clinic() throws Throwable {
        body = SupportFunctions.get(MyConfig.Endpoint + "api/vets");
        System.out.println("All the vets in the clinic " + body.asString());
    }

    @Then("^I verify the status code of the response$")
    public void i_verify_the_status_code_of_the_response() throws Throwable {
        Assert.assertEquals(200,SupportFunctions.getResponseCode());
        System.out.println("Response code:" + SupportFunctions.getResponseCode());
    }
    @Then("^I want to add specialities \"([^\"]*)\"$")
    public void i_want_to_add_specialities(String vetToAdd) throws Throwable{
        String requestVetObject = null;
        requestVetObject = SupportFunctions.getDatafromJsonFile(vetToAdd);

        body = SupportFunctions.post(MyConfig.Endpoint + "api/vets",requestVetObject);
        Assert.assertEquals("Response Code",201,SupportFunctions.getResponseCode());

        System.out.println("Response Body" + body.asString());
        addedVetDetails =body.asString().split("specialties")[0];

    }

    @Then("verify the new specialities added to the vet")
    public void validate_the_creation_of_vet() throws Throwable {
        body = SupportFunctions.get(MyConfig.Endpoint + "api/vets");
        Assert.assertEquals("Response Code",200,SupportFunctions.getResponseCode());

        System.out.println("Response Body" + body.asString());
        Assert.assertTrue(body.asString().contains(addedVetDetails));
    }

}
