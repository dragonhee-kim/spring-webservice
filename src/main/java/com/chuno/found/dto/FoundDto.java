package com.chuno.found.dto;

import com.chuno.found.dao.Found;
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
    private long foundId;

    private String foundTitle;
    private String foundContent;
    private String foundPhoto;
    private String memId;
    private String categoryName;


    public Found toEntity(){
        return Found.builder()

                .memId(memId)
                .foundTitle(foundTitle)
                .foundContent(foundContent)
                .foundPhoto(foundPhoto)
                .categoryName(categoryName)

                .build();
    }
}
