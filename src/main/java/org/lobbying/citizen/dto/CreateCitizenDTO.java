package org.lobbying.citizen.dto;

import lombok.Builder;
import lombok.Data;

/**
 * Created by eneko on 13/01/18.
 */
@Data
@Builder
public class CreateCitizenDTO {

    private String email;
    private String name;
}
