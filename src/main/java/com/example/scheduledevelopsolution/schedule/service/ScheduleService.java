package com.example.scheduledevelopsolution.schedule.service;

import com.example.scheduledevelopsolution.schedule.dto.request.ScheduleSaveRequestDto;
import com.example.scheduledevelopsolution.schedule.dto.response.ScheduleSaveResponseDto;
import com.example.scheduledevelopsolution.schedule.entity.Schedule;
import com.example.scheduledevelopsolution.schedule.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    @Transactional
    public ScheduleSaveResponseDto save(ScheduleSaveRequestDto requestDto) {
        new Schedule(requestDto)
    }
}
