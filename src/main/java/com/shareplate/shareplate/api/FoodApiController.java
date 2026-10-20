
package com.shareplate.shareplate.api;

import com.shareplate.shareplate.client.FoodServiceClient;
import com.shareplate.shareplate.entity.FoodListing;
import com.shareplate.shareplate.service.FoodListingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/foods")
public class FoodApiController {

    private final FoodListingService service;
    private final FoodServiceClient foodServiceClient;

    // One constructor for both dependencies
    public FoodApiController(
            FoodListingService service,
            FoodServiceClient foodServiceClient) {
        this.service = service;
        this.foodServiceClient = foodServiceClient;
    }

    @GetMapping
    public List<FoodListing> getAllFoods() {
        return service.getAllFood();
    }

    @GetMapping("/status/{status}")
    public List<FoodListing> getFoodByStatus(
            @PathVariable String status) {
        return service.getFoodByStatus(status);
    }

    @GetMapping("/location/{location}")
    public List<FoodListing> getFoodByLocation(
            @PathVariable String location) {
        return service.getFoodByLocation(location);
    }

    @PostMapping
    public FoodListing addFood(@RequestBody FoodListing food) {
        return service.addFood(food);
    }

    // Communicate with the second Spring Boot application
    @GetMapping("/foodservice-message")
    public String getFoodServiceMessage() {
        return foodServiceClient.getFoodServiceMessage();
    }
}
