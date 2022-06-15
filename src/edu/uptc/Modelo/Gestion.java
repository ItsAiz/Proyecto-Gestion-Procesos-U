package edu.uptc.Modelo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

import javax.crypto.spec.PSource;



public class Gestion {
	@SuppressWarnings("unused")
	private Coordinador coordinador;
	private ArrayList<Materia> materias;
	private ArrayList<Docente> docentes;
	private ArrayList<Estudiante> estudiantes;
	public Gestion() {
		this.materias=new ArrayList<Materia>();
		this.coordinador=new Coordinador();
		this.docentes=new ArrayList<Docente>();
		this.estudiantes=new ArrayList<Estudiante>();
		inicializarEstudiantes();
	}
	public String mostrarDocenteLoggeado(String usuario) {
		for (int i = 0; i < docentes.size(); i++) {
			if (docentes.get(i).getUsuario().equals(usuario)) {
				return docentes.get(i).getNombre() ;
			}
		}
		return null;
	}
	public String mostrarEstudianteLoggeado(String usuario) {
		String nombre="";
		ArrayList<Integer> posiciones= buscarPosicionesMateriasPorUsuarioEstudiante(usuario);
		for (int i = 0; i < materias.get(posiciones.get(0)).getEstudiantes().size(); i++) {
			if(materias.get(posiciones.get(0)).getEstudiantes().get(i).getUsuario().equals(usuario)) {
				nombre+=materias.get(posiciones.get(0)).getEstudiantes().get(i).getNombre();
			}
		}
		return nombre;
	}
	public boolean verificarCoordinador(String usuario,String contraseña) {
		if(usuario.equals(coordinador.getUsuario())&& contraseña.equals(coordinador.getContraseña())) {
			return true;
		}else {
			return false;
		}
	}
	public boolean verificarDocente(String usuario,String contraseña) {
		int posi=-1;
		for (int i = 0; i < docentes.size(); i++) {
			if(usuario.equals(docentes.get(i).getUsuario())&& contraseña.equals(docentes.get(i).getContraseña())) {
				posi+=1;
				posi+=i;
				break;
			}
		}
		if(posi!=-1) {
			return true;
		}else {
			return false;
		}
	}
	public boolean verificarEstudiante(String usuario) {
		ArrayList<Integer> posiciones=buscarPosicionesMateriasPorUsuarioEstudiante(usuario);
		if(posiciones.isEmpty()) {
			return false;
		}else {
			return true;
		}
	}
	public int buscarPosicionDocentePorCedula(int cedula) {
		int posi=-1;
		for (int i = 0; i < docentes.size(); i++) {
			if(cedula==docentes.get(i).getCedula()) {
				posi+=1;
				posi+=i;
				break;
			}
		}
		if(posi!=-1) {
			return posi;
		}else {
			return -1;
		}
	}
	public int buscarPosicionDocentePorUsuario(String usuario) {
		int posi=-1;
		for (int i = 0; i < docentes.size(); i++) {
			if(usuario.equals(docentes.get(i).getUsuario())) {
				posi+=1;
				posi+=i;
				break;
			}
		}
		if(posi!=-1) {
			return posi;
		}else {
			return -1;
		}
	}
	public void inicializarEstudiantes() {
		Estudiante estudiante=new Estudiante("Jose", Programa.INGENIERIA_ELECTRÓNICA, "a","2", "nose@nose.com", 2, 321);
		estudiantes.add(estudiante);
		estudiante=new Estudiante("Antonio", Programa.ADMINISTRACIÓN_EMPRESAS, "b","2", "noseD@nose.com", 5, 322);
		estudiantes.add(estudiante);
		estudiante=new Estudiante("Ivan", Programa.INGENIERIA_MINAS, "c","2", "noseT@nose.com", 3, 201911876);
		estudiantes.add(estudiante);
	}
	public String modificarDocente(String[] entradas) {
		int posicion = buscarPosicionDocentePorCedula(Integer.parseInt(entradas[5]));
		int añosExperiencia=0;
		if (posicion != -1) {
			añosExperiencia=calcularAñosExperiencia(entradas[4]);
			docentes.get(posicion).setNombre(entradas[0]);
			docentes.get(posicion).setPrograma(Programa.valueOf(entradas[1]));
			docentes.get(posicion).setUsuario(entradas[2]);
			docentes.get(posicion).setContraseña(entradas[3]);
			docentes.get(posicion).setAñosExperiencia(añosExperiencia);
			docentes.get(posicion).setArea(Area.valueOf(entradas[6]));
			return "Docente modificado con exito";
		} else {
			return "Error al modificar el Docente";
		}
	}
	public String modificarMateria( String[] datosMateria) {
		int posicionMateria=buscarPosicionMateria(Integer.parseInt(datosMateria[0]));
		if(datosMateria.length==5) {
			materias.get(posicionMateria).setNombre(Area.valueOf(datosMateria[1]));
			materias.get(posicionMateria).setSemestre(Integer.parseInt(datosMateria[2]));
			materias.get(posicionMateria).setCreditos(Integer.parseInt(datosMateria[3]));
			materias.get(posicionMateria).setPrograma(Programa.valueOf(datosMateria[4]));
			return "Materia actualizada";
		}else {
			return "Datos incompletos";
		}
	}
	public String[][] mostrarDatosDocentes() {
		String[][] datos = new String[docentes.size()][100];
		for (int i = 0; i <docentes.size(); i++) {
			datos[i][0] = docentes.get(i).getNombre();
			datos[i][1] = ""+docentes.get(i).getPrograma();
			datos[i][2] = docentes.get(i).getUsuario();
			datos[i][3] = docentes.get(i).getContraseña();
			datos[i][4] = ""+docentes.get(i).getAñosExperiencia();
			datos[i][5] = ""+docentes.get(i).getCedula();
			datos[i][6] = ""+docentes.get(i).getArea();
		}
		return datos;
	}
	public String[][] mostrarDatosMaterias() {
		String[][] datos = new String[materias.size()][100];
		for (int i = 0; i <materias.size(); i++) {
			datos[i][0] = ""+materias.get(i).getCodigo();
			datos[i][1] = ""+materias.get(i).getNombre();
			datos[i][2] = ""+materias.get(i).getSemestre();
			datos[i][3] = ""+materias.get(i).getCreditos();
			datos[i][4] = ""+materias.get(i).getDocente().getCedula();
			datos[i][5] = ""+materias.get(i).getPrograma();
		}
		return datos;
	}
	/*public ArrayList<Integer> posicionMateriaporDocente(int cedula) {
		ArrayList<Integer> listaPosiciones=new ArrayList<Integer>();
		int posi=-1;
		for (int i = 0; i < materias.size(); i++) {
			if(materias.get(i).getDocente().getCedula()==cedula) {
				posi+=1;
				posi+=i;
				if(posi!=-1) {
					listaPosiciones.add(posi);
					posi=-1;
				}
			}
		}
		return listaPosiciones;
	}*/
	public String[][] mostrarDatosMateriasDocente(int cedula) {
		String[][] datos = new String[materias.size()][5];
		for (int i = 0; i <materias.size(); i++) {
			if(materias.get(i).getDocente().getCedula()==cedula) {
				datos[i][0] = ""+materias.get(i).getCodigo();
				datos[i][1] = ""+materias.get(i).getNombre();
				datos[i][2] = ""+materias.get(i).getSemestre();
				datos[i][3] = ""+materias.get(i).getCreditos();
				datos[i][4] = ""+materias.get(i).getPrograma();
			}
		}
		return datos;
	}
	public ArrayList<Integer> buscarPosicionesEstudianteCorrespondiente(ArrayList<Integer> posicionesMaterias, String usuario) {
		ArrayList<Integer> posicionesEstudianteEnMaterias=new ArrayList<Integer>();
		for (int i = 0; i < posicionesMaterias.size(); i++) {
			for (int j = 0; j < materias.get(i).getEstudiantes().size(); j++) {
				if(materias.get(i).getEstudiantes().get(j).getUsuario().equals(usuario)) {
					posicionesEstudianteEnMaterias.add(j);
				}
			}
		}
		return posicionesEstudianteEnMaterias;
	}
	public String[][] mostrarDatosActividadesEstudianteActivas(String usuario) {
		ArrayList<Integer> posicionesMateria= buscarPosicionesMateriasPorUsuarioEstudiante(usuario);
		ArrayList<Integer> posicionesEstudianteEnMaterias=buscarPosicionesEstudianteCorrespondiente(posicionesMateria, usuario);
		int cantidadFilas=0;
		for (int i = 0; i <posicionesMateria.size(); i++) {
			cantidadFilas+=materias.get(posicionesMateria.get(i)).getEstudiantes().get(posicionesEstudianteEnMaterias.get(i)).getActividades().size();
		}
		SimpleDateFormat simpleDateFormat= new SimpleDateFormat("dd/MM/yyyy");
		Date fechaplazo=new Date();
		String datos[][]=new String[cantidadFilas][4];
		int fila=0;
		for (int i = 0; i < posicionesMateria.size(); i++) {
			for (int j = 0; j < materias.get(posicionesMateria.get(i)).getEstudiantes().get(posicionesEstudianteEnMaterias.get(i)).getActividades().size(); j++) {
				if(materias.get(posicionesMateria.get(i)).getEstudiantes().get(posicionesEstudianteEnMaterias.get(i)).getActividades().get(j).estadoActividad()) {
					datos[fila][0]=""+materias.get(posicionesMateria.get(i)).getEstudiantes().get(posicionesEstudianteEnMaterias.get(i)).getActividades().get(j).getCodigo();
					datos[fila][1]=materias.get(posicionesMateria.get(i)).getEstudiantes().get(posicionesEstudianteEnMaterias.get(i)).getActividades().get(j).getNombre();
					fechaplazo=materias.get(posicionesMateria.get(i)).getEstudiantes().get(posicionesEstudianteEnMaterias.get(i)).getActividades().get(j).getFechaEntrega();
					String fechaf=simpleDateFormat.format(fechaplazo);
					datos[fila][2]=fechaf;
					datos[fila][3]=""+materias.get(posicionesMateria.get(i)).getCodigo();
					fila++;
				}
			}
		}
		return datos;
	}
	public String[][] mostrarDatosActividadesEstudiantesConNota(String usuario) {
		ArrayList<Integer> posicionesMateria= buscarPosicionesMateriasPorUsuarioEstudiante(usuario);
		ArrayList<Integer> posicionesEstudianteEnMaterias=buscarPosicionesEstudianteCorrespondiente(posicionesMateria, usuario);
		int cantidadFilas=0;
		for (int i = 0; i <posicionesMateria.size(); i++) {
			cantidadFilas+=materias.get(posicionesMateria.get(i)).getEstudiantes().get(posicionesEstudianteEnMaterias.get(i)).getActividades().size();
		}
		SimpleDateFormat simpleDateFormat= new SimpleDateFormat("dd/MM/yyyy");
		Date fechaplazo=new Date();
		String datos[][]=new String[cantidadFilas][6];
		int fila=0;
		for (int i = 0; i < posicionesMateria.size(); i++) {
			for (int j = 0; j < materias.get(posicionesMateria.get(i)).getEstudiantes().get(posicionesEstudianteEnMaterias.get(i)).getActividades().size(); j++) {
				datos[fila][0]=""+materias.get(posicionesMateria.get(i)).getEstudiantes().get(posicionesEstudianteEnMaterias.get(i)).getActividades().get(j).getCodigo();
				datos[fila][1]=materias.get(posicionesMateria.get(i)).getEstudiantes().get(posicionesEstudianteEnMaterias.get(i)).getActividades().get(j).getNombre();
				fechaplazo=materias.get(posicionesMateria.get(i)).getEstudiantes().get(posicionesEstudianteEnMaterias.get(i)).getActividades().get(j).getFechaEntrega();
				String fechaf=simpleDateFormat.format(fechaplazo);
				datos[fila][2]=fechaf;
				datos[fila][3]=""+materias.get(posicionesMateria.get(i)).getCodigo();
				datos[fila][4]=""+materias.get(posicionesMateria.get(i)).getEstudiantes().get(posicionesEstudianteEnMaterias.get(i)).getActividades().get(j).getNota();
				datos[fila][5]=""+materias.get(posicionesMateria.get(i)).getEstudiantes().get(posicionesEstudianteEnMaterias.get(i)).getActividades().get(j).getPorcentaje();
				fila++;
			}
		}
		return datos;
	}
	
