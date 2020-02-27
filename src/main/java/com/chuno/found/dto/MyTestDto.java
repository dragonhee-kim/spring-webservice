package com.chuno.found.dto;

import com.chuno.found.dao.Found;
import com.chuno.found.dao.MyTest;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Optional;

@Getter
@Setter
@NoArgsConstructor
public class MyTestDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long testId;

    private String testName;


    @ManyToOne
    private Found found;

    public MyTest toEntity(){
        return MyTest.builder()

                .testName(testName)
                .found(found)
                .build();
    }


}
