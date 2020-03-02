package com.chuno.found.findService;

import com.chuno.found.kafka.producer.Sender;
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
public class FindService {
    private static final Logger LOGGER = LoggerFactory.getLogger(FindService.class);

    @Autowired
    Sender sender;

    @Autowired
    private FindRepository findRepository;


    /*
    * 습득물 조회 API
    * @request : id
    *
    * @return : 습득물
    * */
    public List<Find> selectFindItem(String category){
        return findRepository.findByCategory(category);
    }


    /*
    * 습득물 리스트 조회 API
    * @request : category
    *
    *  @return : 습득물 리스트
    * */
    public List<Find> selectFindListByCaetgory(String category){
        return findRepository.findByCategory(category);
    }

    /*
     * 습득물 리스트 조회 API
     *
     *  @return : 습득물 리스트
     * */
    public List<Find> selectFindAllList(){
        return findRepository.findAll();
    }

    public void insertFind(Find find){
        // 우선 습득물 db저장
        findRepository.save(find.toEntity());
        List<Find> finds = findRepository.findAll();
        Find f1 = finds.get(0);

                //       LOGGER.info("createdAt : "+find.);
        String category = find.getCategory();
        String topic = "msa_test_20200224";
        Map<String, Object> payload = new HashMap<>();
        payload.put("service","FindService");
        payload.put("key","find");
        payload.put("category",category);

        try{
            System.out.println("try");
            sender.send(topic,payload);

        } catch (JsonProcessingException e) {

            System.out.println("catch");
            e.printStackTrace();
        }


    }



}
