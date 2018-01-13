package org.lobbying.policy.mapper;

import junit.framework.TestCase;
import org.junit.Test;
import org.lobbying.policy.domain.PolicyUpdate;
import org.lobbying.policy.dto.CreatePolicyUpdateDTO;
import org.lobbying.policy.dto.PolicyUpdateDTO;

import java.time.Instant;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.Matchers.isEmptyString;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.notNull;
import static org.mockito.Mockito.*;

/**
 * Created by eneko on 14/01/18.
 */
public class PolicyUpdateMapperTest{

    private PolicyUpdateMapper policyMapperUpdate = new PolicyUpdateMapper();

    @Test
    public void from() throws Exception {

        String policyId = "1234";
        String updateContent ="policy update content";
        String updateTimestamp = Instant.now().toString();

        CreatePolicyUpdateDTO createPolicyUpdateDTO = mock(CreatePolicyUpdateDTO.class);
        when(createPolicyUpdateDTO.getPolicyId()).thenReturn(policyId);
        when(createPolicyUpdateDTO.getUpdateTimestamp()).thenReturn(updateTimestamp);
        when(createPolicyUpdateDTO.getUpdateContent()).thenReturn(updateContent);

        PolicyUpdate policyUpdate = policyMapperUpdate.from(createPolicyUpdateDTO);

        verify(createPolicyUpdateDTO).getUpdateContent();
        verify(createPolicyUpdateDTO).getUpdateTimestamp();
        verify(createPolicyUpdateDTO).getPolicyId();

        assertThat(policyUpdate.getId(), not(isEmptyString()));
        assertThat(policyUpdate.getPolicyId(),equalTo(policyId));

    }

    @Test
    public void to() throws Exception {


        String id = "1234-a";
        String policyId = "1234";
        String updateContent ="policy update content";
        Instant updateTimestamp = Instant.now();

        PolicyUpdate policyUpdate = mock(PolicyUpdate.class);
        when(policyUpdate.getId()).thenReturn(id);
        when(policyUpdate.getPolicyId()).thenReturn(policyId);
        when(policyUpdate.getUpdateTimestamp()).thenReturn(updateTimestamp);
        when(policyUpdate.getUpdateContent()).thenReturn(updateContent);

        PolicyUpdateDTO policyUpdateDTO = policyMapperUpdate.to(policyUpdate);

        verify(policyUpdate).getUpdateContent();
        verify(policyUpdate).getUpdateTimestamp();
        verify(policyUpdate).getPolicyId();

        assertThat(policyUpdateDTO.getId(), equalTo(id));
        assertThat(policyUpdateDTO.getPolicyId(),equalTo(policyId));

    }


}