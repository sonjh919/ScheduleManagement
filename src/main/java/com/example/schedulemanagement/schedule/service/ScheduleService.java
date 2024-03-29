package com.example.schedulemanagement.schedule.service;

import com.example.schedulemanagement.exception.BadCredentialsException;
import com.example.schedulemanagement.schedule.dto.ScheduleRequestDto;
import com.example.schedulemanagement.schedule.dto.ScheduleResponseDto;
import com.example.schedulemanagement.schedule.entity.Schedule;
import com.example.schedulemanagement.schedule.repository.ScheduleRepository;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    public ScheduleService(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    @Transactional
    public ScheduleResponseDto createSchedule(ScheduleRequestDto scheduleRequestDto) {
        Schedule schedule = new Schedule(scheduleRequestDto);
        Schedule saveSchedule = scheduleRepository.save(schedule);

        return new ScheduleResponseDto(saveSchedule);
    }

    public List<ScheduleResponseDto> getSchedules() {
        return scheduleRepository.findAllByOrderByDateCreatedDesc().stream()
            .map(ScheduleResponseDto::new).toList();
    }

    public ScheduleResponseDto getScheduleById(Long id) {
        Schedule schedule = findSchedule(id);
        return new ScheduleResponseDto(schedule);
    }

    @Transactional
    public ScheduleResponseDto updateScheduleById(Long id, ScheduleRequestDto scheduleRequestDto) {
        Schedule schedule = findSchedule(id);
        validatePassword(schedule, scheduleRequestDto);

        schedule.update(scheduleRequestDto);

        return new ScheduleResponseDto(schedule);
    }

    @Transactional
    public void deleteSchedule(Long id, ScheduleRequestDto scheduleRequestDto) {
        Schedule schedule = findSchedule(id);
        validatePassword(schedule, scheduleRequestDto);

        scheduleRepository.delete(schedule);
    }

    private Schedule findSchedule(Long id) {
        return scheduleRepository.findById(id).orElseThrow(() ->
            new EntityNotFoundException("[ERROR] 선택한 일정은 존재하지 않습니다.")
        );
    }

    private void validatePassword(Schedule schedule, ScheduleRequestDto scheduleRequestDto) {
        if (!schedule.getPassword().equals(scheduleRequestDto.getPassword())) {
            throw new BadCredentialsException("[ERROR] 비밀번호가 다릅니다.");
        }
    }
}
