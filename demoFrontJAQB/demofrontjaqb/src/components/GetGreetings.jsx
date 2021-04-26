import React, { useState, useEffect } from 'react';
import axios from 'axios';

const GetGreeting = () => {
    const apiUrl = "http://localhost:8282/"

    const GreetingData = [
        { id: 1, content: "Sin contenido" },
    ];
    const [greeting, setGreeting] = useState(GreetingData);
    //const [showLoading, setShowLoading] = useState(true);

    useEffect(() => {
        const fechaData = async () => {
            const result = await axios(apiUrl + 'api/pacientesCustomAPI/getAllPacientes');
            setGreeting(result.data);
        };
        fechaData();
    }, []);

    return (
        <div style={{ color: '#031249' }}>
        <h1>Peticion con Axios</h1>
            {
                greeting.map(item => <p >id = {item.id} | nombre = {item.nombre} | sexo = {item.sexo} | edad = {item.edad} </p>)
            }
        </div>
    );

};

export default GetGreeting;