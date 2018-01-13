package org.lobbying.policy;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.lobbying.citizen.dto.CitizenDTO;
import org.lobbying.policy.controller.PolicyController;
import org.lobbying.policy.domain.PolicyUpdate;
import org.lobbying.policy.dto.CreatePolicyUpdateDTO;
import org.lobbying.policy.dto.PolicyUpdateDTO;
import org.lobbying.policy.mapper.PolicyMapper;
import org.lobbying.policy.mapper.PolicyUpdateMapper;
import org.lobbying.policy.service.PolicyService;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Instant;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.isEmptyString;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class PolicyControllerTest {
    private static Logger LOGGER = LoggerFactory.getLogger(PolicyControllerTest.class);

    @Mock
    private PolicyService policyService;

    @Mock
    private PolicyMapper policyMapper;

    @Mock
    private PolicyUpdateMapper policyUpdateMapper;

    @InjectMocks
    private PolicyController policyController;

    @Test
    public void createPolicy() throws Exception {
        LOGGER.warn("Not implemented");
    }

    @Test
    public void getPolicyById() throws Exception {
        LOGGER.warn("Not implemented");
    }

    @Test
    public void updatePolicy() throws Exception {

        String policyId = "1234";
        String policyUpdateId = "1234-a";
        String policyUpdateContent = "policy update content";
        String policyUpdateTimestamp = Instant.now().toString();

        CreatePolicyUpdateDTO createPolicyUpdateDTO = mock(CreatePolicyUpdateDTO.class);
        when(createPolicyUpdateDTO.getPolicyId()).thenReturn(policyId);
        when(createPolicyUpdateDTO.getUpdateContent()).thenReturn(policyUpdateContent);
        when(createPolicyUpdateDTO.getUpdateTimestamp()).thenReturn(policyUpdateTimestamp);

        PolicyUpdate policyUpdate = mock(PolicyUpdate.class);
        when(policyUpdate.getId()).thenReturn(policyUpdateId);
        when(policyUpdate.getPolicyId()).thenReturn(policyId);

        PolicyUpdateDTO policyUpdateDTO = mock(PolicyUpdateDTO.class);
        when(policyUpdateDTO.getId()).thenReturn(policyUpdateId);
        when(policyUpdateDTO.getPolicyId()).thenReturn(policyId);

        when(policyUpdateMapper.from(createPolicyUpdateDTO)).thenReturn(policyUpdate);
        when(policyService.updatePolicy(policyId,policyUpdate)).thenReturn(policyUpdate);
        when(policyUpdateMapper.to(policyUpdate)).thenReturn(policyUpdateDTO);

        PolicyUpdateDTO policyUpdateDTO2 = policyController.updatePolicy(policyId,createPolicyUpdateDTO);

        verify(policyUpdateMapper).from(createPolicyUpdateDTO);
        verify(policyService).updatePolicy(policyId,policyUpdate);
        verify(policyUpdateMapper).to(policyUpdate);

        assertThat(policyUpdateDTO2.getPolicyId(),equalTo(policyId));
        assertThat(policyUpdateDTO2.getId(), not(isEmptyString()));


    }



}