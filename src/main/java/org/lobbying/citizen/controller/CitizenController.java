package org.lobbying.citizen.controller;

import org.lobbying.citizen.domain.Citizen;
import org.lobbying.citizen.dto.CitizenDTO;
import org.lobbying.citizen.dto.CreateCitizenDTO;
import org.lobbying.citizen.mapper.CitizenMapper;
import org.lobbying.citizen.service.CitizenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

/**
 * Created by eneko on 13/01/18.
 */
@RestController
public class CitizenController {

    @Autowired
    private CitizenMapper citizenMapper;

    @Autowired
    private CitizenService citizenService;

    public  CitizenController(CitizenService citizenService,CitizenMapper citizenMapper){
        this.citizenService = citizenService;
        this.citizenMapper = citizenMapper;
    }

    @PostMapping(path = "/citizens")
    public CitizenDTO createCitizen(@RequestBody CreateCitizenDTO createCitizenDTO)  {
        Citizen createCitizen =  citizenMapper.from(createCitizenDTO);
        Citizen createdCitizen = citizenService.createCitizen(createCitizen);
        return citizenMapper.to(createdCitizen);
    }

    @GetMapping(path = "/citizens/{id}")
    public CitizenDTO getCitizenById(@PathVariable("id") String citizenId) {
        Citizen citizenFound =  citizenService.getCitizenById(citizenId);
        return  citizenMapper.to(citizenFound);
    }


}
