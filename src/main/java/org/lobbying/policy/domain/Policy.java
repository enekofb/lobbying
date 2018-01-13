package org.lobbying.policy.domain;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.UUID;

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

}
