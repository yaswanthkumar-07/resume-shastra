package com.resumeshastra.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.resumeshastra.entity.Achievement;

@Repository
public interface AchievementRepository extends JpaRepository<Achievement, Long> {

    List<Achievement> findByResumeIdOrderByDisplayOrderAsc(Long resumeId);

}