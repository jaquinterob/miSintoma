package com.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Paciente {
	
	private @Id 	@GeneratedValue  long documento;
	@Column
	private String nombre;
	@Column
	private String sexo;
	@Column
	private int edad;
	@Column
	private String telefono;
	@Column
	private String celular;
	@Column
	private String direccion;
	
	public Paciente(long documento, String nombre, String sexo, int edad, String telefono, String celular,
			String direccion) {
		this.documento = documento;
		this.nombre = nombre;
		this.sexo = sexo;
		this.edad = edad;
		this.telefono = telefono;
		this.celular = celular;
		this.direccion = direccion;
	}

	public long getDocumento() {
		return documento;
	}

	public void setDocumento(long documento) {
		this.documento = documento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
}