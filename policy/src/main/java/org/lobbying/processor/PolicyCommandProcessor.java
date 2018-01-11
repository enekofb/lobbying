package org.lobbying.processor;

import com.opencredo.concursus.domain.events.state.StateRepository;
import com.opencredo.concursus.domain.time.StreamTimestamp;
import com.opencredo.concursus.mapping.events.methods.proxying.ProxyingEventBus;
import com.opencredo.concursus.spring.commands.processing.CommandHandler;
import org.lobbying.domain.PolicyState;
import org.springframework.beans.factory.annotation.Autowired;

@CommandHandler
public final class PolicyCommandProcessor implements PolicyState.Commands {

    private final ProxyingEventBus eventBus;
    private final StateRepository<PolicyState> citizenStateRepository;

    @Autowired
    public PolicyCommandProcessor(ProxyingEventBus eventBus, StateRepository<PolicyState> policyStateRepository) {
        this.eventBus = eventBus;
        this.citizenStateRepository = policyStateRepository;
    }

    @Override
    public void create(StreamTimestamp ts, String policyId, String policyName) {
        eventBus.dispatch(PolicyState.Events.class, policyEvent -> policyEvent.created(ts,policyId,policyName));
    }

}
