package com.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name = "TBL_Sintomas")
public class Sintomas {
	
	@Id
	@Column(name = "Sintoma_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idSintoma;
	@Column(name = "Sintoma_Name")
	private String namesintoma;
	@Column(name = "Sintoma_Descripcion")
	private String descripcion;
	public Integer getIdSintoma() {
		return idSintoma;
	}
	public void setIdSintoma(Integer idSintoma) {
		this.idSintoma = idSintoma;
	}
	public String getNamesintoma() {
		return namesintoma;
	}
	public void setNamesintoma(String namesintoma) {
		this.namesintoma = namesintoma;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	@Override
	public String toString() {
		return "Sintomas [idSintoma=" + idSintoma + ", namesintoma=" + namesintoma + ", descripcion=" + descripcion
				+ "]";
	}
	public Sintomas() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	

}
