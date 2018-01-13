package org.lobbying.common;

import lombok.Builder;
import org.lobbying.policy.dto.CreatePolicyDTO;
import org.lobbying.policy.domain.PolicyUpdate;
import org.lobbying.policy.dto.CreatePolicyUpdateDTO;
import org.lobbying.policy.dto.PolicyDTO;
import org.lobbying.policy.dto.PolicyUpdateDTO;
import org.springframework.boot.test.web.client.TestRestTemplate;

/**
 * Created by eneko on 13/01/18.
 */
@Builder
public class PolicyWorld {

    // POLICY URLS
    public static final String CREATE_POLICY_URL = "http://localhost:{port}/policies";
    public static final String UPDATE_POLICY_URL = "http://localhost:{port}/policies/{id}/updates";
    public static final String GET_POLICY_BY_ID_URL = "http://localhost:{port}/policies/{id}";
    public static final String GET_POLICY_UPDATE_BY_ID = "http://localhost:{port}/policies/{policyId}/updates/{policyUpdateId}";

    // CITIZEN URLS
    public static final String CREATE_CITIZEN_URL = "http://localhost:{port}/citizens";
    public static final String GET_CITIZEN_BY_ID_URL = "http://localhost:{port}/citizens/{id}";

    private TestRestTemplate policyClient;
    private int port;


    private PolicyDTO policy;
    private PolicyUpdateDTO policyUpdate;


    public PolicyDTO createPolicy(String policyName, String policyDescription) {

        CreatePolicyDTO createPolicyDTO = CreatePolicyDTO
                .builder()
                .name(policyName)
                .description(policyDescription)
                .build();
        return (policy = policyClient.
                postForObject(CREATE_POLICY_URL, createPolicyDTO, PolicyDTO.class,port,createPolicyDTO));
    }

    public PolicyDTO getPolicy(){
        return policy;
    }

    public PolicyUpdateDTO updatePolicy(CreatePolicyUpdateDTO createPolicyUpdateDto) {

        policyUpdate = policyClient.
                postForObject(UPDATE_POLICY_URL, createPolicyUpdateDto,
                        PolicyUpdateDTO.class,port,createPolicyUpdateDto.getPolicyId());
        return policyUpdate;
    }

    public PolicyUpdateDTO getPolicyUpdate(String policyId, String policyUpdateId) {

        policyUpdate = policyClient.
                getForObject(GET_POLICY_UPDATE_BY_ID,
                        PolicyUpdateDTO.class,port,policyId,policyUpdateId);

        return policyUpdate;
    }
}
