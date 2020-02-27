package com.chuno.found.lostService;

import com.chuno.found.findService.Find;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Lost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private int quantity;
    private String lostUserId;
    private String lostLocation;
    private String category;
    private Date lostTime;

    @Builder
    public Lost (String name, int quantity, String lostUserId, String lostLocation,
                String category, Date lostTime){
        this.name = name;
        this.quantity = quantity;
        this.lostUserId = lostUserId;
        this.lostLocation = lostLocation;
        this.category = category;
        this.lostTime = lostTime;
    }

    public Lost toEntity() {
        return Lost.builder()
                .name(name)
                .quantity(quantity)
                .lostUserId(lostUserId)
                .lostLocation(lostLocation)
                .category(category)
                .lostTime(lostTime)
                .build();
    }

}
