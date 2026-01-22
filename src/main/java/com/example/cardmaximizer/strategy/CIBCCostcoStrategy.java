package com.example.cardmaximizer.strategy;
import com.example.cardmaximizer.model.*;
import org.springframework.stereotype.Component;

@Component
public class CIBCCostcoStrategy implements RewardStrategy {
    @Override
    public double calculateReward(Purchase purchase) {
        if (purchase.getCategory() == Category.GAS_COSTCO) return 0.03;
        if (purchase.getCategory() == Category.DINING) return 0.03;
        if (purchase.getCategory() == Category.COSTCO_WAREHOUSE) return 0.01;
        return 0.005;
    }
    @Override
    public String getCardName() { return "CIBC Costco Mastercard"; }

    @Override
    public String getReason(Purchase purchase) {
        if (purchase.getCategory() == Category.GAS_COSTCO) return "Industry-leading 3% on fuel";
        if (purchase.getCategory() == Category.DINING) return "Competitive 3% on restaurants";
        return "Standard Costco rewards";
    }
}