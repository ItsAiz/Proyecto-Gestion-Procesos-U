package edu.uptc.Vista;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

import edu.uptc.Control.Control;
import edu.uptc.Modelo.Area;
import edu.uptc.Modelo.Programa;

public class PanelCoordinadorCrearMaterias extends JPanel{
	private JLabel lblNombre;
	private JComboBox<String> comboNombreMateria;
	private JLabel lblCodigo;
	private JTextField fieldCodigoMateria;
	private JLabel lblSemestre;
	private JComboBox<Integer> comboSemestre;
	private JComboBox<Integer> comboCreditos;
	private JComboBox<String> comboPrograma;
	private JLabel lblPrograma;
	private JLabel lblCreditos;
	private JButton btnSeleccionarDocente;
	private JButton btnSeleccionarEstudiantes;
	private JButton btnAtras;
	private JButton btnModificar;
	private JLabel lblNombreDocente;
	private JTextField fieldNombreDocente;
	private JLabel lblArea;
	private JTextField fieldArea;
	private String[] docenteInfo;
	public PanelCoordinadorCrearMaterias() {
		setLayout(null);
		setBorder(BorderFactory.createLineBorder(Color.black));
		setOpaque(false);
		inicializar();
		caracteristicas();
		agregar();
	}
	private void inicializar() {
		lblNombre=new JLabel("Nombre");
		comboNombreMateria=new JComboBox<String>();
		comboNombreMateria.setModel(new DefaultComboBoxModel(Area.values()));
		
		lblCodigo=new JLabel("Código");
		fieldCodigoMateria=new JTextField("32231");
		
		lblSemestre=new JLabel("Semestre");
		comboSemestre=new JComboBox<Integer>();
		
		lblCreditos=new JLabel("Créditos");
		comboCreditos=new JComboBox<Integer>();
		
		btnSeleccionarDocente=new JButton("Docente");
		btnSeleccionarEstudiantes=new JButton("Asignar Estudiantes");
		
		lblNombreDocente=new JLabel("Docente");
		fieldNombreDocente=new JTextField();
		
		lblPrograma=new JLabel("Programa");
		comboPrograma=new JComboBox<String>();
		comboPrograma.setModel(new DefaultComboBoxModel(Programa.values()));
		
		lblArea=new JLabel("Area docente");
		fieldArea=new JTextField();
		
		lblArea=new JLabel("Area Docente");
		fieldArea=new JTextField();
		
		
		btnAtras=new JButton("Volver");
		
		btnModificar=new JButton("Modificar");
		
	}
	private void caracteristicas() {
		Color color=new Color(117,174,72);
		lblNombre.setBounds(10, 20, 200, 20);
		lblNombre.setForeground(Color.black);
		comboNombreMateria.setBounds(100,20,214 , 27);
		
		lblCodigo.setBounds(10, 100, 200, 20);
		lblCodigo.setForeground(Color.black);
		fieldCodigoMateria.setBounds(100,100,214 , 27);
		
		lblSemestre.setBounds(10, 200, 200, 20);
		lblSemestre.setForeground(Color.black);
		comboSemestre.setBounds(100,200,214 , 27);
		comboSemestre.addItem(1); comboSemestre.addItem(2); comboSemestre.addItem(3); comboSemestre.addItem(4); comboSemestre.addItem(5);
		comboSemestre.addItem(6);comboSemestre.addItem(7);comboSemestre.addItem(8);comboSemestre.addItem(9);comboSemestre.addItem(10);
		
		lblCreditos.setBounds(10,300, 200,20 );
		lblCreditos.setForeground(Color.black);
		comboCreditos.setBounds(100,300, 214, 27);
		comboCreditos.addItem(2);comboCreditos.addItem(3);comboCreditos.addItem(4);
		
		lblPrograma.setBounds(10,400,100,27);
		lblPrograma.setForeground(Color.black);
		comboPrograma.setBounds(100,400, 214, 27);
		
		btnSeleccionarDocente.setBounds(400, 20, 314, 20);
		btnSeleccionarDocente.setBackground(color);
		
		btnSeleccionarEstudiantes.setBounds(400, 100, 314, 20);
		
		lblNombreDocente.setBounds(400,200,100,27);
		fieldNombreDocente.setBounds(500, 200, 214, 27);
		
		lblArea.setBounds(400, 300, 100, 27);
		fieldArea.setBounds(500, 300, 214, 27);
		
		btnAtras.setBounds(10, 450, 100, 20);
		
		btnModificar.setBounds(650, 450, 100,20 );
		
	}

