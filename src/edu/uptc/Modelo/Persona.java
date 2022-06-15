package edu.uptc.Modelo;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Persona implements Serializable{
	private String nombre;
	private Programa programa;
	private String usuario;
	private String contraseña;
	public Persona(String nombre,Programa programa, String usuario, String contraseña) {
		this.nombre=nombre;
		this.programa=programa;
		this.usuario=usuario;
		this.contraseña=contraseña;
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
	public String getContraseña() {
		return contraseña;
	}
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	
}
