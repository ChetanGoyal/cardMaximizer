package com.example.cardmaximizer.model;

public class Recommendation {
    private String cardName;
    private double rewardValue;
    private String reason;

    public Recommendation(String cardName, double rewardValue,String reason) {
        this.cardName = cardName;
        this.rewardValue = rewardValue;
    }

    public String getCardName() { return cardName; }
    public double getRewardValue() { return rewardValue; }
    public String getReason() { return reason; }


    public String getFormattedReward() {
        return String.format("%.1f%%", this.rewardValue * 100);
    }

    @Override
    public String toString() {
        return "Recommendation{" +
                "cardName='" + cardName + '\'' +
                ", rewardValue=" + rewardValue +
                ", reason='" + reason + '\'' +
                '}';
    }
}