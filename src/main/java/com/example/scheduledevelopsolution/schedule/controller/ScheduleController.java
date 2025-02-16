package com.example.scheduledevelopsolution.schedule.controller;

import com.example.scheduledevelopsolution.schedule.dto.request.ScheduleSaveRequestDto;
import com.example.scheduledevelopsolution.schedule.dto.response.ScheduleSaveResponseDto;
import com.example.scheduledevelopsolution.schedule.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ScheduleController {

    private final ScheduleService scheduleService;

    @PostMapping("/schedules")
    public ResponseEntity<ScheduleSaveResponseDto> save(@RequestBody ScheduleSaveRequestDto requestDto){
        return ResponseEntity.ok(scheduleService.save(requestDto));
    }
}
