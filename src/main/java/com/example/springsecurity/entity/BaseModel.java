package com.example.springsecurity.entity;


import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseModel {

    @Column(nullable = false,updatable = false, columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP ")
    @CreatedDate
    private LocalDateTime createdAt;


    @Column(nullable = false, columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP")
    @LastModifiedDate
    private LocalDateTime updatedAt;

}
