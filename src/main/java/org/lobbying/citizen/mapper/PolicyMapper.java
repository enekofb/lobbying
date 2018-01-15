package org.lobbying.citizen.mapper;


import org.lobbying.citizen.domain.Policy;
import org.lobbying.citizen.dto.PolicyDTO;

/**
 * Created by eneko on 11/01/18.
 */
//@Component
public class PolicyMapper {


    public org.lobbying.citizen.domain.Policy from(PolicyDTO policyDTO) {
        return Policy.builder()
                .id(policyDTO.getId())
                .name(policyDTO.getName())
                .description(policyDTO.getDescription())
                .build();
    }
}
