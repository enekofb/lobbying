package org.lobbying.policy.mapper;

import org.lobbying.policy.domain.Policy;
import org.lobbying.policy.domain.PolicyUpdate;
import org.lobbying.policy.dto.CreatePolicyDTO;
import org.lobbying.policy.dto.CreatePolicyUpdateDTO;
import org.lobbying.policy.dto.PolicyDTO;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.HashMap;


/**
 * Created by eneko on 11/01/18.
 */
//@Component
public class PolicyMapper {


    public Policy from(CreatePolicyDTO createPolicyDto){

        return Policy.builder()
                .name(createPolicyDto.getName())
                .updates(new HashMap<>())
                .description(createPolicyDto.getDescription())
                .build();

    }

    public PolicyUpdate from(CreatePolicyUpdateDTO createPolicyUpdateDTO) {
        return PolicyUpdate.builder()
                .policyId(createPolicyUpdateDTO.getPolicyId())
                .updateContent(createPolicyUpdateDTO.getUpdateContent())
                .updateTimestamp(Instant.parse(createPolicyUpdateDTO.getUpdateTimestamp()))
                .build();
    }

    public PolicyDTO to(Class<PolicyDTO> toClass, Policy createdPolicy) {
        return PolicyDTO.builder()
                .id(createdPolicy.getId())
                .name(createdPolicy.getName())
                .description(createdPolicy.getDescription())
                .build();
    }

    public Policy from(PolicyDTO policy) {
        return Policy.builder()
                .id(policy.getId())
                .name(policy.getName())
                .description(policy.getDescription())
                .build();
    }
}
