package com.example.kafkaprojectwithscheduler.service;


import com.example.kafkaprojectwithscheduler.model.DataModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {

    private static final String TOPIC = "your_kafka_topic";

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    public void sendMessage(DataModel dataModel) {
        kafkaTemplate.send(TOPIC, dataModel);
    }
}
