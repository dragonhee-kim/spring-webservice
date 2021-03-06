package com.chuno.found.kafka.producer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;

import java.util.Map;

public class Sender {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(Sender.class);


    @Autowired
    private KafkaTemplate <String, String> kafkaTemplate;

    public void send(String topic, Map<String, Object> payload) throws JsonProcessingException {
        LOGGER.info("sending payload='{}'",payload.toString());

        ObjectMapper objectMapper = new ObjectMapper();

        //ProducerRecord 이건 뭐지?
        LOGGER.info("test1");
        ProducerRecord<String,String> producerRecord = new ProducerRecord<>(topic,objectMapper.writeValueAsString(payload));
        LOGGER.info("test2");
            kafkaTemplate.send(producerRecord);

        kafkaTemplate.flush();

        LOGGER.info("test3");
    }

}
