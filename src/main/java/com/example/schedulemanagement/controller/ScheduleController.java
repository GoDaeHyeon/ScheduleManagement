package com.example.schedulemanagement.controller;

import com.example.schedulemanagement.model.Schedule;
import com.example.schedulemanagement.service.ScheduleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/schedules")
public class ScheduleController {
    private final ScheduleService scheduleService;

    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @PostMapping
    public String addSchedule(@RequestBody Schedule schedule) {
        scheduleService.createSchedule(schedule);
        return "Schedule created successfully";
    }

    @GetMapping
    public List<Schedule> getAllSchedules() {
        return scheduleService.getAllSchedules();
    }

    @PutMapping("/{id}")
    public String updateSchedule(@PathVariable int id, @RequestBody Schedule schedule) {
        schedule.setId(id);
        scheduleService.updateSchedule(schedule);
        return "Schedule updated successfully";
    }

    @DeleteMapping("/{id}")
    public String deleteSchedule(@PathVariable int id, @RequestParam String password) {
        scheduleService.deleteSchedule(id, password);
        return "Schedule deleted successfully";
    }
}
