
package com.shareplate.shareplate.inheritance;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "sponsored_food")
public class SponsoredFood extends FoodRecord {

    private String sponsorName;

    public SponsoredFood() {
    }

    public String getSponsorName() {
        return sponsorName;
    }

    public void setSponsorName(String sponsorName) {
        this.sponsorName = sponsorName;
    }
}
