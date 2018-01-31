package org.lobbying.policy;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.lobbying.common.CommonLobbyingStepDefs;
import org.lobbying.policy.dto.CreatePolicyDTO;
import org.lobbying.policy.dto.PolicyDTO;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class CreatePolicyStepDefs extends CommonLobbyingStepDefs {

    private CreatePolicyDTO createPolicyDTO;

    private PolicyDTO createdPolicy;

    @Given("^I want to create a policy with name \"([^\"]*)\" and description \"([^\"]*)\"$")
    public void iWantToCreateAPolicyWithNameAndDescription(String policyName, String policyDescription) throws Throwable {
        createPolicyDTO = CreatePolicyDTO.builder().name(policyName).description(policyDescription).build();
        assertThat(createPolicyDTO.getDescription(), equalTo(policyDescription));
        assertThat(createPolicyDTO.getName(), equalTo(policyName));
    }

    @When("^I create policy$")
    public void iCreatePolicy() throws Throwable {
        createdPolicy = restTemplate.postForObject(CREATE_POLICY_URL, createPolicyDTO, PolicyDTO.class,port);
        assertThat(createdPolicy.getName(),equalTo(createPolicyDTO.getName()));
    }

    @Then("^policy has been created$")
    public void policyHasBeenCreated() throws Throwable {
        PolicyDTO policyDTO = restTemplate.getForObject(GET_POLICY_BY_ID_URL, PolicyDTO.class, port,createdPolicy.getId());
        assertThat(createdPolicy.getId(),equalTo(policyDTO.getId()));
    }
}
