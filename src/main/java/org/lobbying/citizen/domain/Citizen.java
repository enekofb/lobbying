package org.lobbying.citizen.domain;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;

/**
 * Created by eneko on 13/01/18.
 */
@Builder
@Data
public class Citizen {
    @Id
    private String id;
    private String name;
    private String email;
}
