import React, { useState, useEffect } from 'react';
import axios from 'axios';

const GetPaciente = () => {
    const apiUrl = "http://localhost:8282/"

    const PacienteData = [
        { id: 1, content: "Sin contenido" },
    ];
    const [pacientes, setPacientes] = useState(PacienteData);
    //const [showLoading, setShowLoading] = useState(true);
    const fechaData = async () => {
        const result = await axios(apiUrl + 'api/pacientesCustomAPI/getAllPacientes');
        setPacientes(result.data);
    };

    useEffect(() => {
        fechaData();
    }, []);

    return (
        <div style={{ color: '#031249' }}>
        <h1>Peticion de pacientes con Axios</h1>
            {
                pacientes.map(paciente => <p >id = {paciente.id} | nombre = {paciente.nombre} | sexo = {paciente.sexo} | edad = {paciente.edad} </p>)
            }
        </div>
    );

};

export default GetPaciente;