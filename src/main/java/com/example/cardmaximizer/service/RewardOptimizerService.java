package com.example.cardmaximizer.service;

import com.example.cardmaximizer.model.Purchase;
import com.example.cardmaximizer.model.Recommendation;
import com.example.cardmaximizer.strategy.*;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

@Service
public class RewardOptimizerService {
    private final List<RewardStrategy> wallet = Arrays.asList(
            new ScotiaPassportStrategy(),
            new TDFirstClassStrategy(),
            new CIBCCostcoStrategy(),
            new PCMastercardStrategy()
    );

    public Recommendation getBestCard(Purchase purchase) {
        return wallet.stream()
                .map(s -> new Recommendation(s.getCardName(), s.calculateReward(purchase), s.getReason(purchase)))
                .max(Comparator.comparingDouble(Recommendation::getRewardValue))
                .orElseThrow(() -> new RuntimeException("No strategies found"));
    }
}
