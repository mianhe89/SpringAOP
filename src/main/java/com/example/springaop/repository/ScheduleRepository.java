package com.example.springaop.repository;


import com.example.springaop.dto.ResScheduleDto;
import com.example.springaop.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
    List<ResScheduleDto> findAllByOrderByCreatedAtDesc();

}
