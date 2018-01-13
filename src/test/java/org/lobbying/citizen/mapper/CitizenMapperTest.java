package org.lobbying.citizen.mapper;

import org.junit.Test;
import org.lobbying.citizen.domain.Citizen;
import org.lobbying.citizen.dto.CitizenDTO;
import org.lobbying.citizen.dto.CreateCitizenDTO;
import org.mockito.InjectMocks;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by eneko on 13/01/18.
 */
public class CitizenMapperTest {

    private CitizenMapper citizenMapper = new CitizenMapper();

    @Test
    public void from() throws Exception {

        String email = "john@gmail.com";
        String name = "john";

        CreateCitizenDTO createCitizenDTO = mock(CreateCitizenDTO.class);
        when(createCitizenDTO.getEmail()).thenReturn(email);
        when(createCitizenDTO.getName()).thenReturn(name);

        Citizen mappedCitizen = citizenMapper.from(createCitizenDTO);

        verify(createCitizenDTO).getEmail();
        verify(createCitizenDTO).getName();

        assertThat(mappedCitizen.getEmail(),equalTo(createCitizenDTO.getEmail()));
        assertThat(mappedCitizen.getName(),equalTo(createCitizenDTO.getName()));

    }

    @Test
    public void to() throws Exception {


        String id = "1234";
        String email = "john@gmail.com";
        String name = "john";

        Citizen citizen = mock(Citizen.class);
        when(citizen.getEmail()).thenReturn(email);
        when(citizen.getName()).thenReturn(name);
        when(citizen.getId()).thenReturn(id);

        CitizenDTO mappedCitizen = citizenMapper.to(citizen);

        verify(citizen).getEmail();
        verify(citizen).getName();
        verify(citizen).getId();

        assertThat(mappedCitizen.getEmail(),equalTo(citizen.getEmail()));
        assertThat(mappedCitizen.getName(),equalTo(citizen.getName()));
        assertThat(mappedCitizen.getId(),equalTo(citizen.getId()));

    }


}