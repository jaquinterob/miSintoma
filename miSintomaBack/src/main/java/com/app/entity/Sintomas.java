package com.app.entity;

import java.util.ArrayList;
import java.util.List;


public class Sintomas {
		private List<Sintoma> sintomasList;
		public List<Sintoma> getSintomasList(){
			if(sintomasList == null) {
				sintomasList = new ArrayList<>();
			}
			return sintomasList;
		}
		public void setSintomasList(List<Sintoma> sintomasList) {
			this.sintomasList = sintomasList;
		}
		
		
	
}
