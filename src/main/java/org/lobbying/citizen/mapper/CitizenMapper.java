package org.lobbying.citizen.mapper;

import org.lobbying.citizen.domain.Citizen;
import org.lobbying.citizen.dto.CitizenDTO;
import org.lobbying.citizen.dto.CreateCitizenDTO;
import org.springframework.stereotype.Component;

/**
 * Created by eneko on 13/01/18.
 */
@Component
public class CitizenMapper {

    public Citizen from(CreateCitizenDTO createCitizenDTO) {
        return Citizen.builder()
                .name(createCitizenDTO.getName())
                .email(createCitizenDTO.getEmail())
                .build();
    }

    public CitizenDTO to(Citizen createdCitizen) {
        return CitizenDTO.builder()
                .name(createdCitizen.getName())
                .email(createdCitizen.getEmail())
                .id(createdCitizen.getId())
                .build();
    }
}
