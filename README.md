⚔️ Card Maximizer: Strategy Pattern Demo

A full-stack "Gamified" financial tool that optimizes credit card rewards using a Java Strategy Pattern backend and a React frontend.
🚀 The Mission

This application solves the "Which card do I use?" problem by calculating the highest yield based on merchant categories, purchase amounts, and international FX fees. It features a tie-breaker system to prioritize premium cards when cash-back percentages match.
🛠️ Tech Stack

    Backend: Java 21, Spring Boot 3, Maven

    Frontend: React 18, Tailwind CSS, Framer Motion (Animations), Lucide React (Icons)

    Architecture: Strategy Design Pattern, RESTful API

🧩 Key Features

    Smart Tie-Breaking: If two cards offer 1%, the engine uses a priority attribute to pick the card with better secondary perks (e.g., insurance).

    Loot Ranking System: Rewards are ranked as Legendary, Epic, or Rare based on the calculated yield.

    Real-time ROI: Calculates approximate dollar returns on the server side for precision.
