package edu.uptc.Vista;

import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;

import edu.uptc.Control.Control;
import edu.uptc.Modelo.Area;
import edu.uptc.Modelo.Docente;
import edu.uptc.Modelo.Estudiante;
import edu.uptc.Modelo.Programa;
@SuppressWarnings("serial")
public class VentanaPrincipal extends JFrame implements Acciones {
	Fondo fondo=new Fondo();
	private JButton btnLoggoutAdmin;
	private JButton btnLoggoutDocente;
	private JButton btnLoggoutEstudiante;
	private JButton btnCerrar;
	private Panel_IniciarSesion panel_IniciarSesion;
	private PanelCoordinadorCRUDDocentes panelCoordinadorCRUDDocentes;
	private PanelCoordinadorListaDocentes panelCoordinadorListaDocentes;
	private PanelCoordinadorCrearDocentes panelCoordinadorCrearDocentes;
	private PanelCoordinadorCRUMaterias panelCoordinadorCRUMaterias;
	private PanelCoordinadorCrearMaterias panelCoordinadorCrearMaterias;
	private PanelCoordinadorDocentesSeleccionables panelCoordinadorDocentesSeleccionables;
	private PanelCoordinadorSeleccionEstudiantes panelCoordinadorSeleccionEstudiantes;
	private PanelCoordinadorListaMaterias panelCoordinadorListaMaterias;
	private PanelDocenteOpciones panelDocenteOpciones;
	private PanelDocenteListaMaterias panelDocenteListaMaterias;
	private PanelDocenteAsignarActividad panelDocenteAsignarActividad;
	private PanelOpcionesEstudiante panelOpcionesEstudiante;
	private PanelEstudianteListaActividades panelEstudianteListaActividades;
	private PanelEstudianteResponderActividad panelEstudianteResponderActividad;
	private PanelDocenteListaEstudiantes panelDocenteListaEstudiantes;
	private PanelDocenteActividadesEstudianteSeleccionado panelDocenteActividadesEstudianteSeleccionado;
	private PanelDocenteCalificarActividadEstudiante panelDocenteCalificarActividadEstudiante;
	private PanelEstudianteListaActividadesConNota panelEstudianteListaActividadesConNota;
	public VentanaPrincipal() {
		setContentPane(fondo);
		setResizable(false);
		setLayout(null);
		setSize(800,600);
		setLocation(200, 80);
		setTitle("Universidad NN");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		inicializar();
		caracteristicas();
		agregar();
	}
	private void inicializar() {
		btnLoggoutAdmin=new JButton("Loggout");
		btnLoggoutDocente=new JButton("Loggout");
		btnLoggoutEstudiante=new JButton("Loggout");
		btnCerrar=new JButton("Cerrar para guardar información");
		panel_IniciarSesion=new Panel_IniciarSesion();
		panelCoordinadorCRUDDocentes=new PanelCoordinadorCRUDDocentes();
		panelCoordinadorListaDocentes=new PanelCoordinadorListaDocentes();
		panelCoordinadorCrearDocentes=new PanelCoordinadorCrearDocentes();
		panelCoordinadorCRUMaterias=new PanelCoordinadorCRUMaterias();
		
		panelCoordinadorCrearMaterias=new PanelCoordinadorCrearMaterias();
		panelCoordinadorDocentesSeleccionables=new PanelCoordinadorDocentesSeleccionables();
		panelCoordinadorListaMaterias=new PanelCoordinadorListaMaterias();
		panelCoordinadorSeleccionEstudiantes=new PanelCoordinadorSeleccionEstudiantes();
		
		panelDocenteOpciones=new PanelDocenteOpciones();
		panelDocenteListaMaterias=new PanelDocenteListaMaterias();
		panelDocenteAsignarActividad=new PanelDocenteAsignarActividad();
		panelDocenteListaEstudiantes=new PanelDocenteListaEstudiantes();
		panelDocenteActividadesEstudianteSeleccionado=new PanelDocenteActividadesEstudianteSeleccionado();
		panelDocenteCalificarActividadEstudiante=new PanelDocenteCalificarActividadEstudiante();
		
		panelOpcionesEstudiante=new PanelOpcionesEstudiante();
		panelEstudianteListaActividades=new PanelEstudianteListaActividades();
		panelEstudianteResponderActividad=new PanelEstudianteResponderActividad();
		panelEstudianteListaActividadesConNota=new PanelEstudianteListaActividadesConNota();
		
	}
	private void caracteristicas() {
		btnLoggoutAdmin.setBounds(10, 450, 100,27);
		btnLoggoutDocente.setBounds(10, 450, 100,27);
		btnLoggoutEstudiante.setBounds(10, 450, 100,27);
		btnCerrar.setBounds(500, 450, 100, 27);
		panel_IniciarSesion.setBounds(0,50,800, 455);
		panelCoordinadorCRUDDocentes.setBounds(10, 2 , 765, 250);
		panelCoordinadorListaDocentes.setBounds(10, 10, 770, 500);
		panelCoordinadorCrearDocentes.setBounds(20, 10, 770, 500);
		panelCoordinadorCRUMaterias.setBounds(10,250, 765, 200);
		panelCoordinadorCrearMaterias.setBounds(20, 10, 770, 500);
		panelCoordinadorDocentesSeleccionables.setBounds(10, 10, 770, 500);
		panelCoordinadorSeleccionEstudiantes.setBounds(10, 10, 770, 500);
		panelCoordinadorListaMaterias.setBounds(10, 10, 770, 500);
		panelDocenteOpciones.setBounds(17, 10, 754,50 );
		panelDocenteListaMaterias.setBounds(10, 10, 770, 500);
		panelDocenteAsignarActividad.setBounds(20, 10, 770, 500);
		panelDocenteListaEstudiantes.setBounds(10, 10, 770, 500);
		panelDocenteActividadesEstudianteSeleccionado.setBounds(10, 10, 770, 500);
		panelDocenteCalificarActividadEstudiante.setBounds(10, 10, 770, 500);
		panelOpcionesEstudiante.setBounds(17, 10, 754,50);
		panelEstudianteListaActividades.setBounds(10, 10, 770, 500);
		panelEstudianteResponderActividad.setBounds(10, 10, 770, 500);
		panelEstudianteListaActividadesConNota.setBounds(10, 10, 770, 500);
	}
	private void agregar() {
		add(panel_IniciarSesion);
		add(btnCerrar);
	}
	public void iniciarPrograma(Control control) {
		panel_IniciarSesion.asignarLister(control);
		panelCoordinadorCRUDDocentes.asignarListener(control);
		panelCoordinadorListaDocentes.asignarLister(control);
		panelCoordinadorCrearDocentes.asignarLister(control);
		panelCoordinadorCRUMaterias.asignarListener(control);
		panelCoordinadorCrearMaterias.asignarLister(control);
		panelCoordinadorDocentesSeleccionables.asignarLister(control);
		panelCoordinadorSeleccionEstudiantes.asignarLister(control);
		panelCoordinadorListaMaterias.asignarLister(control);	
		panelDocenteOpciones.asignarListener(control);
		panelDocenteListaMaterias.asignarLister(control);
		panelDocenteAsignarActividad.asignarLister(control);
		panelDocenteListaEstudiantes.asignarLister(control);
		panelDocenteActividadesEstudianteSeleccionado.asignarLister(control);
		panelDocenteCalificarActividadEstudiante.asignarListener(control);
		panelOpcionesEstudiante.asignarListener(control);
		panelEstudianteListaActividades.asignarLister(control);
		panelEstudianteResponderActividad.asignarListener(control);
		
		asingarListener(control);
		setVisible(true);
	}
	public void asingarListener(Control control) {
		btnLoggoutAdmin.setActionCommand(Acciones.LOGGOUT_COORDINADOR);
		btnLoggoutAdmin.addActionListener(control);
		
		btnLoggoutDocente.setActionCommand(Acciones.LOGGOUT_DOCENTE);
		btnLoggoutDocente.addActionListener(control);
		
		btnLoggoutEstudiante.setActionCommand(Acciones.LOGGOUT_ESTUDIANTE);
		btnLoggoutEstudiante.addActionListener(control);
		
		btnCerrar.setActionCommand(Acciones.CERRAR);
		btnCerrar.addActionListener(control);
		
	}
	@Override
	public void activar(String seccion) {
		if(seccion.equals("inicio sesion")) {
			add(panel_IniciarSesion);
			add(btnCerrar);
		}else if(seccion.equals("opciones coordinador")) {
			add(panelCoordinadorCRUDDocentes);
			add(panelCoordinadorCRUMaterias);
			add(btnLoggoutAdmin);
		}else if(seccion.equals("lista docentes")) {
			panelCoordinadorListaDocentes.getBtnEliminar().setEnabled(false);
			panelCoordinadorListaDocentes.getBtnModificar().setEnabled(false);
			add(panelCoordinadorListaDocentes);
		}else if(seccion.equals("crear docentes")) {
			panelCoordinadorCrearDocentes.getBtnRegistrar().setEnabled(true);
			panelCoordinadorCrearDocentes.getBtnModificar().setEnabled(false);
			panelCoordinadorCrearDocentes.getFieldCedula().setEnabled(true);
			add(panelCoordinadorCrearDocentes);
			TitledBorder border=new TitledBorder("Crear Docente");
			Color color=new Color(255, 255, 255, 255);
			border.setTitleColor(color);
			panelCoordinadorCrearDocentes.setBorder(border);
		}else if(seccion.equals("actualizar docentes")) {
			panelCoordinadorListaDocentes.getBtnEliminar().setEnabled(false);
			panelCoordinadorListaDocentes.getBtnModificar().setEnabled(true);
			add(panelCoordinadorListaDocentes);
		}else if(seccion.equals("modificarD")) {
			panelCoordinadorCrearDocentes.getBtnModificar().setEnabled(true);
			panelCoordinadorCrearDocentes.getBtnRegistrar().setEnabled(false);
			panelCoordinadorCrearDocentes.getFieldCedula().setEnabled(false);
			add(panelCoordinadorCrearDocentes);
			TitledBorder border=new TitledBorder("Modificar Docente");
			Color color=new Color(255, 255, 255, 255);
			border.setTitleColor(color);
			panelCoordinadorCrearDocentes.setBorder(border);
		}else if(seccion.equals("eliminar docentes")) {
			TitledBorder border=new TitledBorder("Eliminar empleado");
			Color color=new Color(255, 255, 255, 255);
			border.setTitleColor(color);
			panelCoordinadorListaDocentes.setBorder(border);
			panelCoordinadorListaDocentes.getBtnModificar().setEnabled(false);
			panelCoordinadorListaDocentes.getBtnEliminar().setEnabled(true);
			add(panelCoordinadorListaDocentes);
		}else if (seccion.equals("crear materias")) {
			add(panelCoordinadorCrearMaterias);
			TitledBorder border=new TitledBorder("Crear Materia");
			Color color=new Color(255, 255, 255, 255);
			border.setTitleColor(color);
			panelCoordinadorCrearMaterias.getBtnModificar().setEnabled(false);
			panelCoordinadorCrearMaterias.setBorder(border);
		}else if(seccion.equals("docente")) {
			add(panelCoordinadorDocentesSeleccionables);
			TitledBorder border=new TitledBorder("Docentes disponibles");
			Color color=new Color(255, 255, 255, 255);
			border.setTitleColor(color);
			panelCoordinadorDocentesSeleccionables.setBorder(border);
		}else if(seccion.equals("lista estudiantes")) {
			add(panelCoordinadorSeleccionEstudiantes);
			TitledBorder border=new TitledBorder("Lista Estudiantes");
			Color color=new Color(255, 255, 255, 255);
			panelCoordinadorSeleccionEstudiantes.setBorder(border);
		}else if(seccion.equals("lista materias")) {
			add(panelCoordinadorListaMaterias);
			TitledBorder border=new TitledBorder("Lista Materias");
			Color color=new Color(255, 255, 255, 255);
			panelCoordinadorListaMaterias.setBorder(border);
			panelCoordinadorListaMaterias.getBtnModificar().setEnabled(false);
		}else if(seccion.equals("actualizar materias")) {
			add(panelCoordinadorListaMaterias);
			panelCoordinadorListaMaterias.getBtnModificar().setEnabled(true);
			TitledBorder border=new TitledBorder("Lista Materias");
			Color color=new Color(255, 255, 255, 255);
			panelCoordinadorListaMaterias.setBorder(border);
		}else if(seccion.equals("modificarM")) {
			add(panelCoordinadorCrearMaterias);
			TitledBorder border=new TitledBorder("Modificar Docente");
			Color color=new Color(255, 255, 255, 255);
			border.setTitleColor(color);
			panelCoordinadorCrearMaterias.setBorder(border);
			panelCoordinadorCrearMaterias.getFieldCodigoMateria().setEnabled(false);
			panelCoordinadorCrearMaterias.getBtnSeleccionarEstudiantes().setEnabled(false);
			panelCoordinadorCrearMaterias.getBtnModificar().setEnabled(true);
			panelCoordinadorCrearMaterias.getBtnSeleccionarDocente().setEnabled(false);
		}else if(seccion.equals("opciones docente")) {
			add(panelDocenteOpciones);
			TitledBorder border=new TitledBorder("Opciones Docente");
			Color color=new Color(255, 255, 255, 255);
			panelDocenteOpciones.setBorder(border);
			add(btnLoggoutDocente);
		}else if(seccion.equals("lista materias docente")) {
			add(panelDocenteListaMaterias);
			panelDocenteListaMaterias.getBtnSeleccionarMateria().setEnabled(false);
		}else if(seccion.equals("asignar actividades")) {
			add(panelDocenteListaMaterias);
			panelDocenteListaMaterias.getBtnSeleccionarMateria().setEnabled(true);
		}else if(seccion.equals("asignar")) {
			add(panelDocenteAsignarActividad);
			TitledBorder border=new TitledBorder("Crear Actividad");
			Color color=new Color(255, 255, 255, 255);
			panelDocenteAsignarActividad.setBorder(border);
		}else if(seccion.equals("calificar actividades")) {
			add(panelDocenteListaEstudiantes);
		}else if(seccion.equals("calificar estudiante seleccionado")) {
			add(panelDocenteActividadesEstudianteSeleccionado);
		}else if(seccion.equals("calificar actividad seleccionada")) {
			add(panelDocenteCalificarActividadEstudiante);
		}else if(seccion.equals(Acciones.DOCENTE)) {
			panelCoordinadorCrearMaterias.getBtnModificar().setEnabled(true);
		}else if(seccion.equals("opciones estudiante")) {
			add(panelOpcionesEstudiante);
			add(btnLoggoutEstudiante);
		}else if(seccion.equals("lista actividades estudiante")) {
			add(panelEstudianteListaActividades);
			TitledBorder border=new TitledBorder("Actividades activas");
			Color color=new Color(255, 255, 255, 255);
			panelEstudianteListaActividades.setBorder(border);
		}else if(seccion.equals("subir respuesta")) {
			add(panelEstudianteResponderActividad);
			TitledBorder border=new TitledBorder("Responder Actividad");
			Color color=new Color(255, 255, 255, 255);
			panelEstudianteResponderActividad.setBorder(border);
		}else if(seccion.equals("historial actividades")) {
			add(panelEstudianteListaActividadesConNota);
		}
		repaint();
	}
	@Override
	public void desactivar(String seccion) {
		if(seccion.equals("inicio sesion")) {
			remove(panel_IniciarSesion);
			remove(btnCerrar);
		}else if(seccion.equals("opciones coordinador")) {
			remove(panelCoordinadorCRUDDocentes);
			remove(panelCoordinadorCRUMaterias);
		}else if(seccion.equals("lista docentes")) {
			remove(panelCoordinadorListaDocentes);
		}else if(seccion.equals("crear docentes")) {
			remove(panelCoordinadorCrearDocentes);
		}else if(seccion.equals("loggoutCoordinador")) {
			remove(btnLoggoutAdmin);
		}else if(seccion.equals("crear materias")) {
			remove(panelCoordinadorCrearMaterias);
		}else if(seccion.equals("docente")) {
			remove(panelCoordinadorDocentesSeleccionables);
		}else if(seccion.equals("lista estudiantes")) {
			remove(panelCoordinadorSeleccionEstudiantes);
		}else if(seccion.equals("lista materias")) {
			remove(panelCoordinadorListaMaterias);
		}else if(seccion.equals("lista materias docente")) {
			remove(panelDocenteListaMaterias);
		}else if(seccion.equals("opciones docente")) {
			remove(panelDocenteOpciones);
		}else if(seccion.equals("asignar")) {
			remove(panelDocenteAsignarActividad);
		}else if(seccion.equals("loggoutDocente")) {
			remove(btnLoggoutDocente);
		}else if(seccion.equals("opciones estudiante")) {
			remove(panelOpcionesEstudiante);
		}else if(seccion.equals("loggoutEstudiante")) {
			remove(btnLoggoutEstudiante);
		}else if(seccion.equals("lista actividades estudiante")) {
			remove(panelEstudianteListaActividades);
		}else if(seccion.equals("subir respuesta")) {
			remove(panelEstudianteResponderActividad);
		}else if(seccion.equals("calificar actividades")) {
			remove(panelDocenteListaEstudiantes);
		}else if(seccion.equals("calificar estudiante seleccionado")) {
			remove(panelDocenteActividadesEstudianteSeleccionado);
		}else if(seccion.equals("calificar actividad seleccionada")) {
			remove(panelDocenteCalificarActividadEstudiante);
		}else if(seccion.equals("historial actividades")) {
			remove(panelEstudianteListaActividadesConNota);
		}
		repaint();
	}

