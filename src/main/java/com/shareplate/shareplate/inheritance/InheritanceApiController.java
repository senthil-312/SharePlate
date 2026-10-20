
package com.shareplate.shareplate.inheritance;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/food-records")
public class InheritanceApiController {

    private final FoodRecordRepository repository;

    public InheritanceApiController(FoodRecordRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<FoodRecord> getAllRecords() {
        return repository.findAll();
    }

    @PostMapping("/donated")
    public DonatedFood addDonatedFood(
            @RequestBody DonatedFood food) {
        return repository.save(food);
    }

    @PostMapping("/sponsored")
    public SponsoredFood addSponsoredFood(
            @RequestBody SponsoredFood food) {
        return repository.save(food);
    }
}
