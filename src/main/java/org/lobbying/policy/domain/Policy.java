package org.lobbying.policy.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Map;

/**
 * Created by eneko on 10/01/18.
 */
@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Policy {

    @Id
    @GeneratedValue
    private String id;
    private String name;
    private String description;

    @ElementCollection
    @Embedded
    private Map<String,PolicyUpdate> updates;

    public PolicyUpdate update(PolicyUpdate policyUpdate){
        updates.put(policyUpdate.getId(), policyUpdate);
        return policyUpdate;
    }

    public PolicyUpdate getUpdateById(String policyUpdateId) {
        return this.updates.get(policyUpdateId);
    }
}
