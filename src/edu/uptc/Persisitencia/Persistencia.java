package edu.uptc.Persisitencia;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import edu.uptc.Modelo.Docente;
import edu.uptc.Modelo.Estudiante;
import edu.uptc.Modelo.Materia;

public class Persistencia {
	@SuppressWarnings("resource")
	public void cargarMaterias(ArrayList<Materia> materias) {
		FileOutputStream fileOutputStream;
		try {
			fileOutputStream = new FileOutputStream("src\\edu\\uptc\\Archivos\\materia.ser");
			ObjectOutputStream materiaSerializada=new ObjectOutputStream(fileOutputStream);
			for (int i = 0; i < materias.size(); i++) {
				materiaSerializada.writeObject(materias.get(i));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}	
	@SuppressWarnings("resource")
	public ArrayList<Materia> descargarMaterias(){
		ArrayList<Materia> materias=new ArrayList<Materia>();
		ArrayList<Estudiante> estudiantes=new ArrayList<Estudiante>();
		Docente docente;
		try {
			FileInputStream fileInputStream=new FileInputStream("src\\edu\\uptc\\Archivos\\materia.ser");
			ObjectInputStream materiaSerializada=new ObjectInputStream(fileInputStream);
			Materia materia=(Materia)materiaSerializada.readObject();
			materias.add(materia);
			while (materia!=null) {
				materia=(Materia)materiaSerializada.readObject();
				materias.add(materia);
			}
			
		} catch (FileNotFoundException e) {
			//JOptionPane.showMessageDialog(null, "Iniciando...");
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Iniciando...");
		} catch (ClassNotFoundException e) {
			//JOptionPane.showMessageDialog(null, "Iniciando...");
		}
		return materias;
	}
	public void cargarDocentes(ArrayList<Docente> docentes) {
		FileOutputStream fileOutputStream;
		try {
			fileOutputStream = new FileOutputStream("src\\edu\\uptc\\Archivos\\docente.ser");
			ObjectOutputStream docenteSerializado=new ObjectOutputStream(fileOutputStream);
			for (int i = 0; i <docentes.size(); i++) {
				docenteSerializado.writeObject(docentes.get(i));
			}
		} catch (FileNotFoundException e) {
			System.out.println("Cargado con exito, cerrando");
		} catch (IOException e) {
			
		}
		
	}
	@SuppressWarnings("resource")
	public ArrayList<Docente> descargarDocentes(){
		ArrayList<Docente> docentes=new ArrayList<Docente>();
		try {
			FileInputStream fileInputStream=new FileInputStream("src\\edu\\uptc\\Archivos\\docente.ser");
			ObjectInputStream docenteSerializado=new ObjectInputStream(fileInputStream);
			Docente docente =(Docente)docenteSerializado.readObject();
			docentes.add(docente);
			while (docente!=null) {
				docente=(Docente)docenteSerializado.readObject();
				docentes.add(docente);
			}
		} catch (FileNotFoundException e) {
			//JOptionPane.showMessageDialog(null, "Iniciando...");
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Iniciando...");
		} catch (ClassNotFoundException e) {
		//	JOptionPane.showMessageDialog(null, "Iniciando...");
		}
		return docentes;
	}
	public void cargarEstudiantes(ArrayList<Estudiante> estudiantes) {
		FileOutputStream fileOutputStream;
		try {
			fileOutputStream = new FileOutputStream("src\\edu\\uptc\\Archivos\\estudiante.ser");
			ObjectOutputStream estudianteSerializado=new ObjectOutputStream(fileOutputStream);
			for (int i = 0; i <estudiantes.size(); i++) {
				estudianteSerializado.writeObject(estudiantes.get(i));
			}
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
		}
	}
	/*public ArrayList<Estudiante> descargarEstudiantes(){
		ArrayList<Estudiante> estudiantes=new ArrayList<Estudiante>();
		try {
			FileInputStream fileInputStream=new FileInputStream("src\\edu\\uptc\\Archivos\\estudiante.ser");
			ObjectInputStream estudianteSerializado=new ObjectInputStream(fileInputStream);
			Estudiante estudiante =(Estudiante)estudianteSerializado.readObject();
			estudiantes.add(estudiante);
			while (estudiante!=null) {
				estudiante=(Estudiante)estudianteSerializado.readObject();
				estudiantes.add(estudiante);
			}
		} catch (FileNotFoundException e) {
			//JOptionPane.showMessageDialog(null, "Iniciando...");
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Iniciando...");
		} catch (ClassNotFoundException e) {
		//	JOptionPane.showMessageDialog(null, "Iniciando...");
		}
		return estudiantes;
	}*/
	
}
