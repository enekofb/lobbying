package org.lobbying;

import com.opencredo.concursus.domain.time.StreamTimestamp;
import com.opencredo.concursus.mapping.annotations.HandlesCommandsFor;
import com.opencredo.concursus.mapping.annotations.HandlesEvent;
import com.opencredo.concursus.mapping.annotations.HandlesEventsFor;
import com.opencredo.concursus.mapping.annotations.Initial;
import lombok.Getter;

/**
 * Created by eneko on 09/01/18.
 */
@HandlesEventsFor("policy")
@Getter
public final class Policy {

    @HandlesCommandsFor("policy")
    public interface Commands {
        void create(StreamTimestamp ts, String policyId,String name);
    }

    @HandlesEventsFor("policy")
    public interface Events {
        @Initial
        void created(StreamTimestamp ts, String policyId,String name);
    }

    private final String id;
    private String name;

    private Policy(String id, String name) {
        this.id = id;
        this.name = name;
    }

    @HandlesEvent
    public static Policy created(String citizenId, String citizenName) {
        return new Policy(citizenId, citizenName);
    }


}
