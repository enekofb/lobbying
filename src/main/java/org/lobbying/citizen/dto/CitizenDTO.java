package org.lobbying.citizen.dto;

import lombok.Builder;
import lombok.Data;

/**
 * Created by eneko on 13/01/18.
 */
@Builder
@Data
public class CitizenDTO {

    private String email;
    private String name;
    private String id;

}
