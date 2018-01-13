package org.lobbying.citizen;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.lobbying.citizen.dto.CitizenDTO;
import org.lobbying.citizen.dto.CreateCitizenDTO;
import org.lobbying.common.BackgroundPolicyStepDefs;
import org.lobbying.common.CommonPolicyStepDefs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class CreateCitizenStepDefs extends CommonPolicyStepDefs {


    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate citizenClient;

    private CreateCitizenDTO createCitizenDTO;

    private CitizenDTO citizenDTO;


    @Given("^I want to create a citizen with email \"([^\"]*)\"  and name \"([^\"]*)\"$")
    public void i_want_to_create_a_citizen_with_email_and_name(String citizenEmail,String citizenName) throws Throwable {
        createCitizenDTO = CreateCitizenDTO.builder().email(citizenEmail).name(citizenName).build();
        assertThat(createCitizenDTO.getEmail(), equalTo(citizenEmail));
        assertThat(createCitizenDTO.getName(), equalTo(citizenName));
    }

    @When("^I create the citizen$")
    public void i_create_the_citizen() throws Throwable {
        citizenDTO = citizenClient.postForObject(CREATE_CITIZEN_URL, createCitizenDTO, CitizenDTO.class,port);
        assertThat(citizenDTO.getName(),equalTo(createCitizenDTO.getName()));
    }

    @Then("^citizen has been created$")
    public void citizen_has_been_created() throws Throwable {
        CitizenDTO getCitizenDTO = citizenClient.getForObject(GET_CITIZEN_BY_ID_URL, CitizenDTO.class, port,citizenDTO.getId());
        assertThat(getCitizenDTO.getId(),equalTo(citizenDTO.getId()));
    }


}
