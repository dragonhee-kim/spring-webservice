package com.chuno.found.kafka.consumer;

import com.chuno.found.alarmService.AlarmService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;

import java.util.Map;

public class Receiver {

    private static final Logger LOGGER = LoggerFactory.getLogger(Receiver.class);

    @Autowired
    AlarmService alarmService;

    @KafkaListener(topics="msa_test_20200224")
    public  void receive(ConsumerRecord consumerRecord) throws JsonProcessingException {

        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, String> payload = objectMapper.readValue(consumerRecord.value().toString(),Map.class);

        LOGGER.info("kafkaListener - payload " + payload.toString());
        System.out.println("kafkaListener - payload" + payload.toString());
        String service = payload.get("service").toString();
        String key = payload.get("key").toString();

        // 습득물 서비스가 보냄
        if(service.equals("FindService")){


            LOGGER.info("Receiver in FindService -  " );
            System.out.println("Receiver in FindService ");

            //물품을 습득했을때
            if(key.equals("find")){
                String category = payload.get("category").toString();

                LOGGER.info("go to alarm " );


                alarmService.getLostItemInfo(category);
            }

        }

    }
}
