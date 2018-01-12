package org.lobbying.domain;

import com.opencredo.concursus.domain.time.StreamTimestamp;
import com.opencredo.concursus.mapping.annotations.HandlesCommandsFor;
import com.opencredo.concursus.mapping.annotations.HandlesEvent;
import com.opencredo.concursus.mapping.annotations.HandlesEventsFor;
import com.opencredo.concursus.mapping.annotations.Initial;
import lombok.Getter;

/**
 * Created by eneko on 09/01/18.
 */
@HandlesEventsFor("citizen")
@Getter
public final class Citizen {

    @HandlesCommandsFor("citizen")
    public interface Commands {
        void create(StreamTimestamp now, String citizenId, String citizenName);
        void trackPolicy(StreamTimestamp ts, String citizenId, String policyId);
    }

    @HandlesEventsFor("citizen")
    public interface Events {
        @Initial
        void created(StreamTimestamp ts, String citizenId, String citizenName);
        void tracked(StreamTimestamp ts, String citizenId, String policyId);
    }

    private final String id;
    private String name;

    private Citizen(String id,String name) {
        this.id = id;
        this.name = name;
    }

    @HandlesEvent
    public static Citizen created(String citizenId, String citizenName) {
        return new Citizen(citizenId, citizenName);
    }


}
