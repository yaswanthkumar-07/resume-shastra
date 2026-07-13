package com.resumeshastra.service;

import com.resumeshastra.dto.PersonalDetailsDTO;
import com.resumeshastra.response.PersonalDetailsResponseDTO;

public interface PersonalDetailsService {

    PersonalDetailsResponseDTO savePersonalDetails(PersonalDetailsDTO dto);

}