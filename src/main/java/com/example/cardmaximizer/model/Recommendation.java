package com.example.cardmaximizer.model;

public class Recommendation {
    private String cardName;
    private double rewardValue;
    private String reason;
    private String rank;

    public Recommendation(String cardName, double rewardValue,String reason) {
        this.cardName = cardName;
        this.rewardValue = rewardValue;
        this.rank = determineRank(rewardValue);
    }

    public String getCardName() { return cardName; }
    public double getRewardValue() { return rewardValue; }
    public String getReason() { return reason; }
    public String getRank() { return rank; }

    private String determineRank(double value) {
        if (value >= 0.04) return "LEGENDARY"; // 4% or higher
        if (value >= 0.03) return "EPIC";      // 3% to 3.9%
        if (value >= 0.02) return "RARE";      // 2% to 2.9%
        return "COMMON";                       // Below 2%
    }

    public String getFormattedReward() {
        return String.format("%.1f%%", this.rewardValue * 100);
    }

    public void setCardName(String cardName) { this.cardName = cardName; }
    public void setRewardValue(double rewardValue) {
        this.rewardValue = rewardValue;
        this.rank = determineRank(rewardValue); // Update rank if value changes
    }
    public void setReason(String reason) { this.reason = reason; }

    @Override
    public String toString() {
        return "Recommendation{" +
                "cardName='" + cardName + '\'' +
                ", rewardValue=" + rewardValue +
                ", reason='" + reason + '\'' +
                '}';
    }
}