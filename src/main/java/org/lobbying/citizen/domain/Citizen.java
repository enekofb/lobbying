package org.lobbying.citizen.domain;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.util.Map;

/**
 * Created by eneko on 13/01/18.
 */
@Builder
@Data
@Entity
public class Citizen {
    @Id
    @GeneratedValue
    private String id;
    private String name;
    private String email;

    @ElementCollection
    @Embedded
    private Map<String,Policy> policies;

    public boolean trackPolicy(Policy policy){
        policies.put(policy.getId(), policy);
        return true;
    }

    public boolean isTrackingPolicyById(String policyId) {
        return policies.containsKey(policyId);
    }
}
