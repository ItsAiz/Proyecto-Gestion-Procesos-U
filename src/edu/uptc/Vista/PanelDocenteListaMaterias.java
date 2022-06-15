package edu.uptc.Vista;


import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import edu.uptc.Control.Control;
import edu.uptc.Modelo.Area;
import edu.uptc.Modelo.Docente;
import edu.uptc.Modelo.Programa;

public class PanelDocenteListaMaterias extends JPanel {
	private DefaultTableModel defaultTableModel;
	private JTable tablaListaMateriasDocente;
	private JScrollPane scroll;
	private JButton btnSeleccionarMateria;
	public PanelDocenteListaMaterias() {
		setOpaque(false);
		setLayout(null);
		setOpaque(false);
		inicializar();
		caracteristicas();
		agregar();
	}
	private void inicializar() {
		String[] titulos= {"Código","Nombre","Semestre","Creditos","Prorama"};
		defaultTableModel=new DefaultTableModel();
		defaultTableModel.setColumnIdentifiers(titulos);
		tablaListaMateriasDocente=new JTable(defaultTableModel);
		scroll=new JScrollPane(tablaListaMateriasDocente);
		btnSeleccionarMateria=new JButton("Seleccionar Materia");
	}
	private void caracteristicas() {
		scroll.setBounds(10, 60, 745, 370);
		btnSeleccionarMateria.setBounds(550, 450, 200,27);
	}
	private void agregar() {
		add(scroll);
		add(btnSeleccionarMateria);
		
	}
	public DefaultTableModel getDefaultTableModel() {
		return defaultTableModel;
	}
	public void asignarLister(Control control) {
		
		btnSeleccionarMateria.setActionCommand(Acciones.SELECCIONAR_MATERIA);
		btnSeleccionarMateria.addActionListener(control);
	}
	public JTable getTablaListaMateriasDocente() {
		return tablaListaMateriasDocente;
	}
	public void setTablaListaMateriasDocente(JTable tablaListaMateriasDocente) {
		this.tablaListaMateriasDocente = tablaListaMateriasDocente;
	}
	public JScrollPane getScroll() {
		return scroll;
	}
	public void setScroll(JScrollPane scroll) {
		this.scroll = scroll;
	}
	public JButton getBtnSeleccionarMateria() {
		return btnSeleccionarMateria;
	}
	public void setBtnSeleccionarMateria(JButton btnSeleccionarMateria) {
		this.btnSeleccionarMateria = btnSeleccionarMateria;
	}
	public void setDefaultTableModel(DefaultTableModel defaultTableModel) {
		this.defaultTableModel = defaultTableModel;
	}
	
}
