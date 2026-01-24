package com.example.cardmaximizer.strategy;
import com.example.cardmaximizer.model.*;
import org.springframework.stereotype.Component;

@Component
public class TDFirstClassStrategy implements RewardStrategy {
    @Override
    public double calculateReward(Purchase purchase) {
        // Expedia for TD: 8 points per $1 (approx 4% value)
        if (purchase.getCategory() == Category.TRAVEL_EXPEDIA) return 0.04;

        // Grocery/Dining/Recurring: 6 points per $1 (approx 3% value)
        if (purchase.getCategory() == Category.DINING ||
        purchase.getCategory() == Category.GROCERY) return 0.03;

        // Digital Media/Gaming often codes as Recurring or 4x points
        if (purchase.getCategory() == Category.GAMING_DIGITAL
                || purchase.getCategory() == Category.RECURRING_BILL) return 0.02;
        if(purchase.getCategory() == Category.PUBLIC_TRANSIT){
            return 0.03;
        }

        if (purchase.isInternational()) {
            return 0.0; // This represents the 2.5% saved on FX fees
        }
        return 0.01; // Base 2 points per $1 (1% value)
    }
    @Override
    public String getCardName() { return "TD First Class Infinite"; }

    public String getReason(Purchase purchase) { return "High TD Reward points multiplier"; }
}