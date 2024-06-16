package com.example.springaop.service;

import com.example.springaop.dto.ReqScheduleDto;
import com.example.springaop.dto.ResScheduleDto;
import com.example.springaop.entity.Schedule;
import com.example.springaop.repository.ScheduleRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ScheduleService {
    private final ScheduleRepository scheduleRepository;

    public ScheduleService(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository; // 의존성 주입
    }// 생성자에 Repository 를적으면서 왜? 의존성이 주입되는지 다시 한 번 공부.

    @Transactional
    public ResScheduleDto createSchedule(ReqScheduleDto reqScheduleDto) {
        String title = reqScheduleDto.getTitle();
        String content = reqScheduleDto.getContent();
        String manager = reqScheduleDto.getManager();
        Integer password = reqScheduleDto.getPassword();
        Schedule schedule = new Schedule(title, content, manager, password);

        scheduleRepository.save(schedule);

        return new ResScheduleDto(schedule);
    }

    public ResScheduleDto findSchedule(Long scheduleId) {
        Schedule schedule = scheduleRepository.findById(scheduleId).orElseThrow(
                () -> new RuntimeException("없는 아이디 입니다.")
        );
        return new ResScheduleDto(schedule);
    }

    public List<ResScheduleDto> findAllSchedule() {
//        return scheduleRepository.findAllByOrderByCreatedAtDesc().stream().map(ResScheduleDto::new).toList();
        return scheduleRepository.findAll().stream().map(ResScheduleDto::new).toList();
    }

    public ResScheduleDto updateSchedule(Long id, ReqScheduleDto reqScheduleDto) {
        Schedule schedule = scheduleRepository.findById(id).orElseThrow(
                () -> new RuntimeException("없는 아이디 입니다.")
        );
        if (!(id.equals(schedule.getId())) || !Objects.equals(reqScheduleDto.getPassword(), schedule.getPassword())) {
            throw new RuntimeException("패스워드 오류 혹은 사용자와 일치하지 않는 유저입니다.");
        }
        String title = reqScheduleDto.getTitle();
        String content = reqScheduleDto.getContent();
        String manager = reqScheduleDto.getManager();
        schedule.changeSchedule(title, content, manager);
        scheduleRepository.save(schedule);
        return new ResScheduleDto(schedule);
    }

    public void deleteSchedule(Long id) {
        Schedule schedule = scheduleRepository.findById(id).orElseThrow(
                () -> new RuntimeException("없는 아이디 입니다.")
        );
        schedule.isDelete();
        scheduleRepository.save(schedule); //Soft Delete 상태로써 관리

        // scheduleRepository.deleteById(id); Hard Delete
    }
}
