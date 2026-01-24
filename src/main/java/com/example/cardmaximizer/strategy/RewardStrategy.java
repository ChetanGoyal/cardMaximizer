package com.example.cardmaximizer.strategy;
import com.example.cardmaximizer.model.Purchase;

public interface RewardStrategy {
    double calculateReward(Purchase purchase);
    String getCardName();
    String getReason(Purchase purchase);
    default int getPriority() {
        return 1;
    }
}