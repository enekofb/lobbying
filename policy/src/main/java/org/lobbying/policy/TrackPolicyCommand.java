package org.lobbying.policy;

import com.opencredo.concursus.domain.events.channels.EventOutChannel;
import com.opencredo.concursus.domain.time.StreamTimestamp;
import com.opencredo.concursus.mapping.events.methods.proxying.EventEmittingProxy;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

/**
 * Created by eneko on 09/01/18.
 */
@Data
@Builder
public class TrackPolicyCommand {

    private UUID policyId;
    private UUID citizenId;

    //TODO: refactor me
    private EventOutChannel outChannel = System.out::println;

    // Create a proxy that sends events to the outChannel.
    private PolicyEvents policyEvents = EventEmittingProxy.proxying(outChannel, PolicyEvents.class);

    public TrackPolicyCommandResult execute(){

        policyEvents.tracked(StreamTimestamp.now(),citizenId,policyId);
        retun new TrackPolicyCommandResult();

    }

}
