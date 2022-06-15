package edu.uptc.Vista;

import java.util.ArrayList;

import javax.swing.JTable;

import edu.uptc.Modelo.Estudiante;

public interface Acciones {
	public static String INGRESAR= "ingresar";
	public static String CERRAR= "cerrar";
	
	public static String LISTA_DOCENTES="lista docentes";
	public static String CREAR_DOCENTES="crear docentes";
	public static String REGISTRAR_DOCENTE="registrar docente";
	public static String ACTUALIZAR_DOCENTES="actualizar docentes";
	public static String ELIMINAR_DOCENTES="eliminar docentes";
	
	public  static String MODIFICAR_DOCENTE="modificar docente";
	public static String MODIFICARD="modificarD";
	public static String ELIMINARD="eliminare docentes";
	
	public static String LISTA_MATERIAS="lista materias";
	public static String CREAR_MATERIAS="crear materias";
	public static String REGISTRAR_MATERIA="registrar materia";
	public static String ACTUALIZAR_MATERIAS="actualizar materias";	
	
	public static String VOLVER_CREAR_DOCENTE="volverCD";
	public static String DOCENTE="docente";
	public static String SELECCION_DOCENTE="selecionar docente";
	public static String SELECCION_ESTUDIANTES="selecionar estudiantes";
	public static String MODIFICAR_MATERIA="modificar materia";
	public static String MODIFICARM="modificarM";
	public static String DOCENTED="docented";
	public static String ESTUDIANTES_SELECCIONADOS="estudiantes seleccionados";
	
	public static String LISTA_MATERIAS_DOCENTE="lista materias docente";
	public static String ASIGNAR_ACTIVIDADES="asignar actividades";
	public static String SELECCIONAR_MATERIA="seleccionar materia";
	public static String CALIFICAR_ACTIVIDADES="calificar actividades";
	public static String CALIFICAR_ESTUDIANTE_SELECCIONADO="calificar estudiante seleccionado";
	public static String CALIFICAR_ACTIVIDAD_SELECCIONADA="calificar actividad seleccionada";
	public static String SUBIR_NOTA_ACTIVIDAD_SELECCIONADA="subir nota actividad seleccionada";
	public static String VOLVER_CALIFICAR_ACTIVIDADES="volver calificar actividades";
	public static String VOLVER_CALIFICAR_ACTIVIDAD_SELECCIONADA="volver calificar actividad seleccionada";
	public static String ASIGNAR="asignar";
	public static String VOLVER_DOCENTE_LISTA_MATERIAS="volver docente";
	
	public static String LISTA_ACTIVIDADES_ESTUDIANTE="lista actividades";
	public static String HISTORIAL_ACTIVIDADES="historial actividades";
	public static String PROMEDIO_ACUMULADO="promedio acumulado";
	public static String SELECCION_ACTIVIDAD_RESPONDER="seleccion responder actividad";
	public static String SUBIR_RESPUESTA="subir respuesta";
	public static String VOLVER_LISTA_ACTIVIDADES="volver lista actividades";
	
	public static String LOGGOUT_COORDINADOR="loggoutCoordinador";
	public static String LOGGOUT_DOCENTE="loggoutDocente";
	public static String LOGGOUT_ESTUDIANTE="loggoutEstudiante";
	public static String VOLVER="volver";
	
	public void activar(String seccion);
	public void desactivar(String seccion);
	public String[] capturar(String seccion);
	public void metodoExtra(String seccion);
	public void mostrar(String[][] salidas, String seccion);
	public void mensaje(String mensaje);
	public String[] metodoExtraRetorna(String seccion);
	public Estudiante[] listaEstudiantesSeleccionados();
}
