package com.example.kafkaprojectwithscheduler.scheduler;

import com.example.kafkaprojectwithscheduler.model.DataModel;
import com.example.kafkaprojectwithscheduler.service.DataService;
import com.example.kafkaprojectwithscheduler.service.KafkaProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class DataScheduler {

    @Autowired
    private DataService dataService;

    @Autowired
    private KafkaProducerService kafkaProducerService;

    @Scheduled(fixedRate = 300000) // Run every 5 minutes
    public void fetchDataAndPublishToKafka() {
        DataModel dataModel = dataService.getDataModelFromAPI();
        kafkaProducerService.sendMessage(dataModel);
    }
}