	public String[][] mostrarDescripcionActividad(int codigoMateria,String usuario, int codigoActividad){
		int posicionMateria=buscarPosicionMateria(codigoMateria);
		int posicionEstudiante=buscarPosicionEstudiante(posicionMateria,usuario);
		int posicionActividad=buscarPosicionActividadResponder(posicionMateria, posicionEstudiante, codigoActividad);
		String[][] descripcion=new String[2][1];
		descripcion[0][0]=materias.get(posicionMateria).getEstudiantes().get(posicionEstudiante).getActividades().get(posicionActividad).getDescripcion();
		descripcion[1][0]=materias.get(posicionMateria).getEstudiantes().get(posicionEstudiante).getActividades().get(posicionActividad).getRespuesta();
		return descripcion;
	}
	public String[][] mostrarDatosRespuestaEstudiante(int codigoMateria,int codigoEstudiante, int codigoActividad){
		int posicionMateria=buscarPosicionMateria(codigoMateria);
		int posicionEstudiante=buscarPosicionEstudiantePorCodigo(posicionMateria, codigoEstudiante);
		int posicionActividad=buscarPosicionActividadResponder(posicionMateria, posicionEstudiante, codigoActividad);
		String[][] descripcion=new String[2][1];
		descripcion[0][0]=materias.get(posicionMateria).getEstudiantes().get(posicionEstudiante).getActividades().get(posicionActividad).getDescripcion();
		descripcion[1][0]=materias.get(posicionMateria).getEstudiantes().get(posicionEstudiante).getActividades().get(posicionActividad).getRespuesta();
		return descripcion;
	}
	public String[][] mostrarEstudiantesCalificar(int cedula){
		int cantidadFilas=0;
		ArrayList<Integer> posicionesMateriasDocente=buscarPosicionesMateriasPorCedulaDocente(cedula);
		for (int i = 0; i < posicionesMateriasDocente.size(); i++) {
			cantidadFilas+=materias.get(posicionesMateriasDocente.get(i)).getEstudiantes().size();
		}
		String[][] datos = new String[cantidadFilas][9];
		int fila=0;
		for (int i = 0; i < posicionesMateriasDocente.size(); i++) {
			for (int j = 0; j < materias.get(posicionesMateriasDocente.get(i)).getEstudiantes().size(); j++) {
				datos[fila][0]=materias.get(posicionesMateriasDocente.get(i)).getEstudiantes().get(j).getNombre();
				datos[fila][1]=""+materias.get(posicionesMateriasDocente.get(i)).getEstudiantes().get(j).getPrograma();
				datos[fila][2]=materias.get(posicionesMateriasDocente.get(i)).getEstudiantes().get(j).getUsuario();
				datos[fila][3]=materias.get(posicionesMateriasDocente.get(i)).getEstudiantes().get(j).getContraseña();
				datos[fila][4]=materias.get(posicionesMateriasDocente.get(i)).getEstudiantes().get(j).getCorreo();
				datos[fila][5]=""+materias.get(posicionesMateriasDocente.get(i)).getEstudiantes().get(j).getSemestre();
				datos[fila][6]=""+materias.get(posicionesMateriasDocente.get(i)).getEstudiantes().get(j).getCodigo();
				datos[fila][7]=""+materias.get(posicionesMateriasDocente.get(i)).getNombre();
				datos[fila][8]=""+materias.get(posicionesMateriasDocente.get(i)).getCodigo();
				fila++;
			}
		}
		return datos;
	}
	public String[][] mostrarActividadesEstudianteSeleccionado(int codigoEstudiante,int codigoMateria){
		int cantidadFilas=0;
		int posicionMateria=buscarPosicionMateria(codigoMateria);
		int posicionEstudiante=buscarPosicionEstudiantePorCodigo(posicionMateria, codigoEstudiante);
		int filas=0;
		Date fechaplazo=new Date();
		SimpleDateFormat simpleDateFormat= new SimpleDateFormat("dd/MM/yyyy");
		cantidadFilas+=materias.get(posicionMateria).getEstudiantes().get(posicionEstudiante).getActividades().size();
		String[][] datos=new String[cantidadFilas][4];
		for (int i = 0; i <materias.get(posicionMateria).getEstudiantes().get(posicionEstudiante).getActividades().size(); i++) {
			datos[filas][0]=""+materias.get(posicionMateria).getEstudiantes().get(posicionEstudiante).getActividades().get(i).getCodigo();
			datos[filas][1]=materias.get(posicionMateria).getEstudiantes().get(posicionEstudiante).getActividades().get(i).getNombre();
			fechaplazo=materias.get(posicionMateria).getEstudiantes().get(posicionEstudiante).getActividades().get(i).getFechaEntrega();
			String fechaEntrega=simpleDateFormat.format(fechaplazo);
			datos[filas][2]=fechaEntrega;
			datos[filas][3]=""+codigoMateria;
			filas++;
		}
		return datos;
		
	}
	public String asignarNotaActividad(int codigoMateria,int codigoEstudiante, int codigoActividad, int nota) {
		int posicionMateria=buscarPosicionMateria(codigoMateria);
		int posicionEstudiante=buscarPosicionEstudiantePorCodigo(posicionMateria, codigoEstudiante);
		int posicionActividad=buscarPosicionActividadResponder(posicionMateria, posicionEstudiante, codigoActividad);
		materias.get(posicionMateria).getEstudiantes().get(posicionEstudiante).getActividades().get(posicionActividad).setNota(nota);
		return "Actividad calificada";
	}
	public String responderActividad(int codigoMateria,String usuario,int codigoActividad, String[] respuesta) {
		if(respuesta[0]!=null) {
			int posicionMateria=buscarPosicionMateria(codigoMateria);
			int posicionEstudiante=buscarPosicionEstudiante(posicionMateria,usuario);
			int posicionActividad=buscarPosicionActividadResponder(posicionMateria, posicionEstudiante, codigoActividad);
			materias.get(posicionMateria).getEstudiantes().get(posicionEstudiante).getActividades().get(posicionActividad).setRespuesta(respuesta[0]);
			return "Respuesta guardada con éxito";
		}else {
			return "Digite su respuesta";
		}
	}
	public String promedioAcumulado(String usuario) {
		ArrayList<Integer> posicionesMateria= buscarPosicionesMateriasPorUsuarioEstudiante(usuario);
		ArrayList<Integer> posicionesEstudianteEnMaterias=buscarPosicionesEstudianteCorrespondiente(posicionesMateria, usuario);
		int notasMaterias=0;
		int creditos=0;
		for (int i = 0; i < posicionesMateria.size(); i++) {
			for (int j = 0; j < materias.get(posicionesMateria.get(i)).getEstudiantes().get(posicionesEstudianteEnMaterias.get(i)).getActividades().size(); j++) {
				notasMaterias+=((materias.get(posicionesMateria.get(i)).getEstudiantes().get(posicionesEstudianteEnMaterias.get(i)).getActividades().get(j).getNota())*((materias.get(posicionesMateria.get(i)).getEstudiantes().get(posicionesEstudianteEnMaterias.get(i)).getActividades().get(j).getPorcentaje())/100));
				creditos+=materias.get(posicionesMateria.get(i)).getCreditos();
			}
		}
		int acumuladoF=(notasMaterias*creditos)/creditos;
		System.out.println(acumuladoF);
		return ""+acumuladoF;
	}
	public String[][] mostrarDatosEstudiantes() {
		String[][] datos = new String[estudiantes.size()][100];
		for (int i = 0; i <estudiantes.size(); i++) {
			datos[i][0] = estudiantes.get(i).getNombre();
			datos[i][1] = ""+estudiantes.get(i).getPrograma();
			datos[i][2] = estudiantes.get(i).getUsuario();
			datos[i][3] = estudiantes.get(i).getContraseña();
			datos[i][4] = estudiantes.get(i).getCorreo();
			datos[i][5] = ""+estudiantes.get(i).getSemestre();
			datos[i][6] = ""+estudiantes.get(i).getCodigo();
		}
		return datos;
	}
	public int calcularAñosExperiencia(String fechaExpedicion ) {
		int añosExperiencia=0;
		Date fechaExpedicionDate = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		try {
			fechaExpedicionDate = simpleDateFormat.parse(fechaExpedicion);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		añosExperiencia=Period.between(fechaExpedicionDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), LocalDate.now()).getYears();
		return añosExperiencia;
	}
	public String crearDocente(String[] entradasRegistroDocente) {
		int añosExperiencia=0;
		if(entradasRegistroDocente[0]!=null&& entradasRegistroDocente[1]!=null&&entradasRegistroDocente[2]!=null&&entradasRegistroDocente[3]!=null&&entradasRegistroDocente[4]!=null&&entradasRegistroDocente[5]!=null&&entradasRegistroDocente[6]!=null) {
			if(buscarPosicionMateria(Integer.parseInt(entradasRegistroDocente[5]))==-1) {
				Area area=Area.valueOf(entradasRegistroDocente[6]);
				añosExperiencia=calcularAñosExperiencia(entradasRegistroDocente[4]);
				Docente docente=new Docente(entradasRegistroDocente[0], Programa.valueOf(entradasRegistroDocente[1]), entradasRegistroDocente[2], entradasRegistroDocente[3], añosExperiencia, Integer.parseInt(entradasRegistroDocente[5]), area);
				docentes.add(docente);
				return "Docente creado con exito";
			}else {
				return "Ya existe un docente con esa cedula";
			}
		}else {
			return "Datos incompletos";
		}
		
	}
	public int buscarPosicionMateria(int codigo) {
		for (int i = 0; i < materias.size(); i++) {
			if (materias.get(i).getCodigo()==codigo) {
				return i;
			}
		}
		return -1;
	}
	public int buscarPosicionEstudiante(int posicionMateria, String usuario) {
		for (int j = 0; j < materias.get(posicionMateria).getEstudiantes().size(); j++) {
			if(materias.get(posicionMateria).getEstudiantes().get(j).getUsuario().equals(usuario)) {
				return j;
			}
		}
		return -1;
	}
	public int buscarPosicionEstudiantePorCodigo(int posicionMateria, int codigo) {
		for (int j = 0; j < materias.get(posicionMateria).getEstudiantes().size(); j++) {
			if(materias.get(posicionMateria).getEstudiantes().get(j).getCodigo()==codigo) {
				return j;
			}
		}
		return -1;
	}
	public int buscarPosicionActividadResponder(int posicionMateria, int posicionEstudiante,int codigoActividad) {
		for (int j = 0; j < materias.get(posicionMateria).getEstudiantes().get(posicionEstudiante).getActividades().size(); j++) {
			if(materias.get(posicionMateria).getEstudiantes().get(posicionEstudiante).getActividades().get(j).getCodigo()==codigoActividad) {
				return j;
			}
		}
		return -1;
	}
	public ArrayList<Integer> buscarPosicionesMateriasPorUsuarioEstudiante(String usuario) {
		ArrayList<Integer> posiciones=new ArrayList<Integer>();
		for (int i = 0; i <materias.size(); i++) {
			for (int j = 0; j < materias.get(i).getEstudiantes().size(); j++) {
				if(materias.get(i).getEstudiantes().get(j).getUsuario().equals(usuario)) {
					posiciones.add(i);
				}
			}
		}
		return posiciones;
	}
	public ArrayList<Integer> buscarPosicionesMateriasPorCedulaDocente(int cedula) {
		ArrayList<Integer> posiciones=new ArrayList<Integer>();
		for (int i = 0; i <materias.size(); i++) {
			if(materias.get(i).getDocente().getCedula()==cedula) {
				posiciones.add(i);
			}
		}
		return posiciones;
	}
	public String asignarEstudiantesCorrespondientes(Estudiante[] estudiantes, int codigoMateria) {
		ArrayList<Estudiante> estudiantesList=new ArrayList<Estudiante>();
		ArrayList<Estudiante> finalLista=new ArrayList<Estudiante>();
		for (int i = 0; i < estudiantes.length; i++) {
			if(estudiantes[i]!=null) {
				estudiantesList.add(estudiantes[i]);
			}
		}
		int posicion=buscarPosicionMateria(codigoMateria);
		for (int i = 0; i < estudiantesList.size(); i++) {
			if(estudiantesList.get(i).getSemestre()>=materias.get(posicion).getSemestre()) {
				finalLista.add(estudiantesList.get(i));
			}
		}
		materias.get(posicion).setEstudiantes(finalLista);
		return "Hecho";
	}
	public String crearMateria(String[] datosMateria,String[] datosDocente,int codigo) {
		if(buscarPosicionMateria(codigo)==-1) {
			if(datosMateria.length==5) {
				Docente docente=new Docente(datosDocente[0], Programa.valueOf(datosDocente[1]), datosDocente[2], datosDocente[3], Integer.parseInt(datosDocente[4]),Integer.parseInt(datosDocente[5]), Area.valueOf(datosDocente[6]));
				Materia materia=new Materia(Integer.parseInt(datosMateria[0]),Area.valueOf(datosMateria[1]), Integer.parseInt(datosMateria[2]), Integer.parseInt(datosMateria[3]), docente, Programa.valueOf(datosMateria[4]));
				materias.add(materia);
				return "Por favor, añada los estudiantes a la materia que acaba de crear";
			}else {
				return "Datos incompletos";
			}
		}else {
			return "Ya existe una materia con el mismo código";
		}
	}
	public Date deStringADate(String fecha) {
		Date fechaNacimientoDate = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		try {
			fechaNacimientoDate = simpleDateFormat.parse(fecha);
		} catch (ParseException e) {
			e.getErrorOffset();
		}
		return fechaNacimientoDate;
	}
	public boolean verificarNoSuperePorciento(ArrayList<Actividad> actividades, int porcentaje) {
		int porcentajeAcumulado=0;
		for (int i = 0; i < actividades.size(); i++) {
			porcentajeAcumulado+=actividades.get(i).getPorcentaje();
		}
		if(porcentajeAcumulado+porcentaje<=100) {
			return true;
		}else {
			return false;
		}
	}
	public int buscarPosicionActividad(int codigoActividad,int posicionMateria ) {
		int posi=-1;
		for (int i = 0; i < materias.get(posicionMateria).getEstudiantes().size(); i++) {
			for (int j = 0; j < materias.get(posicionMateria).getEstudiantes().get(i).getActividades().size(); j++) {
				if(materias.get(posicionMateria).getEstudiantes().get(i).getActividades().get(j).getCodigo()==codigoActividad) {
					posi+=1;
					posi+=i;
					break;
				}
			}
		}
		return posi;
	}
	public String asignarActividad(int codigoMateriaDocente,String[] datosActividad) {
		Date fechaActividadInicial=deStringADate(datosActividad[3]);
		Date fechaActual=new Date();
		int posicionMateria=buscarPosicionMateria(codigoMateriaDocente);
			if(datosActividad.length==5) {
				if(fechaActividadInicial.after(fechaActual)) {
					if(buscarPosicionActividad(Integer.parseInt(datosActividad[0]), posicionMateria)==-1) {
						int porcentaje=Integer.parseInt(datosActividad[2]);
						if(verificarNoSuperePorciento(materias.get(posicionMateria).getEstudiantes().get(0).getActividades(),porcentaje)) {
							if(porcentaje<=100) {
								for (int i = 0; i < materias.get(posicionMateria).getEstudiantes().size(); i++) {
									Actividad actividad=new Actividad(Integer.parseInt(datosActividad[0]), datosActividad[1],porcentaje, 0, fechaActividadInicial,"", datosActividad[4]);
									materias.get(posicionMateria).getEstudiantes().get(i).getActividades().add(actividad);
									
								}
								return "Actividad asignada con exito";
							}else {
								return "Error, porcentaje por encima del 100%";
							}
						}else {
							return "Verifique los porcentajes de las actividades";
						}
					}else {
						return "Ya existe una actividad con ese código";
					}
				}else {
					return "Error, fecha incorrecta";
				}
			}else {
				return "Datos incompletos";
			}
	}
	public int buscarPosicion(int cedula) {
		for (int i = 0; i < docentes.size(); i++) {
			if (docentes.get(i).getCedula()==cedula) {
				return i;
			}
		}
		return -1;
	}
	public String eliminarDocente(String posicion) {
		if (Integer.parseInt(posicion) >= docentes.size()) {
			return "Docente Inexistente";
		} else {
			docentes.remove(Integer.parseInt(posicion));
			return "Docente eliminado con exito";
		}
	}
	public ArrayList<Docente> getDocentes() {
		return docentes;
	}
	public ArrayList<Materia> getMaterias() {
		return materias;
	}
	public void setMaterias(ArrayList<Materia> materias) {
		this.materias = materias;
	}
	public void setDocentes(ArrayList<Docente> docentes) {
		this.docentes = docentes;
	}
	public ArrayList<Estudiante> getEstudiantes() {
		return estudiantes;
	}
	public void setEstudiantes(ArrayList<Estudiante> estudiantes) {
		this.estudiantes = estudiantes;
	}
}
