package com.example.schedulemanagement.schedule.service;

import com.example.schedulemanagement.schedule.dto.ScheduleResponseDto;
import com.example.schedulemanagement.schedule.dto.ScheduleRequestDto;
import com.example.schedulemanagement.schedule.entity.Schedule;
import com.example.schedulemanagement.schedule.repository.ScheduleRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ScheduleService {
    private final ScheduleRepository scheduleRepository;

    public ScheduleService(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    public ScheduleResponseDto createSchedule(ScheduleRequestDto scheduleRequestDto) {
        Schedule schedule = new Schedule(scheduleRequestDto);
        Schedule saveSchedule = scheduleRepository.save(schedule);

        return new ScheduleResponseDto(saveSchedule);
    }

    public List<ScheduleResponseDto> getSchedules() {
        return scheduleRepository.findAllByOrderByDateCreatedDesc().stream().map(ScheduleResponseDto::new).toList();
    }

    public ScheduleResponseDto getScheduleById(Long id) {
        Schedule schedule = scheduleRepository.findByScheduleId(id);
        return new ScheduleResponseDto(schedule);
    }

    @Transactional
    public ScheduleResponseDto updateScheduleById(Long id, ScheduleRequestDto scheduleRequestDto) {
        Schedule schedule = scheduleRepository.findByScheduleId(id);
        schedule.update(scheduleRequestDto);

        return new ScheduleResponseDto(schedule);
    }
}
