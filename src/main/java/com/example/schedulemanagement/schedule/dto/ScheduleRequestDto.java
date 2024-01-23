package com.example.schedulemanagement.schedule.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.sql.Date;
import lombok.Data;

@Data
@NotNull
public class ScheduleRequestDto {

    @Size(max = 32)
    private String title;

    @Size(max = 1024)
    private String content;

    @Size(max = 8)
    private String author;

    @Size(max = 32)
    private String password;

    private Date dateCreated;
}
