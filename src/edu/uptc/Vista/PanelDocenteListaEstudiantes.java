package edu.uptc.Vista;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import edu.uptc.Control.Control;

public class PanelDocenteListaEstudiantes extends JPanel{
	private DefaultTableModel defaultTableModel;
	private JTable tablaListaEstudiantesCalificar;
	private JScrollPane scroll;
	private JButton btnSeleccionar;
	public PanelDocenteListaEstudiantes() {
		setOpaque(false);
		setLayout(null);
		setOpaque(false);
		inicializar();
		caracteristicas();
		agregar();
	}
	private void inicializar() {
		String[] titulos= {"Nombre","Programa","Usuario","Contraseña","Correo","Semestre","Codigo","Materia","Codigo materia"};
		defaultTableModel=new DefaultTableModel();
		defaultTableModel.setColumnIdentifiers(titulos);
		tablaListaEstudiantesCalificar=new JTable(defaultTableModel);
		scroll=new JScrollPane(tablaListaEstudiantesCalificar);
		btnSeleccionar=new JButton("Calificar Actividades");
	}
	private void caracteristicas() {
		scroll.setBounds(10, 60, 745, 370);
		btnSeleccionar.setBounds(540, 450, 214, 20 );
	}
	private void agregar() {
		add(scroll);
		add(btnSeleccionar);
		
	}
	public void asignarLister(Control control) {
		btnSeleccionar.setActionCommand(Acciones.CALIFICAR_ESTUDIANTE_SELECCIONADO);
		btnSeleccionar.addActionListener(control);
	}
	public JTable getTablaListaEstudiantesCalificar() {
		return tablaListaEstudiantesCalificar;
	}
	public DefaultTableModel getDefaultTableModel() {
		return defaultTableModel;
	}
	public JButton getBtnSeleccionar() {
		return btnSeleccionar;
	}
}
