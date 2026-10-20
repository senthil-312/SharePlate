
package com.shareplate.shareplate.controller;

import com.shareplate.shareplate.entity.FoodListing;
import com.shareplate.shareplate.service.FoodListingService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class FoodListingController {

    private final FoodListingService service;

    public FoodListingController(FoodListingService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("foods", service.getAllFood());
        return "index";
    }

    @PostMapping("/add")
    public String addFood(@ModelAttribute FoodListing food) {
        service.addFood(food);
        return "redirect:/";
    }

    @PostMapping("/delete/{id}")
    public String deleteFood(@PathVariable Long id) {
        service.deleteFood(id);
        return "redirect:/";
    }

    @PostMapping("/claim/{id}")
    public String claimFood(
            @PathVariable Long id,
            @RequestParam String studentName) {

        service.claimFood(id, studentName);
        return "redirect:/";
    }

}
