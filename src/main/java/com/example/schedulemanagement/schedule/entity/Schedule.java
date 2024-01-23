package com.example.schedulemanagement.schedule.entity;


import com.example.schedulemanagement.schedule.dto.ScheduleRequestDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.sql.Date;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "TB_SCHEDULE")
@NoArgsConstructor
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long scheduleId;

    @Column(name = "TITLE", length = 500)
    private String title;

    @Column(name = "CONTENT", length = 1024)
    private String content;

    @Column(name = "AUTHOR", length = 8)
    private String author;

    @Column(name = "PASSWORD", length = 32)
    private String password;

    @Column(name = "DATE_CREATED")
    private Date dateCreated;

    public Schedule(ScheduleRequestDto scheduleRequestDto) {
        this.title = scheduleRequestDto.getTitle();
        this.content = scheduleRequestDto.getContent();
        this.author = scheduleRequestDto.getAuthor();
        this.password = scheduleRequestDto.getPassword();
        this.dateCreated = scheduleRequestDto.getDateCreated();
    }

    public void update(ScheduleRequestDto scheduleRequestDto) {
        this.title = scheduleRequestDto.getTitle();
        this.content = scheduleRequestDto.getContent();
        this.author = scheduleRequestDto.getAuthor();
    }
}
