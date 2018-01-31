package org.lobbying.citizen.gateway;


import org.lobbying.citizen.domain.Policy;
import org.lobbying.citizen.mapper.PolicyMapper;
import org.lobbying.citizen.domain.Policy;
import org.lobbying.citizen.dto.PolicyDTO;
import org.lobbying.utils.client.PolicyClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class PolicyGateway {

    @Autowired
    private PolicyClient policyClient;

    @Autowired
    @Qualifier("citizen")
    private final PolicyMapper policyMapper;

    public PolicyGateway(PolicyClient policyClient, PolicyMapper policyMapper){
        this.policyClient = policyClient;
        this.policyMapper = policyMapper;
    }

    public Policy getPolicyById(String policyId) {
        PolicyDTO policyDTO = policyClient.getPolicyById(policyId);
        return policyMapper.from(policyDTO);
    }

}
