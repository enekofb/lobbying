package org.lobbying.citizen;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.lobbying.citizen.controller.CitizenController;
import org.lobbying.citizen.domain.Citizen;
import org.lobbying.citizen.dto.CitizenDTO;
import org.lobbying.citizen.dto.CreateCitizenDTO;
import org.lobbying.citizen.mapper.CitizenMapper;
import org.lobbying.citizen.service.CitizenService;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CitizenControllerTest {

    @Mock
    private CitizenService citizenService;

    @Mock
    private CitizenMapper citizenMapper;

    @InjectMocks
    private CitizenController citizenController;

    @Test
    public void createCitizen(){
        String id = "1234";
        String email = "john@gmail.com";
        String name = "john";

        CreateCitizenDTO createCitizenDTO = mock(CreateCitizenDTO.class);
        when(createCitizenDTO.getEmail()).thenReturn(email);
        when(createCitizenDTO.getName()).thenReturn(name);

        Citizen citizen = mock(Citizen.class);
        when(citizen.getId()).thenReturn(id);

        CitizenDTO citizenDTO = mock(CitizenDTO.class);
        when(citizenDTO.getId()).thenReturn(id);

        when(citizenMapper.from(createCitizenDTO)).thenReturn(citizen);
        when(citizenMapper.to(citizen)).thenReturn(citizenDTO);
        when(citizenService.createCitizen(citizen)).thenReturn(citizen);

        CitizenDTO createdCitizen = citizenController.createCitizen(createCitizenDTO);

        verify(citizenMapper).from(createCitizenDTO);
        verify(citizenMapper).to(citizen);
        verify(citizenService).createCitizen(citizen);

        assertThat(createdCitizen.getEmail(),equalTo(citizen.getEmail()));
        assertThat(createdCitizen.getName(),equalTo(citizen.getName()));
        assertThat(createdCitizen.getId(),equalTo(citizen.getId()));

    }


    @Test
    public void getCitizenById() throws Exception {
        String citizenId = "1234";

        Citizen citizen = mock(Citizen.class);
        when(citizen.getId()).thenReturn(citizenId);

        CitizenDTO citizenDTO = mock(CitizenDTO.class);
        when(citizenDTO.getId()).thenReturn(citizenId);

        when(citizenService.getCitizenById(citizenId)).thenReturn(citizen);
        when(citizenMapper.to(citizen)).thenReturn(citizenDTO);

        CitizenDTO createdCitizen = citizenController.getCitizenById(citizenId);

        verify(citizenService).getCitizenById(citizenId);
        verify(citizenMapper).to(citizen);

        assertThat(createdCitizen.getId(),equalTo(citizen.getId()));

    }

    @Test
    public void trackPolicy() throws Exception {

        String citizenId = "1234";
        String policyId = "1234";

        when(citizenService.trackPolicy(citizenId,policyId)).thenReturn(true);

        boolean policyTracked = citizenController.trackPolicy(citizenId,policyId);

        assertThat(policyTracked,is(Boolean.TRUE));



    }

    @Test
    public void isCitizenTrackingPolicyById() throws Exception {

        String citizenId = "1234";
        String policyId = "1234";

        when(citizenService.isCitizenTrackingPolicyById(citizenId,policyId)).thenReturn(true);

        boolean policyTracked = citizenController.isCitizenTrackingPolicyById(citizenId,policyId);

        assertThat(policyTracked,is(Boolean.TRUE));

    }

}
