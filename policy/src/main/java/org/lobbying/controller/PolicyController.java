package org.lobbying.controller;

import org.lobbying.dao.CreatePolicyDAO;
import org.lobbying.service.PolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PolicyController {

    @Autowired
    private PolicyService policyService;

    @PostMapping(path = "/policies")
    public String createCitizen(@RequestBody CreatePolicyDAO createPolicyDao) {
        return policyService.createPolicy(createPolicyDao);
    }

}
