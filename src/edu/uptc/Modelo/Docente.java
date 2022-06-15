package edu.uptc.Modelo;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Docente extends Persona implements Serializable{
	private int añosExperiencia;
	private int cedula;
	private Area area;
	public Docente(String nombre, Programa programa, String usuario, String contraseña, int añosExperiencia, int cedula,Area area ) {
		super(nombre, programa, usuario, contraseña);
		this.añosExperiencia=añosExperiencia;
		this.cedula=cedula;
		this.area=area;
	}
	public int getAñosExperiencia() {
		return añosExperiencia;
	}
	public void setAñosExperiencia(int añosExperiencia) {
		this.añosExperiencia = añosExperiencia;
	}
	public int getCedula() {
		return cedula;
	}
	public void setCedula(int cedula) {
		this.cedula = cedula;
	}
	public Area getArea() {
		return area;
	}
	public void setArea(Area area) {
		this.area = area;
	}
	
	
}
