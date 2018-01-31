package org.lobbying.policy.controller;

import org.lobbying.policy.domain.Policy;
import org.lobbying.policy.domain.PolicyUpdate;
import org.lobbying.policy.dto.CreatePolicyDTO;
import org.lobbying.policy.dto.CreatePolicyUpdateDTO;
import org.lobbying.policy.dto.PolicyDTO;
import org.lobbying.policy.dto.PolicyUpdateDTO;
import org.lobbying.policy.mapper.PolicyMapper;
import org.lobbying.policy.mapper.PolicyUpdateMapper;
import org.lobbying.policy.service.PolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
public class PolicyController {

    @Autowired
    private PolicyService policyService;

    @Autowired
    @Qualifier("policy")
    private PolicyMapper policyMapper;

    @Autowired
    private PolicyUpdateMapper policyUpdateMapper;

    @PostMapping(path = "/policies")
    public PolicyDTO createPolicy(@RequestBody CreatePolicyDTO createPolicyDao) {
        Policy createdPolicy =  policyService.createPolicy(policyMapper.from(createPolicyDao));
        PolicyDTO createdPolicyDto =  policyMapper.to(PolicyDTO.class,createdPolicy);
        return createdPolicyDto;
    }

    @GetMapping(path = "/policies/{id}")
    public PolicyDTO getPolicyById(@PathVariable("id") String id) {
        Policy policyFound =  policyService.getPolicyById(id);
        return  policyMapper.to(PolicyDTO.class,policyFound);
    }

    @PostMapping(path = "/policies/{id}/updates")
    public PolicyUpdateDTO updatePolicy(@PathVariable("id") String policyId, @RequestBody CreatePolicyUpdateDTO createPolicyUpdateDTO) {
        PolicyUpdate policyUpdate = policyUpdateMapper.from(createPolicyUpdateDTO);
        PolicyUpdate policyUpdated =  policyService.updatePolicy(policyId,policyUpdate);
        return  policyUpdateMapper.to(policyUpdated);
    }

    @GetMapping(path = "/policies/{policyId}/updates/{policyUpdateId}")
    public PolicyUpdateDTO getPolicyUpdateById(@PathVariable("policyId") String policyId, @PathVariable("policyUpdateId") String policyUpdateId) {
        PolicyUpdate policyUpdated =  policyService.getPolicyUpdate(policyId,policyUpdateId);
        return  policyUpdateMapper.to(policyUpdated);
    }

}
