# 💳 Credit Card Reward Optimizer (Java Spring Boot)

A real-world financial tool designed to maximize credit card rewards using the **Strategy Design Pattern**.

## 🚀 The Problem
Managing multiple credit cards (TD, Scotia, PC, CIBC) with varying reward tiers is complex. This tool automates the decision-making process to ensure every dollar spent yields the highest return.

## 🛠️ Technical Highlights
- **Design Pattern:** Implements the **Strategy Pattern** to decouple reward logic. Adding a new card is as simple as adding one class.
- **Dependency Injection:** Uses Spring Boot's auto-discovery to inject all implementations of `RewardStrategy` into the service automatically.
- **Java 21 Features:** Utilizes **Switch Expressions** for clean, readable reward mapping.
- **Observability:** Integrated SLF4J logging to track the engine's decision-making in real-time.

## 📈 Reward Logic (2026 Strategy)
- **International:** Scotia Passport (No FX Fees).
- **Costco/Gas:** CIBC Costco (3% Cash Back).
- **Groceries:** PC Mastercard (3% at Loblaws) / Scotia (3% at Sobeys).
- **Travel/Gaming:** TD First Class (4% via Expedia for TD / 2% Recurring).
