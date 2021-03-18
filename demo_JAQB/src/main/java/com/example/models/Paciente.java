package com.example.models;

public class Paciente {
	
	private String documento;
	private String nombre;
	private String sexo;
	private int edad;
	private String telefono;
	private String celular;
	private String direccion;
	
	public Paciente(String documento, String nombre, String sexo, int edad, String telefono, String celular,
			String direccion) {
		this.documento = documento;
		this.nombre = nombre;
		this.sexo = sexo;
		this.edad = edad;
		this.telefono = telefono;
		this.celular = celular;
		this.direccion = direccion;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
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
