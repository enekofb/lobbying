package org.lobbying.citizen.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class PolicyDTO {

    private String id;
    private String name;
    private String description;
}
