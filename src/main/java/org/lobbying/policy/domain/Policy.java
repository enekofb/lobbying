package org.lobbying.policy.domain;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by eneko on 10/01/18.
 */
@Data
@Builder
public class Policy {

    @Id
    private String id;
    private String name;
    private String description;

    private Map<String,PolicyUpdate> updates;

    public PolicyUpdate update(PolicyUpdate policyUpdate){
        updates.put(policyUpdate.getId(), policyUpdate);
        return policyUpdate;
    }

    public PolicyUpdate getUpdateById(String policyUpdateId) {
        return this.updates.get(policyUpdateId);
    }
}
