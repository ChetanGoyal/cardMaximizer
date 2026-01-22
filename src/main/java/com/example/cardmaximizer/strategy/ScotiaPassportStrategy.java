package com.example.cardmaximizer.strategy;
import com.example.cardmaximizer.model.*;
import org.springframework.stereotype.Component;

@Component
public class ScotiaPassportStrategy implements RewardStrategy {
    @Override
    public double calculateReward(Purchase purchase) {
        if (purchase.isInternational()) return 0.025; // FX Savings
        if (purchase.getCategory() == Category.GROCERY_EMPIRE) return 0.03;
        return 0.01;
    }
    @Override
    public String getCardName() { return "Scotia Passport Visa Infinite"; }

    public String getReason(Purchase purchase) {
        return purchase.isInternational() ? "No FX Fees (2.5% saved)" : "3x Scene+ Points";
    }
}