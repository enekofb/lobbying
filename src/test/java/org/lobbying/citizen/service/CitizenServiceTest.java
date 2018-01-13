package org.lobbying.citizen.service;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.lobbying.citizen.domain.Citizen;
import org.lobbying.citizen.repository.CitizenRepository;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by eneko on 13/01/18.
 */


@RunWith(MockitoJUnitRunner.class)
public class CitizenServiceTest extends TestCase {

    private CitizenRepository citizenRepository;

    private CitizenService citizenService;

    @Before
    public void setup(){
        citizenRepository = Mockito.mock(CitizenRepository.class);
        citizenService = new CitizenService(citizenRepository);
    }

    @Test
    public void testCreateCitizen() throws Exception {
        String citizenId = "1234";
        String citizenEmail = "john@gmail.com";

        Citizen createCitizen = mock(Citizen.class);
        Citizen createdCitizen = mock(Citizen.class);

        when(createdCitizen.getId()).thenReturn(citizenId);
        when(createdCitizen.getEmail()).thenReturn(citizenEmail);
        when(citizenRepository.save(createCitizen)).thenReturn(createdCitizen);

        Citizen savedCitizen = citizenService.createCitizen(createCitizen);

        verify(citizenRepository).save(createCitizen);

        assertThat(savedCitizen.getEmail(),equalTo(createdCitizen.getEmail()));
        assertThat(savedCitizen.getId(),equalTo(citizenId));

    }

    @Test
    public void testGetCitizenById() throws Exception {

        String citizenId = "1234";

        Citizen citizen = mock(Citizen.class);
        when(citizen.getId()).thenReturn(citizenId);

        when(citizenRepository.findOne(citizenId)).thenReturn(citizen);

        Citizen citizenFound = citizenService.getCitizenById(citizenId);

        verify(citizenRepository).findOne(citizenId);

        assertThat(citizenFound.getId(),equalTo(citizenId));

    }

}
