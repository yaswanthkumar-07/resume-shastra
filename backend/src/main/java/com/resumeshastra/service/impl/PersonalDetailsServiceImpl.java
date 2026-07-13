package com.resumeshastra.service.impl;

import com.resumeshastra.dto.PersonalDetailsDTO;
import com.resumeshastra.entity.Resume;
import com.resumeshastra.mapper.ResumeMapper;
import com.resumeshastra.repository.ResumeRepository;
import com.resumeshastra.service.PersonalDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PersonalDetailsServiceImpl implements PersonalDetailsService {

    private final ResumeRepository resumeRepository;
    private final ResumeMapper resumeMapper;

    @Override
    public String savePersonalDetails(PersonalDetailsDTO dto) {

        Resume resume = resumeMapper.dtoToEntity(dto);

        resumeRepository.save(resume);

        return "Personal details saved successfully";
    }
}