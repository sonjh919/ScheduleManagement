package com.example.schedulemanagement.schedule.repository;

import com.example.schedulemanagement.schedule.entity.Schedule;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

    List<Schedule> findAllByOrderByDateCreatedDesc();
}
