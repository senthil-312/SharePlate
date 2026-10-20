
package com.shareplate.shareplate.client;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class FoodServiceClient {

    private final RestClient restClient;

    public FoodServiceClient() {
        this.restClient = RestClient.create("http://localhost:8081");
    }

    public String getFoodServiceMessage() {
        return restClient.get()
                .uri("/api/message")
                .retrieve()
                .body(String.class);
    }
}
