
package com.shareplate.shareplate.inheritance;

import jakarta.persistence.*;

@Entity
@Table(name = "food_records")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class FoodRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String foodName;
    private int quantity;

    public FoodRecord() {
    }

    public FoodRecord(String foodName, int quantity) {
        this.foodName = foodName;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
