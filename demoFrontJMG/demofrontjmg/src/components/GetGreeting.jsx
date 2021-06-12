import React, {useState, useEffect} from "react";
import axios from "axios";

const GetGreeting = () => {
    const apiUrl = "htpp://localhost:8282/";
    const GreetingData = [
        { id: 1, content: "Sin contenido" },
    ];
    const [greeting, setGreeting] = useState(GreetingData);
    const [showLoading, setShowLoading] = useState(true);
    useEffect(() => {
        const fetchData = async () => {
            const result = await axios(apiUrl + "greeting");
            setGreeting(result.data.content);
        };
        fetchData();
    }, []);
    return (
        <div className = "container">
            <h1>{greeting}</h1>
        </div>
    );
};
export default GetGreeting;