package org.lobbying.policy.controller;

import org.lobbying.policy.dto.CreatePolicyDTO;
import org.lobbying.policy.domain.Policy;
import org.lobbying.policy.dto.PolicyDTO;
import org.lobbying.policy.mapper.PolicyMapper;
import org.lobbying.policy.service.PolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PolicyController {

    @Autowired
    private PolicyService policyService;

    @Autowired
    private PolicyMapper policyMapper;

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

}
