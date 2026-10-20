
package com.shareplate.shareplate.inheritance;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "donated_food")
public class DonatedFood extends FoodRecord {

    private String donorName;

    public DonatedFood() {
    }

    public String getDonorName() {
        return donorName;
    }

    public void setDonorName(String donorName) {
        this.donorName = donorName;
    }
}
