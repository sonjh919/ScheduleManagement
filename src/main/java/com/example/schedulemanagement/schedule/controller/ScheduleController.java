package com.example.schedulemanagement.schedule.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import com.example.schedulemanagement.schedule.dto.ScheduleRequestDto;
import com.example.schedulemanagement.schedule.dto.ScheduleResponseDto;
import com.example.schedulemanagement.schedule.service.ScheduleService;
import java.net.URI;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/schedules")
public class ScheduleController {
    private final ScheduleService scheduleService;

    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @PostMapping()
    public ResponseEntity<ScheduleResponseDto> createSchedule(@RequestBody ScheduleRequestDto scheduleRequestDto){

        ScheduleResponseDto scheduleResponseDto = scheduleService.createSchedule(scheduleRequestDto);
        URI createdUri = linkTo(methodOn(ScheduleController.class).createSchedule(scheduleRequestDto)).slash(scheduleResponseDto.getScheduleId()).toUri();

        return ResponseEntity.created(createdUri).body(scheduleResponseDto);
    }

    @GetMapping()
    public ResponseEntity<List<ScheduleResponseDto>> getSchedules() {
        return ResponseEntity.ok().body(scheduleService.getSchedules());
    }

}
