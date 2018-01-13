package org.lobbying.policy.dto;

import lombok.Builder;
import lombok.Data;

import java.time.Instant;

/**
 * Created by eneko on 13/01/18.
 */
@Builder
@Data
public class PolicyUpdateDTO {

    private String id;

    private String policyId;
    private String updateContent;
    private String updateTimestamp;
}
