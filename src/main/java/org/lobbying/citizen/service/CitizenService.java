package org.lobbying.citizen.service;

import org.lobbying.citizen.domain.Citizen;
import org.lobbying.citizen.gateway.PolicyGateway;
import org.lobbying.citizen.repository.CitizenRepository;
import org.lobbying.citizen.domain.Policy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by eneko on 13/01/18.
 */

@Component
public class CitizenService {

    @Autowired
    private CitizenRepository citizenRepository;

    @Autowired
    private PolicyGateway policyGateway;

    public CitizenService(CitizenRepository citizenRepository) {
        this.citizenRepository = citizenRepository;
    }

    public Citizen createCitizen(Citizen createCitizen) {
        return citizenRepository.save(createCitizen);
    }

    public Citizen getCitizenById(String citizenId) {
        return citizenRepository.findOne(citizenId);
    }

    public boolean trackPolicy(String citizenId, String policyId) {
        Policy policy = getPolicyById(policyId);
        return getCitizenById(citizenId).trackPolicy(policy);

    }

    private Policy getPolicyById(String policyId) {
        return policyGateway.getPolicyById(policyId);
    }

    public boolean isCitizenTrackingPolicyById(String citizenId, String policyId) {
        return getCitizenById(citizenId)
                .isTrackingPolicyById(policyId);
    }
}
