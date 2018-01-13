package org.lobbying.policy.service;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.lobbying.policy.domain.Policy;
import org.lobbying.policy.domain.PolicyUpdate;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

/**
 * Created by eneko on 13/01/18.
 */
@RunWith(MockitoJUnitRunner.class)
public class PolicyServiceTest extends TestCase {

    private PolicyRepository policyRepository;

    private PolicyService policyService;

    @Before
    public void setup(){
        policyRepository = Mockito.mock(PolicyRepository.class);
        policyService = new PolicyService(policyRepository);
    }

    @Test
    public void createPolicy() throws Exception {

    }

    @Test
    public void getPolicyById() throws Exception {

    }

    @Test
    public void updatePolicy() throws Exception {

        String policyId = "1234";
        String policyUpdateId = "1234-a";

        Policy policy = mock(Policy.class);

        PolicyUpdate policyUpdate = mock(PolicyUpdate.class);
        when(policyUpdate.getId()).thenReturn(policyId);

        PolicyUpdate policyUpdated = mock(PolicyUpdate.class);
        when(policyUpdated.getId()).thenReturn(policyUpdateId);

        when(policyRepository.findOne(policyId)).thenReturn(policy);
        when(policy.update(policyUpdate)).thenReturn(policyUpdated);

        PolicyUpdate policyUpdated2 = policyService.updatePolicy(policyId,policyUpdate);

        verify(policyRepository).findOne(policyId);
        verify(policy).update(policyUpdate);

        assertThat(policyUpdated2.getId(),equalTo(policyUpdated.getId()));

    }

}