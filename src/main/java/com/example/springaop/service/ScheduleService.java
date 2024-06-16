package com.example.springaop.service;

import com.example.springaop.dto.ReqScheduleDto;
import com.example.springaop.dto.ResScheduleDto;
import com.example.springaop.entity.Schedule;
import com.example.springaop.entity.TimeStamped;
import com.example.springaop.repository.ScheduleRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class ScheduleService {
    private final ScheduleRepository scheduleRepository;

    public ScheduleService(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository; // 의존성 주입
    }// 생성자에 Repository 를적으면서 왜? 의존성이 주입되는지 다시 한 번 공부.

    @Transactional
    public ResScheduleDto createSchedule(ReqScheduleDto ReqScheduleDto) {
        String title = ReqScheduleDto.getTitle();
        String content = ReqScheduleDto.getContent();
        String manager = ReqScheduleDto.getManager();
        Integer password = ReqScheduleDto.getPassword();
        Schedule schedule = new Schedule(title, content, manager, password);

        scheduleRepository.save(schedule);

        return new ResScheduleDto(schedule);
    }


}
