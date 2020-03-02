package com.chuno.found.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;


@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseTimeEntity{

    @CreatedDate
    private LocalDateTime createdAt; // db의 column 명은 create_at

    @LastModifiedDate
    private LocalDateTime updatedAt; // db의 column 명은 update_at이다

}
