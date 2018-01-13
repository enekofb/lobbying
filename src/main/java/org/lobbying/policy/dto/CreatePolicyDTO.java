package org.lobbying.policy.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class CreatePolicyDTO {

    private String name;
    private String description;
}
