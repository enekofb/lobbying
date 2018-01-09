package org.lobbying.policy;

import com.opencredo.concursus.domain.time.StreamTimestamp;
import com.opencredo.concursus.mapping.annotations.HandlesEventsFor;
import java.util.UUID;


@HandlesEventsFor("policy")
public interface PolicyEvents {
    void tracked(StreamTimestamp ts, UUID citizenId, UUID policyId);
}