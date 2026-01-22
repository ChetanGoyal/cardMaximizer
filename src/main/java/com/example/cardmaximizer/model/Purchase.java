package com.example.cardmaximizer.model;

public class Purchase {
    private double amount;
    private Category category; // Enum: GROCERY, GAS, TRAVEL, GAMING, etc.
    private String merchant;   // Optional: "Costco", "Sobeys", "Steam"
    private boolean isInternational;

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getMerchant() {
        return merchant;
    }

    public void setMerchant(String merchant) {
        this.merchant = merchant;
    }

    public boolean isInternational() {
        return isInternational;
    }

    public void setInternational(boolean international) {
        isInternational = international;
    }
}