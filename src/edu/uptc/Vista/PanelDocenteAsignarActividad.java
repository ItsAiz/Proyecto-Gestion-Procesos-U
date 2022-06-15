package edu.uptc.Vista;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

import edu.uptc.Control.Control;

public class PanelDocenteAsignarActividad extends JPanel{
	private JLabel lblNombre;
	private JTextField fieldNombre;
	private JLabel lblCodigo;
	private JTextField fieldCodigo;
	private JLabel lblPorcentaje;
	private JTextField fieldPorcentaje;
	private JTextArea areaDescripcion;
	private JLabel lblFechaPlazo;
	private JDateChooser dateChooser;
	private JButton btnAtras;
	private JButton btnAsignarActividad;
	public PanelDocenteAsignarActividad() {
		setLayout(null);
		setBorder(BorderFactory.createLineBorder(Color.black));
		setOpaque(false);
		inicializar();
		caracteristicas();
		agregar();
	}
	private void inicializar() {
		lblCodigo=new JLabel("Codigo");
		fieldCodigo=new JTextField();
		
		lblNombre=new JLabel("Nombre");
		fieldNombre=new JTextField();
		
		lblPorcentaje=new JLabel("Porentaje");
		fieldPorcentaje=new JTextField();
		
		lblFechaPlazo=new JLabel("Fecha plazo");
		dateChooser=new JDateChooser("dd/MM/yyyy","##/##/####",'_');
		dateChooser.setEnabled(true);
		
		areaDescripcion=new JTextArea("Descripción");
		
		btnAsignarActividad=new JButton("Asignar Actividad");
		btnAtras=new JButton("Volver");
		
	}

	private void caracteristicas() {
		lblNombre.setBounds(10, 20, 200, 20);
		lblNombre.setForeground(Color.black);
		fieldNombre.setBounds(100,20,214 , 27);
		
		lblCodigo.setBounds(10, 100, 200, 20);
		lblCodigo.setForeground(Color.black);
		fieldCodigo.setBounds(100,100,214 , 27);
		
		lblPorcentaje.setBounds(10, 200, 200, 20);
		lblPorcentaje.setForeground(Color.black);
		fieldPorcentaje.setBounds(100,200,214 , 27);
		
		lblFechaPlazo.setBounds(10, 300, 100, 20);
		lblFechaPlazo.setForeground(Color.black);
		dateChooser.setBounds(100,300,200, 27);
		
		areaDescripcion.setBounds(400, 20, 350, 300);
		
		btnAsignarActividad.setBounds(550, 450, 200,27);
		btnAtras.setBounds(10, 450, 100, 20);
		
	}
	private void agregar() {
		add(lblCodigo);
		add(fieldCodigo);
		
		add(lblNombre);
		add(fieldNombre);

		add(lblPorcentaje);
		add(fieldPorcentaje);
		
		add(areaDescripcion);
		
		add(lblFechaPlazo);
		add(dateChooser);
		
		add(btnAsignarActividad);
		add(btnAtras);
	}
	public void asignarLister(Control control) {
		btnAtras.setActionCommand(Acciones.VOLVER_DOCENTE_LISTA_MATERIAS);
		btnAtras.addActionListener(control);
		
		btnAsignarActividad.setActionCommand(Acciones.ASIGNAR);
		btnAsignarActividad.addActionListener(control);
	}
	public JTextField getFieldNombre() {
		return fieldNombre;
	}
	public void setFieldNombre(JTextField fieldNombre) {
		this.fieldNombre = fieldNombre;
	}
	public JTextField getFieldCodigo() {
		return fieldCodigo;
	}
	public void setFieldCodigo(JTextField fieldCodigo) {
		this.fieldCodigo = fieldCodigo;
	}
	public JTextField getFieldPorcentaje() {
		return fieldPorcentaje;
	}
	public void setFieldPorcentaje(JTextField fieldPorcentaje) {
		this.fieldPorcentaje = fieldPorcentaje;
	}
	public JTextArea getAreaDescripcion() {
		return areaDescripcion;
	}
	public void setAreaDescripcion(JTextArea areaDescripcion) {
		this.areaDescripcion = areaDescripcion;
	}
	public JDateChooser getDateChooser() {
		return dateChooser;
	}
	public void setDateChooser(JDateChooser dateChooser) {
		this.dateChooser = dateChooser;
	}
	public JButton getBtnAsignarActividad() {
		return btnAsignarActividad;
	}
	public void setBtnAsignarActividad(JButton btnAsignarActividad) {
		this.btnAsignarActividad = btnAsignarActividad;
	}
	public JButton getBtnAtras() {
		return btnAtras;
	}
	
}
