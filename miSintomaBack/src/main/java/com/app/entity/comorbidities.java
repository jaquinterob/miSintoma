package com.app.entity;

import java.util.ArrayList;
import java.util.List;

public class comorbidities {
	private List<comorbidity> comorbidityList;
    
    public List<comorbidity> getComorbidityList() {
        if(comorbidityList == null) {
        	comorbidityList = new ArrayList<>();
        }
        //
        return comorbidityList;
    }
 
    public void setComorbidityList(List<comorbidity> comorbidityList) {
        this.comorbidityList = comorbidityList;
    }
}