	@Override
	public String[] capturar(String seccion) {
		String passw=new String(panel_IniciarSesion.getFieldContraseña());
		if(seccion.equals(Acciones.INGRESAR)) {
			String[] entradas= {
				panel_IniciarSesion.getFieldtUsuario().getText(),
				passw
			};
			return entradas;
		}else if (seccion.equals(Acciones.REGISTRAR_DOCENTE)) {
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			try {
				@SuppressWarnings("deprecation")
				String[] entradas = {
						panelCoordinadorCrearDocentes.getFieldNombreDocente().getText(),
						""+panelCoordinadorCrearDocentes.getProgramas().getSelectedItem(),
						panelCoordinadorCrearDocentes.getFieldUsuarioDocente().getText(),
						panelCoordinadorCrearDocentes.getFieldContraseñaDocente().getText(),
						dateFormat.format(panelCoordinadorCrearDocentes.getDateChooser().getDate()),
						panelCoordinadorCrearDocentes.getFieldCedula().getText(),
						""+panelCoordinadorCrearDocentes.getAreas().getSelectedItem()
						};
					return entradas;
			} catch (Exception e) {
				mensaje("Error, datos incompletos o errados");
			}
		}else if (seccion.equals(Acciones.MODIFICARD)) {
			String[] captura = new String[1];
			captura[0] = "" + panelCoordinadorListaDocentes.getTablaListaDocentes().getSelectedRow();
			return captura;
		}else if (seccion.equals(Acciones.MODIFICAR_DOCENTE)) {
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			String[] entradas = {
					panelCoordinadorCrearDocentes.getFieldNombreDocente().getText(),
					""+panelCoordinadorCrearDocentes.getProgramas().getSelectedItem(),
					panelCoordinadorCrearDocentes.getFieldUsuarioDocente().getText(),
					panelCoordinadorCrearDocentes.getFieldContraseñaDocente().getText(),
					dateFormat.format(panelCoordinadorCrearDocentes.getDateChooser().getDate()),
					panelCoordinadorCrearDocentes.getFieldCedula().getText(),
					""+panelCoordinadorCrearDocentes.getAreas().getSelectedItem()
					};
			limipiarCamposDocente();
			repaint();
			return entradas;
		}else if (seccion.equals(Acciones.MODIFICARM)) {
			String[] captura = new String[1];
			captura[0] = "" + panelCoordinadorListaMaterias.getTablaListaMaterias().getSelectedRow();
			return captura;
		}else if(seccion.equals(Acciones.MODIFICAR_MATERIA)) {
			panelCoordinadorCrearDocentes.getBtnModificar().setEnabled(true);
			String[] entradas = {
					panelCoordinadorCrearMaterias.getFieldCodigoMateria().getText(),
					""+panelCoordinadorCrearMaterias.getComboNombreMateria().getSelectedItem(),
					""+panelCoordinadorCrearMaterias.getComboSemestre().getSelectedItem(),
					""+panelCoordinadorCrearMaterias.getComboCreditos().getSelectedItem(),
					""+panelCoordinadorCrearMaterias.getComboPrograma().getSelectedItem(),
					};
			limipiarCamposMateria();
			repaint();
			return entradas;
		}else if (seccion.equals(Acciones.ELIMINAR_DOCENTES)) {
			String[] captura = new String[1];
			captura[0] = "" + panelCoordinadorListaDocentes.getTablaListaDocentes().getSelectedRow();
			return captura;
		}else if(seccion.equals(Acciones.SELECCION_ESTUDIANTES)) {
			String[] captura= {
					panelCoordinadorCrearMaterias.getFieldCodigoMateria().getText(),
					""+panelCoordinadorCrearMaterias.getComboNombreMateria().getSelectedItem(),
					""+panelCoordinadorCrearMaterias.getComboSemestre().getSelectedItem(),
					""+panelCoordinadorCrearMaterias.getComboCreditos().getSelectedItem(),
					""+panelCoordinadorCrearMaterias.getComboPrograma().getSelectedItem()
					
			};
			return captura;
		}else if(seccion.equals(Acciones.ASIGNAR)) {
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			String[] captura= {
				panelDocenteAsignarActividad.getFieldCodigo().getText(),
				panelDocenteAsignarActividad.getFieldNombre().getText(),
				panelDocenteAsignarActividad.getFieldPorcentaje().getText(),
				dateFormat.format(panelDocenteAsignarActividad.getDateChooser().getDate()),
				panelDocenteAsignarActividad.getAreaDescripcion().getText()
			};
			return captura;
		}else if(seccion.equals(Acciones.SUBIR_NOTA_ACTIVIDAD_SELECCIONADA)) {
			String[] datos= {
					panelDocenteCalificarActividadEstudiante.getFieldNota().getText()
				};
				return datos;
		}else if(seccion.equals(Acciones.SUBIR_RESPUESTA)) {
			String[] datos= {
					panelEstudianteResponderActividad.getFieldRespuesta().getText()
				};
				return datos;
		}
		return null;
	}
	@Override
	public String[] metodoExtraRetorna(String seccion) {
		if(seccion.equals(Acciones.SELECCION_ESTUDIANTES)) {
			int posicion=panelCoordinadorDocentesSeleccionables.getTablaListaDocentes().getSelectedRow();
			String[] docente= {
				""+panelCoordinadorDocentesSeleccionables.getDefaultTableModel().getValueAt(posicion, 0),
				""+panelCoordinadorDocentesSeleccionables.getDefaultTableModel().getValueAt(posicion, 1),
				""+panelCoordinadorDocentesSeleccionables.getDefaultTableModel().getValueAt(posicion, 2),
				""+panelCoordinadorDocentesSeleccionables.getDefaultTableModel().getValueAt(posicion, 3),
				""+panelCoordinadorDocentesSeleccionables.getDefaultTableModel().getValueAt(posicion, 4),
				""+panelCoordinadorDocentesSeleccionables.getDefaultTableModel().getValueAt(posicion, 5),
				""+panelCoordinadorDocentesSeleccionables.getDefaultTableModel().getValueAt(posicion, 6)
			};
			panelCoordinadorCrearMaterias.setInfoDocente(docente[0], Programa.valueOf(docente[1]),docente[2], docente[3], Integer.parseInt(docente[4]), Integer.parseInt(docente[5]),Area.valueOf(docente[6]));
			return docente;
			
		}else if(seccion.equals(Acciones.SELECCIONAR_MATERIA)) {
			int posicion=panelDocenteListaMaterias.getTablaListaMateriasDocente().getSelectedRow();
			String[] codigoMateria= {
				""+panelDocenteListaMaterias.getDefaultTableModel().getValueAt(posicion, 0)	
			};
			return codigoMateria;
		}else if(seccion.equals(Acciones.SELECCION_ACTIVIDAD_RESPONDER)) {
			int posicion=panelEstudianteListaActividades.getTablaListaActividades().getSelectedRow();
			String[] codigoActividad= {
				""+panelEstudianteListaActividades.getDefaultTableModel().getValueAt(posicion, 0),
				""+panelEstudianteListaActividades.getDefaultTableModel().getValueAt(posicion, 3)
			};
			return codigoActividad;
		}else if(seccion.equals(Acciones.CALIFICAR_ESTUDIANTE_SELECCIONADO)) {
			int posicion=panelDocenteListaEstudiantes.getTablaListaEstudiantesCalificar().getSelectedRow();
			String[] codigoEstudianteyMateria={
				""+panelDocenteListaEstudiantes.getDefaultTableModel().getValueAt(posicion, 6),
				""+panelDocenteListaEstudiantes.getDefaultTableModel().getValueAt(posicion, 8)
			};
			return  codigoEstudianteyMateria;
		}else if(seccion.equals(Acciones.CALIFICAR_ACTIVIDAD_SELECCIONADA)) {
			int posicion=panelDocenteActividadesEstudianteSeleccionado.getTablaListaActividadesEstudianteSeleccionado().getSelectedRow();
			String[] codigoActividad={
				""+panelDocenteActividadesEstudianteSeleccionado.getDefaultTableModel().getValueAt(posicion, 0)
			};
			return codigoActividad;
		}else if(seccion.equals(Acciones.SUBIR_NOTA_ACTIVIDAD_SELECCIONADA)) {
			String[] nota= {
				panelDocenteCalificarActividadEstudiante.getFieldNota().getText()
			};
		}
		return null;
	}
	@Override
	public void metodoExtra(String seccion) {
		if(seccion.equals(Acciones.SELECCION_DOCENTE)) {
			int posicion=panelCoordinadorDocentesSeleccionables.getTablaListaDocentes().getSelectedRow();
			String[] docente= {
				""+panelCoordinadorDocentesSeleccionables.getDefaultTableModel().getValueAt(posicion, 0),
				""+panelCoordinadorDocentesSeleccionables.getDefaultTableModel().getValueAt(posicion, 1),
				""+panelCoordinadorDocentesSeleccionables.getDefaultTableModel().getValueAt(posicion, 2),
				""+panelCoordinadorDocentesSeleccionables.getDefaultTableModel().getValueAt(posicion, 3),
				""+panelCoordinadorDocentesSeleccionables.getDefaultTableModel().getValueAt(posicion, 4),
				""+panelCoordinadorDocentesSeleccionables.getDefaultTableModel().getValueAt(posicion, 5),
				""+panelCoordinadorDocentesSeleccionables.getDefaultTableModel().getValueAt(posicion, 6)
			};
			panelCoordinadorCrearMaterias.setInfoDocente(docente[0], Programa.valueOf(docente[1]),docente[2], docente[3], Integer.parseInt(docente[4]), Integer.parseInt(docente[5]),Area.valueOf(docente[6]));
		}
	}
	@Override
	public void mostrar(String[][] salidas, String seccion) {
		if (seccion.equals(Acciones.LISTA_DOCENTES)) {
			try {
				limpiarTablaDocentes();
				for (int i = 0; i < salidas.length; i++) {
					panelCoordinadorListaDocentes.getDefaultTableModel().addRow(salidas[i]);
				}
			} catch (Exception e) {
			}
		}else if (seccion.equals(Acciones.MODIFICARD)) {
			try {
				panelCoordinadorCrearDocentes.getFieldNombreDocente().setText(salidas[0][0]);
				panelCoordinadorCrearDocentes.getProgramas().setSelectedItem(Programa.valueOf(salidas[0][1]));
				panelCoordinadorCrearDocentes.getFieldUsuarioDocente().setText(salidas[0][2]);
				panelCoordinadorCrearDocentes.getFieldContraseñaDocente().setText(salidas[0][3]);
				panelCoordinadorCrearDocentes.getFieldCedula().setText(salidas[0][5]);
				panelCoordinadorCrearDocentes.getAreas().setSelectedItem(Area.valueOf(salidas[0][6]));
			} catch (Exception e) {
			}
		}else if(seccion.equals(Acciones.DOCENTE)) {
			try {
				limpiarTablaDocentesSeleccionar();
				for (int i = 0; i < salidas.length; i++) {
					panelCoordinadorDocentesSeleccionables.getDefaultTableModel().addRow(salidas[i]);
				}
			} catch (Exception e) {
			}
		}else if(seccion.equals(Acciones.SELECCION_ESTUDIANTES)) {
			try {
				limpiarTablaEstudiantesSeleccionar();
				for (int i = 0; i < salidas.length; i++) {
					panelCoordinadorSeleccionEstudiantes.getDefaultTableModel().addRow(salidas[i]);
				}
			} catch (Exception e) {
			}
		}else if(seccion.equals(Acciones.LISTA_MATERIAS)) {
			try {
				limpiarTablaMaterias();
				for (int i = 0; i < salidas.length; i++) {
					panelCoordinadorListaMaterias.getDefaultTableModel().addRow(salidas[i]);
				}
			} catch (Exception e) {
			}
		}else if (seccion.equals(Acciones.MODIFICARM)) {
			try {
				panelCoordinadorCrearMaterias.getFieldCodigoMateria().setText(salidas[0][0]);
				panelCoordinadorCrearMaterias.getComboNombreMateria().setSelectedItem(Area.valueOf(salidas[0][1]));
				panelCoordinadorCrearMaterias.getComboSemestre().setSelectedItem(Integer.parseInt(salidas[0][2]));
				panelCoordinadorCrearMaterias.getComboCreditos().setSelectedItem(Integer.parseInt(salidas[0][3]));
				panelCoordinadorCrearMaterias.getComboPrograma().setSelectedItem(Programa.valueOf(salidas[0][4]));
			} catch (Exception e) {
			}
		}else if(seccion.equals(Acciones.LISTA_MATERIAS_DOCENTE)) {
			try {
				limpiarTablaMateriasDocente();
				for (int i = 0; i < salidas.length; i++) {
					if(salidas[i][0]!=null&&salidas[i][1]!=null&&salidas[i][2]!=null&&salidas[i][3]!=null&&salidas[i][4]!=null) {
						panelDocenteListaMaterias.getDefaultTableModel().addRow(salidas[i]);
					}
				}
			} catch (Exception e) {
			}
		}else if(seccion.equals(Acciones.LISTA_ACTIVIDADES_ESTUDIANTE)) {
			try {
				limpiarTablaListaActividades();
				for (int i = 0; i < salidas.length; i++) {
					if(salidas[i][0]!=null&&salidas[i][1]!=null&&salidas[i][2]!=null&&salidas[i][3]!=null) {
						panelEstudianteListaActividades.getDefaultTableModel().addRow(salidas[i]);
					}
				}
			} catch (Exception e) {
			}
		}else if(seccion.equals(Acciones.SELECCION_ACTIVIDAD_RESPONDER)) {
			panelEstudianteResponderActividad.getAreapregunta().setText(salidas[0][0]);
			panelEstudianteResponderActividad.getFieldRespuesta().setText(salidas[1][0]);
		}else if(seccion.equals(Acciones.CALIFICAR_ACTIVIDADES)) {
			try {
				limpiarTablaListaEstudiantesCalificar();
				for (int i = 0; i < salidas.length; i++) {
					if(salidas[i][0]!=null&&salidas[i][1]!=null&&salidas[i][2]!=null&&salidas[i][3]!=null&&salidas[i][4]!=null&&salidas[i][5]!=null&&salidas[i][6]!=null&&salidas[i][7]!=null&&salidas[i][8]!=null) {
						panelDocenteListaEstudiantes.getDefaultTableModel().addRow(salidas[i]);
					}
				}
			} catch (Exception e) {
			}
		}else if(seccion.equals(Acciones.CALIFICAR_ESTUDIANTE_SELECCIONADO)) {
			try {
				limpiarTablaListaEstudiantesCalificarActividades();
				for (int i = 0; i < salidas.length; i++) {
					if(salidas[i][0]!=null&&salidas[i][1]!=null&&salidas[i][2]!=null&&salidas[i][3]!=null) {
						panelDocenteActividadesEstudianteSeleccionado.getDefaultTableModel().addRow(salidas[i]);
					}
				}
				
			} catch (Exception e) {
				
			}
		}else if(seccion.equals(Acciones.CALIFICAR_ACTIVIDAD_SELECCIONADA)) {
			panelDocenteCalificarActividadEstudiante.getAreapregunta().setText(salidas[0][0]);
			panelDocenteCalificarActividadEstudiante.getFieldRespuesta().setText(salidas[1][0]);
		}else if(seccion.equals(Acciones.HISTORIAL_ACTIVIDADES)) {
			try {
				limpiarTablaListaActividadesConNota();
				for (int i = 0; i < salidas.length; i++) {
					if(salidas[i][0]!=null&&salidas[i][1]!=null&&salidas[i][2]!=null&&salidas[i][3]!=null&&salidas[i][4]!=null&&salidas[i][5]!=null) {
						panelEstudianteListaActividadesConNota.getDefaultTableModel().addRow(salidas[i]);
					}
				}
			} catch (Exception e) {
			}
		}
	}

