package com.resumeshastra.service.impl;

import com.resumeshastra.dto.PersonalDetailsDTO;
import com.resumeshastra.service.PersonalDetailsService;
import org.springframework.stereotype.Service;

@Service
public class PersonalDetailsServiceImpl implements PersonalDetailsService {

    @Override
    public String savePersonalDetails(PersonalDetailsDTO dto) {

        return "Personal details received successfully for " + dto.getFullName();

    }

}