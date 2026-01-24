import React from 'react';
import { motion } from 'framer-motion';
import { Trophy, Sparkles, Zap } from 'lucide-react';

const RewardDisplay = ({ reward }) => {
    if (!reward) return null;

    const rankColors = {
        LEGENDARY: {
            color: "from-orange-600 via-yellow-500 to-red-600",
            glow: "shadow-[0_0_30px_rgba(249,115,22,0.6)]",
            textColor: "text-orange-400",
            icon: <Trophy className="w-6 h-6 animate-bounce" />
        },
        EPIC: {
            color: "from-purple-600 via-fuchsia-500 to-indigo-600",
            glow: "shadow-[0_0_20px_rgba(168,85,247,0.5)]",
            textColor: "text-purple-400",
            icon: <Sparkles className="w-5 h-5 animate-pulse" />
        },
        RARE: {
            color: "from-blue-600 to-cyan-500",
            glow: "shadow-[0_0_15px_rgba(59,130,246,0.4)]",
            textColor: "text-blue-400",
            icon: <Zap className="w-5 h-5" />
        },
        COMMON: "text-gray-400 border-gray-400"
    };

    const config = rankColors[reward.rank] || rankColors.RARE;

    return (
        <motion.div
            key={reward.cardName}
            initial={{ y: 20, opacity: 0 }}
            animate={{ y: 0, opacity: 1 }}
            className={`relative p-1 rounded-2xl bg-gradient-to-br ${config.color} ${config.glow} mt-8`}
        >
            <div className="bg-gray-950 rounded-xl p-8 text-center">
                <div className="flex items-center justify-center gap-3 mb-3">
                    {config.icon}
                    <span className={`${config.textColor} font-black tracking-widest text-xs uppercase`}>
            {reward.rank} Item Found
          </span>
                    {config.icon}
                </div>

                <h2 className="text-3xl font-black text-white italic mb-4">
                    {reward.cardName}
                </h2>

                <div className="text-5xl font-mono font-bold text-white mb-4">
                    +{reward.rewardValue * 100}% <span className="text-xl">Yield</span>
                </div>
                <div className="flex flex-col items-center mt-4">
                    <div className="text-sm text-gray-500 uppercase tracking-widest font-bold">Approx. Gold Earned</div>
                    <div className="text-4xl font-black text-yellow-500">
                        ${reward.approxReturn?.toFixed(2)}
                    </div>
                </div>

                <p className="text-gray-400 italic">"{reward.reason}"</p>
            </div>
        </motion.div>
    );
};

export default RewardDisplay;