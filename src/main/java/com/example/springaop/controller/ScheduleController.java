package com.example.springaop.controller;

import com.example.springaop.dto.ReqScheduleDto;
import com.example.springaop.dto.ResScheduleDto;
import com.example.springaop.service.ScheduleService;
import org.springframework.web.bind.annotation.*;

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

    //Read Schedule
    @GetMapping("/schedules/{scheduleId}")
    public ReqScheduleDto getSchedule(@PathVariable Long scheduleId) {
        return null;
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
