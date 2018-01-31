package org.lobbying;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.lobbying.citizen.dto.CitizenDTO;
import org.lobbying.common.CommonLobbyingStepDefs;
import org.lobbying.policy.dto.PolicyDTO;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNull.notNullValue;

public class TrackPolicyStepDefs extends CommonLobbyingStepDefs{

    private CitizenDTO citizenDTO;

    private PolicyDTO policyDTO;

    @Given("^the citizen is interested on the policy$")
    public void theCitizenIsInterestedOnThePolicy() throws Throwable {
        citizenDTO = getPolicyWorld().getCitizenDTO();
        assertThat(citizenDTO,is(notNullValue()));
        policyDTO = getPolicyWorld().getPolicyDTO();
        assertThat(policyDTO,is(notNullValue()));
    }

    @When("^citizen tracks the policy$")
    public void citizenTracksThePolicy() throws Throwable {
        boolean tracked = getPolicyWorld().citizenTrackPolicy(citizenDTO.getId(),policyDTO.getId());
        assertThat(policyDTO,is(notNullValue()));
    }

    @Then("^the policy has been tracked$")
    public void thePolicyHasBeenTracked() throws Throwable {
        PolicyDTO policyByCitizen = getPolicyWorld()
                .getPolicyByCitizen(citizenDTO.getId(),policyDTO.getId());
        assertThat(policyDTO,is(notNullValue()));
        assertThat(policyByCitizen.getId(),equalTo(policyDTO.getId()));
    }
}
