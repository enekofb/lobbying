package org.lobbying.policy.service;

import org.lobbying.policy.domain.Policy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
