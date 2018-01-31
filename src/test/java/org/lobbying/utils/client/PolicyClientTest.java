package org.lobbying.utils.client;

import org.junit.Before;
import org.junit.Test;
import org.lobbying.citizen.dto.PolicyDTO;
import org.springframework.web.client.RestTemplate;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class PolicyClientTest {

    private RestTemplate policyRestTemplate;

    private PolicyClient policyClient;

    private String policyBaseUrl = "http://www.lobbying.org/policies";

    @Before
    public void setup() {
        policyRestTemplate = mock(RestTemplate.class);
        policyClient = new PolicyClient(policyRestTemplate, policyBaseUrl);
    }

    @Test
    public void getPolicyById() throws Exception {

        String policyId = "1234";

        PolicyDTO policyDto = mock(PolicyDTO.class);
        when(policyDto.getId()).thenReturn(policyId);

        when(policyRestTemplate.
                getForObject(policyClient.getPolicyByIdUrl(), PolicyDTO.class, policyId))
                .thenReturn(policyDto);

        PolicyDTO gottenPolicyDTO = policyClient.getPolicyById(policyId);

        verify(policyRestTemplate)
                .getForObject(policyClient.getPolicyByIdUrl(), PolicyDTO.class, policyId);

        assertThat(gottenPolicyDTO.getId(), equalTo(policyDto.getId()));

    }

}