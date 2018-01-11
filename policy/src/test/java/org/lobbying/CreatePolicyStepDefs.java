package org.lobbying;

import com.opencredo.concursus.spring.commands.CommandSystemBeans;
import com.opencredo.concursus.spring.events.EventSystemBeans;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.lobbying.dao.CreatePolicyDAO;
import org.lobbying.dao.GetPolicyDAO;
import org.lobbying.domain.Policy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.ContextConfiguration;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNull.notNullValue;

@SpringBootTest(classes = { EventSystemBeans.class,CommandSystemBeans.class, PolicyApplication.class },
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ContextConfiguration
public class CreatePolicyStepDefs {

    public static final String CREATE_POLICY_URL = "http://localhost:{port}/policies";

    private static final String GET_POLICY_BY_ID_URL = "http://localhost:{port}/policies/{id}";

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate policyClient;

    private CreatePolicyDAO createPolicyDAO;

    private String createdPolicyId;

    @Given("^I want to create a policy with name \"([^\"]*)\" and description \"([^\"]*)\"$")
    public void iWantToCreateAPolicyWithNameAndDescription(String policyName, String policyDescription) throws Throwable {
        createPolicyDAO = CreatePolicyDAO.builder().name(policyName).description(policyDescription).build();
        assertThat(createPolicyDAO.getDescription(), equalTo(policyDescription));
        assertThat(createPolicyDAO.getName(), equalTo(policyName));
    }

    @When("^I create policy$")
    public void iCreatePolicy() throws Throwable {
        CreatePolicyDAO createdPolicy = policyClient.postForObject(CREATE_POLICY_URL, createPolicyDAO, CreatePolicyDAO.class,port);
        assertThat(createdPolicy, notNullValue());
    }

    @Then("^policy has been created$")
    public void policyHasBeenCreated() throws Throwable {
        GetPolicyDAO getPolicyDao = policyClient.getForObject(GET_POLICY_BY_ID_URL, GetPolicyDAO.class, port,createdPolicyId);
        assertThat(createPolicyDAO.getDescription(), equals(getPolicyDao.getDescription()));
        assertThat(createPolicyDAO.getName(), equals(getPolicyDao.getName()));
    }
}
