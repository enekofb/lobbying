package org.lobbying;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.lobbying.dao.CreatePolicyDAO;
import org.lobbying.dao.GetPolicyDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsNull.notNullValue;

public class CreatePolicyStepDefs {

    public static final String CREATE_POLICY_URL = "http://localhost:8080/policies";

    private static final String GET_POLICY_BY_ID_URL = "http://localhost:8080/policies/{id}";

    @Autowired
    private RestTemplate policyClient;

    private CreatePolicyDAO createPolicyDAO;

    private String createdPolicyId;

    @Given("^I want to create a policy with name \"([^\"]*)\" and description \"([^\"]*)\"$")
    public void iWantToCreateAPolicyWithNameAndDescription(String policyName, String policyDescription) throws Throwable {
        createPolicyDAO = CreatePolicyDAO.builder().name(policyName).description(policyDescription).build();
        assertThat(createPolicyDAO.getDescription(), equals(policyDescription));
        assertThat(createPolicyDAO.getName(), equals(policyName));
    }

    @When("^I create policy$")
    public void iCreatePolicy() throws Throwable {
        createdPolicyId = policyClient.postForObject(CREATE_POLICY_URL, createPolicyDAO, String.class);
        assertThat(createdPolicyId, notNullValue());
    }

    @Then("^policy has been created$")
    public void policyHasBeenCreated() throws Throwable {
        GetPolicyDAO getPolicyDao = policyClient.getForObject(GET_POLICY_BY_ID_URL, GetPolicyDAO.class, createdPolicyId);
        assertThat(createPolicyDAO.getDescription(), equals(getPolicyDao.getDescription()));
        assertThat(createPolicyDAO.getName(), equals(getPolicyDao.getName()));
    }
}
