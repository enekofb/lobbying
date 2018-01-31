package org.lobbying.common;

import lombok.Builder;
import org.lobbying.citizen.dto.CitizenDTO;
import org.lobbying.citizen.dto.CreateCitizenDTO;
import org.lobbying.policy.dto.CreatePolicyDTO;
import org.lobbying.policy.dto.CreatePolicyUpdateDTO;
import org.lobbying.policy.dto.PolicyDTO;
import org.lobbying.policy.dto.PolicyUpdateDTO;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

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
    public static final String CITIZEN_TRACK_POLICY_URL = "http://localhost:{port}/citizens/{ciitizenId}/policies/{policyId}";

    private TestRestTemplate restTemplate;
    private int port;


    private PolicyUpdateDTO policyUpdate;

    private CitizenDTO citizenDTO;

    private PolicyDTO policyDTO;


    public PolicyDTO createPolicy(String policyName, String policyDescription) {

        CreatePolicyDTO createPolicyDTO = CreatePolicyDTO
                .builder()
                .name(policyName)
                .description(policyDescription)
                .build();
        return (policyDTO = restTemplate.
                postForObject(CREATE_POLICY_URL, createPolicyDTO, PolicyDTO.class,port,createPolicyDTO));
    }

    public PolicyDTO getPolicyDTO(){
        return policyDTO;
    }

    public PolicyUpdateDTO updatePolicy(CreatePolicyUpdateDTO createPolicyUpdateDto) {

        policyUpdate = restTemplate.
                postForObject(UPDATE_POLICY_URL, createPolicyUpdateDto,
                        PolicyUpdateDTO.class,port,createPolicyUpdateDto.getPolicyId());
        return policyUpdate;
    }

    public PolicyUpdateDTO getPolicyUpdate(String policyId, String policyUpdateId) {

        policyUpdate = restTemplate.
                getForObject(GET_POLICY_UPDATE_BY_ID,
                        PolicyUpdateDTO.class,port,policyId,policyUpdateId);

        return policyUpdate;
    }

    public CitizenDTO createCitizen(String citizenName, String citizenEmail) {
        CreateCitizenDTO createCitizenDTO = CreateCitizenDTO.builder().email(citizenEmail).name(citizenName).build();
        assertThat(createCitizenDTO.getEmail(), equalTo(citizenEmail));
        assertThat(createCitizenDTO.getName(), equalTo(citizenName));

        citizenDTO = restTemplate.postForObject(CREATE_CITIZEN_URL, createCitizenDTO, CitizenDTO.class, port);
        assertThat(citizenDTO.getName(),equalTo(createCitizenDTO.getName()));
        return citizenDTO;

    }

    public CitizenDTO getCitizenDTO() {
        return citizenDTO;
    }

    public boolean citizenTrackPolicy(String citizenId, String policyId) {
        restTemplate.put(CITIZEN_TRACK_POLICY_URL, new String(),
                port,citizenId,policyId);
        return true;
    }

    public PolicyDTO getPolicyByCitizen(String citizenId, String policyId) {
        return restTemplate.
                getForEntity(CITIZEN_TRACK_POLICY_URL,
                        PolicyDTO.class, port,citizenId,policyId).getBody();
    }
}