	@Override
	public void mensaje(String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje);
	}
	private void limpiarTablaDocentes() {
		for (int i = 0; i < panelCoordinadorListaDocentes.getDefaultTableModel().getRowCount(); i++) {
			panelCoordinadorListaDocentes.getDefaultTableModel().removeRow(i);
			i--;
		}
	}
	private void limpiarTablaMaterias() {
		for (int i = 0; i < panelCoordinadorListaMaterias.getDefaultTableModel().getRowCount(); i++) {
			panelCoordinadorListaMaterias.getDefaultTableModel().removeRow(i);
			i--;
		}
	}
	private void limpiarTablaMateriasDocente() {
		for (int i = 0; i < panelDocenteListaMaterias.getDefaultTableModel().getRowCount(); i++) {
			panelDocenteListaMaterias.getDefaultTableModel().removeRow(i);
			i--;
		}
	}
	private void limpiarTablaListaActividades() {
		for (int i = 0; i < panelEstudianteListaActividades.getDefaultTableModel().getRowCount(); i++) {
			panelEstudianteListaActividades.getDefaultTableModel().removeRow(i);
			i--;
		}
	}
	private void limpiarTablaListaActividadesConNota() {
		for (int i = 0; i < panelEstudianteListaActividadesConNota.getDefaultTableModel().getRowCount(); i++) {
			panelEstudianteListaActividadesConNota.getDefaultTableModel().removeRow(i);
			i--;
		}
	}
	private void limpiarTablaListaEstudiantesCalificar() {
		for (int i = 0; i < panelDocenteListaEstudiantes.getDefaultTableModel().getRowCount(); i++) {
			panelDocenteListaEstudiantes.getDefaultTableModel().removeRow(i);
			i--;
		}
	}
	private void limpiarTablaListaEstudiantesCalificarActividades() {
		for (int i = 0; i < panelDocenteActividadesEstudianteSeleccionado.getDefaultTableModel().getRowCount(); i++) {
			panelDocenteActividadesEstudianteSeleccionado.getDefaultTableModel().removeRow(i);
			i--;
		}
	}
	private void limpiarTablaDocentesSeleccionar() {
		for (int i = 0; i < panelCoordinadorDocentesSeleccionables.getDefaultTableModel().getRowCount(); i++) {
			panelCoordinadorDocentesSeleccionables.getDefaultTableModel().removeRow(i);
			i--;
		}
	}
	private void limpiarTablaEstudiantesSeleccionar() {
		for (int i = 0; i < panelCoordinadorSeleccionEstudiantes.getDefaultTableModel().getRowCount(); i++) {
			panelCoordinadorSeleccionEstudiantes.getDefaultTableModel().removeRow(i);
			i--;
		}
	}
	public void limipiarCamposDocente() {
		panelCoordinadorCrearDocentes.getFieldNombreDocente().setText("");
		panelCoordinadorCrearDocentes.getProgramas().setSelectedItem(Programa.INGENIERIA_SISTEMAS);
		panelCoordinadorCrearDocentes.getFieldUsuarioDocente().setText("");
		panelCoordinadorCrearDocentes.getFieldContraseñaDocente().setText("");
		panelCoordinadorCrearDocentes.getFieldCedula().setText("");
		panelCoordinadorCrearDocentes.getAreas().setSelectedItem(Area.CALCULO);
	}
	public void limipiarCamposMateria() {
		panelCoordinadorCrearMaterias.getFieldCodigoMateria().setText("");
		panelCoordinadorCrearMaterias.getComboNombreMateria().setSelectedItem(Area.CALCULO);
		panelCoordinadorCrearMaterias.getComboSemestre().setSelectedItem(1);
		panelCoordinadorCrearMaterias.getComboCreditos().setSelectedItem(2);
		panelCoordinadorCrearMaterias.getComboPrograma().setSelectedItem(Programa.INGENIERIA_SISTEMAS);
	}
	public boolean seleccionado(int row, int column,JTable tabla) {
		return tabla.getValueAt(row, column)!=null;
	}
	@Override
	public Estudiante[] listaEstudiantesSeleccionados() {
		Estudiante[] estudiantesSeleccionados = new Estudiante[panelCoordinadorSeleccionEstudiantes.getTablaListaEstudiantes().getRowCount()];
		for (int i = 0; i < panelCoordinadorSeleccionEstudiantes.getTablaListaEstudiantes().getRowCount(); i++) {
			if(seleccionado(i, 7, panelCoordinadorSeleccionEstudiantes.getTablaListaEstudiantes())) {
				//System.out.println(panelCoordinadorSeleccionEstudiantes.getTablaListaEstudiantes().getValueAt(i, 0));
				Estudiante estudiante=new Estudiante(panelCoordinadorSeleccionEstudiantes.getTablaListaEstudiantes().getValueAt(i, 0).toString(), Programa.valueOf(panelCoordinadorSeleccionEstudiantes.getTablaListaEstudiantes().getValueAt(i, 1).toString()), panelCoordinadorSeleccionEstudiantes.getTablaListaEstudiantes().getValueAt(i, 2).toString(),
						panelCoordinadorSeleccionEstudiantes.getTablaListaEstudiantes().getValueAt(i, 3).toString().toString(), panelCoordinadorSeleccionEstudiantes.getTablaListaEstudiantes().getValueAt(i, 4).toString().toString(), Integer.parseInt(panelCoordinadorSeleccionEstudiantes.getTablaListaEstudiantes().getValueAt(i, 5).toString().toString()), Integer.parseInt(panelCoordinadorSeleccionEstudiantes.getTablaListaEstudiantes().getValueAt(i, 6).toString().toString()));
				estudiantesSeleccionados[i]=estudiante;
			}
		}
		return estudiantesSeleccionados;
	}
}
