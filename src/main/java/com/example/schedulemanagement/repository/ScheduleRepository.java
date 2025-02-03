package com.example.schedulemanagement.repository;

import com.example.schedulemanagement.model.Schedule;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ScheduleRepository {
    private final JdbcTemplate jdbcTemplate;

    public ScheduleRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // 일정 저장
    public void save(Schedule schedule) {
        String sql = "INSERT INTO schedules (title, writer, date, password) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, schedule.getTitle(), schedule.getWriter(), schedule.getDate(), schedule.getPassword());
    }

    // 일정 조회
    public List<Schedule> findAll() {
        String sql = "SELECT * FROM schedules";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Schedule schedule = new Schedule();
            schedule.setId(rs.getInt("id"));
            schedule.setTitle(rs.getString("title"));
            schedule.setWriter(rs.getString("writer"));
            schedule.setDate(rs.getString("date"));
            schedule.setPassword(rs.getString("password"));
            return schedule;
        });
    }

    // 일정 수정
    public void update(Schedule schedule) {
        String sql = "UPDATE schedules SET title = ?, writer = ?, date = ? WHERE id = ? AND password = ?";
        jdbcTemplate.update(sql, schedule.getTitle(), schedule.getWriter(), schedule.getDate(), schedule.getId(), schedule.getPassword());
    }

    // 일정 삭제
    public void delete(int id, String password) {
        String sql = "DELETE FROM schedules WHERE id = ? AND password = ?";
        jdbcTemplate.update(sql, id, password);
    }
}
