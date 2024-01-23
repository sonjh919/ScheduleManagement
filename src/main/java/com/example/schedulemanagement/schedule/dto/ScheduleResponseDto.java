package com.example.schedulemanagement.schedule.dto;

import com.example.schedulemanagement.schedule.entity.Schedule;
import java.sql.Date;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ScheduleResponseDto {

    private Long scheduleId;
    private String title;
    private String content;
    private String author;
    private String password;
    private Date dateCreated;

    public ScheduleResponseDto(Schedule schedule) {
        this.scheduleId = schedule.getScheduleId();
        this.title = schedule.getTitle();
        this.content = schedule.getContent();
        this.author = schedule.getAuthor();
        this.password = schedule.getPassword();
        this.dateCreated = schedule.getDateCreated();
    }
}
