package org.lobbying.processor;

import com.opencredo.concursus.domain.events.state.StateRepository;
import com.opencredo.concursus.domain.time.StreamTimestamp;
import com.opencredo.concursus.mapping.events.methods.proxying.ProxyingEventBus;
import com.opencredo.concursus.spring.commands.processing.CommandHandler;
import org.lobbying.domain.Citizen;
import org.springframework.beans.factory.annotation.Autowired;

@CommandHandler
public final class CitizenCommandProcessor implements Citizen.Commands {

    private final ProxyingEventBus eventBus;
    private final StateRepository<Citizen> citizenStateRepository;

    @Autowired
    public CitizenCommandProcessor(ProxyingEventBus eventBus,StateRepository<Citizen> gameStateRepository) {
        this.eventBus = eventBus;
        this.citizenStateRepository = gameStateRepository;
    }

    @Override
    public void create(StreamTimestamp ts, String citizenId, String citizenName) {
        eventBus.dispatch(Citizen.Events.class, citizenEvent -> citizenEvent.created(ts,citizenId,citizenName));
    }

    @Override
    public void trackPolicy(StreamTimestamp ts, String citizenId,String policyId) {
        Citizen citizen = citizenStateRepository.getState(citizenId).orElseThrow(IllegalArgumentException::new);
        eventBus.dispatch(Citizen.Events.class, citizenEvent -> citizenEvent.tracked(ts,citizenId,policyId));
    }
}
