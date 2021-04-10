package com.app.entity;

import java.util.ArrayList;
import java.util.List;

public class Pacientes 
{
    private List<Paciente> pacienteList;
    
    public List<Paciente> getPacienteList() {
        if(pacienteList == null) {
        	pacienteList = new ArrayList<>();
        }
        return pacienteList;
    }
 
    public void setPacienteList(List<Paciente> pacienteList) {
        this.pacienteList = pacienteList;
    }
}