package com.app.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="CovidVaccine")

public class CovidVaccine implements Serializable{
	private static final long serialVersionUID = 1L;
	//
	@Id
	@GeneratedValue(  strategy= GenerationType.AUTO,   generator="native")
	@GenericGenerator( name = "native",  strategy = "native"  )
	@Column(name = "id")
	private long id;
	
	@Column(name = "nameVaccine")
	private String nameVaccine;
	
	@Column(name = "components")
	private String components;
	
	@Column(name = "laboratory")
	private String laboratory;
	
	@Column(name = "expirationDate")
	private String expirationDate;
	
	@Column(name = "clinicalData")
	private String clinicalData;
	
	@Column(name = "vaccineBatch")
	private String vaccineBatch;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNameVaccine() {
		return nameVaccine;
	}

	public void setNameVaccine(String nameVaccine) {
		this.nameVaccine = nameVaccine;
	}
	
	public String getComponents() {
		return components;
	}

	public void setComponents(String components) {
		this.components = components;
	}
	
	public String getLaboratory() {
		return laboratory;
	}

	public void setLaboratory(String laboratory) {
		this.laboratory = laboratory;
	}
	
	public String getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}
	
	public String getClinicalData() {
		return clinicalData;
	}

	public void setClinicalData(String clinicalData) {
		this.clinicalData = clinicalData;
	}
	
	public String getVaccineBatch() {
		return vaccineBatch;
	}

	public void setVaccineBatch(String vaccineBatch) {
		this.vaccineBatch = vaccineBatch;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "CovidVaccine [id=" + id + ", nameVaccine=" + nameVaccine + ", components=" + components + 
				", laboratory=" + laboratory + ", expirationDate=" + expirationDate + ", clinicalData=" + clinicalData +
				", vaccineBatch=" + vaccineBatch +"]";
	}
	
	public CovidVaccine(String nameVaccine, String components, String laboratory, String expirationDate, String clinicalData, String vaccineBatch ) {
		this.nameVaccine = nameVaccine;
		this.components = components;
		this.laboratory = laboratory;
		this.expirationDate = expirationDate;
		this.clinicalData = clinicalData;
		this.vaccineBatch = vaccineBatch;
	}
	
	public CovidVaccine() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
