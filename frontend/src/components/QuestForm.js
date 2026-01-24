import React, { useState } from 'react';
import { Sword, Globe } from 'lucide-react';

const QuestForm = ({ onResults }) => {
    const API_BASE_URL = process.env.REACT_APP_API_URL || "http://localhost:8080";
    const [purchase, setPurchase] = useState({ amount: '', category: 'DINING', isInternational: false });

    const handleSubmit = async (e) => {
        e.preventDefault();
        const response = await fetch(`${API_BASE_URL}/api/v1/optimize`, {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(purchase),
        });
        const data = await response.json();
        onResults(data);
    };

    return (
        <form onSubmit={handleSubmit} className="p-6 bg-gray-900 text-white rounded-lg border-2 border-yellow-600">
            <h2 className="text-xl font-bold mb-4 text-yellow-500">⚔️ Start New Quest</h2>
            <input
                type="number"
                placeholder="Enter Amount ($)"
                className="w-full p-2 mb-4 bg-gray-800 border border-gray-600"
                onChange={(e) => setPurchase({...purchase, amount: e.target.value})}
            />
            <select
                className="w-full p-2 mb-4 bg-gray-800 border border-gray-600"
                onChange={(e) => setPurchase({...purchase, category: e.target.value})}
            >
                <option value="DINING">Dining & Drinks</option>
                <option value="GAS_COSTCO">Costco Gas</option>
                <option value="GAMING_DIGITAL">Digital Gaming</option>
                <option value="GAS_ESSO">Esso Gas</option>
                <option value="GAS">Other Gas and EV charging</option>
                <option value="GROCERY_LOBLAWS">Grocery(Loblaws / No Frills / Zehrs)</option>
                <option value="GROCERY_EMPIRE">Grocery(Sobeys, Safeway, FreshCo, etc.)</option>
                <option value="PUBLIC_TRANSIT">Public Transit</option>
                <option value="COSTCO_WAREHOUSE">Costco Warehouse</option>
                <option value="ONLINE_COSTCO">Costco Online</option>
                <option value="TRAVEL_EXPEDIA">Travel Expedia</option>
                <option value="GROCERY">Grocery</option>
                <option value="RECURRING_BILL">Recurring Bill</option>
                <option value="OTHER">Other Expenditure</option>
                <option value="ENTERTAINMENT">Entertainment</option>
                <option value="SHOPPERS_DRUG_MART">Shoppers Drug Mart</option>
            </select>

            <div className="mb-8 p-4 rounded-md border border-blue-900/50 bg-blue-950/20 flex items-center justify-between group cursor-pointer"
                 onClick={() => setPurchase(p => ({...p, isInternational: !p.isInternational}))}>
                <div className="flex items-center gap-3">
                    <Globe className={`w-6 h-6 transition-colors ${purchase.isInternational ? 'text-blue-400' : 'text-gray-600'}`} />
                    <div>
                        <div className="text-sm font-bold uppercase tracking-tight">International Quest</div>
                        <div className="text-[10px] text-gray-500 leading-tight">Apply FX Fee Protection logic</div>
                    </div>
                </div>
                <input
                    type="checkbox"
                    checked={purchase.isInternational}
                    className="w-5 h-5 accent-blue-500 cursor-pointer"
                    onChange={() => {}} // Handled by div click
                />
            </div>

            <button className="w-full bg-yellow-600 hover:bg-yellow-500 p-2 font-bold uppercase tracking-widest">
                <Sword className="w-5 h-5" /> Scan Rewards
            </button>
        </form>
    );
};

export default QuestForm;