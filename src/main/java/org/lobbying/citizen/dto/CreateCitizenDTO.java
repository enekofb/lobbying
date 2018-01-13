package org.lobbying.citizen.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by eneko on 13/01/18.
 */
@Builder
@Data
public class CreateCitizenDTO {

    private String email;
    private String name;

}
