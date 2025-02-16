package com.example.scheduledevelopsolution.common.entity;

import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class DateBaseEntity {

    @CreatedDate
    @Column(updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime modifiedAt;
}

// JDBC에서는 작성일과 수정일을 DB에서 만들어주기 때문에 두번 쿼리 했어야 했음
// JPA에서는 애플리케이션에서 만들어주기 때문에 그래서 쿼리를 안해도 알 수 있음


