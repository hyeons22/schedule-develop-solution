package com.example.scheduledevelopsolution.schedule.service;

import com.example.scheduledevelopsolution.schedule.dto.request.ScheduleSaveRequestDto;
import com.example.scheduledevelopsolution.schedule.dto.request.ScheduleUpdateRequestDto;
import com.example.scheduledevelopsolution.schedule.dto.response.ScheduleResponseDto;
import com.example.scheduledevelopsolution.schedule.dto.response.ScheduleSaveResponseDto;
import com.example.scheduledevelopsolution.schedule.dto.response.ScheduleUpdateResponseDto;
import com.example.scheduledevelopsolution.schedule.entity.Schedule;
import com.example.scheduledevelopsolution.schedule.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.event.TransactionalEventListener;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    @Transactional
    public ScheduleSaveResponseDto save(ScheduleSaveRequestDto requestDto) {
        Schedule schedule = new Schedule(
                requestDto.getUserName(),
                requestDto.getTitle(),
                requestDto.getContent()
        );
        // builder를 쓰면 생성자의 파라미터 순서가 바꿔도 상관없음
        // 사용시 해당 Entity 생성자위에 @Builder 추가
        // builder 사용 이유 : 실수 방지
//        Schedule.builder()
//                .userName(requestDto.getUserName())
//                .title(requestDto.getTitle())
//                .content(requestDto.getContent())
//                .build();
        Schedule savedSchedule = scheduleRepository.save(schedule);
        return new ScheduleSaveResponseDto(
                savedSchedule.getId(),
                savedSchedule.getUserName(),
                savedSchedule.getTitle(),
                savedSchedule.getContent(),
                savedSchedule.getCreatedAt(),
                savedSchedule.getModifiedAt()
        );
    }

    @Transactional(readOnly = true)
    public List<ScheduleResponseDto> findAll() {
        List<Schedule> schedules = scheduleRepository.findAll();
        List<ScheduleResponseDto> dtoList = new ArrayList<>();

        for (Schedule schedule : schedules) {
            ScheduleResponseDto dto = new ScheduleResponseDto(
                    schedule.getId(),
                    schedule.getUserName(),
                    schedule.getTitle(),
                    schedule.getContent(),
                    schedule.getCreatedAt(),
                    schedule.getModifiedAt()
            );
            dtoList.add(dto);
        }
        return dtoList;
    }

    @Transactional(readOnly = true)
    public ScheduleResponseDto findById(Long scheduleId) {
        Schedule schedule = scheduleRepository.findById(scheduleId).orElseThrow(
                () -> new IllegalArgumentException("id에 맞는 일정이 없습니다.")
        );
        return new ScheduleResponseDto(
                schedule.getId(),
                schedule.getUserName(),
                schedule.getTitle(),
                schedule.getContent(),
                schedule.getCreatedAt(),
                schedule.getModifiedAt()
        );
    }

    @Transactional
    public ScheduleUpdateResponseDto update(Long scheduleId, ScheduleUpdateRequestDto requestDto) {
        Schedule schedule = scheduleRepository.findById(scheduleId).orElseThrow(
                () -> new IllegalArgumentException("id에 맞는 일정이 없습니다.")
        );
        schedule.update(
                requestDto.getUserName(),
                requestDto.getTitle(),
                requestDto.getContent()
        );

        // 명시적으로 save 해도 됩니다.
//        scheduleRepository.save(schedule); // 영속성 컨텍스트에 의해서 이 save()가 없어도 작동함
        //하지만 @Transactional이 없을 경우 영속성컨테스트가 존재를 안하므로 버그!

        return new ScheduleUpdateResponseDto(
                schedule.getId(),
                schedule.getUserName(),
                schedule.getTitle(),
                schedule.getContent(),
                schedule.getCreatedAt(),
                schedule.getModifiedAt()
        );
    }


}
