package com.chuno.found.dao;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyTest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long testId;

    private String testName;

    @ManyToOne
    private Found found;

    @Builder
    public MyTest(String testName, Found found){
        this.testName = testName;
        this.found = found;
    }


}
