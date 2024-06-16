package com.example.springaop.controller;

import com.example.springaop.dto.ReqScheduleDto;
import com.example.springaop.dto.ResScheduleDto;
import com.example.springaop.service.ScheduleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")

public class ScheduleController {
    private final ScheduleService scheduleService;

    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    //Create Schedule complete
    @PostMapping("/schedules")
    public ResScheduleDto postSchedule(@RequestBody ReqScheduleDto reqScheduleDto) {
        return scheduleService.createSchedule(reqScheduleDto);
    }

    //특정 Read Schedule
    @GetMapping("/schedules/{scheduleId}")
    public ResScheduleDto getSchedule(@PathVariable Long scheduleId) {
        return scheduleService.findSchedule(scheduleId);
    }

    //All read Schedule
    @GetMapping("/schedules")
    public List<ResScheduleDto> getSchedule() {
        return scheduleService.findAllSchedule();
    }

    //Update Schedule
    @PutMapping("/schedules/{scheduleId}")
    public ReqScheduleDto updateSchedule(@PathVariable Long scheduleId, @RequestBody ReqScheduleDto reqScheduleDto) {
        return null;
    }

    //Delete Schedule
    @DeleteMapping("/schedules//{scheduleId}")
    public ReqScheduleDto deleteSchedule(@PathVariable Long scheduleId, @RequestBody ReqScheduleDto reqScheduleDto) {
        return null;
    }
}
