package com.example.cardmaximizer.strategy;

import com.example.cardmaximizer.model.*;
import org.springframework.stereotype.Component;

@Component
public class PCMastercardStrategy implements RewardStrategy {
    @Override
    public double calculateReward(Purchase purchase) {
        // High return at Loblaws-owned stores
        if (purchase.getCategory() == Category.GROCERY_LOBLAWS) return 0.03;

        if(purchase.getCategory() == Category.SHOPPERS_DRUG_MART)return 0.045;

        // Esso/Mobil: Usually 30 pts per litre, roughly 3% value
        if (purchase.getCategory() == Category.GAS_ESSO) return 0.03;

        if (purchase.isInternational()) {
            return 0.0; // This represents the 2.5% saved on FX fees
        }

        return 0.01; // Base 10 pts per $1 (1% value)
    }

    @Override
    public String getCardName() { return "PC Financial Mastercard"; }

    @Override
    public String getReason(Purchase purchase) {
        if (purchase.getCategory() == Category.GROCERY_LOBLAWS) return "Max PC Optimum point yield";
        return "Standard PC points earn";
    }
}