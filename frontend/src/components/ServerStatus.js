import React, { useState, useEffect } from 'react';

const ServerStatus = () => {
    const [status, setStatus] = useState('checking'); // 'up', 'down', 'checking'
    const API_BASE_URL = process.env.REACT_APP_API_URL || "http://localhost:8080";

    useEffect(() => {
        // Option 1: Define the function inside the Effect
        const checkHealth = async () => {
            try {
                // We use the Actuator health endpoint you added to the backend
                const response = await fetch(`${API_BASE_URL}/actuator/health`);
                if (response.ok) {
                    setStatus('up');
                } else {
                    setStatus('down');
                }
            } catch (error) {
                // If the fetch fails entirely, the server is likely sleeping
                setStatus('down');
            }
        };

        // Run immediately on mount
        checkHealth();

        // Polling: Check every 30 seconds to see if the server has gone to sleep
        const interval = setInterval(checkHealth, 30000);

        // Cleanup: Important for IT engineers to prevent memory leaks!
        return () => clearInterval(interval);
    }, [API_BASE_URL]); // Only re-run if the API URL changes

    const statusMap = {
        up: { color: '#4ade80', text: 'Backend Live' },
        down: { color: '#f87171', text: 'Backend Sleeping' },
        checking: { color: '#fbbf24', text: 'Checking Status...' }
    };

    const current = statusMap[status];

    return (
        <div style={{
            display: 'inline-flex',
            alignItems: 'center',
            gap: '8px',
            padding: '4px 12px',
            borderRadius: '20px',
            backgroundColor: 'rgba(30, 41, 59, 0.5)',
            border: '1px solid rgba(255,255,255,0.1)'
        }}>
            <div style={{
                width: '8px',
                height: '8px',
                borderRadius: '50%',
                backgroundColor: current.color,
                boxShadow: `0 0 8px ${current.color}`
            }} />
            <span style={{ color: '#94a3b8', fontSize: '0.75rem', fontWeight: '500' }}>
                {current.text}
            </span>
        </div>
    );
};

export default ServerStatus;