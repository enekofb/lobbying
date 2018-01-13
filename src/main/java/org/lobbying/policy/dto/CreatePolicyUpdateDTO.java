package org.lobbying.policy.dto;

import lombok.Builder;
import lombok.Data;

/**
 * Created by eneko on 14/01/18.
 */
@Builder
@Data
public class CreatePolicyUpdateDTO {
    private String policyId;
    private String updateContent;
    private String updateTimestamp;

}
