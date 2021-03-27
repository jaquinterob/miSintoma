package com.example.demo;

import java.sql.Date;

public class Documento {
	
	
	public static String TipoDocumento;
	public static String NumeroDocumento;
	public static Date FechaExpedicion;
	
	
	public Documento(String tipodocumento, String numerodocumento, Date fechaexpedicion) {
		super();
		this.TipoDocumento = tipodocumento;
		this.NumeroDocumento = numerodocumento;
		this.FechaExpedicion = fechaexpedicion;
	}
	
	
	public static String getTipoDocumento() {
		return TipoDocumento;
	}
	public static void setTipoDocumento(String tipoDocumento) {
		TipoDocumento = tipoDocumento;
	}
	public static String getNumeroDocumento() {
		return NumeroDocumento;
	}
	public static void setNumeroDocumento(String numeroDocumento) {
		NumeroDocumento = numeroDocumento;
	}
	public static Date getFechaExpedicion() {
		return FechaExpedicion;
	}
	public static void setFechaExpedicion(Date fechaExpedicion) {
		FechaExpedicion = fechaExpedicion;
	}

}
