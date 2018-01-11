package org.lobbying.service;

import org.lobbying.domain.Policy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class PolicyService {

    @Autowired
    private PolicyRepository policies;

    public Policy createPolicy(Policy createPolicy) {
        return policies.save(createPolicy);
    }

    public Policy getPolicyById(String policyId) {
        return policies.findOne(policyId);
    }
}
