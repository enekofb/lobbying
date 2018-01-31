package org.lobbying.policy.domain;

import lombok.Builder;
import lombok.Data;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Map;

/**
 * Created by eneko on 10/01/18.
 */
@Data
@Builder
@Entity
public class Policy {

    @Id
    @GeneratedValue
    private String id;
    private String name;
    private String description;

    @ElementCollection
    private Map<String,PolicyUpdate> updates;

    public PolicyUpdate update(PolicyUpdate policyUpdate){
        updates.put(policyUpdate.getId(), policyUpdate);
        return policyUpdate;
    }

    public PolicyUpdate getUpdateById(String policyUpdateId) {
        return this.updates.get(policyUpdateId);
    }
}
