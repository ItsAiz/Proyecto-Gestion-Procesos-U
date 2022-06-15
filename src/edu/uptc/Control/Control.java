package edu.uptc.Control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import edu.uptc.Modelo.Estudiante;
import edu.uptc.Modelo.Gestion;
import edu.uptc.Persisitencia.Persistencia;
import edu.uptc.Vista.Acciones;

public class Control implements ActionListener {
	private Acciones acciones;
	private Persistencia persistencia;
	private Gestion gestion;
	private int codigoMateria;
	private int codigoMateriaActividad;
	private int cedulaDocente;
	private String usuarioEstudiante;
	private int codigoMateriaParaestudiante;
	private int codigoActividad;
	private int codigoActividadDocente;
	private int codigoEstudiante;
	private int codigoMateriaCalificarEstudiante;
	public Control(Acciones acciones) {
		this.acciones=acciones;
		gestion=new Gestion();
		persistencia=new Persistencia();
		cargarEstudiantes();
		descargarMaterias();
		descargarDocentes();
	}
	@Override
	public void actionPerformed(ActionEvent evento) {
		switch (evento.getActionCommand()) {
		case Acciones.INGRESAR: 
//			for (int i = 0; i < gestion.getMaterias().get(1).getEstudiantes().get(0).getActividades().size(); i++) {
//				System.out.println(gestion.getMaterias().get(1).getEstudiantes().get(0).getActividades().get(i).getPorcentaje());
//			}
			String entradas[]=acciones.capturar(Acciones.INGRESAR);
			if(gestion.verificarCoordinador(entradas[0], entradas[1])==true) {
				acciones.desactivar("inicio sesion");
				acciones.mensaje("Bienvenido SR.Coordinador");
				acciones.activar("loggoutCoordinador");
				acciones.activar("opciones coordinador");
			}else if(gestion.verificarDocente(entradas[0], entradas[1])) {
				acciones.desactivar("inicio sesion");
				acciones.mensaje("Bienvenido Sr docente "+gestion.mostrarDocenteLoggeado(entradas[0]));
				int posi=gestion.buscarPosicionDocentePorUsuario(entradas[0]);
				cedulaDocente=gestion.getDocentes().get(posi).getCedula();
				acciones.activar("opciones docente");
				acciones.activar("lista materias docente");
				acciones.mostrar(gestion.mostrarDatosMateriasDocente(cedulaDocente), Acciones.LISTA_MATERIAS_DOCENTE);
			}else if(gestion.verificarEstudiante(entradas[0])) {
				usuarioEstudiante=entradas[0];
				acciones.desactivar("inicio sesion");
				acciones.mensaje("Bienvenido estudiante "+gestion.mostrarEstudianteLoggeado(entradas[0]));
				acciones.activar("opciones estudiante");
				acciones.activar("lista actividades estudiante");
				acciones.mostrar(gestion.mostrarDatosActividadesEstudianteActivas(entradas[0]),Acciones.LISTA_ACTIVIDADES_ESTUDIANTE);
			}else {
				acciones.mensaje("Usuario inexistente");
			}
			break;
		case Acciones.LOGGOUT_COORDINADOR:
			acciones.desactivar("opciones coordinador");
			acciones.desactivar("loggoutCoordinador");
			acciones.activar("inicio sesion");
			break;
		case Acciones.VOLVER:
			acciones.desactivar("lista materias");
			acciones.desactivar("lista docentes");
			acciones.desactivar("crear docentes");
			acciones.desactivar("crear materias");
			acciones.desactivar("lista docentes");
			acciones.activar("opciones coordinador");
			break;
		case Acciones.LISTA_DOCENTES:
			acciones.desactivar("loggoutCoordinador");
			acciones.desactivar("opciones coordinador");
			acciones.activar("lista docentes");
			acciones.mostrar(gestion.mostrarDatosDocentes(), Acciones.LISTA_DOCENTES);
			break;
		case Acciones.CREAR_DOCENTES:
			acciones.desactivar("loggoutCoordinador");
			acciones.desactivar("opciones coordinador");
			acciones.activar("crear docentes");
			break;
		case Acciones.REGISTRAR_DOCENTE:
			String entradasRegistroDocente[]=acciones.capturar(Acciones.REGISTRAR_DOCENTE);
			try {
				acciones.mensaje(gestion.crearDocente(entradasRegistroDocente));
			} catch (Exception e) {
				acciones.mensaje("Intente de nuevo");
				acciones.desactivar("crear docentes");
				acciones.activar("crear docentes");
			}
			break;
		case Acciones.ACTUALIZAR_DOCENTES:
			acciones.desactivar("loggoutCoordinador");
			acciones.desactivar("opciones coordinador");
			acciones.activar("actualizar docentes");
			acciones.mostrar(gestion.mostrarDatosDocentes(), Acciones.LISTA_DOCENTES);
			break;
		case Acciones.MODIFICARD:
			try {
				int posicion = Integer.parseInt(acciones.capturar(Acciones.MODIFICARD)[0]);
				String[][] captura = new String[1][7];
				captura[0][0] = gestion.getDocentes().get(posicion).getNombre();
				captura[0][1] = ""+gestion.getDocentes().get(posicion).getPrograma();
				captura[0][2]=  gestion.getDocentes().get(posicion).getUsuario();
				captura[0][3] = gestion.getDocentes().get(posicion).getContraseña();
				captura[0][4] = ""+gestion.getDocentes().get(posicion).getAñosExperiencia();
				captura[0][5] =	""+gestion.getDocentes().get(posicion).getCedula();
				captura[0][6] =	""+gestion.getDocentes().get(posicion).getArea();
				acciones.desactivar("loggoutCoordinador");
				acciones.desactivar("lista docentes");
				acciones.activar("modificarD");
				acciones.mostrar(captura, Acciones.MODIFICARD);
			} catch (Exception e) {
				acciones.mensaje("Seleccione un empleado");
			}
			break;
		case Acciones.MODIFICAR_DOCENTE:
			entradas = acciones.capturar(Acciones.MODIFICAR_DOCENTE);
			acciones.mensaje(gestion.modificarDocente(entradas));
			break;
		case Acciones.ELIMINAR_DOCENTES:
			acciones.mostrar(gestion.mostrarDatosDocentes(), Acciones.LISTA_DOCENTES);
			acciones.desactivar("opciones coordinador");
			acciones.desactivar("loggoutCoordinador");
			acciones.activar("eliminar docentes");
			break;
		case Acciones.ELIMINARD:
			acciones.desactivar("loggoutCoordinador");
			acciones.mensaje(gestion.eliminarDocente(acciones.capturar(Acciones.ELIMINAR_DOCENTES)[0]));
			acciones.desactivar("lista docentes");
			acciones.mostrar(gestion.mostrarDatosDocentes(), Acciones.LISTA_DOCENTES);
			acciones.activar("eliminar docentes");
			break;
		case Acciones.LISTA_MATERIAS:
			acciones.desactivar("loggoutCoordinador");
			acciones.desactivar("opciones coordinador");
			acciones.activar("lista materias");
			acciones.mostrar(gestion.mostrarDatosMaterias(), Acciones.LISTA_MATERIAS);
			break;
		case Acciones.CREAR_MATERIAS:
			acciones.desactivar("loggoutCoordinador");
			acciones.desactivar("opciones coordinador");
			acciones.activar("crear materias");
			break;
		case Acciones.DOCENTE:
			acciones.desactivar("loggoutCoordinador");
			acciones.desactivar("crear materias");
			acciones.activar("docente");
			acciones.mostrar(gestion.mostrarDatosDocentes(), Acciones.DOCENTE);
			break;
		case Acciones.SELECCION_DOCENTE:
			acciones.metodoExtra(Acciones.SELECCION_DOCENTE);
			acciones.desactivar("docente");
			acciones.activar("crear materias");
			break;
		case Acciones.SELECCION_ESTUDIANTES:
			acciones.desactivar("crear materias");
			String datosDocente[]=acciones.metodoExtraRetorna(Acciones.SELECCION_ESTUDIANTES);
			String datosMateria[]=acciones.capturar(Acciones.SELECCION_ESTUDIANTES);
			try {
				codigoMateria=Integer.parseInt(datosMateria[0]);
				if(gestion.crearMateria(datosMateria, datosDocente,codigoMateria).equals("Por favor, añada los estudiantes a la materia que acaba de crear")){
					acciones.mensaje("Por favor, añada los estudiantes a la materia que acaba de crear");
					acciones.activar("lista estudiantes");
					acciones.mostrar(gestion.mostrarDatosEstudiantes(), Acciones.SELECCION_ESTUDIANTES);
				}else {
					acciones.mensaje(gestion.crearMateria(datosMateria, datosDocente,codigoMateria));
					acciones.activar("crear materias");
				}
			} catch (Exception e) {
				acciones.mensaje("Datos incompletos");
				acciones.activar("crear materias");
			}
			break;
		case Acciones.ESTUDIANTES_SELECCIONADOS:
			Estudiante[] estudiantes=acciones.listaEstudiantesSeleccionados();
			if(estudiantes.length!=0) {
				acciones.mensaje(gestion.asignarEstudiantesCorrespondientes(estudiantes, codigoMateria));
				acciones.mensaje("Estudiantes añadidos");
				acciones.desactivar("lista estudiantes");
				acciones.activar("crear materias");
			}else {
				acciones.mensaje("Ningun estudiante seleccionado");
				acciones.activar("lista estudiantes");
			}
			break;
		case Acciones.ACTUALIZAR_MATERIAS:
			acciones.desactivar("loggoutCoordinador");
			acciones.desactivar("opciones coordinador");
			acciones.activar("actualizar materias");
			acciones.mostrar(gestion.mostrarDatosMaterias(), Acciones.LISTA_MATERIAS);
			break;
		case Acciones.MODIFICARM:
			try {
				int posicionMateria = Integer.parseInt(acciones.capturar(Acciones.MODIFICARM)[0]);
				String[][] captura = new String[1][6];
				captura[0][0]=""+gestion.getMaterias().get(posicionMateria).getCodigo();
				captura[0][1]=""+gestion.getMaterias().get(posicionMateria).getNombre();
				captura[0][2]=""+gestion.getMaterias().get(posicionMateria).getSemestre();
				captura[0][3]=""+gestion.getMaterias().get(posicionMateria).getCreditos();
			//	captura[0][4]=""+gestion.getMaterias().get(posicionMateria).getDocente().getCedula();
				captura[0][4]=""+gestion.getMaterias().get(posicionMateria).getPrograma();
				acciones.desactivar("loggoutCoordinador");
				acciones.desactivar("lista materias");
				acciones.activar("modificarM");
				acciones.mostrar(captura, Acciones.MODIFICARM);
			} catch (Exception e) {
				acciones.mensaje("Seleccione una materia");
			}
			break;
		case Acciones.MODIFICAR_MATERIA:
			String datosMateriaD[]=acciones.capturar(Acciones.MODIFICAR_MATERIA);
			if(gestion.modificarMateria(datosMateriaD).equals("Datos incompletos")) {
				acciones.mensaje("Datos incompletos");
				acciones.activar("modificarM");
			}else {
				acciones.mensaje("Materia actualizada correctamente");
				acciones.desactivar("modificarM");
				acciones.desactivar("lista materias");
				acciones.desactivar("crear materias");
				acciones.activar("opciones coordinador");
			}
			break;
		case Acciones.VOLVER_DOCENTE_LISTA_MATERIAS:
			acciones.desactivar("asignar");
			acciones.activar("opciones docente");
			acciones.activar("lista materias docente");
			break;
		case Acciones.LISTA_MATERIAS_DOCENTE:
			acciones.desactivar("asignar actividades");
			acciones.desactivar("calificar actividades");
			acciones.activar("lista materias docente");
			acciones.mostrar(gestion.mostrarDatosMateriasDocente(cedulaDocente),Acciones.LISTA_MATERIAS_DOCENTE );
			break;
		case Acciones.ASIGNAR_ACTIVIDADES:
			acciones.desactivar("calificar actividades");
			acciones.desactivar("lista materias docente");
			acciones.activar("asignar actividades");
			acciones.mostrar(gestion.mostrarDatosMateriasDocente(cedulaDocente),Acciones.LISTA_MATERIAS_DOCENTE );
			break;
		case Acciones.SELECCIONAR_MATERIA:
			acciones.desactivar("loggoutDocente");
			try {
				String[] codigoMateriaR=acciones.metodoExtraRetorna(Acciones.SELECCIONAR_MATERIA);
				codigoMateriaActividad=Integer.parseInt(codigoMateriaR[0]);
				acciones.desactivar("lista materias docente");
				acciones.desactivar("opciones docente");
				acciones.activar("asignar");
			} catch (Exception e) {
				acciones.mensaje("Seleccione una materia");
			}
			break;
		case Acciones.ASIGNAR:
			String[] datosActividad=acciones.capturar(Acciones.ASIGNAR);
			if(gestion.asignarActividad(codigoMateriaActividad, datosActividad).equals("Actividad asignada con exito")) {
				acciones.mensaje("Actividad asignada con exito");
				acciones.desactivar("asignar");
				acciones.activar("opciones docente");
				acciones.activar("lista materias docente");
			}else {
				acciones.mensaje(gestion.asignarActividad(codigoMateriaActividad, datosActividad));
				acciones.desactivar("asignar");
				acciones.activar("opciones docente");
				acciones.activar("lista materias docente");
			}
			break;
		case Acciones.VOLVER_CALIFICAR_ACTIVIDADES:
			acciones.desactivar("calificar estudiante seleccionado");
			acciones.activar("calificar actividades");
			acciones.activar("opciones docente");
			acciones.activar("loggoutDocente");
			break;
		case Acciones.CALIFICAR_ACTIVIDADES:
			acciones.desactivar("lista materias docente");
			acciones.desactivar("asignar");
			acciones.activar("calificar actividades");
			acciones.mostrar(gestion.mostrarEstudiantesCalificar(cedulaDocente),Acciones.CALIFICAR_ACTIVIDADES);
			break;
		case Acciones.CALIFICAR_ESTUDIANTE_SELECCIONADO:
			String[] codigoEstudianteS=acciones.metodoExtraRetorna(Acciones.CALIFICAR_ESTUDIANTE_SELECCIONADO);
			codigoEstudiante=Integer.parseInt(codigoEstudianteS[0]);
			codigoMateriaCalificarEstudiante=Integer.parseInt(codigoEstudianteS[1]);
			acciones.desactivar("calificar actividades");
			acciones.desactivar("lista materias docente");
			acciones.desactivar("opciones docente");
			acciones.desactivar("loggoutDocente");
			acciones.desactivar("asignar");
			acciones.activar("calificar estudiante seleccionado");
			acciones.mostrar(gestion.mostrarActividadesEstudianteSeleccionado(codigoEstudiante, codigoMateriaCalificarEstudiante), Acciones.CALIFICAR_ESTUDIANTE_SELECCIONADO);
			break;
		case Acciones.CALIFICAR_ACTIVIDAD_SELECCIONADA:
			acciones.desactivar("calificar estudiante seleccionado");
			acciones.activar("calificar actividad seleccionada");
			String[] codigoActividadString=acciones.metodoExtraRetorna(Acciones.CALIFICAR_ACTIVIDAD_SELECCIONADA);
			codigoActividadDocente=Integer.parseInt(codigoActividadString[0]);
			acciones.mostrar(gestion.mostrarDatosRespuestaEstudiante(codigoMateriaCalificarEstudiante, codigoEstudiante, codigoActividadDocente), Acciones.CALIFICAR_ACTIVIDAD_SELECCIONADA);
			break;
		case Acciones.SUBIR_NOTA_ACTIVIDAD_SELECCIONADA:
			String[] notaS=acciones.capturar(Acciones.SUBIR_NOTA_ACTIVIDAD_SELECCIONADA);
			try {
				int nota=Integer.parseInt(notaS[0]);
				if(nota>=0&&nota<=50) {
					acciones.mensaje(gestion.asignarNotaActividad(codigoMateriaCalificarEstudiante, codigoEstudiante, codigoActividadDocente, nota));
				}else {
					acciones.mensaje("Por favor, digite una nota valida");
					acciones.desactivar("calificar actividad seleccionada");
					acciones.activar("calificar estudiante seleccionado");
				}
			} catch (Exception e) {
				acciones.mensaje("Por favor, digite una nota valida");
				acciones.desactivar("calificar actividad seleccionada");
				acciones.activar("calificar estudiante seleccionado");
			}
			break;
		case Acciones.VOLVER_CALIFICAR_ACTIVIDAD_SELECCIONADA:
			acciones.desactivar("calificar actividad seleccionada");
			acciones.activar("calificar estudiante seleccionado");
			break;
		case Acciones.LOGGOUT_DOCENTE:
			acciones.desactivar("lista materias docente");
			acciones.desactivar("opciones docente");
			acciones.desactivar("calificar actividades");
			acciones.desactivar("loggoutDocente");
			acciones.mensaje("Saliendo");
			acciones.activar("inicio sesion");
			break;
		case Acciones.LOGGOUT_ESTUDIANTE:
			acciones.desactivar("lista actividades estudiante");
			acciones.desactivar("historial actividades");
			acciones.desactivar("promedio acumulado");
			acciones.desactivar("opciones estudiante");
			acciones.desactivar("loggoutEstudiante");
			acciones.mensaje("Saliendo");
			acciones.activar("inicio sesion");
			break;
		case Acciones.LISTA_ACTIVIDADES_ESTUDIANTE:
			acciones.desactivar("historial actividades");
			acciones.desactivar("promedio acumulado");
			acciones.activar("lista actividades estudiante");
			acciones.mostrar(gestion.mostrarDatosActividadesEstudianteActivas(usuarioEstudiante),Acciones.LISTA_ACTIVIDADES_ESTUDIANTE);
			break;
		case Acciones.VOLVER_LISTA_ACTIVIDADES:
			acciones.desactivar("subir respuesta");
			acciones.activar("opciones estudiante");
			acciones.activar("lista actividades estudiante");
			acciones.mostrar(gestion.mostrarDatosActividadesEstudianteActivas(usuarioEstudiante),Acciones.LISTA_ACTIVIDADES_ESTUDIANTE);
			acciones.activar("loggoutEstudiante");
			break;
		case Acciones.SELECCION_ACTIVIDAD_RESPONDER:
			try {
				String[] codigoActividadyCodigoMateria=acciones.metodoExtraRetorna(Acciones.SELECCION_ACTIVIDAD_RESPONDER);
				codigoMateriaParaestudiante=Integer.parseInt(codigoActividadyCodigoMateria[1]);
				codigoActividad=Integer.parseInt(codigoActividadyCodigoMateria[0]);
				acciones.desactivar("loggoutEstudiante");
				acciones.desactivar("lista actividades estudiante");
				acciones.desactivar("opciones estudiante");
				acciones.activar("subir respuesta");
				acciones.mostrar(gestion.mostrarDescripcionActividad(codigoMateriaParaestudiante, usuarioEstudiante, codigoActividad), Acciones.SELECCION_ACTIVIDAD_RESPONDER);
			} catch (Exception e) {
				acciones.mensaje("Seleccione una actividad");
			}
			break;
		case Acciones.SUBIR_RESPUESTA:
			String respuesta[]=acciones.capturar(Acciones.SUBIR_RESPUESTA);
			System.out.println(respuesta[0]);
			acciones.mensaje(gestion.responderActividad(codigoMateriaParaestudiante, usuarioEstudiante, codigoActividad, respuesta));
			acciones.desactivar("subir respuesta");
			acciones.activar("opciones estudiante");
			acciones.activar("lista actividades estudiante");
			break;
		case Acciones.HISTORIAL_ACTIVIDADES:
			acciones.desactivar("lista actividades estudiante");
			acciones.desactivar("promedio acumulado");
			acciones.activar("historial actividades");
			acciones.mostrar(gestion.mostrarDatosActividadesEstudiantesConNota(usuarioEstudiante), Acciones.HISTORIAL_ACTIVIDADES);
			break;
		case Acciones.PROMEDIO_ACUMULADO:
			acciones.mensaje(gestion.promedioAcumulado(usuarioEstudiante));
			break;
		case Acciones.CERRAR:
			codigoMateria=0;
			codigoMateriaActividad=0;
			cedulaDocente=0;
			usuarioEstudiante="";
			codigoMateriaParaestudiante=0;
			codigoActividad=0;
			cargarMaterias();
			cargarDocentes();
			System.exit(0);
			break;
		default:
			break;
		}
	}
	public void cargarMaterias() {
		persistencia.cargarMaterias(gestion.getMaterias());
	}
	public void descargarMaterias() {
		gestion.setMaterias(persistencia.descargarMaterias());
	}
	public void cargarDocentes() {
		persistencia.cargarDocentes(gestion.getDocentes());
	}
	public void descargarDocentes() {
		gestion.setDocentes(persistencia.descargarDocentes());
	}
	public void cargarEstudiantes() {
		persistencia.cargarEstudiantes(gestion.getEstudiantes());
	}
}
