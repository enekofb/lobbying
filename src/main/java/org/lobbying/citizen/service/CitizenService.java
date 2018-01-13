package org.lobbying.citizen.service;

import org.lobbying.citizen.domain.Citizen;
import org.lobbying.citizen.repository.CitizenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by eneko on 13/01/18.
 */

@Component
public class CitizenService {

    @Autowired
    private CitizenRepository citizenRepository;

    public CitizenService(CitizenRepository citizenRepository) {
        this.citizenRepository = citizenRepository;
    }

    public Citizen createCitizen(Citizen createCitizen) {
        return citizenRepository.save(createCitizen);
    }

    public Citizen getCitizenById(String citizenId) {
        return citizenRepository.findOne(citizenId);

    }
}
