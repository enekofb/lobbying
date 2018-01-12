package org.lobbying;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.lobbying.dto.CreatePolicyDTO;
import org.lobbying.dto.PolicyDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.ContextConfiguration;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

@SpringBootTest(classes = {PolicyApplication.class },
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ContextConfiguration
public class CreatePolicyStepDefs {

    public static final String CREATE_POLICY_URL = "http://localhost:{port}/policies";

    private static final String GET_POLICY_BY_ID_URL = "http://localhost:{port}/policies/{id}";

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate policyClient;

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
        createdPolicy = policyClient.postForObject(CREATE_POLICY_URL, createPolicyDTO, PolicyDTO.class,port);
        assertThat(createdPolicy.getName(),equalTo(createPolicyDTO.getName()));
    }

    @Then("^policy has been created$")
    public void policyHasBeenCreated() throws Throwable {
        PolicyDTO policyDTO = policyClient.getForObject(GET_POLICY_BY_ID_URL, PolicyDTO.class, port,createdPolicy.getId());
        assertThat(createdPolicy.getId(),equalTo(policyDTO.getId()));
    }
}
