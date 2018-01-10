package org.lobbying.dao;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class GetPolicyDAO {

    private String name;
    private String description;
}
