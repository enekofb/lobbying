package org.lobbying.policy.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.Instant;

/**
 * Created by eneko on 13/01/18.
 */
@Builder
@Data
@Embeddable
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class PolicyUpdate {

    @Id
    @GeneratedValue
    private String id;

    private String policyId;
    private String updateContent;
    private Instant updateTimestamp;


}
