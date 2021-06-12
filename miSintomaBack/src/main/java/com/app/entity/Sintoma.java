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
@Table(name = "TBL_Sintomas")
public class Sintoma implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)  
	@GeneratedValue(strategy= GenerationType.AUTO,   generator="native")
	@GenericGenerator(name = "native",  strategy = "native"  )
	@Column(name = "id")
	private long id;
	@Column(name = "Sintoma_Name")
	private String namesintoma;
	@Column(name = "Sintoma_Descripcion")
	private String descripcion;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "Sintomas [id=" + id + ", namesintoma=" + namesintoma + ", descripcion=" + descripcion + "]";
	}
	
	public Sintoma(String namesintoma, String descripcion) {
		this.id = id;
		this.namesintoma = namesintoma;
		this.descripcion = descripcion;
		
	}
	public Sintoma() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
