package org.lobbying.policy.service;

import org.lobbying.policy.domain.Policy;
import org.lobbying.policy.domain.PolicyUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PolicyService {

    @Autowired
    private PolicyRepository policyRepository;

    public PolicyService(PolicyRepository policyRepository) {
        this.policyRepository = policyRepository;
    }

    public Policy createPolicy(Policy createPolicy) {
        return policyRepository.save(createPolicy);
    }

    public Policy getPolicyById(String policyId) {
        return policyRepository.findOne(policyId);
    }

    public PolicyUpdate updatePolicy(String policyId, PolicyUpdate policyUpdate) {
        Policy policy = policyRepository.findOne(policyId);
        PolicyUpdate policyUpdated = policy.update(policyUpdate);
        policyRepository.save(policy);
        return policyUpdated;
    }

    public PolicyUpdate getPolicyUpdate(String policyId, String policyUpdateId) {
        return policyRepository
                .findOne(policyId)
                .getUpdateById(policyUpdateId);
    }
}
