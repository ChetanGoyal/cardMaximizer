import React, { useState, useEffect } from 'react';

const ServerStatus = () => {
    const [status, setStatus] = useState('checking'); // 'up', 'down', 'checking'
    const API_BASE_URL = process.env.REACT_APP_API_URL || "http://localhost:8080";

    const checkHealth = async () => {
        try {
            const response = await fetch(`${API_BASE_URL}/actuator/health`);
            if (response.ok) {
                setStatus('up');
            } else {
                setStatus('down');
            }
        } catch (error) {
            setStatus('down');
        }
    };

    useEffect(() => {
        checkHealth(); // Check immediately on load
        const interval = setInterval(checkHealth, 30000); // Check every 30 seconds
        return () => clearInterval(interval);
    }, []);

    const statusMap = {
        up: { color: '#4ade80', text: 'Backend Live' },
        down: { color: '#f87171', text: 'Backend Sleeping' },
        checking: { color: '#fbbf24', text: 'Checking Status...' }
    };

    const current = statusMap[status];

    return (
        <div style={{ display: 'flex', alignItems: 'center', gap: '8px', fontSize: '0.8rem' }}>
            <div style={{
                width: '10px', height: '10px', borderRadius: '50%',
                backgroundColor: current.color, boxShadow: `0 0 8px ${current.color}`
            }} />
            <span style={{ color: '#94a3b8' }}>{current.text}</span>
        </div>
    );
};

export default ServerStatus;