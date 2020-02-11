package com.chuno.found;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Found {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long found_id;

    private String found_name;
    private String found_content;
    private String found_photo;
    private String mem_id;

    @Builder
    public Found(String mem_id, String found_name, String found_content, String found_photo){
        this.mem_id = mem_id;
        this.found_name = found_name;
        this.found_content = found_content;
        this.found_photo = found_photo;


    }

}
