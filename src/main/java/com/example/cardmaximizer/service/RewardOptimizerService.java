package com.example.cardmaximizer.service;

import com.example.cardmaximizer.model.Purchase;
import com.example.cardmaximizer.model.Recommendation;
import com.example.cardmaximizer.strategy.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

@Service
public class RewardOptimizerService {
    private static final Logger logger = LoggerFactory.getLogger(RewardOptimizerService.class);
    private final List<RewardStrategy> wallet = Arrays.asList(
            new ScotiaPassportStrategy(),
            new TDFirstClassStrategy(),
            new CIBCCostcoStrategy(),
            new PCMastercardStrategy()
    );

    public Recommendation getBestCard(Purchase purchase) {
        logger.info("Finding best card for: {}", purchase.getCategory());
        return wallet.stream()
                .map(s -> new Recommendation(s.getCardName(), s.calculateReward(purchase)
                        ,purchase.getAmount(), s.getReason(purchase),s.getPriority()))
                .max(Comparator.comparingDouble(Recommendation::getRewardValue)
                        .thenComparingInt(Recommendation::getPriority))
                .orElseThrow(() -> new RuntimeException("No strategies found"));
    }
}
