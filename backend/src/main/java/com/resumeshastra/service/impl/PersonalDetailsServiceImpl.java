package com.resumeshastra.service.impl;

import com.resumeshastra.dto.PersonalDetailsDTO;
import com.resumeshastra.entity.Resume;
import com.resumeshastra.mapper.ResumeMapper;
import com.resumeshastra.repository.ResumeRepository;
import com.resumeshastra.service.PersonalDetailsService;
import com.resumeshastra.response.PersonalDetailsResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PersonalDetailsServiceImpl implements PersonalDetailsService {

    private final ResumeRepository resumeRepository;
    private final ResumeMapper resumeMapper;

    @Override
    public PersonalDetailsResponseDTO savePersonalDetails(PersonalDetailsDTO dto) {

        Resume resume = resumeMapper.dtoToEntity(dto);

        Resume savedResume = resumeRepository.save(resume);

return PersonalDetailsResponseDTO.builder()
        .resumeId(savedResume.getId())
        .build();
    }
}