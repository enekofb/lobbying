package org.lobbying.policy.domain;

import lombok.Builder;
import lombok.Data;

import java.time.Instant;

/**
 * Created by eneko on 13/01/18.
 */
@Builder
@Data
public class PolicyUpdate {

    private String id;

    private String policyId;
    private String updateContent;
    private Instant updateTimestamp;


}
