package com.example.scheduledevelopsolution.schedule.entity;

import com.example.scheduledevelopsolution.common.entity.DateBaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Entity
@NoArgsConstructor


public class Schedule extends DateBaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userName;
    private String title;
    private String content;

    //@Builder
    public Schedule(String userName, String title, String content) {
        this.userName = userName;
        this.title = title;
        this.content = content;
    }

    public void update(String userName, String title, String content) {
        this.userName = userName;
        this.title = title;
        this.content = content;
    }
}
