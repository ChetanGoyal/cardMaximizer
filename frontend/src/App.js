import React, { useState } from 'react';
import QuestForm from './components/QuestForm';
import RewardDisplay from './components/RewardDisplay';

function App() {
    const [reward, setReward] = useState(null);
    const [loading, setLoading] = useState(false);

    const handleResults = (data) => {
        setLoading(true);
        // Simulate a "scanning" delay for gaming effect
        setTimeout(() => {
            setReward(data);
            setLoading(false);
        }, 800);
    };

    return (
        <div className="min-h-screen bg-black text-white font-sans p-4 md:p-10">
            <header className="max-w-2xl mx-auto text-center mb-10">
                <h1 className="text-4xl font-black tracking-tighter text-yellow-500 uppercase italic">
                    Card Maximizer <span className="text-white">v1.0</span>
                </h1>
                <p className="text-gray-400 mt-2">Optimize your spending. Maximize your loot.</p>
            </header>

            <main className="max-w-xl mx-auto space-y-8">
                <QuestForm onResults={handleResults} />

                {loading && (
                    <div className="text-center py-10 animate-pulse text-yellow-600 font-bold">
                        SCANNING MERCHANT DATA...
                    </div>
                )}

                {!loading && <RewardDisplay reward={reward} />}
            </main>
        </div>
    );
}

export default App;