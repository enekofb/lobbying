package org.lobbying.common;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import org.lobbying.citizen.dto.CitizenDTO;
import org.lobbying.policy.dto.PolicyDTO;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 * Created by eneko on 13/01/18.
 */
public class BackgroundLobbyingStepDefs extends CommonLobbyingStepDefs {

    @Given("^a policy with name \"([^\"]*)\" and description \"([^\"]*)\"$")
    public void a_policy_with_name_and_description(String policyName, String policyDescription) throws Throwable {
        PolicyDTO policy = getPolicyWorld().createPolicy(policyName, policyDescription);
        assertThat(policy.getName(),equalTo(policy.getName()));
    }

    @And("^a citizen with name \"([^\"]*)\" and email \"([^\"]*)\"$")
    public void aCitizenWithNameAndEmail(String citizenName, String citizenEmail) throws Throwable {
        CitizenDTO citizenDTO = getPolicyWorld().createCitizen(citizenName,citizenEmail);
        assertThat(citizenDTO.getName(),equalTo(citizenName));
    }
}
