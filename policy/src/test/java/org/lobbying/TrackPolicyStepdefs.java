package org.lobbying;

import com.opencredo.concursus.domain.events.state.StateRepository;
import com.opencredo.concursus.domain.time.StreamTimestamp;
import com.opencredo.concursus.mapping.commands.methods.proxying.CommandProxyFactory;
import com.opencredo.concursus.spring.commands.CommandSystemBeans;
import com.opencredo.concursus.spring.events.EventSystemBeans;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

/**
 * Created by eneko on 08/01/18.
 */
@SpringBootTest(classes = { EventSystemBeans.class,CommandSystemBeans.class, PolicyApplication.class })
@ContextConfiguration(classes = PolicyApplication.class)
public class TrackPolicyStepdefs{

    @Autowired
    public CommandProxyFactory commandBus;

    @Autowired
    public StateRepository<Citizen> citizenStateRepository;

    @Autowired
    public StateRepository<Policy> policyStateRepository;

    private Citizen.Commands citizenCommands;

    private Policy.Commands policyCommands;

    private Citizen citizen;

    private Policy policy;

    public TrackPolicyStepdefs(@Autowired CommandProxyFactory commandBus){
        citizenCommands =commandBus.getProxy(Citizen.Commands.class);
        policyCommands =commandBus.getProxy(Policy.Commands.class);
    }

    @When("^I track the policy$")
    public void iTrackThePolicy() throws Throwable {
        citizenCommands.trackPolicy(StreamTimestamp.now(), citizen.getId(),policy.getId());
    }

    @Then("^the policy has been tracked$")
    public void thePolicyHasBeenTracked() throws Throwable {

    }

    @Given("^a policy with id \"([^\"]*)\" and name \"([^\"]*)\" exists$")
    public void aPolicyWithIdAndNameExists(String policyId, String policyName) throws Throwable {
        policyCommands.create(StreamTimestamp.now(),policyId,policyName);
    }

    @And("^a citizen with id \"([^\"]*)\" and name \"([^\"]*)\" exists$")
    public void aCitizenWithIdAndNameExists(String citizenId, String citizenName) throws Throwable {
        citizenCommands.create(StreamTimestamp.now(),citizenId,citizenName);
    }

    @Given("^a citizen with id \"([^\"]*)\"$")
    public void aCitizenWithId(String citizenId) throws Throwable {
        citizen = citizenStateRepository.getState(citizenId).orElseThrow(IllegalArgumentException::new);
    }

    @And("^interested in a policy with id \"([^\"]*)\"$")
    public void interestedInAPolicyWithId(String policyId) throws Throwable {
        policy = policyStateRepository.getState(policyId).orElseThrow(IllegalArgumentException::new);
    }
}

