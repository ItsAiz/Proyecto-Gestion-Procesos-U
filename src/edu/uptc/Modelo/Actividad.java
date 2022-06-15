package edu.uptc.Modelo;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class Actividad implements Serializable{
	private String respuesta;
	private int codigo;
	private String nombre;
	private int porcentaje;
	private int nota;
	private Date fechaEntrega;
	private String descripcion;
	public Actividad(int codigo, String nombre,int porcentaje, int nota, Date fechaEntrega, String respuesta, String descripcion) {
		this.codigo=codigo;
		this.nombre=nombre;
		this.porcentaje=porcentaje;
		this.nota=nota;
		this.fechaEntrega=fechaEntrega;
		this.respuesta=respuesta;
		this.descripcion=descripcion;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getPorcentaje() {
		return porcentaje;
	}
	public void setPorcentaje(int porcentaje) {
		this.porcentaje = porcentaje;
	}
	public int getNota() {
		return nota;
	}
	public void setNota(int nota) {
		this.nota = nota;
	}
	public Date getFechaEntrega() {
		return fechaEntrega;
	}
	public void setFechaEntrega(Date fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}
	public String getRespuesta() {
		return respuesta;
	}
	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public boolean estadoActividad() {
		Date fechaActual=new Date();
		if(fechaEntrega.equals(fechaActual)) {
			return false;
		}else {
			return true;
		}
	}
}
