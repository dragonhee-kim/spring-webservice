package com.chuno.found.dao;

import com.chuno.found.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@Entity
//@NamedQuery(name="Found.myTest", query = "SELECT * FROM found as f WHERE f.found_id = ?") //쿼리 만들수 있다.
//@Entity("found") -> found와 매핑인가?
public class Found extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long foundId;
    //camel로 사용하면 _ 를 붙인것과 똑같은 효과
    private String foundTitle;
    private String foundContent;
    private String foundPhoto;
    private String memId;
    private String categoryName;

    @Builder
    public Found(String memId, String foundTitle, String foundContent, String foundPhoto, String categoryName){
        this.memId = memId;
        this.foundTitle = foundTitle;
        this.foundContent = foundContent;
        this.foundPhoto = foundPhoto;
        this.categoryName = categoryName;

    }



}
