
package com.shareplate.shareplate.repository;

import com.shareplate.shareplate.entity.FoodListing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FoodListingRepository
        extends JpaRepository<FoodListing, Long> {

    // HQL Query 1: Find food by status
    @Query("SELECT f FROM FoodListing f WHERE f.status = :status")
    List<FoodListing> findFoodByStatus(
            @Param("status") String status);

    // HQL Query 2: Find food by pickup location
    @Query("SELECT f FROM FoodListing f WHERE f.location = :location")
    List<FoodListing> findFoodByLocation(
            @Param("location") String location);
}
