package org.lobbying.policy;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.hamcrest.Matchers;

import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by eneko on 08/01/18.
 */
public class TrackPolicyStepdefs extends PolicyBaseStepDefs{

    private TrackPolicyCommandResult trackPolicyCommandResult;

    @Given("^I am a citizen \"([^\"]*)\"$")
    public void iAmACitizen(String citizenId) throws Throwable {
        getWorld().setCitizenId(citizenId);
    }

    @And("^I am interested in a policy about \"([^\"]*)\"$")
    public void iAmInterestedInAPolicyAbout(String policyId) throws Throwable {
        getWorld().setPolicyId(policyId);
    }

    @When("^I track the policy$")
    public void iTrackThePolicy() throws Throwable {
        trackPolicyCommandResult =  getWorld().trackPolicy(getWorld().getCitizenId(),getWorld().getPolicyId());
    }

    @Then("^the policy has been tracked$")
    public void thePolicyHasBeenTracked() throws Throwable {
        assertThat(trackPolicyCommandResult.executed(), Matchers.is(true));
    }

}
