package edu.uptc.Modelo;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Docente extends Persona implements Serializable{
	private int a�osExperiencia;
	private int cedula;
	private Area area;
	public Docente(String nombre, Programa programa, String usuario, String contrase�a, int a�osExperiencia, int cedula,Area area ) {
		super(nombre, programa, usuario, contrase�a);
		this.a�osExperiencia=a�osExperiencia;
		this.cedula=cedula;
		this.area=area;
	}
	public int getA�osExperiencia() {
		return a�osExperiencia;
	}
	public void setA�osExperiencia(int a�osExperiencia) {
		this.a�osExperiencia = a�osExperiencia;
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
