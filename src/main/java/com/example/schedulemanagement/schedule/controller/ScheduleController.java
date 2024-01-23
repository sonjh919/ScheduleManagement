package com.example.schedulemanagement.schedule.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import com.example.schedulemanagement.schedule.dto.ScheduleRequestDto;
import com.example.schedulemanagement.schedule.dto.ScheduleResponseDto;
import com.example.schedulemanagement.schedule.service.ScheduleService;
import jakarta.validation.Valid;
import java.net.URI;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
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
    public ResponseEntity<ScheduleResponseDto> createSchedule(
        @RequestBody @Valid ScheduleRequestDto scheduleRequestDto) {
        System.out.println(scheduleRequestDto.getAuthor().length());

        ScheduleResponseDto scheduleResponseDto = scheduleService.createSchedule(
            scheduleRequestDto);
        URI createdUri = linkTo(
            methodOn(ScheduleController.class).createSchedule(scheduleRequestDto)).slash(
            scheduleResponseDto.getScheduleId()).toUri();

        return ResponseEntity.created(createdUri).body(scheduleResponseDto);
    }

    @GetMapping()
    public ResponseEntity<List<ScheduleResponseDto>> getSchedules() {
        return ResponseEntity.ok().body(scheduleService.getSchedules());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ScheduleResponseDto> getScheduleById(@PathVariable Long id) {
        return ResponseEntity.ok().body(scheduleService.getScheduleById(id));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ScheduleResponseDto> updateScheduleById(@PathVariable Long id,
        @RequestBody @Valid ScheduleRequestDto scheduleRequestDto) {
        ScheduleResponseDto scheduleResponseDto = scheduleService.updateScheduleById(id,
            scheduleRequestDto);
        URI createdUri = linkTo(
            methodOn(ScheduleController.class).updateScheduleById(id, scheduleRequestDto)).slash(
            scheduleResponseDto.getScheduleId()).toUri();

        return ResponseEntity.created(createdUri).body(scheduleResponseDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ScheduleResponseDto> deleteSchedule(@PathVariable Long id,
        @RequestBody @Valid ScheduleRequestDto scheduleRequestDto) {
        scheduleService.deleteSchedule(id, scheduleRequestDto);
        return ResponseEntity.noContent().build();
    }

}
