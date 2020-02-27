package com.chuno.found.alarmService;

import com.chuno.found.kafka.producer.Sender;
import com.chuno.found.lostService.Lost;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;





import java.net.URI;
import java.util.*;

@Service
public class AlarmService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AlarmService.class);

    @Autowired
    Sender sender;

    // LostService 에 Rest API 조회를 통해 해당 카테고리의 분실물자 정보 조회
    public void getLostItemInfo(String category){
        LOGGER.info("1111111111111111111111");
        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
        factory.setConnectTimeout(5000);
        factory.setReadTimeout(5000);

        HttpClient httpClient = HttpClientBuilder.create()
                .setMaxConnPerRoute(5)
                .setMaxConnTotal(100)
                .build();
        factory.setHttpClient(httpClient);
        LOGGER.info("222222222222222222222");
        String lostServiceUrl = "http://49.50.167.142:8080/lost/item/list";
        URI uri = URI.create(lostServiceUrl);

        RestTemplate restTemplate = new RestTemplate(factory);
        LOGGER.info("3333333333333333333333 category :" + category);
        Map<String, Object> param = new HashMap<>();
        param.put("category", category);

        Lost[] losts = restTemplate.postForObject(uri,param,Lost[].class);
        LOGGER.info("44444444444444444444444444");
        List<Lost> lostList = new LinkedList<>();
        if(losts != null && losts.length>0){
            lostList = Arrays.asList(losts);
        }
        LOGGER.info("55555555555555555555555555555");
        String topic = "msa_test_20200224";
        Map<String, Object> payload = new HashMap<>();
        payload.put("service","AlarmService");
        payload.put("key","alarm");
        LOGGER.info("666666666666666666 "+lostList.size());

        if(lostList.size() > 0){
            StringBuilder lost_user_id = new StringBuilder();
            for(Lost lost : lostList) {
                LOGGER.info("물건을 잃어 버린 사람의 ID: " + lost.getLostUserId());

                lost_user_id.append(lost.getLostUserId()).append(",");
            }
            payload.put("lost_user_id", lost_user_id);
        }
        else{
            LOGGER.info("물건이 잃어 버린 사람이 없습니다.");

        }

        try{
            LOGGER.info("alarm에서 kafka로 send, topic : " +topic);

            sender.send(topic,payload);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }


    }
}
