package com.example.kafkaprojectwithscheduler.controller;

import com.example.kafkaprojectwithscheduler.model.DataModel;
import com.example.kafkaprojectwithscheduler.service.DataService;
import com.example.kafkaprojectwithscheduler.service.KafkaProducerService;
import  org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/data")
public class DataController {

    @Autowired
    private DataService dataService;

    @Autowired
    private KafkaProducerService kafkaProducerService;

    @GetMapping("/publish")
    public String publishDataToKafka() {
        DataModel dataModel = dataService.getDataModelFromAPI();
        kafkaProducerService.sendMessage(dataModel);
        return "DataModel published to Kafka";
    }
}
