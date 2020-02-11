package com.chuno.found;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
public class FoundDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long found_id;

    private String found_name;
    private String found_content;
    private String found_photo;
    private String mem_id;

    public Found toEntity(){
        return Found.builder()

                .mem_id(mem_id)
                .found_name(found_name)
                .found_content(found_content)
                .found_photo(found_photo)

                .build();
    }
}
