package com.example.scheduledevelopsolution.schedule.controller;

import com.example.scheduledevelopsolution.schedule.dto.request.ScheduleSaveRequestDto;
import com.example.scheduledevelopsolution.schedule.dto.request.ScheduleUpdateRequestDto;
import com.example.scheduledevelopsolution.schedule.dto.response.ScheduleResponseDto;
import com.example.scheduledevelopsolution.schedule.dto.response.ScheduleSaveResponseDto;
import com.example.scheduledevelopsolution.schedule.dto.response.ScheduleUpdateResponseDto;
import com.example.scheduledevelopsolution.schedule.service.ScheduleService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ScheduleController {

    private final ScheduleService scheduleService;

    @PostMapping("/schedules")
    public ResponseEntity<ScheduleSaveResponseDto> save(@RequestBody ScheduleSaveRequestDto requestDto){
        return ResponseEntity.ok(scheduleService.save(requestDto));
    }

    @GetMapping("/schedules")
    public ResponseEntity<List<ScheduleResponseDto>> findAll(){
        return ResponseEntity.ok(scheduleService.findAll());
    }

    @GetMapping("/schedules/{scheduleId}")
    public ResponseEntity<ScheduleResponseDto> findById(@PathVariable Long scheduleId){
        return ResponseEntity.ok(scheduleService.findById(scheduleId));
    }

    @PutMapping("/schedules/{scheduleId}")
    public ResponseEntity<ScheduleUpdateResponseDto> update(
            @PathVariable Long scheduleId,
            @RequestBody ScheduleUpdateRequestDto requestDto
            ){
        return ResponseEntity.ok(scheduleService.update(scheduleId,requestDto));
    }

    @DeleteMapping("/schedules/{scheduleId}")
    public void deleteById(@PathVariable Long scheduleId){
        scheduleService.deleteById(scheduleId);
    }
}
