package edu.uptc.Modelo;

import java.util.ArrayList;

public class Estudiante extends Persona {
	private String correo;
	private int semestre;
	private int codigo;
	private ArrayList<Actividad> actividades;
	public Estudiante(String nombre, Programa programa, String usuario, String contraseña, String correo, int semestre, int codigo) {
		super(nombre, programa, usuario, contraseña);
		this.actividades=new ArrayList<Actividad>();
		this.correo=correo;
		this.semestre=semestre;
		this.codigo=codigo;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public int getSemestre() {
		return semestre;
	}
	public void setSemestre(int semestre) {
		this.semestre = semestre;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public ArrayList<Actividad> getActividades() {
		return actividades;
	}
	public void setActividades(ArrayList<Actividad> actividades) {
		this.actividades = actividades;
	}
	
}
