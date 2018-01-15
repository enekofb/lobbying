package org.lobbying.policy;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.lobbying.common.CommonLobbyingStepDefs;
import org.lobbying.policy.dto.CreatePolicyUpdateDTO;
import org.lobbying.policy.dto.PolicyUpdateDTO;

import java.time.Instant;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.isEmptyString;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 * Created by eneko on 13/01/18.
 */
public class UpdatePolicyStepDefs extends CommonLobbyingStepDefs {

    private CreatePolicyUpdateDTO createPolicyUpdateDto;
    private PolicyUpdateDTO policyUpdatedDto;

    @Given("^the system has gathered an update for the previous policy$")
    public void the_system_has_gathered_an_update_for_the_previous_policy() throws Throwable {

        createPolicyUpdateDto = CreatePolicyUpdateDTO
                .builder()
                .policyId(getPolicyWorld()
                        .getPolicyDTO()
                        .getId())
                .updateTimestamp(Instant.now().toString())
                .updateContent("udpated").build();

    }

    @When("^I update the policy$")
    public void i_update_the_policy() throws Throwable {
        policyUpdatedDto = getPolicyWorld()
                .updatePolicy(createPolicyUpdateDto);
        assertThat(createPolicyUpdateDto.getPolicyId(), equalTo(policyUpdatedDto.getPolicyId()));
        assertThat(policyUpdatedDto.getId(), not(isEmptyString()));
    }

    @Then("^policy has been updated$")
    public void policy_has_been_updated() throws Throwable {
        PolicyUpdateDTO gottenPolicyUpdateDto = getPolicyWorld()
                .getPolicyUpdate(policyUpdatedDto.getPolicyId(), policyUpdatedDto.getId());
        assertThat(policyUpdatedDto.getPolicyId(), equalTo(gottenPolicyUpdateDto.getPolicyId()));

    }
}
