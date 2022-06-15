package edu.uptc.Modelo;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Persona implements Serializable{
	private String nombre;
	private Programa programa;
	private String usuario;
	private String contrase�a;
	public Persona(String nombre,Programa programa, String usuario, String contrase�a) {
		this.nombre=nombre;
		this.programa=programa;
		this.usuario=usuario;
		this.contrase�a=contrase�a;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Programa getPrograma() {
		return programa;
	}
	public void setPrograma(Programa programa) {
		this.programa = programa;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getContrase�a() {
		return contrase�a;
	}
	public void setContrase�a(String contrase�a) {
		this.contrase�a = contrase�a;
	}
	
}
