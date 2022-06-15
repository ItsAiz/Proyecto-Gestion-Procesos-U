package edu.uptc.Modelo;

import java.io.Serializable;
import java.util.ArrayList;
@SuppressWarnings("serial")
public class Materia implements Serializable {
	private int codigo;
	private Area nombre;
	private int semestre;
	private int creditos;
	private Docente docente;
	private Programa programa;
	private ArrayList<Estudiante> estudiantes;
	public Materia(int codigo,Area nombre, int semestre, int creditos, Docente docente, Programa programa) {
		this.codigo=codigo;
		this.nombre=nombre;
		this.semestre=semestre;
		this.creditos=creditos;
		this.docente=docente;
		this.programa=programa;
		this.estudiantes=new ArrayList<Estudiante>();
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public Area getNombre() {
		return nombre;
	}
	public void setNombre(Area nombre) {
		this.nombre = nombre;
	}
	public int getSemestre() {
		return semestre;
	}
	public void setSemestre(int semestre) {
		this.semestre = semestre;
	}
	public int getCreditos() {
		return creditos;
	}
	public void setCreditos(int creditos) {
		this.creditos = creditos;
	}
	public Docente getDocente() {
		return docente;
	}
	public void setDocente(Docente docente) {
		this.docente = docente;
	}
	public Programa getPrograma() {
		return programa;
	}
	public void setPrograma(Programa programa) {
		this.programa = programa;
	}
	public ArrayList<Estudiante> getEstudiantes() {
		return estudiantes;
	}
	public void setEstudiantes(ArrayList<Estudiante> estudiantes) {
		this.estudiantes = estudiantes;
	}
	
}
