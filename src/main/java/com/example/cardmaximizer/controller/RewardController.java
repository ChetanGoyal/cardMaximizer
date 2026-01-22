package com.example.cardmaximizer.controller;

import com.example.cardmaximizer.model.*;
import com.example.cardmaximizer.service.RewardOptimizerService;
import com.example.cardmaximizer.strategy.*;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api/v1/optimize")
public class RewardController {

    private final RewardOptimizerService service;

    public RewardController(RewardOptimizerService service) {
        this.service = service; }

    @PostMapping
    public ResponseEntity<Recommendation> optimize(@RequestBody Purchase purchase) {
        if (purchase.getAmount() <= 0) {
            throw new RuntimeException("Purchase amount must be greater than zero.");
        }
        return ResponseEntity.ok(service.getBestCard(purchase));
    }

//    private final List<RewardStrategy> strategies = Arrays.asList(
//            new ScotiaPassportStrategy(),
//            new CIBCCostcoStrategy(),
//            new TDFirstClassStrategy(), // Assumed implemented similarly
//            new PCMastercardStrategy()  // Assumed implemented similarly
//    );
//
//    @PostMapping("/optimize")
//    public Recommendation optimize(@RequestBody Purchase purchase) {
//        return strategies.stream()
//                .map(s -> new Recommendation(s.getCardName(), s.calculateReward(purchase)))
//                .max(Comparator.comparingDouble(Recommendation::getRewardValue))
//                .orElse(null);
//    }
//
//    // 1. Endpoint to find the best card for a specific purchase
//    @PostMapping("/best-card")
//    public Recommendation getBestCard(@RequestBody Purchase purchase) {
//        return strategies.stream()
//                .map(s -> new Recommendation(s.getCardName(), s.calculateReward(purchase)))
//                .max(Comparator.comparingDouble(Recommendation::getRewardValue))
//                .orElse(new Recommendation("Cash", 0.0));
//    }
//
//    @GetMapping("/download-strategy")
//    public ResponseEntity<String> downloadStrategy() {
//        String csvHeader = "Category,Recommended Card,Reward Value\n";
//        String csvBody = "Costco Gas,CIBC Costco,3%\n" +
//                "Groceries (Loblaws),PC Mastercard,3%\n" +
//                "International Travel,Scotia Passport,2.5%\n" +
//                "Gaming/Digital,TD First Class,2%";
//
//        return ResponseEntity.ok()
//                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=card_strategy.csv")
//                .contentType(MediaType.parseMediaType("text/csv"))
//                .body(csvHeader + csvBody);
//    }
}