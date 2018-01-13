package org.lobbying.common;

import cucumber.api.java.en.Given;
import org.lobbying.PolicyApplication;
import org.lobbying.policy.dto.PolicyDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 * Created by eneko on 13/01/18.
 */
public class BackgroundPolicyStepDefs extends CommonPolicyStepDefs{

    @Given("^a policy with name \"([^\"]*)\" and description \"([^\"]*)\"$")
    public void a_policy_with_name_and_description(String policyName, String policyDescription) throws Throwable {
        PolicyDTO policy = getPolicyWorld().createPolicy(policyName, policyDescription);
        assertThat(policy.getName(),equalTo(policy.getName()));
    }

}
