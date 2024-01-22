package com.example.schedulemanagement.schedule.dto;

import java.sql.Date;
import lombok.Data;

@Data
public class ScheduleRequestDto {
    private String title;
    private String content;
    private String author;
    private String password;
    private Date dateCreated;
}
