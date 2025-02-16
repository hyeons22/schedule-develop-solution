package com.example.scheduledevelopsolution.schedule.repository;

import com.example.scheduledevelopsolution.schedule.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
}