	private void agregar() {
		add(lblNombre);
		add(comboNombreMateria);
		
		add(lblCodigo);
		add(fieldCodigoMateria);
		
		add(lblSemestre);
		add(comboSemestre);
		
		add(lblCreditos);
		add(comboCreditos);
		
		add(lblSemestre);
		add(comboSemestre);
		
		add(btnSeleccionarDocente);
		
		add(btnSeleccionarEstudiantes);
		add(lblNombreDocente);
		add(fieldNombreDocente);
		
		add(lblPrograma);
		add(comboPrograma);
		
		add(lblArea);
		add(fieldArea);
		
		add(btnAtras);
		
		add(btnModificar);
		
	}
	public void asignarLister(Control control) {
		btnAtras.setActionCommand(Acciones.VOLVER);
		btnAtras.addActionListener(control);
		
		btnModificar.setActionCommand(Acciones.MODIFICAR_MATERIA);
		btnModificar.addActionListener(control);
		
		btnSeleccionarDocente.setActionCommand(Acciones.DOCENTE);
		btnSeleccionarDocente.addActionListener(control);
		
		btnSeleccionarEstudiantes.setActionCommand(Acciones.SELECCION_ESTUDIANTES);
		btnSeleccionarEstudiantes.addActionListener(control);
	}
	public String[] getDocenteInfo() {
		return docenteInfo;
	}
	public void setInfoDocente(String nombre,Programa programa,String usuario, String contraseña, int añosExperiencia,int cedula, Area area) {
		docenteInfo=new String[7];
		docenteInfo[0]=nombre;
		docenteInfo[1]=""+programa;
		docenteInfo[2]=usuario;
		docenteInfo[3]=contraseña;
		docenteInfo[4]=""+añosExperiencia;
		docenteInfo[5]=""+cedula;
		docenteInfo[6]=""+area;
		fieldNombreDocente.setText(docenteInfo[0]);
		fieldArea.setText(docenteInfo[6]);
	}
	public JLabel getLblNombre() {
		return lblNombre;
	}
	public void setLblNombre(JLabel lblNombre) {
		this.lblNombre = lblNombre;
	}
	public JComboBox<String> getComboNombreMateria() {
		return comboNombreMateria;
	}
	public void setComboNombreMateria(JComboBox<String> comboNombreMateria) {
		this.comboNombreMateria = comboNombreMateria;
	}
	public JLabel getLblCodigo() {
		return lblCodigo;
	}
	public void setLblCodigo(JLabel lblCodigo) {
		this.lblCodigo = lblCodigo;
	}
	public JTextField getFieldCodigoMateria() {
		return fieldCodigoMateria;
	}
	public void setFieldCodigoMateria(JTextField fieldCodigoMateria) {
		this.fieldCodigoMateria = fieldCodigoMateria;
	}
	public JLabel getLblSemestre() {
		return lblSemestre;
	}
	public void setLblSemestre(JLabel lblSemestre) {
		this.lblSemestre = lblSemestre;
	}
	public JComboBox<Integer> getComboSemestre() {
		return comboSemestre;
	}
	public void setComboSemestre(JComboBox<Integer> comboSemestre) {
		this.comboSemestre = comboSemestre;
	}
	public JComboBox<Integer> getComboCreditos() {
		return comboCreditos;
	}
	public void setComboCreditos(JComboBox<Integer> comboCreditos) {
		this.comboCreditos = comboCreditos;
	}
	public JLabel getLblCreditos() {
		return lblCreditos;
	}
	public void setLblCreditos(JLabel lblCreditos) {
		this.lblCreditos = lblCreditos;
	}
	public JButton getBtnSeleccionarDocente() {
		return btnSeleccionarDocente;
	}
	public void setBtnSeleccionarDocente(JButton btnSeleccionarDocente) {
		this.btnSeleccionarDocente = btnSeleccionarDocente;
	}
	public JButton getBtnSeleccionarEstudiantes() {
		return btnSeleccionarEstudiantes;
	}
	public void setBtnSeleccionarEstudiantes(JButton btnSeleccionarEstudiantes) {
		this.btnSeleccionarEstudiantes = btnSeleccionarEstudiantes;
	}
	public JButton getBtnAtras() {
		return btnAtras;
	}
	public void setBtnAtras(JButton btnAtras) {
		this.btnAtras = btnAtras;
	}
	public JButton getBtnModificar() {
		return btnModificar;
	}
	public void setBtnModificar(JButton btnModificar) {
		this.btnModificar = btnModificar;
	}
	public void setFieldArea(JTextField fieldArea) {
		this.fieldArea = fieldArea;
	}
	public void setFieldNombreDocente(JTextField fieldNombreDocente) {
		this.fieldNombreDocente = fieldNombreDocente;
	}
	public JTextField getFieldArea() {
		return fieldArea;
	}
	public JTextField getFieldNombreDocente() {
		return fieldNombreDocente;
	}
	public JComboBox<String> getComboPrograma() {
		return comboPrograma;
	}
	public void setComboPrograma(JComboBox<String> comboPrograma) {
		this.comboPrograma = comboPrograma;
	}
	
}
