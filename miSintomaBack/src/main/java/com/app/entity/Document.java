package com.app.entity;


import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Document {
	
	private @Id @GeneratedValue Long id;
	private String TipoDocumento;
	private String NumeroDocumento;
	private Date FechaExpedicion;
	
	
	public Document(long id, String tipodocumento, String numerodocumento, Date fechaexpedicion) {
		super();
		this.id = id;
		this.TipoDocumento = tipodocumento;
		this.NumeroDocumento = numerodocumento;
		this.FechaExpedicion = fechaexpedicion;
	}
	
	
	private String getTipoDocumento() {
		return TipoDocumento;
	}
	private void setTipoDocumento(String tipoDocumento) {
		TipoDocumento = tipoDocumento;
	}
	private String getNumeroDocumento() {
		return NumeroDocumento;
	}
	private void setNumeroDocumento(String numeroDocumento) {
		NumeroDocumento = numeroDocumento;
	}
	private Date getFechaExpedicion() {
		return FechaExpedicion;
	}
	
	private void setFechaExpedicion(Date fechaExpedicion) {
		FechaExpedicion = fechaExpedicion;
	}


	
	public Document() {
		super();
		// TODO Auto-generated constructor stub
	}


	@Override
	public String toString() {
		return "Document [id=" + id + ", TipoDocumento=" + TipoDocumento + ", NumeroDocumento=" + NumeroDocumento
				+ ", FechaExpedicion=" + FechaExpedicion + "]";
	}
	

}