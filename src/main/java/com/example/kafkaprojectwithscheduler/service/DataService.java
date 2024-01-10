package com.example.kafkaprojectwithscheduler.service;



import com.example.kafkaprojectwithscheduler.model.DataModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class DataService {

    @Value("${api.url}") // You can define your API URL in application.properties
    private String apiUrl;

    public DataModel getDataModelFromAPI() {
        // Implement logic to fetch data from CRUD API

        // Example: Using RestTemplate to make a GET request to the API
        RestTemplate restTemplate = new RestTemplate();
        DataModel dataModel = restTemplate.getForObject(apiUrl, DataModel.class);

        if (dataModel == null) {
            // Handle the case when the API response is null
            throw new RuntimeException("Failed to fetch data from API");
        }

        return dataModel;
    }
}
