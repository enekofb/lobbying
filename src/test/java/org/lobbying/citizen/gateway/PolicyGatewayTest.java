package org.lobbying.citizen.gateway;


import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.lobbying.citizen.domain.Policy;
import org.lobbying.citizen.dto.PolicyDTO;
import org.lobbying.citizen.mapper.PolicyMapper;
import org.lobbying.utils.client.PolicyClient;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PolicyGatewayTest extends TestCase {

    @Mock
    PolicyClient policyClient;

    @Mock
    PolicyMapper policyMapper;

    @InjectMocks
    PolicyGateway policyGateway;


    @Test
    public void testGetPolicyById() throws Exception {

        String policyId="1234";
        Policy policy = mock(Policy.class);
        PolicyDTO policyDTO = mock(PolicyDTO.class);

        when(policyClient.getPolicyById(policyId)).thenReturn(policyDTO);
        when(policyMapper.from(policyDTO)).thenReturn(policy);

        Policy gottenPolicy = policyGateway.getPolicyById(policyId);

        verify(policyClient).getPolicyById(policyId);
        verify(policyMapper).from(policyDTO);

        assertThat(gottenPolicy.getId(),equalTo(policyDTO.getId()));
    }



}