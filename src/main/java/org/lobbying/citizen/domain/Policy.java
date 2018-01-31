package org.lobbying.citizen.domain;

import lombok.Builder;
import lombok.Data;
import org.lobbying.policy.domain.PolicyUpdate;
import org.springframework.data.annotation.Id;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import java.util.Map;

@Data
@Builder
@Embeddable
public class Policy {

    private String id;
    private String name;
    private String description;
}
