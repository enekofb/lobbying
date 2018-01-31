package org.lobbying.policy.mapper;

import org.lobbying.policy.dto.CreatePolicyUpdateDTO;
import org.lobbying.policy.domain.PolicyUpdate;
import org.lobbying.policy.dto.PolicyUpdateDTO;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.UUID;

/**
 * Created by eneko on 14/01/18.
 */
@Component
public class PolicyUpdateMapper {
    public PolicyUpdate from(CreatePolicyUpdateDTO createPolicyUpdateDTO) {
        return PolicyUpdate.builder()
                .policyId(createPolicyUpdateDTO.getPolicyId())
                .updateTimestamp(Instant.parse(createPolicyUpdateDTO.getUpdateTimestamp()))
                .updateContent(createPolicyUpdateDTO.getUpdateContent())
                .build();
    }

    public PolicyUpdateDTO to(PolicyUpdate policyUpdate) {
        return PolicyUpdateDTO.builder()
                .id(policyUpdate.getId())
                .policyId(policyUpdate.getPolicyId())
                .updateTimestamp(policyUpdate.getUpdateTimestamp().toString())
                .updateContent(policyUpdate.getUpdateContent())
                .build();
    }
}
