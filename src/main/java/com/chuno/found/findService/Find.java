package com.chuno.found.findService;


import com.chuno.found.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Find extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private int quantity;
    private String findUserId;
    private String findLocation;
    private String category;
    private Date findTime;

    @Builder
    public Find(String name, int quantity, String findUserId, String findLocation,
                  String category, Date findTime){
        this.name = name;
        this.quantity = quantity;
        this.findUserId = findUserId;
        this.findLocation = findLocation;
        this.category = category;
        this.findTime = findTime;
    }

    public Find toEntity() {
        return Find.builder()
                .name(name)
                .quantity(quantity)
                .findUserId(findUserId)
                .findLocation(findLocation)
                .category(category)
                .findTime(findTime)
                .build();
    }


}
