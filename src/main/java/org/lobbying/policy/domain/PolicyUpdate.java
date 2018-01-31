package org.lobbying.policy.domain;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.Instant;

/**
 * Created by eneko on 13/01/18.
 */
@Builder
@Data
@Entity
public class PolicyUpdate {

    @Id
    private String id;

    private String policyId;
    private String updateContent;
    private Instant updateTimestamp;


}
