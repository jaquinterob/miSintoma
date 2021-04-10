package com.app.entity;

import java.util.ArrayList;
import java.util.List;

public class Vaccine
{
    private List<CovidVaccine> vaccineList;
    
    public List<CovidVaccine> getVaccineList() {
        if(vaccineList == null) {
        	vaccineList = new ArrayList<>();
        }
        return vaccineList;
    }
 
    public void setVaccineList(List<CovidVaccine> vaccineList) {
        this.vaccineList = vaccineList;
    }
}