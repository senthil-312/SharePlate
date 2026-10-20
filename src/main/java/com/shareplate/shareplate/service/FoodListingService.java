
package com.shareplate.shareplate.service;

import com.shareplate.shareplate.entity.FoodListing;
import com.shareplate.shareplate.repository.FoodListingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodListingService {

    private final FoodListingRepository repository;

    public FoodListingService(FoodListingRepository repository) {
        this.repository = repository;
    }

    public FoodListing addFood(FoodListing food) {
        return repository.save(food);
    }

    public List<FoodListing> getAllFood() {
        return repository.findAll();
    }

    public FoodListing getFoodById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void deleteFood(Long id) {
        repository.deleteById(id);
    }

    public boolean claimFood(Long id, String studentName) {
    FoodListing food = repository.findById(id).orElse(null);

    if (food == null || !"AVAILABLE".equals(food.getStatus())) {
        return false;
    }

    food.setClaimedBy(studentName);
    food.setStatus("CLAIMED");

    repository.save(food);
    return true;
}

    public List<FoodListing> getFoodByStatus(String status) {
        return repository.findFoodByStatus(status);
    }

    public List<FoodListing> getFoodByLocation(String location) {
        return repository.findFoodByLocation(location);
    }

}