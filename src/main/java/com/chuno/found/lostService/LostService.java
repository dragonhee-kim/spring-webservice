package com.chuno.found.lostService;


import com.chuno.found.findService.Find;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class LostService {
    private static final Logger LOGGER = LoggerFactory.getLogger(LostService.class);



    @Autowired
    private LostRepository lostRepository;

    /*
     * 습득물 조회 API
     * @request : id
     *
     * @return : 습득물
     * */
    public Optional<Lost> selectLostItem(long id){

        return lostRepository.findById(id);
    }


    /*
     * 습득물 리스트 조회 API
     * @request : category
     *
     *  @return : 습득물 리스트
     * */
    public List<Lost> selectLostListByCaetgory(String category){
        return lostRepository.findByCategory(category);
    }

    /*
     * 습득물 리스트 조회 API
     *
     *  @return : 습득물 리스트
     * */
    public List<Lost> selectLostAllList(){
        return lostRepository.findAll();
    }

    public void insertLost(Lost lost){
        // 우선 습득물 db저장
        lostRepository.save(lost.toEntity());
    }


}
