package com.example.schedulemanagement.service;

import com.example.schedulemanagement.model.Schedule;
import com.example.schedulemanagement.repository.ScheduleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleService {
    private final ScheduleRepository scheduleRepository;

    public ScheduleService(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    public void createSchedule(Schedule schedule) {
        scheduleRepository.save(schedule);
    }

    public List<Schedule> getAllSchedules() {
        return scheduleRepository.findAll();
    }

    public void updateSchedule(Schedule schedule) {
        scheduleRepository.update(schedule);
    }

    public void deleteSchedule(int id, String password) {
        scheduleRepository.delete(id, password);
    }
}
